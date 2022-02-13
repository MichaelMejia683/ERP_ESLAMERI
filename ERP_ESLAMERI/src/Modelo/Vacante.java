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
public class Vacante {
    
    private StringProperty idVacante;
    private StringProperty idUsuario;
    private StringProperty cargo;
    private StringProperty experiencia;
    private StringProperty estadoTiempo;
    private StringProperty descripcionHabilidad;
    private StringProperty estado;

    public Vacante() {
    }

    public Vacante(String idVacante, String idUsuario, String cargo, String experiencia, String estadoTiempo, String descripcionHabilidad, String estado) {
        this.idVacante = new SimpleStringProperty(idVacante);
        this.idUsuario = new SimpleStringProperty(idUsuario);
        this.cargo = new SimpleStringProperty(cargo);
        this.experiencia = new SimpleStringProperty(experiencia);
        this.estadoTiempo = new SimpleStringProperty(estadoTiempo);
        this.descripcionHabilidad = new SimpleStringProperty(descripcionHabilidad);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getIdVacante() {
        return idVacante.get();
    }

    public void setIdVacante(String idVacante) {
        this.idVacante = new SimpleStringProperty(idVacante);
    }

    public String getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = new SimpleStringProperty(idUsuario);
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(String cargo) {
        this.cargo = new SimpleStringProperty(cargo);
    }

    public String getExperiencia() {
        return experiencia.get();
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = new SimpleStringProperty(experiencia);
    }

    public String getEstadoTiempo() {
        return estadoTiempo.get();
    }

    public void setEstadoTiempo(String estadoTiempo) {
        this.estadoTiempo = new SimpleStringProperty(estadoTiempo);
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad.get();
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = new SimpleStringProperty(descripcionHabilidad);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }
    
    
    
}
