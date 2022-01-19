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
public class Recibo_Pago {
    
    private String idPago;
    private String idFP;
    private String idCuenta;
    private String valorPagado;

    public Recibo_Pago() {
    }

    public Recibo_Pago(String idPago, String idFP, String idCuenta, String valorPagado) {
        this.idPago = idPago;
        this.idFP = idFP;
        this.idCuenta = idCuenta;
        this.valorPagado = valorPagado;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdFP() {
        return idFP;
    }

    public void setIdFP(String idFP) {
        this.idFP = idFP;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(String valorPagado) {
        this.valorPagado = valorPagado;
    }
    
    
    
}
