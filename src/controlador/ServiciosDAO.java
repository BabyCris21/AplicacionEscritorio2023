package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Servicios;

public class ServiciosDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiciosDAO() {
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

    public boolean agregarServicio(Servicios servicio) {
        String sql = "INSERT INTO servicios (lugar, tipo_servicio, fecha_inicio, trabajador) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicio.getLugar());
            ps.setString(2, servicio.getTipoServicio());
            ps.setString(3, servicio.getFechaInicio());
            ps.setString(4, servicio.getTrabajador());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    servicio.setIdServicio(rs.getLong(1));
                    JOptionPane.showMessageDialog(null, "Servicio agregado con éxito. ID generado: " + servicio.getIdServicio());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el servicio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    public List<Servicios> listarServicios() {
        List<Servicios> listaServicios = new ArrayList<>();
        String sql = "SELECT * FROM servicios";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Servicios servicio = new Servicios();
                servicio.setIdServicio(rs.getLong("id_servicio"));
                servicio.setLugar(rs.getString("lugar"));
                servicio.setTipoServicio(rs.getString("tipo_servicio"));
                servicio.setFechaInicio(rs.getString("fecha_inicio"));
                servicio.setTrabajador(rs.getString("trabajador"));
                listaServicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarRecursos();
        }
        return listaServicios;
    }

    public boolean eliminarServicio(long id) {
        String sql = "DELETE FROM servicios WHERE id_servicio = ?";
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

    public boolean editarServicio(Servicios servicio) {
        String sql = "UPDATE servicios SET lugar=?, tipo_servicio=?, fecha_inicio=?, trabajador=? WHERE id_servicio=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, servicio.getLugar());
            ps.setString(2, servicio.getTipoServicio());
            ps.setString(3, servicio.getFechaInicio());
            ps.setString(4, servicio.getTrabajador());
            ps.setLong(5, servicio.getIdServicio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarRecursos();
        }
    }

    // Otros métodos según sea necesario
    // ...
}
