package modelo;

public class Devolucion {
    private long idDevolucion;
    private String nombre;
    private String datos;
    private String fecha;
    private String cantidad;
    private String producto;
    private String t_cantidad;

    // Constructor
    public Devolucion() {
    }

    public Devolucion(long idDevolucion, String nombre, String datos, String fecha, String cantidad, String producto, String t_cantidad) {
        this.idDevolucion = idDevolucion;
        this.nombre = nombre;
        this.datos = datos;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.producto = producto;
        this.t_cantidad = t_cantidad;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public String getTip_cantidad() {
        return t_cantidad;
    }

    public void setTip_cantidad(String t_cantidad) {
        this.t_cantidad = t_cantidad;
    }
}
