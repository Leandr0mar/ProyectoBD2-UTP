package Conexion;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    conexionBd co = new conexionBd();
    

    public ResultSet listarNotas() {
        String sql = """
                        SELECT n.idNotas,
                            s.codigoSeccion AS codigo_seccion,
                            prof.nombre_completo AS nombre_profesor,
                            alum.nombre_completo AS nombre_alumno,
                            n.PC1,
                            n.PC2,
                            n.PC3,
                            n.PA,
                            n.EF,
                            n.promedio_final,
                            n.estado,
                            n.fecha_nota AS fecha_creacion_nota,
                            pa.codigoPeriodo AS periodo_academico,
                            c.nombre AS nombre_curso
                        FROM notas n
                        JOIN matriculas m ON n.idMatriculas = m.idMatriculas
                        JOIN secciones s ON n.idseccion = s.idseccion
                        JOIN usuarios prof ON s.idProfesor = prof.idUsuarios AND prof.rol = 'profesor'
                        JOIN usuarios alum ON m.alumno_id = alum.idUsuarios AND alum.rol = 'alumno' AND alum.estado = true
                        JOIN cursos c ON m.curso_id = c.idCursos
                        JOIN periodos_academicos pa ON m.periodo_id = pa.idPeriodoAcademico
                        WHERE prof.estado = true
                        ORDER BY 
                            pa.codigoPeriodo,
                            c.nombre,
                            s.codigoSeccion,
                            alum.nombre_completo""";

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = co.getConnection(); 
            ps = cn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error al listar notas: " + e.getMessage());
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
    

public List<Object[]> listarNotasPorId(int idProfe) {
    List<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT 
            n.idNotas,
            u.nombre_completo AS alumno,
            c.nombre AS curso,
            p.codigoPeriodo AS periodo,
            COALESCE(n.PC1, 0) AS PC1,
            COALESCE(n.PC2, 0) AS PC2,
            COALESCE(n.PC3, 0) AS PC3, 
            COALESCE(n.PA, 0) AS PA, 
            COALESCE(n.EF, 0) AS EF, 
            n.promedio_final,
            n.estado 
        FROM notas n 
        JOIN matriculas m ON n.idMatriculas = m.idMatriculas 
        JOIN usuarios u ON m.alumno_id = u.idUsuarios 
        JOIN cursos c ON m.curso_id = c.idCursos 
        JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico
         JOIN secciones s on s.idSeccion=n.idSeccion
        WHERE s.idProfesor=?
        ORDER BY n.idNotas ASC
    """;

    try {
        Connection con = co.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProfe);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[11];
            fila[0] = rs.getInt("idNotas");
            fila[1] = rs.getString("alumno");
            fila[2] = rs.getString("curso");
            fila[3] = rs.getString("periodo");
            fila[4] = rs.getDouble("PC1");
            fila[5] = rs.getDouble("PC2");
            fila[6] = rs.getDouble("PC3");
            fila[7] = rs.getDouble("PA");
            fila[8] = rs.getDouble("EF");
            fila[9] = rs.getDouble("promedio_final");
            fila[10] = rs.getString("estado");
            lista.add(fila);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar notas filtradas: " + e.getMessage());
    }

    return lista;
}
    
    public List<Object[]> listarNotasPorCurso(int idCurso) {
    List<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT 
            n.idNotas,
            u.nombre_completo AS alumno,
            c.nombre AS curso,
            p.codigoPeriodo AS periodo,
            COALESCE(n.PC1, 0) AS PC1,
            COALESCE(n.PC2, 0) AS PC2,
            COALESCE(n.PC3, 0) AS PC3, 
            COALESCE(n.PA, 0) AS PA, 
            COALESCE(n.EF, 0) AS EF, 
            n.promedio_final,
            n.estado 
        FROM notas n 
        JOIN matriculas m ON n.idMatriculas = m.idMatriculas 
        JOIN usuarios u ON m.alumno_id = u.idUsuarios 
        JOIN cursos c ON m.curso_id = c.idCursos 
        JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico 
        WHERE m.curso_id = ?
        ORDER BY n.idNotas ASC
    """;

    try {
        Connection con = co.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCurso);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[11];
            fila[0] = rs.getInt("idNotas");
            fila[1] = rs.getString("alumno");
            fila[2] = rs.getString("curso");
            fila[3] = rs.getString("periodo");
            fila[4] = rs.getDouble("PC1");
            fila[5] = rs.getDouble("PC2");
            fila[6] = rs.getDouble("PC3");
            fila[7] = rs.getDouble("PA");
            fila[8] = rs.getDouble("EF");
            fila[9] = rs.getDouble("promedio_final");
            fila[10] = rs.getString("estado");
            lista.add(fila);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar notas filtradas: " + e.getMessage());
    }

    return lista;
}
    
    
   public List<Object[]> listarNotasPorCursoId(int idCurso, int idProfesor) {
    List<Object[]> lista = new ArrayList<>();

    String sql = """
    SELECT
            n.idNotas,
            u.nombre_completo AS alumno,
            c.nombre AS curso,
            p.codigoPeriodo AS periodo,
            COALESCE(n.PC1, 0) AS PC1,
            COALESCE(n.PC2, 0) AS PC2,
            COALESCE(n.PC3, 0) AS PC3,
            COALESCE(n.PA, 0) AS PA,
            COALESCE(n.EF, 0) AS EF,
            n.promedio_final,
            n.estado
        FROM notas n
        JOIN matriculas m ON n.idMatriculas = m.idMatriculas
        JOIN secciones s ON n.idseccion = s.idseccion
        JOIN usuarios u ON m.alumno_id = u.idUsuarios
        JOIN cursos c ON m.curso_id = c.idCursos
        JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico
        WHERE m.curso_id = ?      
          AND s.idProfesor = ?     
        ORDER BY n.idNotas ASC
    """;

    try {
        Connection con = co.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCurso);
        ps.setInt(2, idProfesor);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[11];
            fila[0] = rs.getInt("idNotas");
            fila[1] = rs.getString("alumno");
            fila[2] = rs.getString("curso");
            fila[3] = rs.getString("periodo");
            fila[4] = rs.getDouble("PC1");
            fila[5] = rs.getDouble("PC2");
            fila[6] = rs.getDouble("PC3");
            fila[7] = rs.getDouble("PA");
            fila[8] = rs.getDouble("EF");
            fila[9] = rs.getDouble("promedio_final");
            fila[10] = rs.getString("estado");
            lista.add(fila);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar notas filtradas: " + e.getMessage());
    }

    return lista;
}
        
    public ResultSet listarNotasAlumno(int idAlumno, String nombreCurso) {
        String sql = """
                                SELECT 
                                    n.idNotas,
                                    u.nombre_completo AS alumno,
                                    c.nombre AS curso,
                                    p.codigoPeriodo AS periodo,
                                    COALESCE(n.PC1, 0) AS PC1,
                                    COALESCE(n.PC2, 0) AS PC2,
                                    COALESCE(n.PC3, 0) AS PC3, 
                                    COALESCE(n.PA, 0) AS PA, 
                                    COALESCE(n.EF, 0) AS EF, 
                                    n.promedio_final,
                                    n.estado 
                                FROM notas n 
                                JOIN matriculas m ON n.idMatriculas = m.idMatriculas 
                                JOIN usuarios u ON m.alumno_id = u.idUsuarios 
                                JOIN cursos c ON m.curso_id = c.idCursos 
                                JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico 
                                WHERE u.idUsuarios = ? and c.nombre like (?) 
                                """;

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = co.getConnection(); 
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setString(2, nombreCurso);
            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error al listar notas: " + e.getMessage());
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
    
    public ResultSet listarCursosPorAlumno(int idAlumno) {
        String sql = """
                                SELECT 
                                    n.idNotas,
                                    u.nombre_completo AS alumno,
                                    c.nombre AS curso,
                                    p.codigoPeriodo AS periodo,
                                    COALESCE(n.PC1, 0) AS PC1,
                                    COALESCE(n.PC2, 0) AS PC2,
                                    COALESCE(n.PC3, 0) AS PC3, 
                                    COALESCE(n.PA, 0) AS PA, 
                                    COALESCE(n.EF, 0) AS EF, 
                                    n.promedio_final,
                                    n.estado 
                                FROM notas n 
                                JOIN matriculas m ON n.idMatriculas = m.idMatriculas 
                                JOIN usuarios u ON m.alumno_id = u.idUsuarios 
                                JOIN cursos c ON m.curso_id = c.idCursos 
                                JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico 
                                WHERE u.idUsuarios = ?
                                """;

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = co.getConnection(); 
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error al listar notas: " + e.getMessage());
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


    
    public int actualizarNota(int idNota,
            BigDecimal pc1, BigDecimal pc2, BigDecimal pc3,
            BigDecimal pa, BigDecimal ef) {
        String sql = """
            UPDATE notas
            SET PC1 = ?, PC2 = ?, PC3 = ?, PA = ?, EF = ?
            WHERE idNotas = ?
        """;

        try {
            Connection con = co.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBigDecimal(1, pc1);
            ps.setBigDecimal(2, pc2);
            ps.setBigDecimal(3, pc3);
            ps.setBigDecimal(4, pa);
            ps.setBigDecimal(5, ef);
            ps.setInt(6, idNota);

            return ps.executeUpdate(); // devuelve 1 si actualizó
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
