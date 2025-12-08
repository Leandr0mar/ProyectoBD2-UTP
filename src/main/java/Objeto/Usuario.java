package Objeto;

public class Usuario {
    private String codigo;
    private String email;
    private String contrasena;
    private String nombrecompleto;
    private String dni;
    private String rol;
    private boolean estado;
    private String token;

    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String token) {
        this.email = email;
        this.token = token;
    }
    
    public Usuario(String email, String contrasena, String nombrecompleto, String rol) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombrecompleto = nombrecompleto;
        this.rol = rol;
    }

    public Usuario(String email, String contrasena, String nombrecompleto, String dni, String rol, boolean estado) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombrecompleto = nombrecompleto;
        this.dni = dni;
        this.rol = rol;
        this.estado = estado;
    }
    
    
    
    public Usuario(String codigo, String email, String contrasena, String nombrecompleto, String dni, String rol, boolean estado) {
        this.codigo = codigo;
        this.email = email;
        this.contrasena = contrasena;
        this.nombrecompleto = nombrecompleto;
        this.dni = dni;
        this.rol = rol;
        this.estado = estado;
    }

    

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public String getToken() {
        return token;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }

    public boolean isEstado() {
        return estado;
    }

}
