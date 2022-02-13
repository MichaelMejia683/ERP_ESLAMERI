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
public class Entrada {
    
    private StringProperty idEntrada;
    private StringProperty idOC;
    private StringProperty idUsuario;
    private StringProperty articulo;
    private StringProperty comentario;
    private StringProperty estado;
    private StringProperty entregadoA;
    private StringProperty entregadoPor;

    public Entrada() {
    }

    public Entrada(String idEntrada, String idOC, String idUsuario, String articulo, String comentario, String estado, String entregadoA, String entregadoPor) {
        this.idEntrada = new SimpleStringProperty(idEntrada);
        this.idOC = new SimpleStringProperty(idOC);
        this.idUsuario = new SimpleStringProperty(idUsuario);
        this.articulo = new SimpleStringProperty(articulo);
        this.comentario = new SimpleStringProperty(comentario);
        this.estado = new SimpleStringProperty(estado);
        this.entregadoA = new SimpleStringProperty(entregadoA);
        this.entregadoPor = new SimpleStringProperty(entregadoPor);
    }

    public String getIdEntrada() {
        return idEntrada.get();
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = new SimpleStringProperty(idEntrada);
    }

    public String getIdOC() {
        return idOC.get();
    }

    public void setIdOC(String idOC) {
        this.idOC = new SimpleStringProperty(idOC);
    }

    public String getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = new SimpleStringProperty(idUsuario);
    }

    public String getArticulo() {
        return articulo.get();
    }

    public void setArticulo(String articulo) {
        this.articulo = new SimpleStringProperty(articulo);
    }

    public String getComentario() {
        return comentario.get();
    }

    public void setComentario(String comentario) {
        this.comentario = new SimpleStringProperty(comentario);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }

    public String getEntregadoA() {
        return entregadoA.get();
    }

    public void setEntregadoA(String entregadoA) {
        this.entregadoA = new SimpleStringProperty(entregadoA);
    }

    public String getEntregadoPor() {
        return entregadoPor.get();
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = new SimpleStringProperty(entregadoPor);
    }
    
    
    
}
