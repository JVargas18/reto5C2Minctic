package model;

public class Req2 { 
    private int estrato;
    private int financiable; 
    private String fechaInicio; 
    private Double porcetaje; 
    
    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getFinanciable() {
        return financiable;
    }

    public void setFinanciable(int financiable) {
        this.financiable = financiable;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Double getPorcetaje() {
        return porcetaje;
    }

    public void setPorcetaje(Double porcetaje) {
        this.porcetaje = porcetaje;
    }

    @Override
    public String toString() {
        return "Req2 [estrato=" + estrato + ", fechaInicio=" + fechaInicio + ", financiable=" + financiable
                + ", porcetaje=" + porcetaje + "]";
    }

    public Req2(int estrato, int financiable, String fechaInicio, Double porcetaje) { 
        toString();
    }
}