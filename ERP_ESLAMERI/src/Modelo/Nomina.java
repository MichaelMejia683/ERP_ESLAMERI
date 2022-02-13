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
public class Nomina {
    
    private StringProperty idNomina;
    private StringProperty idCuenta;
    private StringProperty pagoTotal;
    private StringProperty fechaPago;

    public Nomina() {
    }

    public Nomina(String idNomina, String idCuenta, String pagoTotal, String fechaPago) {
        this.idNomina = new SimpleStringProperty(idNomina);
        this.idCuenta = new SimpleStringProperty(idCuenta);
        this.pagoTotal = new SimpleStringProperty(pagoTotal);
        this.fechaPago = new SimpleStringProperty(fechaPago);
    }

    public String getIdNomina() {
        return idNomina.get();
    }

    public void setIdNomina(String idNomina) {
        this.idNomina = new SimpleStringProperty(idNomina);
    }

    public String getIdCuenta() {
        return idCuenta.get();
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = new SimpleStringProperty(idCuenta);
    }

    public String getPagoTotal() {
        return pagoTotal.get();
    }

    public void setPagoTotal(String pagoTotal) {
        this.pagoTotal = new SimpleStringProperty(pagoTotal);
    }

    public String getFechaPago() {
        return fechaPago.get();
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = new SimpleStringProperty(fechaPago);
    }
    
    
    
}
