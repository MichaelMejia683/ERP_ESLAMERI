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
public class Empresa {
    
    private StringProperty idEmpresa;
    private StringProperty nombre;
    private StringProperty NIT;

    public Empresa() {
    }

    public Empresa(String idEmpresa, String nombre, String NIT) {
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
        this.nombre = new SimpleStringProperty(nombre);
        this.NIT = new SimpleStringProperty(NIT);
    }

    public String getIdEmpresa() {
        return idEmpresa.get();
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getNIT() {
        return NIT.get();
    }

    public void setNIT(String NIT) {
        this.NIT = new SimpleStringProperty(NIT);
    }
    
    
    
}
