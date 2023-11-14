package modelo;
public class Cliente {
    private int id_cliente;
    private String nombreC;
    private String direccionC;
    private String ruc;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombreC, String direccionC, String ruc) {
        this.id_cliente = id_cliente;
        this.nombreC = nombreC;
        this.direccionC = direccionC;
        this.ruc = ruc;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
}
