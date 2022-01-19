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
public class Solicitud_Interna {
    
    private String idSI;
    private String idUsuario;
    private String solicitud;
    private String justi_Solicitud;
    private String tiempo_Espera;
    private String estado;

    public Solicitud_Interna() {
    }

    public Solicitud_Interna(String idSI, String idUsuario, String solicitud, String justi_Solicitud, String tiempo_Espera, String estado) {
        this.idSI = idSI;
        this.idUsuario = idUsuario;
        this.solicitud = solicitud;
        this.justi_Solicitud = justi_Solicitud;
        this.tiempo_Espera = tiempo_Espera;
        this.estado = estado;
    }

    public String getIdSI() {
        return idSI;
    }

    public void setIdSI(String idSI) {
        this.idSI = idSI;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getJusti_Solicitud() {
        return justi_Solicitud;
    }

    public void setJusti_Solicitud(String justi_Solicitud) {
        this.justi_Solicitud = justi_Solicitud;
    }

    public String getTiempo_Espera() {
        return tiempo_Espera;
    }

    public void setTiempo_Espera(String tiempo_Espera) {
        this.tiempo_Espera = tiempo_Espera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
