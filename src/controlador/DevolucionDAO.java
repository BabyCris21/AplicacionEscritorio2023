package controlador;

import modelo.Conexion;
import modelo.Devolucion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DevolucionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean agregarDevolucion(Devolucion devolucion) {
        String sql = "INSERT INTO devoluciones (nombre, datos, fecha, cantidad, motivo) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devolucion.getNombre());
            ps.setString(2, devolucion.getDatos());
            ps.setDate(3, devolucion.getFecha());
            ps.setString(4, devolucion.getCantidad());
            ps.setString(5, devolucion.getMotivo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            cn.close(con);
        }
    }

    public List<Devolucion> listarDevoluciones() {
        List<Devolucion> listaDevoluciones = new ArrayList<>();
        String sql = "SELECT * FROM devoluciones";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Devolucion devolucion = new Devolucion();
                devolucion.setIdDevolucion(rs.getLong("id_devolucion"));
                devolucion.setNombre(rs.getString("nombre"));
                devolucion.setDatos(rs.getString("datos"));
                devolucion.setFecha(rs.getDate("fecha"));
                devolucion.setCantidad(rs.getString("cantidad"));
                devolucion.setMotivo(rs.getString("motivo"));
                listaDevoluciones.add(devolucion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            cn.close(con);
        }
        return listaDevoluciones;
    }

    public boolean eliminarDevolucion(long id) {
        String sql = "DELETE FROM devoluciones WHERE id_devolucion = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            cn.close(con);
        }
    }

    public boolean editarDevolucion(Devolucion devolucion) {
        String sql = "UPDATE devoluciones SET nombre=?, datos=?, fecha=?, cantidad=?, motivo=? WHERE id_devolucion=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devolucion.getNombre());
            ps.setString(2, devolucion.getDatos());
            ps.setDate(3, devolucion.getFecha());
            ps.setString(4, devolucion.getCantidad());
            ps.setString(5, devolucion.getMotivo());
            ps.setLong(6, devolucion.getIdDevolucion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            cn.close(con);
        }
    }

    public List<Devolucion> ListarDevoluciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Devolucion> ListarDevolucion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void AgregarDevolucion(Devolucion devolucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
