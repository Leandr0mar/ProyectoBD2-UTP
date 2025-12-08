package Conexion;

import java.sql.*;
import Objeto.PeriodoAcademico;
import javax.swing.JOptionPane;

public class PeriodoAcademicoDAO {
    Connection con;
    conexionBd co = new conexionBd();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarPeriodo(PeriodoAcademico periodo) {
        // Lógica clave: Desactivar el periodo activo anterior si el nuevo será activo
        if (periodo.isEstado()) {
            desactivarPeriodoActivoAnterior();
        }

        String sql = "INSERT INTO periodos_academicos (codigoPeriodo, fecha_inicio, fecha_fin, activo) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {

            Date fechaInicioSQL = Date.valueOf(periodo.getFechaInicio());
            Date fechaFinSQL = Date.valueOf(periodo.getFechaFin());
            
            ps.setString(1, periodo.getCodigo());
            ps.setDate(2, fechaInicioSQL);
            ps.setDate(3, fechaFinSQL);
            ps.setBoolean(4, periodo.isEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar periodo: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha. Use YYYY-MM-DD.");
            return false;
        }
    }
    
    private void desactivarPeriodoActivoAnterior() {
        String sql = "UPDATE periodos_academicos SET activo = FALSE WHERE activo = TRUE";
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al desactivar periodos antiguos: " + e.getMessage());
        }
    }
    
    public boolean actualizarPeriodo(String codPeriodo, PeriodoAcademico periodo) {
        if (periodo.isEstado()) {
            desactivarPeriodoActivoAnterior();
        }
        
        String sql = "UPDATE periodos_academicos SET codigoPeriodo=?, fecha_inicio=?, fecha_fin=?, activo=? WHERE codigoPeriodo=?";

        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            
            Date fechaInicioSQL = Date.valueOf(periodo.getFechaInicio());
            Date fechaFinSQL = Date.valueOf(periodo.getFechaFin());
            
            ps.setString(1, periodo.getCodigo());
            ps.setDate(2, fechaInicioSQL);
            ps.setDate(3, fechaFinSQL);
            ps.setBoolean(4, periodo.isEstado());
            ps.setString(5, codPeriodo); // Clave de búsqueda

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar periodo: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarPeriodo(String codigoPeriodo) {
        String sql = "DELETE FROM periodos_academicos WHERE codigoPeriodo = ?";
        
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, codigoPeriodo);
            return ps.executeUpdate() > 0;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar. El periodo tiene cursos o matrículas asociadas.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar periodo: " + e.getMessage());
        }
        return false;
    }
    
    public ResultSet listarPeriodos() {
        String sql = "SELECT idPeriodoAcademico, codigoPeriodo, fecha_inicio, fecha_fin, activo FROM periodos_academicos ORDER BY fecha_inicio";
        try {
            PreparedStatement ps = co.getConnection().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al listar periodos: " + e.getMessage());
            return null;
        }
    }
    
    public int obtenerIdPeriodoActivo() throws IllegalStateException {
         String sql = "SELECT idPeriodoAcademico FROM periodos_academicos WHERE activo = TRUE AND CURRENT_DATE BETWEEN fecha_inicio AND fecha_fin";
         try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
             if (rs.next()) return rs.getInt(1);
             else throw new IllegalStateException("El sistema no tiene un período académico activo/vigente.");
         }catch (SQLException e) {
            System.out.println("Error al listar periodos: " + e.getMessage());
        }
        return 0;
      }
}
