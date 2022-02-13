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
public class Cliente {
    
    private StringProperty idCliente;
    private StringProperty nombre;
    private StringProperty telefono;
    private StringProperty direccion;

    public Cliente() {
    }

    public Cliente(String idCliente, String nombre, String telefono, String direccion) {
        this.idCliente = new SimpleStringProperty(idCliente);
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        this.direccion = new SimpleStringProperty(direccion);
    }

    public String getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = new SimpleStringProperty(idCliente);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono = new SimpleStringProperty(telefono);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }
    
    
}
