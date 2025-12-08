package Conexion;
import java.sql.*;
public class conexionBd {
    Connection cn;

    public conexionBd() {
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ProyectoBD2",
                "postgres",
                "root"
            );
            
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Error al conectar: "+e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return cn;
    }

}
