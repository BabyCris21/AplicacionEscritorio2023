package modelo;
public class Serviciocancelado {

    private int id_serviciocancelado;
    private String lugars;
    private String tiposervicio;
    private String RUCs;
    private String fechacancelacion;
    private String trabajador;
    
    
    public Serviciocancelado() {
    }
    
    public Serviciocancelado(int id_serviciocancelado, String lugars, String tiposervicio, String RUCs, String fechacancelacion, String trabajador) {
        this.id_serviciocancelado = id_serviciocancelado;
        this.lugars = lugars;
        this.tiposervicio = tiposervicio;
        this.RUCs = RUCs;
        this.fechacancelacion = fechacancelacion;
        this.trabajador = trabajador;
    }

    public int getId_serviciocancelado() {
        return id_serviciocancelado;
    }

    public void setId_serviciocancelado(int id_serviciocancelado) {
        this.id_serviciocancelado = id_serviciocancelado;
    }

    public String getLugars() {
        return lugars;
    }

    public void setLugars(String lugars) {
        this.lugars = lugars;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getRUCs() {
        return RUCs;
    }

    public void setRUCs(String RUCs) {
        this.RUCs = RUCs;
    }

    public String getFechacancelacion() {
        return fechacancelacion;
    }

    public void setFechacancelacion(String fechacancelacion) {
        this.fechacancelacion = fechacancelacion;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

}
