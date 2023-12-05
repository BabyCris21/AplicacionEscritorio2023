package modelo;

public class Servicios {
    private long idServicio;
    private String lugar;
    private String tipoServicio;
    private String fechaInicio;
    private String trabajador;
    private String rucSer;
    private String nuBole;
    private String material;

    public Servicios(){
        
    }
    
    // Constructor
    public Servicios(String lugar, String tipoServicio, String fechaInicio, String trabajador, String rucSer, String nuBole, String material) {
        this.lugar = lugar;
        this.tipoServicio = tipoServicio;
        this.fechaInicio = fechaInicio;
        this.trabajador = trabajador;
        this.rucSer = rucSer;
        this.nuBole = nuBole;
        this.material = material;
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

    public String getRucSer() {
        return rucSer;
    }

    public void setRucSer(String rucSer) {
        this.rucSer = rucSer;
    }

    public String getNuBole() {
        return nuBole;
    }

    public void setNuBole(String nuBole) {
        this.nuBole = nuBole;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
