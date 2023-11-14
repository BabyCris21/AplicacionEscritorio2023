import java.util.Date;

public class Cuenta {

    int id_usuario;
    int id_cuenta;
    int activo;

    String Nombre;
    String Descripcion;

    Date fecha_creacion;

    public Cuenta(int id_usuario, int id_cuenta, int activo, String nombre, String descripcion, Date fecha_creacion) {
        this.id_usuario = id_usuario;
        this.id_cuenta = id_cuenta;
        this.activo = activo;
        Nombre = nombre;
        Descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
