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
public class Orden_Servicio {
    
    private String idOS;
    private String idEmpleado;
    private String idServicio;
    private String idCliente;
    private String estado;
    private String tarifa;
    private String comentario;

    public Orden_Servicio() {
    }

    public Orden_Servicio(String idOS, String idEmpleado, String idServicio, String idCliente, String estado, String tarifa, String comentario) {
        this.idOS = idOS;
        this.idEmpleado = idEmpleado;
        this.idServicio = idServicio;
        this.idCliente = idCliente;
        this.estado = estado;
        this.tarifa = tarifa;
        this.comentario = comentario;
    }

    public String getIdOS() {
        return idOS;
    }

    public void setIdOS(String idOS) {
        this.idOS = idOS;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
}
