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
public class Orden_Servicio {
    
    private StringProperty idOS;
    private StringProperty idEmpleado;
    private StringProperty idServicio;
    private StringProperty idCliente;
    private StringProperty estado;
    private StringProperty tarifa;
    private StringProperty comentario;

    public Orden_Servicio() {
    }

    public Orden_Servicio(String idOS, String idEmpleado, String idServicio, String idCliente, String estado, String tarifa, String comentario) {
        this.idOS = new SimpleStringProperty(idOS);
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
        this.idServicio = new SimpleStringProperty(idServicio);
        this.idCliente = new SimpleStringProperty(idCliente);
        this.estado = new SimpleStringProperty(estado);
        this.tarifa = new SimpleStringProperty(tarifa);
        this.comentario = new SimpleStringProperty(comentario);
    }

    public String getIdOS() {
        return idOS.get();
    }

    public void setIdOS(String idOS) {
        this.idOS = new SimpleStringProperty(idOS);
    }

    public String getIdEmpleado() {
        return idEmpleado.get();
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
    }

    public String getIdServicio() {
        return idServicio.get();
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = new SimpleStringProperty(idServicio);
    }

    public String getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = new SimpleStringProperty(idCliente);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }

    public String getTarifa() {
        return tarifa.get();
    }

    public void setTarifa(String tarifa) {
        this.tarifa = new SimpleStringProperty(tarifa);
    }

    public String getComentario() {
        return comentario.get();
    }

    public void setComentario(String comentario) {
        this.comentario = new SimpleStringProperty(comentario);
    }
    
    
    
}
