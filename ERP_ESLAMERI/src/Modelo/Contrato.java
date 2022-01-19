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
public class Contrato {
    
    private String idContrato;
    private String idEmpresa;
    private String tipoContrato;
    private String tiempoContrato;

    public Contrato() {
    }

    public Contrato(String idContrato, String idEmpresa, String tipoContrato, String tiempoContrato) {
        this.idContrato = idContrato;
        this.idEmpresa = idEmpresa;
        this.tipoContrato = tipoContrato;
        this.tiempoContrato = tiempoContrato;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(String tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }
    
    
    
}
