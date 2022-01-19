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
public class Entrada {
    
    private String idEntrada;
    private String idOC;
    private String idUsuario;
    private String articulo;
    private String comentario;
    private String estado;
    private String entregadoA;
    private String entregadoPor;

    public Entrada() {
    }

    public Entrada(String idEntrada, String idOC, String idUsuario, String articulo, String comentario, String estado, String entregadoA, String entregadoPor) {
        this.idEntrada = idEntrada;
        this.idOC = idOC;
        this.idUsuario = idUsuario;
        this.articulo = articulo;
        this.comentario = comentario;
        this.estado = estado;
        this.entregadoA = entregadoA;
        this.entregadoPor = entregadoPor;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getIdOC() {
        return idOC;
    }

    public void setIdOC(String idOC) {
        this.idOC = idOC;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEntregadoA() {
        return entregadoA;
    }

    public void setEntregadoA(String entregadoA) {
        this.entregadoA = entregadoA;
    }

    public String getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = entregadoPor;
    }
    
    
    
}
