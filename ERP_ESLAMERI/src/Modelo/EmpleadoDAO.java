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
public class EmpleadoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public EmpleadoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearEmpleado(Empleado e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO empleado(idArea,idContrato,nombre,fechaNacimiento,cargo,salario,numeroCuentaBanco,fechaVinculacion) VALUES(?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdArea()));
            pstm.setInt(2,Integer.parseInt(e.getIdContrato()));
            pstm.setString(3, e.getNombre());
            pstm.setString(4, e.getFechaNacimiento());
            pstm.setString(5, e.getCargo());
            pstm.setString(6, e.getSalario());
            pstm.setString(7, e.getNumeroCuentaBanco());
            pstm.setString(8, e.getFechaVinculacion());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un EMPLEADO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un EMPLEADO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarEmpleado(Empleado e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE empleado " +
                         "SET idArea = ?, idContrato = ?, nombre = ?, fechaNacimiento = ?, cargo = ?, salario = ?, numeroCuentaBanco = ?, fechaVinculacion = ?"
                    +    " WHERE idEmpleado = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdArea()));
            pstm.setInt(2,Integer.parseInt(e.getIdContrato()));
            pstm.setString(3, e.getNombre());
            pstm.setString(4, e.getFechaNacimiento());
            pstm.setString(5, e.getCargo());
            pstm.setString(6, e.getSalario());
            pstm.setString(7, e.getNumeroCuentaBanco());
            pstm.setString(8, e.getFechaVinculacion());
            pstm.setInt(9,Integer.parseInt(e.getIdEmpleado()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un EMPLEADO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un EMPLEADO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarEmpleado(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM empleado WHERE idEmpleado = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un EMPLEADO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un EMPLEADO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Empleado> listadoEmpleado(String id){      
        ArrayList<Empleado> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM empleado ORDER BY idEmpleado";            
            }else{
                sql = "SELECT * FROM empleado WHERE idEmpleado = ? "
                    + "ORDER BY idEmpleado";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Empleado empleado = null;
            while(rs.next()){
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getString("idEmpleado"));
                empleado.setIdArea(rs.getString("idArea"));
                empleado.setIdContrato(rs.getString("idContrato"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setFechaNacimiento(rs.getString("fechaNacimiento"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setSalario(rs.getString("salario"));
                empleado.setNumeroCuentaBanco(rs.getString("numeroCuentaBanco"));
                empleado.setFechaVinculacion(rs.getString("fechaVinculacion"));
                listado.add(empleado);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EMPLEADO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EMPLEADO : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
