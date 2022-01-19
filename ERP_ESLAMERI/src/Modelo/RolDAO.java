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
public class RolDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public RolDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearRol(Rol e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO rol(nombre,permisos) VALUES(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getPermisos());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ROL : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ROL : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarRol(Rol e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE rol " +
                         "SET nombre = ?, permisos = ?"
                    +    " WHERE idRol = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getPermisos());
            pstm.setInt(3,Integer.parseInt(e.getIdRol()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ROL : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ROL : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarRol(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM rol WHERE idRol = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un Rol : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un ROL : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Rol> listadoRol(String id){      
        ArrayList<Rol> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM rol ORDER BY idRol";            
            }else{
                sql = "SELECT * FROM rol WHERE idRol = ? "
                    + "ORDER BY idRol";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Rol Rol = null;
            while(rs.next()){
                Rol = new Rol();
                Rol.setIdRol(rs.getString("idRol"));
                Rol.setNombre(rs.getString("nombre"));
                Rol.setPermisos(rs.getString("permisos"));
                listado.add(Rol);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ROL : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ROL : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
