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
public class Orden_Compra {
    
    private StringProperty idOC;
    private StringProperty idProv;
    private StringProperty articulo;
    private StringProperty cantidad;
    private StringProperty precioUnitario;
    private StringProperty precioTotal;
    private StringProperty tiempoEspera;

    public Orden_Compra() {
    }

    public Orden_Compra(String idOC, String idProv, String articulo, String cantidad, String precioUnitario, String precioTotal, String tiempoEspera) {
        this.idOC = new SimpleStringProperty(idOC);
        this.idProv = new SimpleStringProperty(idProv);
        this.articulo = new SimpleStringProperty(articulo);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.precioUnitario = new SimpleStringProperty(precioUnitario);
        this.precioTotal = new SimpleStringProperty(precioTotal);
        this.tiempoEspera = new SimpleStringProperty(tiempoEspera);
    }

    public String getIdOC() {
        return idOC.get();
    }

    public void setIdOC(String idOC) {
        this.idOC = new SimpleStringProperty(idOC);
    }

    public String getIdProv() {
        return idProv.get();
    }

    public void setIdProv(String idProv) {
        this.idProv = new SimpleStringProperty(idProv);
    }

    public String getArticulo() {
        return articulo.get();
    }

    public void setArticulo(String articulo) {
        this.articulo = new SimpleStringProperty(articulo);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(String cantidad) {
        this.cantidad = new SimpleStringProperty(cantidad);
    }

    public String getPrecioUnitario() {
        return precioUnitario.get();
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = new SimpleStringProperty(precioUnitario);
    }

    public String getPrecioTotal() {
        return precioTotal.get();
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = new SimpleStringProperty(precioTotal);
    }

    public String getTiempoEspera() {
        return tiempoEspera.get();
    }

    public void setTiempoEspera(String tiempoEspera) {
        this.tiempoEspera = new SimpleStringProperty(tiempoEspera);
    }

    
    
}
