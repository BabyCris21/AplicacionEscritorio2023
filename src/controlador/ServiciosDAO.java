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
        String sql = "INSERT INTO tb_servicios (lugar, tipo_servicio, fecha_servicio, trabajador_servicios, ruc_servicio, numero_boleta, material) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicio.getLugar());
            ps.setString(2, servicio.getTipoServicio());
            ps.setString(3, servicio.getFechaInicio());
            ps.setString(4, servicio.getTrabajador());
            ps.setString(5,servicio.getRucSer());
            ps.setString(6,servicio.getNuBole());
            ps.setString(7,servicio.getMaterial());
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
        String sql = "SELECT * FROM tb_servicios";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Servicios servicio = new Servicios();
                servicio.setIdServicio(rs.getLong("id_servicios"));
                servicio.setLugar(rs.getString("lugar"));
                servicio.setTipoServicio(rs.getString("tipo_servicio"));
                servicio.setFechaInicio(rs.getString("fecha_servicio"));
                servicio.setTrabajador(rs.getString("trabajador_servicios"));
                servicio.setRucSer(rs.getString("ruc_servicio"));
                servicio.setNuBole(rs.getString("numero_boleta"));
                servicio.setMaterial(rs.getString("material"));
             
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
        String sql = "DELETE FROM tb_servicios WHERE id_servicios = ?";
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

  
    
    public boolean EditarServicio(Servicios servicios){
        String sql = "UPDATE tb_servicios SET lugar=?, tipo_servicio=?, fecha_servicio=?, trabajador_servicios=?, ruc_servicio=?, numero_boleta=?, material=? WHERE id_servicios=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,servicios.getLugar());
            ps.setString(2,servicios.getTipoServicio());
            ps.setString(3,servicios.getFechaInicio());
            ps.setString(4,servicios.getTrabajador());
            ps.setString(5,servicios.getRucSer());
            ps.setString(6,servicios.getNuBole());
            ps.setString(7,servicios.getMaterial());
            ps.setLong(8,servicios.getIdServicio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                ps.close();
                }
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }
}
