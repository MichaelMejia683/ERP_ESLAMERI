/*
 * Programa	: Area.java
 * Fecha	: 16/01/2022
 * Objetivo	: Construye el objeto de Areas
 * Programador	: MICHAEL ARTURO MEJIA ARAGON 201831041
 */
package Modelo;

/**
 *
 * @author MAICOL MEJIA
 */
public class Area {
    
    private String idArea;
    private String nombre;

    public Area() {
    }

    public Area(String idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
