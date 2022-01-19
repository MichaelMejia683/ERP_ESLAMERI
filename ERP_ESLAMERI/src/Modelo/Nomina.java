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
public class Nomina {
    
    private String idNomina;
    private String idCuenta;
    private String pagoTotal;
    private String fechaPago;

    public Nomina() {
    }

    public Nomina(String idNomina, String idCuenta, String pagoTotal, String fechaPago) {
        this.idNomina = idNomina;
        this.idCuenta = idCuenta;
        this.pagoTotal = pagoTotal;
        this.fechaPago = fechaPago;
    }

    public String getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(String idNomina) {
        this.idNomina = idNomina;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(String pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
    
}
