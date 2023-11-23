package modelo;

public class Devolucion {
    private long idDevolucion;
    private String nombre;
    private String datos;
    private String fecha;
    private String cantidad;
    private String motivo;

    // Constructor
    public Devolucion() {
    }

    public Devolucion(long idDevolucion, String nombre, String datos, String fecha, String cantidad, String motivo) {
        this.idDevolucion = idDevolucion;
        this.nombre = nombre;
        this.datos = datos;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    
    // Getters y setters

    public long getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(long idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
