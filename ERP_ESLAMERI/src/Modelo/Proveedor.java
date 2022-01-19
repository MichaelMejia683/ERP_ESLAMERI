/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MAICOL MEJA
 */
public class Proveedor {
    
    private String idProv;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    public Proveedor() {
    }

    public Proveedor(String idProv, String nombre, String direccion, String telefono, String NIT) {
        this.idProv = idProv;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
    
    
    
}
