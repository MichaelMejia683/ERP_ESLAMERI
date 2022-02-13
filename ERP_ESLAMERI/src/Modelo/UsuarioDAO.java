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
public class UsuarioDAO {
    
    private Connection con;
    private PreparedStatement pstm;
    private int rtdo = 0;
    private ResultSet rs;

        private final conexionBD conexion;
        
    public UsuarioDAO() {
        this.rtdo = 0;
        conexion=new conexionBD();
    }
    
    public int crearUsuario(Usuario e){
        try{
            con = conexion.dataSource.getConnection();
            String sql = "INSERT INTO usuario(usuario,idRol,correo,contrasena) VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getUsuario());
            pstm.setInt(2,Integer.parseInt(e.getIdRol()));
            pstm.setString(3, e.getCorreo());
            pstm.setString(4, e.getContrasena());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un USUARIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en crear un USUARIO  : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public int modificarUsuario(Usuario e){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "UPDATE usuario " +
                         "SET usuario = ?, idRol = ?, correo = ?, contrasena = ?"
                    +    " WHERE idUsuario = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, e.getUsuario());
            pstm.setInt(2,Integer.parseInt(e.getIdRol()));
            pstm.setString(3, e.getCorreo());
            pstm.setString(4, e.getContrasena());
            pstm.setInt(5,Integer.parseInt(e.getIdUsuario()));
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un USUARIO : " + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en modificar un USUARIO : " + ex.getMessage());
            }
        }
        return rtdo;
    } 
  
        
            
    public int eliminarUsuario(String id){      
        try{
            con = conexion.dataSource.getConnection();
            String sql = "DELETE FROM usuario WHERE idUsuario = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un USUARIO : "+ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en eliminar un USUARIO : " + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public void listadoUsuario(String id, ObservableList<Usuario> listado){      
        try{
            con = conexion.dataSource.getConnection();
            String sql;
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM usuario ORDER BY idUsuario";            
            }else{
                sql = "SELECT * FROM usuario WHERE idUsuario = ? "
                    + "ORDER BY idUsuario";   
            }                        
            pstm=con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setInt(1,Integer.parseInt(id));
            }
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                listado.add( new Usuario(
                rs.getString("idUsuario"),
                rs.getString("usuario"),
                rs.getString("idRol"),
                rs.getString("correo"),
                rs.getString("contrasena")
                ));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de USUARIO : " + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError en generar listado de USUARIO : " + ex.getMessage());
            }
        }
    }
    
    
    public ArrayList<Usuario> loginUsuario(String usuario, String password){
    
        Connection conectar=null;
        PreparedStatement pst;
        ResultSet rs ;
        Usuario cuenta ;
        ArrayList list = new ArrayList();
        
        try{

            conectar = conexion.dataSource.getConnection();
            
            if(conectar != null){           
                
                String sql ="SELECT *  FROM usuario WHERE usuario =? "
                        + "AND contrasena=?";
                
                pst = conectar.prepareStatement(sql);
                pst.setString(1, usuario);
                pst.setString(2, password);
                                
                rs = pst.executeQuery();
                                
                if(rs.next()){
                    
                    cuenta = new Usuario();
                    cuenta.setUsuario(rs.getString("usuario"));
                    cuenta.setContrasena(rs.getString("contrasena"));
                    cuenta.setIdRol(rs.getString("idRol"));
                    list.add(cuenta);

                }
                 
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al realizar la operación, intente más tarde \no Verifique la base de Datos","Error",JOptionPane.ERROR_MESSAGE);
            }
                
        
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e , ".::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
        }finally{
        
            try{
                conectar.close();
            }catch(SQLException ex){
                System.out.println("Error "+ex);
            }
        
        }
        
       return list;
         
    }
    
}
