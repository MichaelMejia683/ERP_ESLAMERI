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
public class Vacante {
    
    private String idVacante;
    private String idUsuario;
    private String cargo;
    private String experiencia;
    private String estadoTiempo;
    private String descripcionHabilidad;
    private String estado;

    public Vacante() {
    }

    public Vacante(String idVacante, String idUsuario, String cargo, String experiencia, String estadoTiempo, String descripcionHabilidad, String estado) {
        this.idVacante = idVacante;
        this.idUsuario = idUsuario;
        this.cargo = cargo;
        this.experiencia = experiencia;
        this.estadoTiempo = estadoTiempo;
        this.descripcionHabilidad = descripcionHabilidad;
        this.estado = estado;
    }

    public String getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(String idVacante) {
        this.idVacante = idVacante;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstadoTiempo() {
        return estadoTiempo;
    }

    public void setEstadoTiempo(String estadoTiempo) {
        this.estadoTiempo = estadoTiempo;
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
