/*
 * Programa	: Area.java
 * Fecha	: 16/01/2022
 * Objetivo	: Construye el objeto de Areas
 * Programador	: MICHAEL ARTURO MEJIA ARAGON 201831041
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author MAICOL MEJIA
 */
public class Area {
    
    private StringProperty idArea;
    private StringProperty nombre;

    public Area() {
    }

    public Area(String idArea, String nombre) {
        this.idArea = new SimpleStringProperty(idArea);
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getIdArea() {
        return idArea.get();
    }

    public void setIdArea(String idArea) {
        this.idArea = new SimpleStringProperty(idArea);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    
    
    
}
