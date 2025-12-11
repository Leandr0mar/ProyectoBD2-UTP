package Objeto;

public class Matricula {
    
    private int idMatricula;
    private String codigoMatricula;
    private String nombreAlumno;
    private String nombreCurso;
    private String codigoPeriodo;
    private String nombreProfesor;
    
    private int alumno_id;
    private int curso_id;
    private int periodo_id;
    private int seccion_id;

    public Matricula(int alumno_id, int curso_id, int periodo_id) {
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    public Matricula(String codigoMatricula, int alumno_id, int curso_id, int periodo_id) {
        this.codigoMatricula = codigoMatricula;
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    public Matricula(String codigoMatricula, int alumno_id, int curso_id, int periodo_id, int seccion_id) {
        this.codigoMatricula = codigoMatricula;
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
        this.seccion_id = seccion_id;
    }

    public Matricula(int alumno_id, int curso_id, int periodo_id, int seccion_id) {
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
        this.seccion_id = seccion_id;
    }

    
    
    public Matricula(int idMatricula, String codigoMatricula, String nombreAlumno, String nombreCurso, String codigoPeriodo, int alumno_id, int curso_id, int periodo_id) {
        this.idMatricula = idMatricula;
        this.codigoMatricula = codigoMatricula;
        this.nombreAlumno = nombreAlumno;
        this.nombreCurso = nombreCurso;
        this.codigoPeriodo = codigoPeriodo;
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }
    
    public int getIdMatricula() { 
        return idMatricula; 
    }
    
    public String getCodigoMatricula() {
        return codigoMatricula;
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
    
    public int getAlumno_id() {
        return alumno_id; 
    }
    public int getCurso_id() { 
        return curso_id; 
    }
    public int getPeriodo_id() { 
        return periodo_id; 
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public int getSeccion_id() {
        return seccion_id;
    }
    
    
}