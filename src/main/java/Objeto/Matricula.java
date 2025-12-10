package Objeto;

import java.util.Date;

public class Matricula {
    
    private String codigoMatricula;
    private String nombreAlumno;
    private String nombreCurso;
    private String codigoPeriodo;

    // Opcionalmente, para Modificar/Eliminar, podemos incluir los IDs:
    private int alumno_id;
    private int curso_id;
    private int periodo_id;

    public Matricula(int alumno_id, int curso_id, int periodo_id) {
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    
    
    public Matricula(String codigoMatricula, String nombreAlumno, String nombreCurso, String codigoPeriodo, int alumno_id, int curso_id, int periodo_id) {
        this.codigoMatricula = codigoMatricula;
        this.nombreAlumno = nombreAlumno;
        this.nombreCurso = nombreCurso;
        this.codigoPeriodo = codigoPeriodo;
        this.alumno_id = alumno_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
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
    
    // Si los necesitas para la lógica de modificación
    public int getAlumno_id() { return alumno_id; }
    public int getCurso_id() { return curso_id; }
    public int getPeriodo_id() { return periodo_id; }
}