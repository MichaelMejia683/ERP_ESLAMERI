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
public class FacturaPago {
    
    private StringProperty idFP;
    private StringProperty idOC;
    private StringProperty costoTotal;
    private StringProperty fechaVencimiento;
    private StringProperty estado;

    public FacturaPago() {
    }

    public FacturaPago(String idFP, String idOC, String costoTotal, String fechaVencimiento, String estado) {
        this.idFP = new SimpleStringProperty(idFP);
        this.idOC = new SimpleStringProperty(idOC);
        this.costoTotal = new SimpleStringProperty(costoTotal);
        this.fechaVencimiento = new SimpleStringProperty(fechaVencimiento);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getIdFP() {
        return idFP.get();
    }

    public void setIdFP(String idFP) {
        this.idFP = new SimpleStringProperty(idFP);
    }

    public String getIdOC() {
        return idOC.get();
    }

    public void setIdOC(String idOC) {
        this.idOC = new SimpleStringProperty(idOC);
    }

    public String getCostoTotal() {
        return costoTotal.get();
    }

    public void setCostoTotal(String costoTotal) {
        this.costoTotal = new SimpleStringProperty(costoTotal);
    }

    public String getFechaVencimiento() {
        return fechaVencimiento.get();
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = new SimpleStringProperty(fechaVencimiento);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }

    
    
}
