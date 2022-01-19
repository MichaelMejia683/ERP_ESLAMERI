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
public class Orden_CompraDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Orden_CompraDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearOrden_Compra(Orden_Compra e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO orden_compra(idProv,articulo,cantidad,precioUnitario,precioTotal,tiempoEspera) VALUES(?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdProv()));
            pstm.setString(2, e.getArticulo());
            pstm.setString(3, e.getCantidad());
            pstm.setString(4, e.getPrecioUnitario());
            pstm.setString(5, e.getPrecioTotal());
            pstm.setString(6, e.getTiempoEspera());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ORDEN DE COMPRA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un ORDEN DE COMPRA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarOrden_Compra(Orden_Compra e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE orden_compra " +
                         "SET idProv = ?, articulo = ?, cantidad = ?, precioUnitario = ?, precioTotal = ?, tiempoEspera = ?"
                    +    " WHERE idOC = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdProv()));
            pstm.setString(2, e.getArticulo());
            pstm.setString(3, e.getCantidad());
            pstm.setString(4, e.getPrecioUnitario());
            pstm.setString(5, e.getPrecioTotal());
            pstm.setString(6, e.getTiempoEspera());
            pstm.setInt(7,Integer.parseInt(e.getIdOC()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ORDEN DE COMPRA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un ORDEN DE COMPRA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarOrden_Compra(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM orden_compra WHERE idOC = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un ORDEN DE COMPRA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un ORDEN DE COMPRA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Orden_Compra> listadoOrden_Compra(String id){      
        ArrayList<Orden_Compra> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM orden_compra ORDER BY idOC";            
            }else{
                sql = "SELECT * FROM orden_compra WHERE idOC = ? "
                    + "ORDER BY idOC";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Orden_Compra OC = null;
            while(rs.next()){
                OC = new Orden_Compra();
                OC.setIdOC(rs.getString("idOC"));
                OC.setIdProv(rs.getString("idProv"));
                OC.setArticulo(rs.getString("articulo"));
                OC.setCantidad(rs.getString("cantidad"));
                OC.setPrecioUnitario(rs.getString("precioUnitario"));
                OC.setPrecioTotal(rs.getString("precioTotal"));
                OC.setTiempoEspera(rs.getString("tiempoEspera"));
                listado.add(OC);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ORDEN DE COMPRA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de ORDEN DE COMPRA : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
