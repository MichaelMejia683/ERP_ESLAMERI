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
public class EmpresaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public EmpresaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearEmpresa(Empresa e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO empresa(nombre,NIT) VALUES(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getNIT());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una EMPRESA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una EMPRESA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarEmpresa(Empresa e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE empresa " +
                         "SET nombre = ?, NIT = ?"
                    +    " WHERE idEmpresa = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getNIT());
            pstm.setInt(3,Integer.parseInt(e.getIdEmpresa()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una EMPRESA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una EMPRESA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarEmpresa(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM empresa WHERE idEmpresa = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una EMPRESA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una EMPRESA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoEmpresa(String id, ObservableList<Empresa> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM empresa ORDER BY idEmpresa";            
            }else{
                sql = "SELECT * FROM empresa WHERE idEmpresa = ? "
                    + "ORDER BY idEmpresa";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Empresa(
                rs.getString("idEmpresa"),
                rs.getString("nombre"),
                rs.getString("NIT")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EMPRESA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EMPRESA : " + ex.getMessage());
            }
        }
    }
    
}
