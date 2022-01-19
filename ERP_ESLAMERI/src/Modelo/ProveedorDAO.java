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
public class ProveedorDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public ProveedorDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearProveedor(Proveedor e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO proveedor(nombre,direccion,telefono,NIT) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getDireccion());
            pstm.setString(3, e.getTelefono());
            pstm.setString(4, e.getNIT());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un PROVEEDOR : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un PROVEEDOR : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarProveedor(Proveedor e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE proveedor " +
                         "SET nombre = ?, direccion = ?, telefono = ?, NIT = ?"
                    +    " WHERE idProv = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getDireccion());
            pstm.setString(3, e.getTelefono());
            pstm.setString(4, e.getNIT());
            pstm.setInt(5,Integer.parseInt(e.getIdProv()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un PROVEEDOR : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un PROVEEDOR : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarProveedor(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM proveedor WHERE idProv = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un PROVEEDOR : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un PROVEEDOR : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Proveedor> listadoProveedor(String id){      
        ArrayList<Proveedor> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM proveedor ORDER BY idProv";            
            }else{
                sql = "SELECT * FROM proveedor WHERE idProv = ? "
                    + "ORDER BY idProv";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Proveedor prov = null;
            while(rs.next()){
                prov = new Proveedor();
                prov.setIdProv(rs.getString("idProv"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setNIT(rs.getString("NIT"));
                listado.add(prov);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de PROVEEDOR : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de PROVEEDOR : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
