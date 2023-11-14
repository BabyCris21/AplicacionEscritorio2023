package modelo;
public class Almacen {
    private int id_producto;
    private String producto;
    private String marca;
    private Double precio;
    private int cantidad;

    public Almacen() {
    }

    public Almacen(int id_producto, String producto, String marca, Double precio, int cantidad) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
