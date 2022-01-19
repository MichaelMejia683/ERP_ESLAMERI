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
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL
 */
public class ServicioDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public ServicioDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearServicio(Servicio e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO servicio(nombre,tarifa,tiempoEstimado,tipoTiempo) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getTarifa());
            pstm.setString(3, e.getTiempoEstimado());
            pstm.setString(4, e.getTipoTiempo());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarServicio(Servicio e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE servicio " +
                         "SET nombre = ?, tarifa = ?, tiempoEstimado = ?, tipoTiempo = ?"
                    +    " WHERE idServicio = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getTarifa());
            pstm.setString(3, e.getTiempoEstimado());
            pstm.setString(4, e.getTipoTiempo());
            pstm.setInt(5,Integer.parseInt(e.getIdServicio()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarServicio(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM servicio WHERE idServicio = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un SERVICO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un SERVICIO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Servicio> listadoServicio(String id){      
        ArrayList<Servicio> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM servicio ORDER BY idServicio";            
            }else{
                sql = "SELECT * FROM servicio WHERE idServicio = ? "
                    + "ORDER BY idServicio";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Servicio servicio = null;
            while(rs.next()){
                servicio = new Servicio();
                servicio.setIdServicio(rs.getString("idServicio"));
                servicio.setNombre(rs.getString("nombre"));
                servicio.setTarifa(rs.getString("tarifa"));
                servicio.setTiempoEstimado(rs.getString("tiempoEstimado"));
                servicio.setTipoTiempo(rs.getString("tipoTiempo"));
                listado.add(servicio);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de SERVICIO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de SERVICIO : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
