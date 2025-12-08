package Objeto;

public class Curso {
    private String codigoCurso;
    private String nombre;
    private int horasSemanales;
    private int ciclo;

    public Curso() {
    }

    public Curso(String codigoCurso, String nombre, int horasSemanales, int ciclo) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.ciclo = ciclo;
    }

    public Curso(int idCursos, String codigoCurso, String nombre, int horasSemanales, int ciclo) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.ciclo = ciclo;
    }


    public String getCodigoCurso() {
        return codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public int getCiclo() {
        return ciclo;
    }
}
