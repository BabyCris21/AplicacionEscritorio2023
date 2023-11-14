import java.util.Date;

public class ºMovimiento_Categoria {

    int id;
    int id_usuario;
    int activo;

    String Nombre;
    Date fecha_registro;

    public Movimiento_Categoria(int id, int id_usuario, int activo, String nombre, Date fecha_registro) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.activo = activo;
        Nombre = nombre;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
