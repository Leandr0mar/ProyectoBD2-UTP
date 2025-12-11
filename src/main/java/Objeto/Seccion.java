package Objeto;


public class Seccion {
    
    private int idSeccion;
    private String codigoSeccion;
    private String nombreProfesor;
    private String nombreCurso;
    private String codigoPeriodo;

    private int profesor_id;
    private int curso_id;
    private int periodo_id; 

    public Seccion(int profesor_id, int curso_id, int periodo_id) {
        this.profesor_id = profesor_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    
    
    public Seccion(String codigoSeccion, int profesor_id, int curso_id, int periodo_id) {
        this.codigoSeccion = codigoSeccion;
        this.profesor_id = profesor_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    public Seccion(int idSeccion, String codigoSeccion, String nombreProfesor, String nombreCurso, String codigoPeriodo, int profesor_id, int curso_id, int periodo_id) {
        this.idSeccion = idSeccion;
        this.codigoSeccion = codigoSeccion;
        this.nombreProfesor = nombreProfesor;
        this.nombreCurso = nombreCurso;
        this.codigoPeriodo = codigoPeriodo;
        this.profesor_id = profesor_id;
        this.curso_id = curso_id;
        this.periodo_id = periodo_id;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public int getProfesor_id() {
        return profesor_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public int getPeriodo_id() {
        return periodo_id;
    }
    
    
}
