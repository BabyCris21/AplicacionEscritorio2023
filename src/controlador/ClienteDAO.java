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
        String sql = "INSERT INTO clientes (nombreC, direccionC, ruc) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreC());
            ps.setString(2, cl.getDireccionC());
            ps.setString(3, cl.getRuc());
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
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("id_cliente"));
                cl.setNombreC(rs.getString("nombreC"));
                cl.setDireccionC(rs.getString("direccionC"));
                cl.setRuc(rs.getString("ruc"));
                ListaC.add(cl);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaC;
    }
    
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
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
        String sql = "UPDATE clientes SET nombreC=?, direccionC=?, ruc=? WHERE id_cliente=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cl.getNombreC());
            ps.setString(2,cl.getDireccionC());
            ps.setString(3,cl.getRuc());
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
}
