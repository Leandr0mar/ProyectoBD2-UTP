package Conexion;
import java.sql.*;
public class conexionBd {
    public conexionBd() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de PostgreSQL: " + e.getMessage());
        }
    }
    
    public Connection getConnection() throws SQLException {
        try {
            Connection cn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ProyectoBD2",
                "postgres",
                "root"
            );
            return cn;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            throw e;
        }
    }

}
