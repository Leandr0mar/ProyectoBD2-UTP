package Conexion;

import java.sql.*;
import Objeto.Matricula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MatriculaDAO {
    conexionBd co = new conexionBd();

    public boolean registrarMatricula(Matricula ma) {
        String verificarExistencia = "SELECT idMatriculas FROM matriculas WHERE alumno_id=? AND curso_id=? AND periodo_id=?";
        
        String insertar = "INSERT INTO matriculas(alumno_id, curso_id, periodo_id) VALUES (?, ?, ?)";

        try (Connection cn = co.getConnection()) {
            
            PreparedStatement psCheck = cn.prepareStatement(verificarExistencia);
            psCheck.setInt(1, ma.getAlumno_id());
            psCheck.setInt(2, ma.getCurso_id());
            psCheck.setInt(3, ma.getPeriodo_id());
            
            try (ResultSet rsCheck = psCheck.executeQuery()) {
                if (rsCheck.next()) {
                    // Si encuentra un resultado, la matrícula ya existe.
                    System.err.println("La matrícula ya existe para este alumno, curso y periodo.");
                    return false;
                }
            }
            
            psCheck.close(); 
            
            PreparedStatement ps = cn.prepareStatement(insertar);
            ps.setInt(1, ma.getAlumno_id());
            ps.setInt(2, ma.getCurso_id());
            ps.setInt(3, ma.getPeriodo_id());

            int filas = ps.executeUpdate();
            ps.close();
            
            return filas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar matrícula: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }
    
    public boolean modificarMatricula(Matricula ma) {
        String actualizar = "UPDATE matriculas SET alumno_id=?, curso_id=?, periodo_id=? WHERE codigoMatricula=?";

        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(actualizar)) {

            ps.setInt(1, ma.getAlumno_id()); 
            ps.setInt(2, ma.getCurso_id()); 
            ps.setInt(3, ma.getPeriodo_id()); 
            ps.setString(4, ma.getCodigoMatricula()); 
            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error de unicidad al modificar matrícula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar: La combinación Alumno, Curso y Periodo ya existe.");
            return false;
        } catch (SQLException e) {
            System.err.println("Error al modificar matrícula: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean eliminarMatricula(String codMatricula) {
        String eliminar = "DELETE FROM matriculas WHERE codigoMatricula = ?";

        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(eliminar)) {

            ps.setString(1, codMatricula);
            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error de restricción de clave foránea al eliminar matrícula: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede eliminar la matrícula. Existen Notas, Asistencias o Certificados asociados.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            System.err.println("Error al eliminar matrícula: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet listarMatriculas() {
        String sql = "SELECT m.idMatriculas, m.codigoMatricula, " +
                     "u.nombre_completo AS alumno_nombre, " +
                     "c.nombre AS curso_nombre, m.fecha_matricula as fecha_matricula," +
                     "pa.codigoPeriodo AS periodo_codigo, " +
                     "m.alumno_id, m.curso_id, m.periodo_id " +
                     "FROM matriculas m " +
                     "JOIN usuarios u ON m.alumno_id = u.idUsuarios " +
                     "JOIN cursos c ON m.curso_id = c.idCursos " +
                     "JOIN periodos_academicos pa ON m.periodo_id = pa.idPeriodoAcademico " +
                     "ORDER BY m.idMatriculas";

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
