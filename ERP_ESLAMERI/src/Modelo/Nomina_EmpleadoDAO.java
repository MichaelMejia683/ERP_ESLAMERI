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
public class Nomina_EmpleadoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Nomina_EmpleadoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearNomina_Empleado(Nomina_Empleado e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO nomina_empleado(idEmpleado,salarioBase,horasExtraDiurna,recargos,descuentos,salarioTotal,horaExtraNocturno,horaDominical,corte) VALUES(?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setString(2, e.getSalarioBase());
            pstm.setString(3, e.getHorasExtraDiurna());
            pstm.setString(4, e.getRecargos());
            pstm.setString(5, e.getDescuentos());
            pstm.setString(6, e.getSalarioTotal());
            pstm.setString(7, e.getHoraExtraNocturno());
            pstm.setString(8, e.getHoraDominical());
            pstm.setString(9, e.getCorte());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un NXE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un NXE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarNomina_Empleado(Nomina_Empleado e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE nomina_empleado " +
                         "SET idEmpleado = ?, salarioBase = ?, horasExtraDiurna = ?, recargos = ?, descuentos = ?, salarioTotal = ?, horaExtraNocturno = ?, horaDominical = ?, corte = ?"
                    +    " WHERE idNXE = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setString(2, e.getSalarioBase());
            pstm.setString(3, e.getHorasExtraDiurna());
            pstm.setString(4, e.getRecargos());
            pstm.setString(5, e.getDescuentos());
            pstm.setString(6, e.getSalarioTotal());
            pstm.setString(7, e.getHoraExtraNocturno());
            pstm.setString(8, e.getHoraDominical());
            pstm.setString(9, e.getCorte());
            pstm.setInt(10,Integer.parseInt(e.getIdNXE()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un NXE : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un NXE : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarNomina_Empleado(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM nomina_empleado WHERE idNXE = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un NXE : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un NXE : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoNomina_Empleado(String id, ObservableList<Nomina_Empleado> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM nomina_empleado ORDER BY idNXE";            
            }else{
                sql = "SELECT * FROM nomina_empleado WHERE idNXE = ? "
                    + "ORDER BY idNXE";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Nomina_Empleado(
                rs.getString("idNXE"),
                rs.getString("idEmpleado"),
                rs.getString("salarioBase"),
                rs.getString("horasExtraDiurna"),
                rs.getString("recargos"),
                rs.getString("descuentos"),
                rs.getString("salarioTotal"),
                rs.getString("horaExtraNocturno"),
                rs.getString("horaDominical"),
                rs.getString("corte")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de NXE : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de NXE : " + ex.getMessage());
            }
        }
    }
    
}
