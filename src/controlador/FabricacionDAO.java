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
        String sql = "INSERT INTO fabricacion (num_tablero, tablero, foto_tablero, material) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,Fbr.getNum_tablero());
            ps.setString(2,Fbr.getTablero());
            ps.setBytes(3,Fbr.getFoto_tablero());
            ps.setString(4,Fbr.getMaterial());
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
        String sql = "SELECT * FROM fabricacion";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Fabricacion Fbr = new Fabricacion();
            Fbr.setId_fabricacion(rs.getInt("id_fabricacion"));  // Cambiado a 'id_fabricacion'
            Fbr.setNum_tablero(rs.getString("num_tablero"));
            Fbr.setTablero(rs.getString("tablero"));
            Fbr.setFoto_tablero(rs.getBytes("foto_tablero"));
            Fbr.setMaterial(rs.getString("material"));
            ListaFab.add(Fbr);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaFab;
    }
}
