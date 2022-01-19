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
public class Rol {
    
    private String idRol;
    private String nombre;
    private String permisos;

    public Rol() {
    }

    public Rol(String idRol, String nombre, String permisos) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
    
    
    
}
