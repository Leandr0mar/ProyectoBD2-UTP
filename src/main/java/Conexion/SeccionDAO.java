package Conexion;
import java.sql.*;
        
public class SeccionDAO {
    conexionBd co = new conexionBd();
    
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
        
        
}
