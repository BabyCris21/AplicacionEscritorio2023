package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Devolucion;

public class DevolucionDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public DevolucionDAO() {
        Conexion conexion = new Conexion();
        con = conexion.getConnection();
    }

    private void cerrarRecursos() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            // No cierres la conexión aquí para poder reutilizarla en otros métodos.
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e);
        }
    }

    public boolean agregarDevolucion(Devolucion devolucion) {
        String sql = "INSERT INTO tb_devolucion (nombre_empresa, ruc_devolucion, fecha_devolucion, cantidad_devolucion, producto, tipo_cantidad) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, devolucion.getNombre());
            ps.setString(2, devolucion.getDatos());
            ps.setString(3, devolucion.getFecha());
            ps.setString(4, devolucion.getCantidad());
            ps.setString(5, devolucion.getProducto());
            ps.setString(6,devolucion.getTip_cantidad());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    devolucion.setIdDevolucion(rs.getLong(1));
                    JOptionPane.showMessageDialog(null, "Devolución agregada con éxito. ID generado: " + devolucion.getIdDevolucion());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar la devolución.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    public List<Devolucion> listarDevoluciones() {
        List<Devolucion> listaDevoluciones = new ArrayList<>();
        String sql = "SELECT * FROM tb_devolucion";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Devolucion devolucion = new Devolucion();
                devolucion.setIdDevolucion(rs.getLong("id_devolucion"));
                devolucion.setNombre(rs.getString("nombre_empresa"));
                devolucion.setDatos(rs.getString("ruc_devolucion"));
                devolucion.setFecha(rs.getString("fecha_devolucion"));
                devolucion.setCantidad(rs.getString("cantidad_devolucion"));
                devolucion.setProducto(rs.getString("producto"));
                devolucion.setTip_cantidad(rs.getString("tipo_cantidad"));
                listaDevoluciones.add(devolucion);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarRecursos();
        }
        return listaDevoluciones;
    }

    public boolean eliminarDevolucion(long id) {
        String sql = "DELETE FROM tb_devolucion WHERE id_devolucion = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    public boolean editarDevolucion(Devolucion devolucion) {
        String sql = "UPDATE tb_devolucion SET nombre_empresa=?, ruc_devolucion=?, fecha_devolucion=?, cantidad_devolucion=?, producto=?, tipo_cantidad=? WHERE id_devolucion=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, devolucion.getNombre());
            ps.setString(2, devolucion.getDatos());
            ps.setString(3, devolucion.getFecha());
            ps.setString(4, devolucion.getCantidad());
            ps.setString(5, devolucion.getProducto());
            ps.setString(6,devolucion.getTip_cantidad());
            ps.setLong(7, devolucion.getIdDevolucion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarRecursos();
        }
    }
}
