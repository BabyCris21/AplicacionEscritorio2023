
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

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean AgregarUsuario(Usuario usr){
        String sql = "INSERT INTO tb_usuarios (usuario, cargo, password) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuarioU());
            ps.setString(2, usr.getCargoU());
            ps.setString(3, usr.getContraseñaU());
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
            
    public List ListarUsuario(){
        List<Usuario> ListaU = new ArrayList();
        String sql = "SELECT * FROM tb_usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario usr = new Usuario();
                usr.setId_usuarioU(rs.getInt("Id_usuarios"));
                usr.setUsuarioU(rs.getString("usuario"));
                usr.setCargoU(rs.getString("cargo"));
                usr.setContraseñaU(rs.getString("password"));
                ListaU.add(usr);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaU;
    }
    
    public boolean EliminarUsuario(int id){
        String sql = "DELETE FROM tb_usuarios WHERE Id_usuarios = ?";
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
    
    public boolean EditarUsuario(Usuario usr){
        String sql = "UPDATE tb_usuarios SET usuario=?, cargo=?, password=? WHERE Id_usuarios =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usr.getUsuarioU());
            ps.setString(2,usr.getCargoU());
            ps.setString(3,usr.getContraseñaU());
            ps.setInt(4,usr.getId_usuarioU());
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
