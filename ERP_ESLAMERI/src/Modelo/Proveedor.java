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
 * @author MAICOL MEJA
 */
public class Proveedor {
    
    private StringProperty idProv;
    private StringProperty nombre;
    private StringProperty direccion;
    private StringProperty telefono;
    private StringProperty NIT;

    public Proveedor() {
    }

    public Proveedor(String idProv, String nombre, String direccion, String telefono, String NIT) {
        this.idProv = new SimpleStringProperty(idProv);
        this.nombre = new SimpleStringProperty(nombre);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefono = new SimpleStringProperty(telefono);
        this.NIT = new SimpleStringProperty(NIT);
    }

    public String getIdProv() {
        return idProv.get();
    }

    public void setIdProv(String idProv) {
        this.idProv = new SimpleStringProperty(idProv);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public String getNIT() {
        return NIT.get();
    }

    public void setNIT(String NIT) {
        this.NIT = new SimpleStringProperty(NIT);
    }
    
    
    
}
