package Conexion;
import Objeto.Seccion;
import java.sql.*;
import javax.swing.JOptionPane;
        
public class SeccionDAO {
    conexionBd co = new conexionBd();
    
    public boolean registrarSeccion(Seccion se) {
        String verificarExistencia = "SELECT idSeccion FROM secciones WHERE idProfesor=? AND idCursos=? AND idPeriodoAcademico=?";
        
        String insertar = "INSERT INTO secciones(idProfesor, idCursos, idPeriodoAcademico) VALUES (?, ?, ?)";

        try (Connection cn = co.getConnection()) {
            
            PreparedStatement psCheck = cn.prepareStatement(verificarExistencia);
            psCheck.setInt(1, se.getProfesor_id());
            psCheck.setInt(2, se.getCurso_id());
            psCheck.setInt(3, se.getPeriodo_id());
            
            try (ResultSet rsCheck = psCheck.executeQuery()) {
                if (rsCheck.next()) {
                    // Si encuentra un resultado, la matrícula ya existe.
                    System.err.println("La matrícula ya existe para este alumno, curso y periodo.");
                    return false;
                }
            }
            
            psCheck.close(); 
            
            PreparedStatement ps = cn.prepareStatement(insertar);
            ps.setInt(1, se.getProfesor_id());
            ps.setInt(2, se.getCurso_id());
            ps.setInt(3, se.getPeriodo_id());

            int filas = ps.executeUpdate();
            ps.close();
            
            return filas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar matrícula: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }
    
    public boolean modificarSeccion(Seccion se) {
        String actualizar = "UPDATE secciones SET idProfesor=?, idCursos=?, idPeriodoAcademico=? WHERE codigoSeccion=?";

        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(actualizar)) {

            ps.setInt(1, se.getProfesor_id()); 
            ps.setInt(2, se.getCurso_id()); 
            ps.setInt(3, se.getPeriodo_id()); 
            ps.setString(4, se.getCodigoSeccion()); 
            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error de unicidad al modificar seccion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar: La combinación Profesor, Curso y Periodo ya existe.");
            return false;
        } catch (SQLException e) {
            System.err.println("Error al modificar seccion: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarSeccion(String codSeccion) {
        String eliminar = "DELETE FROM secciones WHERE codigoSeccion = ?";

        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(eliminar)) {

            ps.setString(1, codSeccion);
            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error de restricción de clave foránea al eliminar seccion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la seccion. Existen Notas, Asistencias o Certificados asociados.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            System.err.println("Error al eliminar matrícula: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet listarSecciones() {
        String sql = "SELECT s.idseccion, s.codigoSeccion, " +
                     "u.nombre_completo AS profesor_nombre, " +
                     "c.nombre AS curso_nombre, s.fecha_seccion as fecha_seccion," +
                     "pa.codigoPeriodo AS periodo_codigo, " +
                     "s.idProfesor, s.idCursos, s.idPeriodoAcademico " +
                     "FROM secciones s " +
                     "JOIN usuarios u ON s.idProfesor = u.idUsuarios " +
                     "JOIN cursos c ON s.idCursos = c.idCursos " +
                     "JOIN periodos_academicos pa ON s.idPeriodoAcademico = pa.idPeriodoAcademico " +
                     "ORDER BY s.idseccion";

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
        
    public ResultSet listarSeccionesFiltradasNotas(String profesor) {
        if (profesor == null || profesor.trim().isEmpty()) {
            return null;
        }

        String sql = "SELECT s.idseccion, s.codigoSeccion, " +
                     "u.nombre_completo AS profesor_nombre, " +
                     "c.nombre AS curso_nombre, " +
                     "s.fecha_seccion, " +
                     "pa.codigoPeriodo AS periodo_codigo, " +
                     "s.idProfesor, s.idCursos, s.idPeriodoAcademico " +
                     "FROM secciones s " +
                     "JOIN usuarios u ON s.idProfesor = u.idUsuarios " +
                     "JOIN cursos c ON s.idCursos = c.idCursos " +
                     "JOIN periodos_academicos pa ON s.idPeriodoAcademico = pa.idPeriodoAcademico " +
                     "WHERE u.nombre_completo = ? " +
                     "ORDER BY s.fecha_seccion DESC, s.codigoSeccion";

        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cn = co.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, profesor.trim());  // Nombre exacto, sin espacios sobrantes

            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.out.println("Error al listar secciones del profesor '" + profesor + "': " + e.getMessage());
            e.printStackTrace();

            // Cerrar recursos en caso de error
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException ex) {
                System.err.println("Error cerrando recursos: " + ex.getMessage());
            }
            return null;
        }
    }

    public ResultSet listarSeccionesPorProfesor(String nombreProfesor) throws SQLException {
        String sql = """
            SELECT s.idseccion, s.codigoSeccion, c.nombre AS curso_nombre, pa.codigoPeriodo
            FROM secciones s
            JOIN cursos c ON s.idCursos = c.idCursos
            JOIN periodos_academicos pa ON s.idPeriodoAcademico = pa.idPeriodoAcademico
            JOIN usuarios u ON s.idProfesor = u.idUsuarios
            WHERE u.nombre_completo = ? AND pa.activo = true
            ORDER BY pa.codigoPeriodo DESC, c.nombre
            """;
        PreparedStatement ps = co.getConnection().prepareStatement(sql);
        ps.setString(1, nombreProfesor);
        return ps.executeQuery();
    }
    
    public ResultSet listarSeccionPorCurso(String codigoSeccion) throws SQLException {
        String sql = """
        SELECT 
            s.codigoSeccion,
            c.nombre AS curso_nombre,
            pa.codigoPeriodo,
            u.nombre_completo AS profesor
        FROM secciones s
        JOIN cursos c ON s.idCursos = c.idCursos
        JOIN periodos_academicos pa ON s.idPeriodoAcademico = pa.idPeriodoAcademico
        JOIN usuarios u ON s.idProfesor = u.idUsuarios
        WHERE c.nombre =?
          AND pa.activo = true
        ORDER BY pa.codigoPeriodo DESC, c.nombre, s.codigoSeccion;
        """;

        Connection cn = co.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, codigoSeccion.trim());
        return ps.executeQuery();
    }
        
    public int obtenerIdSeccionPorIdProfesor(int idProfesor,int idCurso,int idPeriodo) throws SQLException {
        String sql = "SELECT idSeccion FROM secciones WHERE idProfesor = ? AND idCursos=? and idPeriodoAcademico=? ";
        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idProfesor);
            ps.setInt(2, idCurso);
            ps.setInt(3, idPeriodo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idSeccion");
                }
            }
        }
        return -1;
    }
    
    
}
