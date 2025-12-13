package Conexion;

import Objeto.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "SELECT codigoCurso, nombre, horas_semanales, ciclo,fecha_curso FROM cursos ORDER BY codigoCurso,ciclo ";
        try {
            ps = co.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
            return null;
        }
    }

    public int obtenerIdCursoPorNombre(String nombreCurso) throws SQLException 
    {
        String sql = "SELECT idCursos FROM cursos WHERE nombre = ?";
        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombreCurso);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idCursos");
                }
            }
        }
        return -1;
    }
    public java.sql.ResultSet listarCursosParaCombo() throws SQLException {
            String sql = "SELECT  nombre " +
                         "FROM cursos " +
                         "ORDER BY nombre";

            java.sql.Connection cn = co.getConnection();
            java.sql.PreparedStatement ps = cn.prepareStatement(sql);
            return ps.executeQuery();
        }
    

    public List<String> listarCursosParaComboNotas(int idProfe) {
    List<String> lista = new ArrayList<>();

    String sql = """
                 SELECT DISTINCT
                     c.idCursos,
                     c.nombre AS nombre_curso,
                     s.codigoSeccion,
                     p.codigoPeriodo AS periodo_academico,
                     s.idseccion
                 FROM
                     secciones s
                 JOIN
                     cursos c ON s.idCursos = c.idCursos
                 JOIN
                     periodos_academicos p ON s.idPeriodoAcademico = p.idPeriodoAcademico
                 WHERE
                     s.idProfesor = ?
                 ORDER BY
                     nombre_curso, codigoSeccion;""";

    
    
     try (Connection con = co.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
      
        ps.setInt(1, idProfe);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            int id = rs.getInt("idCursos");
            String nombre = rs.getString("nombre_curso");

            String texto = id + " " + nombre;  // 👈 aqui: 1 Matemática
            lista.add(texto);
        } 
        }


    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, 
            "Error al listar cursos: " + e.getMessage());
    }

    return lista;
}

    }
