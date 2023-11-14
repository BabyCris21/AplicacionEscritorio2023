package modelo;
public class Login {
    private int id;
    private String usuario;
    private String pass;

    public Login() {
    }

    public Login(int id_usuarios, String usuario, String pass) {
        this.id = id_usuarios;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_usuarios) {
        this.id = id_usuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
