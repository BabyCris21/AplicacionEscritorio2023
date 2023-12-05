package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try{
            String myBD = "jdbc:mysql://localhost:3306/sistemasacdb?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "123456789");       
            return con;
        } catch (SQLException e){
            System.out.println(e.toString());          
        }
        return null;
    }

    public void close(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
