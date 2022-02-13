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
public class Rol {
    
    private StringProperty idRol;
    private StringProperty nombre;
    private StringProperty permisos;

    public Rol() {
    }

    public Rol(String idRol, String nombre, String permisos) {
        this.idRol = new SimpleStringProperty(idRol);
        this.nombre = new SimpleStringProperty(nombre);
        this.permisos = new SimpleStringProperty(permisos);
    }

    public String getIdRol() {
        return idRol.get();
    }

    public void setIdRol(String idRol) {
        this.idRol = new SimpleStringProperty(idRol);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getPermisos() {
        return permisos.get();
    }

    public void setPermisos(String permisos) {
        this.permisos = new SimpleStringProperty(permisos);
    }
    
    
    
}
