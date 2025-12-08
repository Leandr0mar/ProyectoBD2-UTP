package Conexion;

import Objeto.Curso;
import java.sql.*;
import javax.swing.JOptionPane;

public class CursoDAO {
    
    Connection con;
    conexionBd co = new conexionBd();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarCurso(Curso curso) {
        String sql = "INSERT INTO cursos ( nombre, horas_semanales, ciclo) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getHorasSemanales());
            ps.setInt(3, curso.getCiclo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar curso: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarCurso(Curso curso) {
        String sql = "UPDATE cursos SET nombre=?, horas_semanales=?, ciclo=? WHERE codigoCurso=?";

        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getHorasSemanales());
            ps.setInt(3, curso.getCiclo());
            ps.setString(4, curso.getCodigoCurso());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar curso: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarCurso(String codCurso) {
        String sql = "DELETE FROM cursos WHERE codigoCurso = ?";
        
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, codCurso);
            return ps.executeUpdate() > 0;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar. El curso está asignado a un período académico o tiene matrículas.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar curso: " + e.getMessage());
        }
        return false;
    }
    
    public ResultSet listarCursos() {
        String sql = "SELECT codigoCurso, nombre, horas_semanales, ciclo FROM cursos ORDER BY codigoCurso,ciclo ";
        try {
            ps = co.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
            return null;
        }
    }
}
