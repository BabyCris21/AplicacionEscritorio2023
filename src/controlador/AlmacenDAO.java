package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Almacen;
import modelo.Conexion;

public class AlmacenDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean AgregarAlmacen(Almacen alm){
        String sql = "INSERT INTO tb_almacen (producto, marca, precio, cantidad) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, alm.getProducto());
            ps.setString(2, alm.getMarca());
            ps.setDouble(3, alm.getPrecio());
            ps.setInt(4,alm.getCantidad());
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

    public List ListarAlmacen(){
            List<Almacen> ListaAlm = new ArrayList();
            String sql = "SELECT * FROM tb_almacen";
            try {
                con = cn.getConnection();
                ps = con.prepareCall(sql);
                rs = ps.executeQuery();         
                while(rs.next()){
                    Almacen alm = new Almacen();
                    alm.setId_producto(rs.getInt("id_almacen"));
                    alm.setProducto(rs.getString("producto"));
                    alm.setMarca(rs.getString("marca"));
                    alm.setPrecio(rs.getDouble("precio"));
                    alm.setCantidad(rs.getInt("cantidad"));
                    ListaAlm.add(alm);
                }      
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        return ListaAlm;
    }
    
     public boolean EliminarAlmacen(int id){
        String sql = "DELETE FROM tb_almacen WHERE id_almacen = ?";
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
     
     public boolean EditarAlmacen(Almacen alm){
        String sql = "UPDATE tb_almacen SET producto=?, marca=?, precio=?, cantidad=? WHERE id_almacen=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alm.getProducto());
            ps.setString(2,alm.getMarca());
            ps.setDouble(3,alm.getPrecio());
            ps.setInt(4,alm.getCantidad());
            ps.setInt(5,alm.getId_producto());
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
