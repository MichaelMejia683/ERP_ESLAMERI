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
import javafx.collections.transformation.FilteredList;
import javax.swing.JOptionPane;

/**
 *
 * @author MAICOL MEJA
 */
public class ContratoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public ContratoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearContrato(Contrato e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO contrato(idEmpresa,tipoContrato,tiempoContrato,nombreContrato) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getTipoContrato());
            pstm.setString(3, e.getTiempoContrato());
            pstm.setString(4, e.getNombreContrato());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CONTRATO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarContrato(Contrato e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE contrato " +
                         "SET idEmpresa = ?, tipoContrato = ?, tiempoContrato = ?, nombreContrato = ?"
                    +    " WHERE idContrato = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getTipoContrato());
            pstm.setString(3, e.getTiempoContrato());
            pstm.setString(4, e.getNombreContrato());
            pstm.setInt(5,Integer.parseInt(e.getIdContrato()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CONTRATO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarContrato(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM contrato WHERE idContrato = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CONTRATO: "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CONTRATO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoContrato(String id,ObservableList<Contrato> listado){
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM contrato ORDER BY idContrato";            
            }else{
                sql = "SELECT * FROM contrato WHERE idContrato = ? "
                    + "ORDER BY idContrato";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Contrato(
                rs.getString("idcontrato"), 
                rs.getString("idempresa"),
                rs.getString("nombrecontrato"),
                rs.getString("tipocontrato"),
                rs.getString("tiempocontrato")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CONTRATO : " + ex.getMessage());
            }
        }
    }


    public void listadoContratoFiltrado(String id,FilteredList<Contrato> listado){
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM contrato ORDER BY idContrato";            
            }else{
                sql = "SELECT * FROM contrato WHERE idContrato = ? "
                    + "ORDER BY idContrato";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Contrato contrato = null;
            while(rs.next()){
                listado.add( new Contrato(
                rs.getString("idcontrato"), 
                rs.getString("idempresa"),
                rs.getString("nombrecontrato"),
                rs.getString("tipocontrato"),
                rs.getString("tiempocontrato")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CONTRATO : " + ex.getMessage());
            }
        }
    }

    
}
