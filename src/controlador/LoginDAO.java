package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    public Login log(String usuario, String pass){
        Login l = new Login();
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND pass = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id_usuarios"));
                l.setUsuario(rs.getString("usuario"));
                l.setPass(rs.getString("pass"));             
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
}
