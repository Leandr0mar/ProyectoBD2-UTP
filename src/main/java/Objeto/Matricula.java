package Objeto;

import java.sql.Date;


public class Matricula {
    private String codigoMatricula;
    private int idAlumno;
    private int idCurso;
    private int idPeriodo;
    
    private String nombreAlumno; 
    private String nombreCurso; 
    private String codigoPeriodo; 
    private Date fechaMatricula;

    public Matricula() {
    }

    public Matricula(int idAlumno, int idCurso) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }

    
    public Matricula(int idAlumno, int idCurso, int idPeriodo, Date fechaMatricula) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
    }

    
    public Matricula(String codigoMatricula, int idAlumno, int idCurso, int idPeriodo, Date fechaMatricula) {
        this.codigoMatricula = codigoMatricula;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
    }

    public Matricula(String codigoMatricula, String nombreAlumno, String nombreCurso, String codigoPeriodo, Date fechaMatricula) {
        this.codigoMatricula = codigoMatricula;
        this.nombreAlumno = nombreAlumno;
        this.nombreCurso = nombreCurso;
        this.codigoPeriodo = codigoPeriodo;
        this.fechaMatricula = fechaMatricula;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }
    
    
}
