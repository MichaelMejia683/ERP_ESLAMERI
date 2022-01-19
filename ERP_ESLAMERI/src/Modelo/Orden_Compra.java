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
public class Orden_Compra {
    
    private String idOC;
    private String idProv;
    private String articulo;
    private String cantidad;
    private String precioUnitario;
    private String precioTotal;
    private String tiempoEspera;

    public Orden_Compra() {
    }

    public Orden_Compra(String idOC, String idProv, String articulo, String cantidad, String precioUnitario, String precioTotal, String tiempoEspera) {
        this.idOC = idOC;
        this.idProv = idProv;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.tiempoEspera = tiempoEspera;
    }

    public String getIdOC() {
        return idOC;
    }

    public void setIdOC(String idOC) {
        this.idOC = idOC;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(String tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    
    
}
