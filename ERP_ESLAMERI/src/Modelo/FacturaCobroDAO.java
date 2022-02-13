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
public class FacturaCobroDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public FacturaCobroDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearFacturaCobro(FacturaCobro e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO facturaCobro(idOS,costoTotal,fechaVencimiento,estado) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdOS()));
            pstm.setString(2, e.getCostoTotal());
            pstm.setString(3, e.getFechaVencimiento());
            pstm.setString(4, e.getEstado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una FACTURA COBRO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una FACTURA COBRO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarFacturaCobro(FacturaCobro e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE facturaCobro " +
                         "SET idOS = ?, costoTotal = ?, fechaVencimiento = ?, estado = ?"
                    +    " WHERE idFC = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdOS()));
            pstm.setString(2, e.getCostoTotal());
            pstm.setString(3, e.getFechaVencimiento());
            pstm.setString(4, e.getEstado());
            pstm.setInt(5,Integer.parseInt(e.getIdFC()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una FACTURA COBRO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una FACTURA COBRO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarFacturaCobro(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM facturaCobro WHERE idFC = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una FACTURA COBRO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una FACTURA COBRO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoFacturaCobro(String id, ObservableList<FacturaCobro> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM facturaCobro ORDER BY idFC";            
            }else{
                sql = "SELECT * FROM facturaCobro WHERE idFC = ? "
                    + "ORDER BY idFC";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new FacturaCobro(
                rs.getString("idFC"),
                rs.getString("idOS"),
                rs.getString("costoTotal"),
                rs.getString("fechaVencimiento"),
                rs.getString("estado")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de FACTURA COBRO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de FACTURA COBRO : " + ex.getMessage());
            }
        }
    }
    
}
