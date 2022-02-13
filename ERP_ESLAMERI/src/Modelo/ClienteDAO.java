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
public class ClienteDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public ClienteDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearCliente(Cliente e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO cliente(nombre,telefono,direccion) VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getTelefono());
            pstm.setString(3, e.getDireccion());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CLIENTE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CLIENTE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarCliente(Cliente e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE cliente " +
                         "SET nombre = ?, telefono = ?, direccion = ?"
                    +    " WHERE idCliente = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getTelefono());
            pstm.setString(3, e.getDireccion());
            pstm.setInt(4,Integer.parseInt(e.getIdCliente()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CLIENTE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CLIENTE : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarCliente(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM cliente WHERE idCliente = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CLIENTE: "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CLIENTE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoCliente(String id,ObservableList<Cliente> listado){
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM cliente ORDER BY idCliente";            
            }else{
                sql = "SELECT * FROM cliente WHERE idCliente = ? "
                    + "ORDER BY idCliente";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Cliente(
                rs.getString("idCliente"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("direccion")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CLIENTE : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CLIENTE : " + ex.getMessage());
            }
        }
    }
    
}
