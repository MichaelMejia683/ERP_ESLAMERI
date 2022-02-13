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
public class FacturaCobro {
    
    private StringProperty idFC;
    private StringProperty idOS;
    private StringProperty costoTotal;
    private StringProperty fechaVencimiento;
    private StringProperty estado;

    public FacturaCobro() {
    }

    public FacturaCobro(String idFC, String idOS, String costoTotal, String fechaVencimiento, String estado) {
        this.idFC = new SimpleStringProperty(idFC);
        this.idOS = new SimpleStringProperty(idOS);
        this.costoTotal = new SimpleStringProperty(costoTotal);
        this.fechaVencimiento = new SimpleStringProperty(fechaVencimiento);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getIdFC() {
        return idFC.get();
    }

    public void setIdFC(String idFC) {
        this.idFC = new SimpleStringProperty(idFC);
    }

    public String getIdOS() {
        return idOS.get();
    }

    public void setIdOS(String idOS) {
        this.idOS = new SimpleStringProperty(idOS);
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
