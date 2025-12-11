package Conexion;
import java.sql.*;

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
                            alum.nombre_completo;""";

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
    
    
}
