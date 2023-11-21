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
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean AgregarDevolucion(Devolucion devolucion) {
        String sql = "INSERT INTO devoluciones (nombreD, datosD, fechaD, cantidadD, motivoD) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devolucion.getNombreD());
            ps.setString(2, devolucion.getDatosD());
            ps.setString(3, devolucion.getFechaD());
            ps.setString(4, devolucion.getCantidadD());
            ps.setString(5, devolucion.getMotivoD());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarDevoluciones() {
        List<Devolucion> ListaDevoluciones = new ArrayList();
        String sql = "SELECT * FROM devoluciones";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Devolucion devolucion = new Devolucion();
                devolucion.setIdDevolucion(rs.getInt("id_devolucion"));
                devolucion.setNombreD(rs.getString("nombreD"));
                devolucion.setDatosD(rs.getString("datosD"));
                devolucion.setFechaD(rs.getString("fechaD"));
                devolucion.setCantidadD(rs.getString("cantidadD"));
                devolucion.setMotivoD(rs.getString("motivoD"));
                ListaDevoluciones.add(devolucion);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaDevoluciones;
    }

    public boolean EliminarDevolucion(int id) {
        String sql = "DELETE FROM devoluciones WHERE id_devolucion = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

        public boolean EditarDevolucion(Devolucion devolucion) {
        String sql = "UPDATE devoluciones SET nombreD=?, datosD=?, fechaD=?, cantidadD=?, motivoD=? WHERE id_devolucion =?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devolucion.getNombreD());
            ps.setString(2, devolucion.getDatosD());
            ps.setString(3, devolucion.getFechaD());
            ps.setString(4, devolucion.getCantidadD());
            ps.setString(5, devolucion.getMotivoD());
            // No se establece el ID en la sentencia UPDATE
            ps.setInt(6, devolucion.getIdDevolucion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

}
