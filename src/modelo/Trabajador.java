package modelo;
public class Trabajador {
    private int id_trabajador;
    private String nombreT;
    private String apellidoT;
    private String dniT;
    private String celularT;
    private String correoT;
    private String cargoT;

    public Trabajador() {
    }

    public Trabajador(int id_trabajador, String nombreT, String apellidoT, String dniT, String celularT, String correoT, String cargoT) {
        this.id_trabajador = id_trabajador;
        this.nombreT = nombreT;
        this.apellidoT = apellidoT;
        this.dniT = dniT;
        this.celularT = celularT;
        this.correoT = correoT;
        this.cargoT = cargoT;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public String getApellidoT() {
        return apellidoT;
    }

    public void setApellidoT(String apellidoT) {
        this.apellidoT = apellidoT;
    }

    public String getDniT() {
        return dniT;
    }

    public void setDniT(String dniT) {
        this.dniT = dniT;
    }

    public String getCelularT() {
        return celularT;
    }

    public void setCelularT(String celularT) {
        this.celularT = celularT;
    }

    public String getCorreoT() {
        return correoT;
    }

    public void setCorreoT(String correoT) {
        this.correoT = correoT;
    }

    public String getCargoT() {
        return cargoT;
    }

    public void setCargoT(String cargoT) {
        this.cargoT = cargoT;
    }

    
    
}
