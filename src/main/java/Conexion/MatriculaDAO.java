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
    
    
    public boolean registrarMatricula(int idAlumno, int idCurso,int idPeriodo) {
    // La tabla principal es 'matriculas'
        String insertar = "INSERT INTO matriculas(alumno_id, curso_id, periodo_id,) VALUES (?, ?, ?)";

        try {
            Connection cn = co.getConnection(); 

            // 2. Insertar matrícula nueva
            PreparedStatement ps = cn.prepareStatement(insertar);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idCurso);
            ps.setInt(3, idPeriodo);

            int filas = ps.executeUpdate();
            ps.close();

            return filas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar matrícula: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }
    
    public ResultSet listarMatriculas() throws SQLException {
        // Esta consulta debe coincidir con los nombres de columna usados en mostrarMatriculas()
        String sql = "SELECT m.codMatricula, " +
                     "a.nombre AS alumno_nombre, " +
                     "a.apellidos AS alumno_apellidos, " +
                     "c.nombre AS curso_asignatura, " + 
                     "m.fecha, m.hora " +
                     "FROM Matricula m " +
                     "JOIN Alumno a ON m.idAlumno = a.idAlumno " +
                     "JOIN Curso c ON m.idCurso = c.idCurso " +
                     "ORDER BY m.fecha DESC, m.hora DESC";

        Connection cn = co.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        
        // Si hay un error, se lanzará la SQLException automáticamente,
        // la cual será atrapada por el 'mostrarMatriculas()'
        return ps.executeQuery();
    }
}
