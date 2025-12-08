package Objeto;

public class PeriodoAcademico {
    private String codigo;
    private String fechaInicio;
    private String fechaFin;
    private boolean estado;

    public PeriodoAcademico() {
    }

    public PeriodoAcademico(String codigo) {
        this.codigo = codigo;
    }
    
    public PeriodoAcademico(String codigo, String fechaInicio, String fechaFin, boolean estado) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
}
