package modelo;

public class Servicios {
    private long idServicio;
    private String lugar;
    private String tipoServicio;
    private String fechaInicio;
    private String trabajador;

    public Servicios(){
        
    }
    
    // Constructor
    public Servicios(String lugar, String tipoServicio, String fechaInicio, String trabajador) {
        this.lugar = lugar;
        this.tipoServicio = tipoServicio;
        this.fechaInicio = fechaInicio;
        this.trabajador = trabajador;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
}
