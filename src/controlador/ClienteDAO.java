package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Conexion;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean AgregarCliente(Cliente cl){
        String sql = "INSERT INTO tb_clientes (nombre_cliente, direccion_cliente, ruc_cliente) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre_cliente());
            ps.setString(2, cl.getDireccion_cliente());
            ps.setString(3, cl.getRuc_cliente());
            ps.execute();
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarClientes(){
        List<Cliente> ListaC = new ArrayList();
        String sql = "SELECT * FROM tb_clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("id_cliente"));
                cl.setNombre_cliente(rs.getString("nombre_cliente"));
                cl.setDireccion_cliente(rs.getString("direccion_cliente"));
                cl.setRuc_cliente(rs.getString("ruc_cliente"));
                ListaC.add(cl);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaC;
    }
    
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM tb_clientes WHERE id_cliente = ?";
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
    
    public boolean EditarCliente(Cliente cl){
        String sql = "UPDATE tb_clientes SET nombre_cliente=?, direccion_cliente=?, ruc_cliente=? WHERE id_cliente=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cl.getNombre_cliente());
            ps.setString(2,cl.getDireccion_cliente());
            ps.setString(3,cl.getRuc_cliente());
            ps.setInt(4,cl.getId_cliente());
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
    public  Cliente buscarcliente(int ruc_cliente){
        Cliente cl = new Cliente ();
        String sql = "SELECT * FROM tb_clientes WHERE ruc_cliente=?";
        try {
             con= cn.getConnection();
             ps=con.prepareStatement(sql);
             ps.setInt(1, ruc_cliente);
             rs=ps.executeQuery();
             if(rs.next()){
                 cl.setNombre_cliente(rs.getString("nombre"));
                 cl.setDireccion_cliente(rs.getString("direccion"));
                 
             }
         } catch (Exception e) { 
             System.out.println(e.toString());
         }
         return cl;
    }
}



