package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Fabricacion;
import modelo.Usuario;

public class FabricacionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
     public boolean AgregarFabricacion(Fabricacion Fbr){
        String sql = "INSERT INTO tb_fabricacion (numero_tablero, nombre_producto, cantidad, fecha_fabricacion, tamanio, trabajador_fabricacion) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,Fbr.getNumero_tablero());
            ps.setString(2,Fbr.getNombre_producto());
            ps.setInt(3,Fbr.getCantidad());
            ps.setString(4,Fbr.getFecha_fabricacion());
            ps.setString(5,Fbr.getTamanio());
            ps.setString(6,Fbr.getTrabajador_fabricacion());
            ps.execute();
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }   finally {
            try {
                con.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarFabricacion(){
        List<Fabricacion> ListaFab = new ArrayList();
        String sql = "SELECT * FROM tb_fabricacion";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            Fabricacion Fbr = new Fabricacion();
            Fbr.setId_fabricacion(rs.getInt("id_fabricacion"));  // Cambiado a 'id_fabricacion'
            Fbr.setNumero_tablero(rs.getString("numero_tablero"));
            Fbr.setNombre_producto(rs.getString("nombre_producto"));
            Fbr.setCantidad(rs.getInt("cantidad"));
            Fbr.setFecha_fabricacion(rs.getString("fecha_fabricacion"));
            Fbr.setTamanio(rs.getString("tamanio"));
            Fbr.setTrabajador_fabricacion(rs.getString("trabajador_fabricacion"));
            ListaFab.add(Fbr);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaFab;
    }
    
    public boolean EliminarFabricacion(int id){
        String sql = "DELETE FROM tb_fabricacion WHERE id_fabricacion = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }   finally{
                try{
                    con.close();
                }   catch (SQLException ex){
                    System.out.println(ex.toString());
                }
        }
    }
    
    public boolean EditarFabricacion(Fabricacion Frb){
        String sql = "UPDATE tb_fabricacion SET numero_tablero=?, nombre_producto=?, cantidad=?, fecha_fabricacion=?, tamanio=?, trabajador_fabricacion=? WHERE id_fabricacion=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,Frb.getNumero_tablero());
            ps.setString(2,Frb.getNombre_producto());
            ps.setInt(3,Frb.getCantidad());
            ps.setString(4,Frb.getFecha_fabricacion());
            ps.setString(5,Frb.getTamanio());
            ps.setString(6,Frb.getTrabajador_fabricacion());
            ps.setInt(7,Frb.getId_fabricacion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }
}