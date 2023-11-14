
package modelo;

public class Usuario {
private int id_usuarioU;
private String usuarioU;
private String cargoU;
private String contraseñaU;

    public Usuario() {
    }

    public Usuario(int id_usuarioU, String usuarioU, String cargoU, String contraseñaU) {
        this.id_usuarioU = id_usuarioU;
        this.usuarioU = usuarioU;
        this.cargoU = cargoU;
        this.contraseñaU = contraseñaU;
    }

    public int getId_usuarioU() {
        return id_usuarioU;
    }

    public void setId_usuarioU(int id_usuarioU) {
        this.id_usuarioU = id_usuarioU;
    }

    public String getUsuarioU() {
        return usuarioU;
    }

    public void setUsuarioU(String usuarioU) {
        this.usuarioU = usuarioU;
    }

    public String getCargoU() {
        return cargoU;
    }

    public void setCargoU(String cargoU) {
        this.cargoU = cargoU;
    }

    public String getContraseñaU() {
        return contraseñaU;
    }

    public void setContraseñaU(String contraseñaU) {
        this.contraseñaU = contraseñaU;
    }
}
