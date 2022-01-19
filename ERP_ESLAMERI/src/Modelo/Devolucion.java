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
public class Devolucion {
    
    private String idDevolucion;
    private String idEntrada;
    private String Comentario;

    public Devolucion() {
    }

    public Devolucion(String idDevolucion, String idEntrada, String Comentario) {
        this.idDevolucion = idDevolucion;
        this.idEntrada = idEntrada;
        this.Comentario = Comentario;
    }

    public String getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(String idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
    
    
    
}
