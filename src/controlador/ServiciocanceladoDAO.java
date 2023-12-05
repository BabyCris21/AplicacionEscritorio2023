/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Serviciocancelado;
import modelo.Servicios;
public class ServiciocanceladoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;   
    public boolean AgregarServiciocancelado(Serviciocancelado serv){
        String sql = "INSERT INTO tb_servicios_cancelados (lugar_servic, tipo_servicio, ruc, fecha_cancelacion,trabajador) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, serv.getLugars());
            ps.setString(2, serv.getTiposervicio());
            ps.setString(3, serv.getRUCs());
            ps.setString(4, serv.getFechacancelacion());
            ps.setString(5, serv.getTrabajador());
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
    public List ListarServiciocancelado(){
        List<Serviciocancelado> ListaServicio = new ArrayList();
        String sql = "SELECT * FROM tb_servicios_cancelados";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Serviciocancelado serv = new Serviciocancelado();
                serv.setId_serviciocancelado(rs.getInt("id_servicios_cancelados"));
                serv.setLugars(rs.getString("lugar_servic"));
                serv.setTiposervicio(rs.getString("tipo_servicio"));
                serv.setRUCs(rs.getString("ruc"));
                serv.setFechacancelacion(rs.getString("fecha_cancelacion"));
                serv.setTrabajador(rs.getString("trabajador"));
                ListaServicio.add(serv);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaServicio;
    }
    public boolean EliminarServiciocancelado(int id){
        String sql = "DELETE FROM tb_servicios_cancelados WHERE id_servicios_cancelados = ?";
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
   public boolean EditarServiciocancelado(Serviciocancelado serv){
        String sql = "UPDATE tb_servicios_cancelados SET lugar_servic=?, tipo_servicio=?, ruc=?,fecha_cancelacion=?,trabajador=? WHERE id_servicios_cancelados =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,serv.getLugars());
            ps.setString(2,serv.getTiposervicio());
            ps.setString(3,serv.getRUCs());
            ps.setString(4,serv.getFechacancelacion());
            ps.setString(5,serv.getTrabajador());
            ps.setInt(6,serv.getId_serviciocancelado());
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
