package Conexion;

import java.sql.*;
import Objeto.Matricula;
import java.util.ArrayList;
import java.util.List;
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
      // CORRECCIÓN: Incluir periodo_id y fecha_matricula en la SQL.
      String sql = "INSERT INTO matriculas (alumno_id, curso_id, periodo_id, fecha_matricula) VALUES (?, ?, ?, CURRENT_DATE)";

      try (Connection conn = co.getConnection()) {

          // El DAO obtiene el ID del período activo automáticamente
          int idPeriodoActivo = periodoDAO.obtenerIdPeriodoActivo(); 

          try (PreparedStatement ps = conn.prepareStatement(sql)) {

              // 1. Mapear alumno_id
              ps.setInt(1, matricula.getIdAlumno());

              // 2. Mapear curso_id
              ps.setInt(2, matricula.getIdCurso());

              // 3. Mapear periodo_id (¡Nuevo índice 3!)
              ps.setInt(3, idPeriodoActivo); 

              // 4. fecha_matricula se maneja con CURRENT_DATE en la SQL, no necesita índice.

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
    
    public boolean eliminarMatricula(String codigoMatricula) {
        String sql = "DELETE FROM matriculas WHERE codigoMatricula = ?";
        
        try (Connection conn = co.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, codigoMatricula);
            return ps.executeUpdate() > 0;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            // El error ocurrirá si la tabla 'notas' tiene una FK a esta matrícula
            JOptionPane.showMessageDialog(null, "❌ No se puede anular la matrícula " + codigoMatricula + " porque tiene notas registradas.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar matrícula: " + e.getMessage());
        }
        return false;
    }
    
    public List<Matricula> listarMatriculasObjetos() {
        List<Matricula> lista = new ArrayList<>();
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

        // Usar try-with-resources para cerrar Connection, PS y RS inmediatamente
        try (Connection conn = co.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Crea un objeto Matricula para la lista (usando el constructor de listado)
                Matricula m = new Matricula(
                    rs.getString("codigoMatricula"),
                    rs.getString("nombre_alumno"),
                    rs.getString("nombre_curso"),
                    rs.getString("codigo_periodo"),
                    rs.getDate("fecha_matricula")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar matrículas (DAO): " + e.getMessage());
            // En caso de error, la lista simplemente se devuelve vacía.
            return new ArrayList<>(); 
        }
        return lista;
    }
            
}
