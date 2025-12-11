package Conexion;

import java.sql.*;
import Objeto.Usuario;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection con;
    conexionBd co = new conexionBd();
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario VerificarUsuario(String correo,String contrasena){
        
        Usuario u=null;
        String sql = "select email,contrasena,nombre_completo,rol from usuarios where email=? and contrasena=? and estado=true";
        
        try{
            con=co.getConnection();
            
            ps =con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                String emailDB = rs.getString("email");
                String contrasenaDB = rs.getString("contrasena");
                String nombreCompleto= rs.getString("nombre_completo");
                String rolDB = rs.getString("rol");
                
                u = new Usuario(emailDB,contrasenaDB,nombreCompleto,rolDB);
            }
        } catch(SQLException e){
            System.out.println("Error al verificar validacion: " + e.getMessage());
        }
        
        return u;
    }
    
    public Usuario VerificarCorreo(String correo){
        Usuario u=null;
        String sql = "select email from usuarios where email=? and estado=true";
        
        try{
            con=co.getConnection();
            
            ps =con.prepareStatement(sql);
            ps.setString(1, correo);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                String emailDB = rs.getString("email");

                u = new Usuario(emailDB);
            }
        } catch(SQLException e){
            System.out.println("Error al verificar correo: " + e.getMessage());
        }
        
        return u;
    }
    
    public String generarTokenRecuperacion(String email) {

        String token = java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Timestamp expiracion = new Timestamp(System.currentTimeMillis() + (30 * 60 * 1000));

        String sql = "UPDATE usuarios SET token_recuperacion=?, token_expiracion=? WHERE email=?";

        try (Connection con = co.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, token);
            ps.setTimestamp(2, expiracion);
            ps.setString(3, email);

            if (ps.executeUpdate() > 0) {
                return token;
            }
        } catch (SQLException e) {
            System.out.println("Error al generar token: " + e.getMessage());
        }
        return null;
    }
    
    public Usuario verificarToken(String correo,String token){
        Usuario u=null;
        String sql= "select email,token_recuperacion from usuarios where email=? AND token_recuperacion=? AND token_expiracion > CURRENT_TIMESTAMP";
        
        try{
            con=co.getConnection();

            ps =con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, token);

            rs=ps.executeQuery();
            if(rs.next()){
                String emailDB = rs.getString("email");
                String tokenRe = rs.getString("token_recuperacion");

                u = new Usuario(emailDB,tokenRe);
            }
        } catch(Exception e){
            System.out.println("Error al verificar token: " + e.getMessage());
        }
            
        
        return u;
    }
    
    public boolean restablecerContrasena(String email, String token, String nuevaContrasena) {
        String sql = "UPDATE usuarios SET contrasena=?, token_recuperacion=NULL, token_expiracion=NULL " +
                     "WHERE email=? AND token_recuperacion=? AND token_expiracion > CURRENT_TIMESTAMP";

        try (Connection con = co.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, nuevaContrasena);
            ps.setString(2, email);
            ps.setString(3, token);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al restablecer contraseña: " + e.getMessage());
        }
        return false;
    }

    //CRUD
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (email, contrasena, nombre_completo, dni, rol, estado) " + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getNombrecompleto());
            ps.setString(4, usuario.getDni());
            ps.setString(5, usuario.getRol());
            ps.setBoolean(6, usuario.isEstado());
            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error de duplicacion de Datos(dni o correo): " + e);
        } catch (Exception e) {
            System.out.println("Error al insertar Usuario: " + e);
        }
        return false;
    }

    public boolean eliminarUsuario(String codigo) {
        String sql = "DELETE FROM Usuarios WHERE codigo = ?";
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar. El Usuario tiene matr\u00edculas registradas.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.getMessage());
        }
        return false;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET email=?, contrasena=?, nombre_completo=?, dni=?, rol=?, estado=? WHERE codigo=?";
        try (PreparedStatement ps = co.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getNombrecompleto());
            ps.setString(4, usuario.getDni());
            ps.setString(5, usuario.getRol());
            ps.setBoolean(6, usuario.isEstado());
            ps.setString(7, usuario.getCodigo());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Usuario: " + e.getMessage());
            return false;
        }
    }

    public ResultSet listarUsuarios() {
        rs = null;
        try {
            String sql = "SELECT codigo,email, contrasena, nombre_completo, dni, rol, estado, fecha_usuario FROM usuarios order by codigo";
            ps = co.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al listar Usuarios: " + e.getMessage());
        }
        return rs;
    } 
    
    public ResultSet listarUsuariosAlumnos() {
        rs = null;
        try {
            String sql = "SELECT codigo,email, contrasena, nombre_completo, dni, rol, estado FROM usuarios WHERE rol like('alumno')order by codigo";
            ps = co.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al listar Usuarios: " + e.getMessage());
        }
        return rs;
    }
    
    public int obtenerIdAlumnoPorNombre(String nombreCompleto) throws SQLException {
        String sql = "SELECT idUsuarios FROM usuarios WHERE nombre_completo = ? AND rol = 'alumno'";
        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombreCompleto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idUsuarios");
                }
            }
        }
        return -1;
    }
    
    public int obtenerIdProfesorPorNombre(String nombreCompleto) throws SQLException {
        String sql = "SELECT idUsuarios FROM usuarios WHERE nombre_completo = ? AND rol = 'profesor'";
        try (Connection cn = co.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombreCompleto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idUsuarios");
                }
            }
        }
        return -1;
    }
    
    public java.sql.ResultSet listarAlumnosParaCombo() throws SQLException {
        String sql = "SELECT nombre_completo " +
                     "FROM usuarios " +
                     "WHERE rol = 'alumno' " +
                     "ORDER BY nombre_completo";

        java.sql.Connection cn = co.getConnection();
        java.sql.PreparedStatement ps = cn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public java.sql.ResultSet listarProfesorParaCombo() throws SQLException {
        String sql = "SELECT nombre_completo " +
                     "FROM usuarios " +
                     "WHERE rol = 'profesor' and estado=true " +
                     "ORDER BY nombre_completo";

        java.sql.Connection cn = co.getConnection();
        java.sql.PreparedStatement ps = cn.prepareStatement(sql);
        return ps.executeQuery();
    }
    
    public ResultSet listarAlumnosPorCodigoSeccion(String codigoSeccion) throws SQLException {
        String sql = """
        SELECT DISTINCT 
               u.idUsuarios AS idAlumno, 
               u.nombre_completo
        FROM usuarios u
        JOIN matriculas m ON u.idUsuarios = m.alumno_id
        JOIN secciones s ON m.curso_id = s.idCursos 
                        AND m.periodo_id = s.idPeriodoAcademico
        JOIN periodos_academicos pa ON s.idPeriodoAcademico = pa.idPeriodoAcademico
        WHERE s.codigoSeccion = ?
          AND u.rol = 'alumno'
          AND u.estado = true
          AND pa.activo = true
        ORDER BY u.nombre_completo
        """;

        Connection cn = co.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, codigoSeccion.trim());
        return ps.executeQuery();
    }
}
