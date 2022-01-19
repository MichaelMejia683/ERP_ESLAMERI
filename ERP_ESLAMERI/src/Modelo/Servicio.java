/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MICHAEL
 */
public class Servicio {
    
    private String idServicio;
    private String nombre;
    private String tarifa;
    private String tiempoEstimado;
    private String tipoTiempo;

    public Servicio() {
    }

    public Servicio(String idServicio, String nombre, String tarifa, String tiempoEstimado, String tipoTiempo) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.tiempoEstimado = tiempoEstimado;
        this.tipoTiempo = tipoTiempo;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getTipoTiempo() {
        return tipoTiempo;
    }

    public void setTipoTiempo(String tipoTiempo) {
        this.tipoTiempo = tipoTiempo;
    }
    
    
    
}
