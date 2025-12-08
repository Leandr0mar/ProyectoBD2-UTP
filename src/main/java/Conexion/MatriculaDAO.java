package Conexion;

import java.sql.*;
import Objeto.Matricula;
import javax.swing.JOptionPane;

public class MatriculaDAO {
    Connection con;
    conexionBd co = new conexionBd();
    PreparedStatement ps;
    ResultSet rs;
    
    private final PeriodoAcademicoDAO periodoDAO = new PeriodoAcademicoDAO();
    private final CursoDAO cursoDAO = new CursoDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public boolean registrarMatricula(Matricula matricula) {
        String sql = "INSERT INTO matriculas (alumno_id, curso_id, periodo_id, fecha_matricula) VALUES (?, ?, ?, CURRENT_DATE)";
        
        try (Connection conn = co.getConnection()) {
            
            int idPeriodoActivo = periodoDAO.obtenerIdPeriodoActivo(); 
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                
                ps.setInt(1, matricula.getIdAlumno());
                ps.setInt(2, matricula.getIdCurso());
                ps.setInt(3, idPeriodoActivo); 

                return ps.executeUpdate() > 0;
            }
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de Matrícula: " + e.getMessage());
            return false;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "❌ Error: El alumno ya se encuentra matriculado en este curso/periodo.");
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL al registrar matrícula: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarMatricula(Matricula matricula) {
        String sql = "UPDATE matriculas SET alumno_id=?, curso_id=?, periodo_id=? WHERE codigoMatricula=?";

        try (Connection conn = co.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, matricula.getIdAlumno());
            ps.setInt(2, matricula.getIdCurso());
            ps.setInt(3, matricula.getIdPeriodo());
            ps.setString(4, matricula.getCodigoMatricula()); // Clave de búsqueda

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar matrícula: " + e.getMessage());
            return false;
        }
    }    
    
    
    public ResultSet listarMatriculas() {
        String sql = """
            SELECT 
                m.codigoMatricula, 
                u.nombre_completo AS nombre_alumno, 
                c.nombre AS nombre_curso, 
                p.codigoPeriodo AS codigo_periodo, 
                m.fecha_matricula 
            FROM matriculas m
            JOIN usuarios u ON m.alumno_id = u.idUsuarios
            JOIN cursos c ON m.curso_id = c.idCursos
            JOIN periodos_academicos p ON m.periodo_id = p.idPeriodoAcademico
            ORDER BY codigoMatricula
        """;
        try {
            PreparedStatement ps = co.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al listar matrículas: " + e.getMessage());
            return null;
        }
    }
            
}
