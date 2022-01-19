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
public class FacturaCobro {
    
    private String idFC;
    private String idOS;
    private String costoTotal;
    private String fechaVencimiento;
    private String estado;

    public FacturaCobro() {
    }

    public FacturaCobro(String idFC, String idOS, String costoTotal, String fechaVencimiento, String estado) {
        this.idFC = idFC;
        this.idOS = idOS;
        this.costoTotal = costoTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public String getIdFC() {
        return idFC;
    }

    public void setIdFC(String idFC) {
        this.idFC = idFC;
    }

    public String getIdOS() {
        return idOS;
    }

    public void setIdOS(String idOS) {
        this.idOS = idOS;
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
