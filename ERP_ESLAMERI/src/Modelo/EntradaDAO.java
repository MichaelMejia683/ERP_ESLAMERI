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
public class EntradaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public EntradaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearEntrada(Entrada e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO entrada(idOC,idUsuario,articulo,comentario,estado,entregadoA,EntregadoPor) VALUES(?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdOC()));
            pstm.setInt(2,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(3, e.getArticulo());
            pstm.setString(4, e.getComentario());
            pstm.setString(5, e.getEstado());
            pstm.setString(6, e.getEntregadoA());
            pstm.setString(7, e.getEntregadoPor());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una ENTRADA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una ENTRADA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarEntrada(Entrada e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE entrada " +
                         "SET idOC = ?, idUsuario = ?, articulo = ?, comentario = ?, estado = ?, entregadoA = ?, entregadoPor = ?"
                    +    " WHERE idEntrada = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdOC()));
            pstm.setInt(2,Integer.parseInt(e.getIdUsuario()));
            pstm.setString(3, e.getArticulo());
            pstm.setString(4, e.getComentario());
            pstm.setString(5, e.getEstado());
            pstm.setString(6, e.getEntregadoA());
            pstm.setString(7, e.getEntregadoPor());
            pstm.setInt(8,Integer.parseInt(e.getIdEntrada()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una ENTRADA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una ENTRADA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarEntrada(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM entrada WHERE idEntrada = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una ENTRADA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una ENTRADA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoEntrada(String id,ObservableList<Entrada> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM entrada ORDER BY idEntrada";            
            }else{
                sql = "SELECT * FROM entrada WHERE idEntrada = ? "
                    + "ORDER BY idEntrada";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Entrada(
                rs.getString("idEntrada"),
                rs.getString("idOC"),
                rs.getString("idUsuario"),
                rs.getString("articulo"),
                rs.getString("comentario"),
                rs.getString("estado"),
                rs.getString("entregadoA"),
                rs.getString("entregadoPor")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ENTRADA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ENTRADA : " + ex.getMessage());
            }
        }
    }
    
}
