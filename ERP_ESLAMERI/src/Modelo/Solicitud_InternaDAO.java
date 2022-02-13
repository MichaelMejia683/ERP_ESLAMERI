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
 * @author MICHAEL
 */
public class Solicitud_InternaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Solicitud_InternaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearSolicitud_Interna(Solicitud_Interna e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO solicitud_interna(idUsuario,solicitud,justi_Solicitud,tiempo_Espera,estado) VALUES(?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(2, e.getSolicitud());
            pstm.setString(3, e.getJusti_Solicitud());
            pstm.setString(4, e.getTiempo_Espera());
            pstm.setString(5, e.getEstado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una SOLICITUD INTERNA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una SOLICITUD INTERNA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarSolicitud_Interna(Solicitud_Interna e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE solicitud_interna " +
                         "SET idUsuario = ?, solicitud = ?, juti_Solicitud = ?, tiempo_Espera = ?, estado = ?"
                    +    " WHERE idSI = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(2, e.getSolicitud());
            pstm.setString(3, e.getJusti_Solicitud());
            pstm.setString(4, e.getTiempo_Espera());
            pstm.setString(5, e.getEstado());
            pstm.setInt(6,Integer.parseInt(e.getIdSI()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una SOLICITUD INTERNA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una SOLICITUD INTERNA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarSolicitud_Interna(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM solicitud_interna WHERE idSI = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una SOLICITUD INTERNA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una SOLICITUD INTERNA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoSolicitud_Interna(String id, ObservableList<Solicitud_Interna> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM solicitud_interna ORDER BY idSI";            
            }else{
                sql = "SELECT * FROM solicitud_interna WHERE idSI = ? "
                    + "ORDER BY idSI";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Solicitud_Interna(
                rs.getString("idSI"),
                rs.getString("idUsuario"),
                rs.getString("solicitud"),
                rs.getString("justi_Solicitud"),
                rs.getString("tiempo_Espera"),
                rs.getString("estado")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de SOLICITUD INTERNA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de SOLICITUD INTERNA : " + ex.getMessage());
            }
        }
    }
    
}
