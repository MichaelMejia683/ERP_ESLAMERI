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
public class NominaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public NominaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearNomina(Nomina e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO nomina(idCuenta,pagoTotal,fechaPago) VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdCuenta()));
            pstm.setString(2, e.getPagoTotal());
            pstm.setString(3, e.getFechaPago());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una NOMINA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una NOMINA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarNomina(Nomina e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE nomina " +
                         "SET idCuenta = ?, pagoTotal = ?, fechaPago = ?"
                    +    " WHERE idNomina = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdCuenta()));
            pstm.setString(2, e.getPagoTotal());
            pstm.setString(3, e.getFechaPago());
            pstm.setInt(3,Integer.parseInt(e.getIdNomina()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una NOMINA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una NOMINA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarNomina(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM nomina WHERE idNomina = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una NOMINA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una NOMINA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Nomina> listadoNomina(String id){      
        ArrayList<Nomina> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM nomina ORDER BY idNomina";            
            }else{
                sql = "SELECT * FROM nomina WHERE idNomina = ? "
                    + "ORDER BY idNomina";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Nomina empresa = null;
            while(rs.next()){
                empresa = new Nomina();
                empresa.setIdNomina(rs.getString("idNomina"));
                empresa.setIdCuenta(rs.getString("idCuenta"));
                empresa.setPagoTotal(rs.getString("pagoTotal"));
                empresa.setFechaPago(rs.getString("fechaPago"));
                listado.add(empresa);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de NOMINA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de NOMINA : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
