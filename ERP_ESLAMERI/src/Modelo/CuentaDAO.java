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
public class CuentaDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public CuentaDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearCuenta(Cuenta e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO cuenta(idEmpresa,numeroCuenta,banco,saldo) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getNumeroCuenta());
            pstm.setString(3, e.getBanco());
            pstm.setString(4, e.getSaldo());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CUENTA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un CUENTA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarCuenta(Cuenta e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE cuenta " +
                         "SET idEmpleado = ?, numeroCuenta = ?, banco = ?, saldo = ?"
                    +    " WHERE idCuenta = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEmpresa()));
            pstm.setString(2, e.getNumeroCuenta());
            pstm.setString(3, e.getBanco());
            pstm.setString(4, e.getSaldo());
            pstm.setInt(5,Integer.parseInt(e.getIdCuenta()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CUENTA : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un CUENTA : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarCuenta(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM cuenta WHERE idCuenta = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CUENTA : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un CUENTA : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Cuenta> listadoCuenta(String id){      
        ArrayList<Cuenta> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM cuenta ORDER BY idCuenta";            
            }else{
                sql = "SELECT * FROM cuenta WHERE idCuenta = ? "
                    + "ORDER BY idCuenta";
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Cuenta cuenta = null;
            while(rs.next()){
                cuenta = new Cuenta();
                cuenta.setIdCuenta(rs.getString("idCliente"));
                cuenta.setIdEmpresa(rs.getString("idEmpresa"));
                cuenta.setNumeroCuenta(rs.getString("numeroCuenta"));
                cuenta.setBanco(rs.getString("banco"));
                cuenta.setSaldo(rs.getString("saldo"));
                listado.add(cuenta);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CUENTA : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de CUENTA : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
