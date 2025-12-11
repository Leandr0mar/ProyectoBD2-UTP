package Conexion;

import java.sql.*;
import Objeto.Matricula;
import javax.swing.JOptionPane;

public class MatriculaDAO {
    conexionBd co = new conexionBd();

    public boolean registrarMatricula(Matricula ma) {
        String verificarExistencia = """
            SELECT idMatriculas
            FROM matriculas
            WHERE alumno_id = ? AND curso_id = ? AND periodo_id = ?
            """;

        String insertarMatricula = """
            INSERT INTO matriculas (alumno_id, curso_id, periodo_id, fecha_matricula)
            VALUES (?, ?, ?, NOW())
            RETURNING idMatriculas
            """;

        String insertarNota = """
            INSERT INTO notas (idMatriculas, idseccion)
            VALUES (?, ?)
            ON CONFLICT (idMatriculas, idseccion) DO NOTHING
            """;

        Connection cn = null;
        try {
            cn = co.getConnection();
            cn.setAutoCommit(false);

            // 1. Verificar existencia
            try (PreparedStatement psCheck = cn.prepareStatement(verificarExistencia)) {
                psCheck.setInt(1, ma.getAlumno_id());
                psCheck.setInt(2, ma.getCurso_id());
                psCheck.setInt(3, ma.getPeriodo_id());
                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Matrícula ya existe para este alumno, curso y período.");
                        cn.rollback();
                        return false;
                    }
                }
            }

            // 2. Insertar matrícula y obtener ID
            int idMatriculaNueva;
            try (PreparedStatement psMat = cn.prepareStatement(insertarMatricula)) {
                psMat.setInt(1, ma.getAlumno_id());
                psMat.setInt(2, ma.getCurso_id());
                psMat.setInt(3, ma.getPeriodo_id());

                try (ResultSet rs = psMat.executeQuery()) {
                    if (rs.next()) {
                        idMatriculaNueva = rs.getInt(1);
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la matrícula insertada.");
                    }
                }
            }

            // 3. Insertar asignación a sección en notas
            try (PreparedStatement psNota = cn.prepareStatement(insertarNota)) {
                psNota.setInt(1, idMatriculaNueva);
                psNota.setInt(2, ma.getSeccion_id());
                psNota.executeUpdate();
            }

            cn.commit();
            System.out.println("Matrícula registrada con éxito. ID: " + idMatriculaNueva +
                               " | Sección: " + ma.getSeccion_id());
            return true;

        } catch (SQLException e) {
            if (cn != null) {
                try { cn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            System.err.println("Error al registrar matrícula: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean modificarMatricula(Matricula ma) {
        String actualizarMatricula = """
            UPDATE matriculas 
            SET alumno_id = ?, curso_id = ?, periodo_id = ? 
            WHERE codigoMatricula = ?
            """;

        String eliminarNotaAntigua = """
            DELETE FROM notas 
            WHERE idMatriculas = (SELECT idMatriculas FROM matriculas WHERE codigoMatricula = ?)
            """;

        String insertarNotaNueva = """
            INSERT INTO notas (idMatriculas, idseccion)
            SELECT idMatriculas, ?
            FROM matriculas 
            WHERE codigoMatricula = ?
            ON CONFLICT (idMatriculas, idseccion) DO NOTHING
            """;

        Connection cn = null;
        try {
            cn = co.getConnection();
            cn.setAutoCommit(false);  

            try (PreparedStatement psMat = cn.prepareStatement(actualizarMatricula)) {
                psMat.setInt(1, ma.getAlumno_id());
                psMat.setInt(2, ma.getCurso_id());
                psMat.setInt(3, ma.getPeriodo_id());
                psMat.setString(4, ma.getCodigoMatricula());

                int filasActualizadas = psMat.executeUpdate();
                if (filasActualizadas == 0) {
                    cn.rollback();
                    System.err.println("No se encontró la matrícula con código: " + ma.getCodigoMatricula());
                    return false;
                }
            }

            try (PreparedStatement psDelete = cn.prepareStatement(eliminarNotaAntigua)) {
                psDelete.setString(1, ma.getCodigoMatricula());
                psDelete.executeUpdate();
            }

            try (PreparedStatement psNota = cn.prepareStatement(insertarNotaNueva)) {
                psNota.setInt(1, ma.getSeccion_id());
                psNota.setString(2, ma.getCodigoMatricula());
                psNota.executeUpdate();
            }

            cn.commit();
            System.out.println("Matrícula modificada con éxito. Código: " + ma.getCodigoMatricula() +
                               " | Nueva sección: " + ma.getSeccion_id());
            return true;

        } catch (SQLException e) {
            if (cn != null) {
                try { cn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            System.err.println("Error al modificar matrícula: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Error al modificar: Posible duplicado en alumno-curso-período o problema con la sección.", 
                "Error de modificación", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

    public boolean eliminarMatricula(String codMatricula) {
        // Consultas en orden correcto
        String eliminarNotas = """
            DELETE FROM notas 
            WHERE idMatriculas = (SELECT idMatriculas FROM matriculas WHERE codigoMatricula = ?)
            """;

        String eliminarCertificados = """
            DELETE FROM certificados 
            WHERE idMatriculas = (SELECT idMatriculas FROM matriculas WHERE codigoMatricula = ?)
            """;

        String eliminarMatricula = """
            DELETE FROM matriculas 
            WHERE codigoMatricula = ?
            """;

        Connection cn = null;
        try {
            cn = co.getConnection();
            cn.setAutoCommit(false);  

            // 1. Eliminar notas asociadas
            try (PreparedStatement psNotas = cn.prepareStatement(eliminarNotas)) {
                psNotas.setString(1, codMatricula);
                psNotas.executeUpdate();
            }

            // 3. Eliminar certificados asociados (si aplica)
            try (PreparedStatement psCert = cn.prepareStatement(eliminarCertificados)) {
                psCert.setString(1, codMatricula);
                psCert.executeUpdate();
            }

            // 4. Finalmente eliminar la matrícula
            try (PreparedStatement psMat = cn.prepareStatement(eliminarMatricula)) {
                psMat.setString(1, codMatricula);
                int filas = psMat.executeUpdate();
                if (filas == 0) {
                    cn.rollback();
                    System.err.println("No se encontró matrícula con código: " + codMatricula);
                    return false;
                }
            }

            cn.commit();
            System.out.println("Matrícula eliminada con éxito (código: " + codMatricula + ") y todos sus registros dependientes.");
            return true;

        } catch (SQLException e) {
            if (cn != null) {
                try { cn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            System.err.println("Error al eliminar matrícula: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Error inesperado al eliminar la matrícula. Contacte al administrador.", 
                "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ResultSet listarMatriculas() {
        String sql = """
                        SELECT m.idMatriculas, 
                            m.codigoMatricula, 
                            u.nombre_completo AS alumno_nombre, 
                            c.nombre AS curso_nombre, 
                            m.fecha_matricula,
                            pa.codigoPeriodo AS periodo_codigo,
                            prof.nombre_completo AS profesor_nombre,
                            m.alumno_id, 
                            m.curso_id, 
                            m.periodo_id,
                            s.idSeccion 
                                FROM matriculas m
                                    JOIN usuarios u ON m.alumno_id = u.idUsuarios AND u.rol = 'alumno' AND u.estado = true
                                    JOIN cursos c ON m.curso_id = c.idCursos
                                    JOIN periodos_academicos pa ON m.periodo_id = pa.idPeriodoAcademico
                                    JOIN secciones s ON s.idCursos = m.curso_id AND s.idPeriodoAcademico = m.periodo_id
                                    JOIN usuarios prof ON s.idProfesor = prof.idUsuarios AND prof.rol = 'profesor' AND prof.estado = true
                                    ORDER BY m.idMatriculas""";

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = co.getConnection(); 
            ps = cn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error al listar matrículas: " + e.getMessage());
            e.printStackTrace();

            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException ex) {
                 System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
            return null; // Devuelve null si falla.
        }
    }
    
}
