
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Almacen;
import modelo.Cliente;
import modelo.Conexion;
import modelo.Usuario;
import modelo.Proveedores;
public class ProveedoresDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean AgregarProveedor(Proveedores pro){
        String sql = "INSERT INTO proveedores (productoP, fechaentregap, empresap, RUCp) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProductoP());
            ps.setString(2, pro.getFechaentregap());
            ps.setString(3, pro.getEmpresap());
            ps.setString(4, pro.getRUCp());
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
    public List ListarProveedor(){
        List<Proveedores> ListaP = new ArrayList();
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Proveedores pro = new Proveedores();
                pro.setId_proveedor(rs.getInt("id_proveedor"));
                pro.setProductoP(rs.getString("productoP"));
                pro.setFechaentregap(rs.getString("fechaentregap"));
                pro.setEmpresap(rs.getString("empresap"));
                pro.setRUCp(rs.getString("RUCp"));
                ListaP.add(pro);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaP;
    }
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
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
    public boolean EditarProveedor(Proveedores pro){
        String sql = "UPDATE proveedores SET productoP=?, fechaentrega=?, empresap=?, RUCp=? WHERE id_proveedor =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,pro.getProductoP());
            ps.setString(2,pro.getFechaentregap());
            ps.setString(3,pro.getEmpresap());
            ps.setString(4,pro.getRUCp());
            ps.setInt(5,pro.getId_proveedor());
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
