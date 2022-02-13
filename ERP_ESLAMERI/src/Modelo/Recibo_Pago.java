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
public class Recibo_Pago {
    
    private StringProperty idPago;
    private StringProperty idFP;
    private StringProperty idCuenta;
    private StringProperty valorPagado;

    public Recibo_Pago() {
    }

    public Recibo_Pago(String idPago, String idFP, String idCuenta, String valorPagado) {
        this.idPago = new SimpleStringProperty(idPago);
        this.idFP = new SimpleStringProperty(idFP);
        this.idCuenta = new SimpleStringProperty(idCuenta);
        this.valorPagado = new SimpleStringProperty(valorPagado);
    }

    public String getIdPago() {
        return idPago.get();
    }

    public void setIdPago(String idPago) {
        this.idPago = new SimpleStringProperty(idPago);
    }

    public String getIdFP() {
        return idFP.get();
    }

    public void setIdFP(String idFP) {
        this.idFP = new SimpleStringProperty(idFP);
    }

    public String getIdCuenta() {
        return idCuenta.get();
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = new SimpleStringProperty(idCuenta);
    }

    public String getValorPagado() {
        return valorPagado.get();
    }

    public void setValorPagado(String valorPagado) {
        this.valorPagado = new SimpleStringProperty(valorPagado);
    }
    
    
    
}
