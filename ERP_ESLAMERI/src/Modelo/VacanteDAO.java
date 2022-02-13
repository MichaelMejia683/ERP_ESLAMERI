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
public class VacanteDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public VacanteDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearVacante(Vacante e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO vacante(idUsuario,cargo,experiencia,estadoTiempo,descripcionHabilidades,estado) VALUES(?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(2, e.getCargo());
            pstm.setString(3, e.getExperiencia());
            pstm.setString(4, e.getEstadoTiempo());
            pstm.setString(5, e.getDescripcionHabilidad());
            pstm.setString(6, e.getEstado());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una VACANTE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una VACANTE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarVacante(Vacante e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE vacante " +
                         "SET idUsuario = ?, cargo = ?, experiencia = ?, estadoTiempo = ?, descripcionHabilidades = ?, estado = ?"
                    +    " WHERE idVacante = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(2, e.getCargo());
            pstm.setString(3, e.getExperiencia());
            pstm.setString(4, e.getEstadoTiempo());
            pstm.setString(5, e.getDescripcionHabilidad());
            pstm.setString(6, e.getEstado());
            pstm.setInt(7,Integer.parseInt(e.getIdVacante()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una VACANTE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una VACANTE : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarVacante(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM vacante WHERE idVacante = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una VACANTE : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una VACANTE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoVacante(String id, ObservableList<Vacante> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM vacante ORDER BY idVacante";            
            }else{
                sql = "SELECT * FROM vacante WHERE idVacante = ? "
                    + "ORDER BY idVacante";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Vacante(
                rs.getString("idVacante"),
                rs.getString("idUsuario"),
                rs.getString("cargo"),
                rs.getString("experiencia"),
                rs.getString("estadoTiempo"),
                rs.getString("descripcionHabilidades"),
                rs.getString("estado")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de VACANTE : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de VACANTE : " + ex.getMessage());
            }
        }
    }
    
}
