/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author MICHAEL
 */
public class Usuario {
    
    private StringProperty idUsuario;
    private StringProperty usuario;
    private StringProperty idRol;
    private StringProperty correo;
    private StringProperty contrasena;

    public Usuario() {
    }

    public Usuario(String idUsuario, String usuario, String idRol, String correo, String contrasena) {
        this.idUsuario = new SimpleStringProperty(idUsuario);
        this.usuario = new SimpleStringProperty(usuario);
        this.idRol = new SimpleStringProperty(idRol);
        this.correo = new SimpleStringProperty(correo);
        this.contrasena = new SimpleStringProperty(contrasena);
    }

    public String getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = new SimpleStringProperty(idUsuario);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public void setUsuario(String usuario) {
        this.usuario = new SimpleStringProperty(usuario);
    }

    public String getIdRol() {
        return idRol.get();
    }

    public void setIdRol(String idRol) {
        this.idRol = new SimpleStringProperty(idRol);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo = new SimpleStringProperty(correo);
    }

    public String getContrasena() {
        return contrasena.get();
    }

    public void setContrasena(String contrasena) {
        this.contrasena = new SimpleStringProperty(contrasena);
    }
    
    
    
}
