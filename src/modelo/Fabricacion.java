package modelo;
public class Fabricacion {
    private int id_fabricacion;
    private String num_tablero;
    private String tablero;
    private byte[] foto_tablero;
    private String material;

    public Fabricacion() {
    }

    public Fabricacion(int id_fabricacion, String num_tablero, String tablero, byte[] foto_tablero, String material) {
        this.id_fabricacion = id_fabricacion;
        this.num_tablero = num_tablero;
        this.tablero = tablero;
        this.foto_tablero = foto_tablero;
        this.material = material;
    }

    public int getId_fabricacion() {
        return id_fabricacion;
    }

    public void setId_fabricacion(int id_fabricacion) {
        this.id_fabricacion = id_fabricacion;
    }

    public String getNum_tablero() {
        return num_tablero;
    }

    public void setNum_tablero(String num_tablero) {
        this.num_tablero = num_tablero;
    }

    public String getTablero() {
        return tablero;
    }

    public void setTablero(String tablero) {
        this.tablero = tablero;
    }

    public byte[] getFoto_tablero() {
        return foto_tablero;
    }

    public void setFoto_tablero(byte[] foto_tablero) {
        this.foto_tablero = foto_tablero;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
