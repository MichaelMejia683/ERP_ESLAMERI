/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MICHAEL
 */
public class Usuario {
    
    private String idUsuario;
    private String usuario;
    private String idRol;
    private String correo;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String idUsuario, String usuario, String idRol, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idRol = idRol;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
