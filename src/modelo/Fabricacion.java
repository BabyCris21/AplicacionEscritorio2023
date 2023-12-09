package modelo;
public class Fabricacion {
    private int id_fabricacion;
    private String numero_tablero;
    private String nombre_producto;
    private int cantidad;
    private String fecha_fabricacion;
    private String tamanio;
    private String trabajador_fabricacion;

    public Fabricacion() {
    }

    public Fabricacion(int id_fabricacion, String numero_tablero, String nombre_producto, int cantidad, String fecha_fabricacion, String tamanio, String trabajador_fabricacion) {
        this.id_fabricacion = id_fabricacion;
        this.numero_tablero = numero_tablero;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.fecha_fabricacion = fecha_fabricacion;
        this.tamanio = tamanio;
        this.trabajador_fabricacion = trabajador_fabricacion;
    }

    public int getId_fabricacion() {
        return id_fabricacion;
    }

    public void setId_fabricacion(int id_fabricacion) {
        this.id_fabricacion = id_fabricacion;
    }

    public String getNumero_tablero() {
        return numero_tablero;
    }

    public void setNumero_tablero(String numero_tablero) {
        this.numero_tablero = numero_tablero;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_fabricacion() {
        return fecha_fabricacion;
    }

    public void setFecha_fabricacion(String fecha_fabricacion) {
        this.fecha_fabricacion = fecha_fabricacion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getTrabajador_fabricacion() {
        return trabajador_fabricacion;
    }

    public void setTrabajador_fabricacion(String trabajador_fabricacion) {
        this.trabajador_fabricacion = trabajador_fabricacion;
    }
    
    
}
