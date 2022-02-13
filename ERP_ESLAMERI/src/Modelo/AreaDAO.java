/*
 * Programa	: AreaDAO.java
 * Fecha	: 16/01/2022
 * Objetivo	: Hacer las operaciones de la BD de las Areas
 * Programador	: MICHAEL ARTURO MEJIA ARAGON 201831041
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
 * @author MAICOL MEJIA
 */
public class AreaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public AreaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearArea(Area e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO area(nombre) VALUES(?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getNombre());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un AREA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un AREA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarArea(Area e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE area " +
                         "SET nombre = ? "
                    +    "WHERE idArea = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1,e.getNombre());
            pstm.setInt(2,Integer.parseInt(e.getIdArea()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un AREA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un AREA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarArea(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM area WHERE idArea = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer. parseInt (id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un AREA: "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un AREA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoArea(String id,ObservableList<Area> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM area ORDER BY idArea";            
            }else{
                sql = "SELECT * FROM area WHERE idArea = ? "
                    + "ORDER BY idArea";      
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Area(
                rs.getString("idArea"),
                rs.getString("nombre")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de AREA: " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de AREA: " + ex.getMessage());
            }
        }
    }
    
}
