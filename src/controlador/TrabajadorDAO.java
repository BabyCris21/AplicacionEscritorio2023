
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
import modelo.Trabajador;

public class TrabajadorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean AgregarTrabajador(Trabajador trb){
        String sql = "INSERT INTO tb_trabajadores (nombre_trabajador, apellido_trabajador, dni_trabajador, celular, correo_trabajador, cargo) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trb.getNombreT());
            ps.setString(2, trb.getApellidoT());
            ps.setString(3, trb.getDniT());
            ps.setString(4, trb.getCelularT());
            ps.setString(5,trb.getCorreoT());
            ps.setString(6, trb.getCargoT());
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
    
    public List ListarTrabajadores(){
        List<Trabajador> ListaT = new ArrayList();
        String sql = "SELECT * FROM tb_trabajadores";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Trabajador trb = new Trabajador();
                trb.setId_trabajador(rs.getInt("id_trabajadores"));
                trb.setNombreT(rs.getString("nombre_trabajador"));
                trb.setApellidoT(rs.getString("apellido_trabajador"));
                trb.setDniT(rs.getString("dni_trabajador"));
                trb.setCelularT(rs.getString("celular"));
                trb.setCorreoT(rs.getString("correo_trabajador"));
                trb.setCargoT(rs.getString("cargo"));
                ListaT.add(trb);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaT;
    }
    
    public boolean EliminarTrabajador(int id){
        String sql = "DELETE FROM tb_trabajadores WHERE id_trabajadores = ?";
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
    
    public boolean EditarTrabajador(Trabajador trb){
        String sql = "UPDATE tb_trabajadores SET nombre_trabajador=?, apellido_trabajador=?, dni_trabajador=?, celular=?, correo_trabajador=?, cargo=? WHERE id_trabajadores=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,trb.getNombreT());
            ps.setString(2,trb.getApellidoT());
            ps.setString(3,trb.getDniT());
            ps.setString(4,trb.getCelularT());
            ps.setString(5,trb.getCorreoT());
            ps.setString(6,trb.getCargoT());
            ps.setInt(7,trb.getId_trabajador());
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
