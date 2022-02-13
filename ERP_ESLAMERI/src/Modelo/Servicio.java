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
 * @author MICHAEL
 */
public class Servicio {
    
    private StringProperty idServicio;
    private StringProperty nombre;
    private StringProperty tarifa;
    private StringProperty tiempoEstimado;
    private StringProperty tipoTiempo;

    public Servicio() {
    }

    public Servicio(String idServicio, String nombre, String tarifa, String tiempoEstimado, String tipoTiempo) {
        this.idServicio = new SimpleStringProperty(idServicio);
        this.nombre = new SimpleStringProperty(nombre);
        this.tarifa = new SimpleStringProperty(tarifa);
        this.tiempoEstimado = new SimpleStringProperty(tiempoEstimado);
        this.tipoTiempo = new SimpleStringProperty(tipoTiempo);
    }

    public String getIdServicio() {
        return idServicio.get();
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = new SimpleStringProperty(idServicio);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getTarifa() {
        return tarifa.get();
    }

    public void setTarifa(String tarifa) {
        this.tarifa = new SimpleStringProperty(tarifa);
    }

    public String getTiempoEstimado() {
        return tiempoEstimado.get();
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = new SimpleStringProperty(tiempoEstimado);
    }

    public String getTipoTiempo() {
        return tipoTiempo.get();
    }

    public void setTipoTiempo(String tipoTiempo) {
        this.tipoTiempo = new SimpleStringProperty(tipoTiempo);
    }
    
    
    
}
