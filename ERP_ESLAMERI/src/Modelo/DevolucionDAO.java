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
public class DevolucionDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public DevolucionDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearDevolucion(Devolucion e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO devolucion(idEntrada,comentario) VALUES(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEntrada()));
            pstm.setString(2, e.getComentario());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una DEVOLUCION : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una DEVOLUCION : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarDevolucion(Devolucion e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE devolucion " +
                         "SET idEntrada = ?, comentario = ?"
                    +    " WHERE idDevolucion = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEntrada()));
            pstm.setString(2, e.getComentario());
            pstm.setInt(3,Integer.parseInt(e.getIdDevolucion()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una DEVOLUCION : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una DEVOLUCION : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarDevolucion(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM devolucion WHERE idDevolucion = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una DEVOLUCION : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una DEVOLUCION : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Devolucion> listadoDevolucion(String id){      
        ArrayList<Devolucion> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM devolucion ORDER BY idDevolucion";            
            }else{
                sql = "SELECT * FROM devolucion WHERE idDevolucion = ? "
                    + "ORDER BY idDevolucion";
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Devolucion devolucion = null;
            while(rs.next()){
                devolucion = new Devolucion();
                devolucion.setIdDevolucion(rs.getString("idDevolucion"));
                devolucion.setIdEntrada(rs.getString("idEntreda"));
                devolucion.setComentario(rs.getString("comentario"));
                listado.add(devolucion);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de DEVOLUCION : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de DEVOLUCION : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
