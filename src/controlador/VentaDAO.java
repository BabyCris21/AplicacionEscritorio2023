/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;
import modelo.Detalle;
import modelo.Venta;

/**
 *
 * @author User
 */
public class VentaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
   public int registrarventa(Venta v){
    String sql = "INSERT INTO tb_ventaescritorio (cliente, vendedor, total) VALUES (?,?,?)";   
       try {
           con =cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1, v.getCliente());
           ps.setString(2, v.getVendedor());
           ps.setDouble(3, v.getTotal());
           ps.execute();

       } catch (Exception e) {
           System.out.println(e.toString());
       }finally{
           try {
               con.close();
           } catch (Exception e) {
               System.out.println(e.toString());
           }
       
   }return r;
   }
   public int registrardetalle(Detalle dv){
    String sql="INSERT INTO tb_detalleescritorio (id_producto, precio, cantidad, id_venta) VALUES (?,?,?,?)"   ;
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, dv.getId_producto());
           ps.setDouble(2, dv.getPrecio());
           ps.setInt(3, dv.getCantidad());
           ps.setInt(4, dv.getId_venta());
           
           ps.execute();
       } catch (Exception e) {
           System.out.println(e.toString());
       }finally{
           try {
               con.close();
           } catch (Exception e) {
               System.out.println(e.toString());
           }
       }return r;
       }
   public int idventa(){
       int id=0;
       String sql = "SELECT MAX(id) FROM tb_ventaescritorio";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           if(rs.next()){
              id = rs.getInt(1);
           }
       } catch (Exception e) {
           System.out.println(e.toString());
       }return r;
   }
   public boolean actualizarstock(int cantidad, int id_producto){
       String sql ="UPDATE tb_almacen SET cantidad = ? WHERE id_almacen = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, cantidad);
           ps.setInt(2, id_producto);
           ps.execute();
           return true;

       } catch (Exception e) {
           System.out.println(e.toString());
           return false;
       }
   }
   }

