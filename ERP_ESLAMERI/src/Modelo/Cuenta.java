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
public class Cuenta {
    
    private StringProperty idCuenta;
    private StringProperty idEmpresa;
    private StringProperty numeroCuenta;
    private StringProperty banco;
    private StringProperty saldo;

    public Cuenta() {
    }

    public Cuenta(String idCuenta, String idEmpresa, String numeroCuenta, String banco, String saldo) {
        this.idCuenta = new SimpleStringProperty(idCuenta);
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
        this.numeroCuenta = new SimpleStringProperty(numeroCuenta);
        this.banco = new SimpleStringProperty(banco);
        this.saldo = new SimpleStringProperty(saldo);
    }

    public String getIdCuenta() {
        return idCuenta.get();
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = new SimpleStringProperty(idCuenta);
    }

    public String getIdEmpresa() {
        return idEmpresa.get();
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = new SimpleStringProperty(idEmpresa);
    }

    public String getNumeroCuenta() {
        return numeroCuenta.get();
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = new SimpleStringProperty(numeroCuenta);
    }

    public String getBanco() {
        return banco.get();
    }

    public void setBanco(String banco) {
        this.banco = new SimpleStringProperty(banco);
    }

    public String getSaldo() {
        return saldo.get();
    }

    public void setSaldo(String saldo) {
        this.saldo = new SimpleStringProperty(saldo);
    }
    
    
    
}
