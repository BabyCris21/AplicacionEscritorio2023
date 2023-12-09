package modelo;
public class Almacen {
    private int id_almacen;
    private String producto;
    private String marca;
    private Double precio;
    private int cantidad;
    
        public Almacen() {
    }
    public Almacen(int id_almacen, String producto, String marca, Double precio, int cantidad) {
        this.id_almacen = id_almacen;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
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
