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
public class Devolucion {
    
    private StringProperty idDevolucion;
    private StringProperty idEntrada;
    private StringProperty Comentario;

    public Devolucion() {
    }

    public Devolucion(String idDevolucion, String idEntrada, String Comentario) {
        this.idDevolucion = new SimpleStringProperty(idDevolucion);
        this.idEntrada = new SimpleStringProperty(idEntrada);
        this.Comentario = new SimpleStringProperty(Comentario);
    }

    public String getIdDevolucion() {
        return idDevolucion.get();
    }

    public void setIdDevolucion(String idDevolucion) {
        this.idDevolucion = new SimpleStringProperty(idDevolucion);
    }

    public String getIdEntrada() {
        return idEntrada.get();
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = new SimpleStringProperty(idEntrada);
    }

    public String getComentario() {
        return Comentario.get();
    }

    public void setComentario(String Comentario) {
        this.Comentario = new SimpleStringProperty(Comentario);
    }
    
    
    
}
