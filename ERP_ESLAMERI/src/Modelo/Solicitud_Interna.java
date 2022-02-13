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
public class Solicitud_Interna {
    
    private StringProperty idSI;
    private StringProperty idUsuario;
    private StringProperty solicitud;
    private StringProperty justi_Solicitud;
    private StringProperty tiempo_Espera;
    private StringProperty estado;

    public Solicitud_Interna() {
    }

    public Solicitud_Interna(String idSI, String idUsuario, String solicitud, String justi_Solicitud, String tiempo_Espera, String estado) {
        this.idSI = new SimpleStringProperty(idSI);
        this.idUsuario = new SimpleStringProperty(idUsuario);
        this.solicitud = new SimpleStringProperty(solicitud);
        this.justi_Solicitud = new SimpleStringProperty(justi_Solicitud);
        this.tiempo_Espera = new SimpleStringProperty(tiempo_Espera);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getIdSI() {
        return idSI.get();
    }

    public void setIdSI(String idSI) {
        this.idSI = new SimpleStringProperty(idSI);
    }

    public String getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = new SimpleStringProperty(idUsuario);
    }

    public String getSolicitud() {
        return solicitud.get();
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = new SimpleStringProperty(solicitud);
    }

    public String getJusti_Solicitud() {
        return justi_Solicitud.get();
    }

    public void setJusti_Solicitud(String justi_Solicitud) {
        this.justi_Solicitud = new SimpleStringProperty(justi_Solicitud);
    }

    public String getTiempo_Espera() {
        return tiempo_Espera.get();
    }

    public void setTiempo_Espera(String tiempo_Espera) {
        this.tiempo_Espera = new SimpleStringProperty(tiempo_Espera);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }
    
    
    
}
