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
public class Evaluacion_DesempeñoDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public Evaluacion_DesempeñoDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearEvaluacion_Desempeño(Evaluacion_Desempeño e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO evaluacion_desempeño(idEmpleado,formulario,indicadoresGestion) VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setString(2, e.getFormulario());
            pstm.setString(3, e.getIndicadoresGestion());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una EVALUACION DE DESEMPEÑO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear una EVALUACION DE DESEMPEÑO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarEvaluacion_Desempeño(Evaluacion_Desempeño e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE evaluacion_desempeño " +
                         "SET idEmpleado = ?, formulario = ?, indicadoresGestion = ?"
                    +    " WHERE idED = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(e.getIdEmpleado()));
            pstm.setString(2, e.getFormulario());
            pstm.setString(3, e.getIndicadoresGestion());
            pstm.setInt(4,Integer.parseInt(e.getIdED()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una EVALUACION DE DESEMPEÑO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar una EVALUACION DE DESEMPEÑO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarEvaluacion_Desempeño(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM evaluacion_desempeño WHERE idED = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una EVALUACION DE DESEMPEÑO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar una EVALUACION DE DESEMPEÑO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Evaluacion_Desempeño> listadoEvaluacion_Desempeño(String id){      
        ArrayList<Evaluacion_Desempeño> listado = new ArrayList<>();
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM evaluacion_desempeño ORDER BY idED";            
            }else{
                sql = "SELECT * FROM evaluacion_desempeño WHERE idED = ? "
                    + "ORDER BY idED";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            Evaluacion_Desempeño ED = null;
            while(rs.next()){
                ED = new Evaluacion_Desempeño();
                ED.setIdED(rs.getString("idED"));
                ED.setIdEmpleado(rs.getString("idEmpleado"));
                ED.setFormulario(rs.getString("formulario"));
                ED.setIndicadoresGestion(rs.getString("indicadoresGestion"));
                listado.add(ED);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EVALUACION DE DESEMPEÑO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de EVALUACION DE DESEMPEÑO : " + ex.getMessage());
            }
        }
        return listado;
    }
    
}
