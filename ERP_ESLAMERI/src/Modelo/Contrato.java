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
public class Contrato {
    
    private StringProperty idContrato;
    private StringProperty idEmpresa;
    private StringProperty nombreContrato;
    private StringProperty tipoContrato;
    private StringProperty tiempoContrato;

    public Contrato() {
    }

    public Contrato(String idContrato, String idEmpresa, String nombreContrato, String tipoContrato, String tiempoContrato) {
        this.idContrato = new SimpleStringProperty(idContrato);
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
        this.nombreContrato = new SimpleStringProperty(nombreContrato);
        this.tipoContrato = new SimpleStringProperty(tipoContrato);
        this.tiempoContrato = new SimpleStringProperty(tiempoContrato);
    }

    public String getIdContrato() {
        return idContrato.get();
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = new SimpleStringProperty(idContrato);
    }

    public String getIdEmpresa() {
        return idEmpresa.get();
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
    }
    
    public String getNombreContrato() {
        return nombreContrato.get();
    }

    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = new SimpleStringProperty(nombreContrato);
    }

    public String getTipoContrato() {
        return tipoContrato.get();
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = new SimpleStringProperty(tipoContrato);
    }

    public String getTiempoContrato() {
        return tiempoContrato.get();
    }

    public void setTiempoContrato(String tiempoContrato) {
        this.tiempoContrato = new SimpleStringProperty(tiempoContrato);
    }
    
    
    
}
