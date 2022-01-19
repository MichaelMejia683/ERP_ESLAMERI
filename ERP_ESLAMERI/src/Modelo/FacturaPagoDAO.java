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
 * @author MAICOL MEJA
 */
public class FacturaPagoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public FacturaPagoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearFacturaPago(FacturaPago e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO facturaPago(idOC,costoTotal,fechaVencimiento,estado) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(2,Integer.parseInt(e.getIdOC()));
            pstm.setString(3, e.getCostoTotal());
            pstm.setString(4, e.getFechaVencimiento());
            pstm.setString(6, e.getEstado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una FACTURA PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una FACTURA PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarFacturaPago(FacturaPago e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE facturaPago " +
                         "SET idOC = ?, costoTotal = ?, fechaVencimiento = ?, estado = ?"
                    +    " WHERE idFP = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdOC()));
            pstm.setString(2, e.getCostoTotal());
            pstm.setString(3, e.getFechaVencimiento());
            pstm.setString(4, e.getEstado());
            pstm.setInt(5,Integer.parseInt(e.getIdFP()));
            rtdo = pstm.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una FACTURA PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una FACTURA PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarFacturaPago(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM facturaPago WHERE idFP = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una FACTURA PAGO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una FACTURA PAGO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<FacturaPago> listadoFacturaPago(String id){      
        ArrayList<FacturaPago> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM facturaPago ORDER BY idFP";            
            }else{
                sql = "SELECT * FROM facturaPago WHERE idFP = ? "
                    + "ORDER BY idFP";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            FacturaPago factura = null;
            while(rs.next()){
                factura = new FacturaPago();
                factura.setIdFP(rs.getString("idFP"));
                factura.setIdOC(rs.getString("idOC"));
                factura.setCostoTotal(rs.getString("costoTotal"));
                factura.setFechaVencimiento(rs.getString("fechaVencimiento"));
                factura.setEstado(rs.getString("estado"));
                listado.add(factura);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de FACTURA PAGO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de FACTURA PAGO : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
