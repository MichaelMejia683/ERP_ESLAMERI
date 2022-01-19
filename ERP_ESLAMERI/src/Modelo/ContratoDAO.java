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
public class ContratoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public ContratoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearContrato(Contrato e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO contrato(idEmpresa,tipoContrato,tiempoContrato) VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getTipoContrato());
            pstm.setString(3, e.getTiempoContrato());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CONTRATO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarContrato(Contrato e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE contrato " +
                         "SET idEmpleado = ?, tipoContrato = ?, tiempoContrato = ?"
                    +    " WHERE idContrato = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getTipoContrato());
            pstm.setString(3, e.getTiempoContrato());
            pstm.setInt(4,Integer.parseInt(e.getIdContrato()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CONTRATO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CONTRATO : " + ex.getMessage());
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
    
    public ArrayList<Cliente> listadoCliente(String id){      
        ArrayList<Cliente> listado = new ArrayList<>();
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
                        
            Cliente cliente = null;
            while(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getString("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                listado.add(cliente);
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
        return listado;
    }
    
}
