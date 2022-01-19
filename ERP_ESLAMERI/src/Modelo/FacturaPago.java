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
public class FacturaPago {
    
    private String idFP;
    private String idOC;
    private String costoTotal;
    private String fechaVencimiento;
    private String estado;

    public FacturaPago() {
    }

    public FacturaPago(String idFP, String idOC, String costoTotal, String fechaVencimiento, String estado) {
        this.idFP = idFP;
        this.idOC = idOC;
        this.costoTotal = costoTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public String getIdFP() {
        return idFP;
    }

    public void setIdFP(String idFP) {
        this.idFP = idFP;
    }

    public String getIdOC() {
        return idOC;
    }

    public void setIdOC(String idOC) {
        this.idOC = idOC;
    }

    public String getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(String costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
