/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Servicios.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author MAICOL MEJA
 */
public class Orden_ServicioDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Orden_ServicioDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearOrden_Servicio(Orden_Servicio e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO orden_servicio(idEmpleado,idServicio,idCliente,estado,tarifa,comentario) VALUES(?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setInt(2,Integer.parseInt(e.getIdServicio()));
            pstm.setInt(3,Integer.parseInt(e.getIdCliente()));
            pstm.setString(4, e.getEstado());
            pstm.setString(5, e.getTarifa());
            pstm.setString(6, e.getComentario());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ORDEN DE SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ORDEN DE SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarOrden_Servicio(Orden_Servicio e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE orden_servicio " +
                         "SET idEmpleado = ?, idServicio = ?, idCliente = ?, estado = ?, tarifa = ?, comentario = ?"
                    +    " WHERE idOS = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setInt(2,Integer.parseInt(e.getIdServicio()));
            pstm.setInt(3,Integer.parseInt(e.getIdCliente()));
            pstm.setString(4, e.getEstado());
            pstm.setString(5, e.getTarifa());
            pstm.setString(6, e.getComentario());
            pstm.setInt(7,Integer.parseInt(e.getIdOS()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ORDEN DE SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ORDEN DE SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarOrden_Servicio(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM orden_servicio WHERE idOS = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un ORDEN DE SERVICIO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un ORDEN DE SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoOrden_Servicio(String id, ObservableList<Orden_Servicio> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM orden_servicio ORDER BY idOS";            
            }else{
                sql = "SELECT * FROM orden_servicio WHERE idOS = ? "
                    + "ORDER BY idOS";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Orden_Servicio(
                rs.getString("idOS"),
                rs.getString("idEmpleado"),
                rs.getString("idServicio"),
                rs.getString("idCliente"),
                rs.getString("estado"),
                rs.getString("tarifa"),
                rs.getString("comentario")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ORDEN DE SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ORDEN DE SERVICIO : " + ex.getMessage());
            }
        }
    }
    
}
