
package modelo;


public class Proveedores {
private int id_proveedor;
private String productoP;
private String fechaentregap;

    public String getEmpresap() {
        return empresap;
    }

    public void setEmpresap(String empresap) {
        this.empresap = empresap;
    }
private String empresap;
private String RUCp; 

    public Proveedores() {
    }

    public Proveedores(int id_proveedor, String productoP, String fechaentregap, String empresap, String RUCp) {
        this.id_proveedor = id_proveedor;
        this.productoP = productoP;
        this.fechaentregap = fechaentregap;
        this.empresap = empresap;
        this.RUCp = RUCp;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getProductoP() {
        return productoP;
    }

    public void setProductoP(String productoP) {
        this.productoP = productoP;
    }

    public String getFechaentregap() {
        return fechaentregap;
    }

    public void setFechaentregap(String fechaentregap) {
        this.fechaentregap = fechaentregap;
    }

    public String getNombre_empresap() {
        return empresap;
    }

    public void setNombre_empresap(String empresap) {
        this.empresap = empresap;
    }

    public String getRUCp() {
        return RUCp;
    }

    public void setRUCp(String RUCp) {
        this.RUCp = RUCp;
    }

    
}
