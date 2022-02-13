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
public class Recibo_PagoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Recibo_PagoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearRecibo_Pago(Recibo_Pago e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO recibo_pago(idFP,idCuenta,valorPagado) VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdFP()));
            pstm.setInt(2,Integer.parseInt(e.getIdCuenta()));
            pstm.setString(3, e.getValorPagado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un RECIBO DE PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un RECIBO DE PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarRecibo_Pago(Recibo_Pago e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE recibo_pago " +
                         "SET idFP = ?, idCuenta = ?, valorPagado = ?"
                    +    " WHERE idPago = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdFP()));
            pstm.setInt(2,Integer.parseInt(e.getIdCuenta()));
            pstm.setString(3, e.getValorPagado());
            pstm.setInt(4,Integer.parseInt(e.getIdPago()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un RECIBO DE PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un RECIBO DE PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarRecibo_Pago(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM recibo_pago WHERE idPago = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un RECIBO DE PAGO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un RECIBO DE PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoRecibo_Pago(String id, ObservableList<Recibo_Pago> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM recibo_pago ORDER BY idPago";            
            }else{
                sql = "SELECT * FROM recibo_pago WHERE idPago = ? "
                    + "ORDER BY idPago";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Recibo_Pago(
                rs.getString("idPago"),
                rs.getString("idFP"),
                rs.getString("idCuenta"),
                rs.getString("valorPagado")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de RECIBO DE PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de RECIBO DE PAGO : " + ex.getMessage());
            }
        }
    }
    
}
