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
public class Empleado {
    
    private StringProperty idEmpleado;
    private StringProperty idArea;
    private StringProperty idContrato;
    private StringProperty nombre;
    private StringProperty fechaNacimiento;
    private StringProperty cargo;
    private StringProperty salario;
    private StringProperty numeroCuentaBanco;
    private StringProperty fechaVinculacion;

    public Empleado() {
    }

    public Empleado(String idEmpleado, String idArea, String idContrato, String nombre, String fechaNamiento, String cargo, String salario, String nuemroCuentaBanco, String fechaVinculacion) {
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
        this.idArea = new SimpleStringProperty(idArea);
        this.idContrato = new SimpleStringProperty(idContrato);
        this.nombre = new SimpleStringProperty(nombre);
        this.fechaNacimiento = new SimpleStringProperty(fechaNamiento);
        this.cargo = new SimpleStringProperty(cargo);
        this.salario = new SimpleStringProperty(salario);
        this.numeroCuentaBanco = new SimpleStringProperty(nuemroCuentaBanco);
        this.fechaVinculacion = new SimpleStringProperty(fechaVinculacion);
    }

    public String getIdEmpleado() {
        return idEmpleado.get();
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
    }

    public String getIdArea() {
        return idArea.get();
    }

    public void setIdArea(String idArea) {
        this.idArea = new SimpleStringProperty(idArea);
    }

    public String getIdContrato() {
        return idContrato.get();
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = new SimpleStringProperty(idContrato);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setFechaNacimiento(String fechaNamiento) {
        this.fechaNacimiento = new SimpleStringProperty(fechaNamiento);
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(String cargo) {
        this.cargo = new SimpleStringProperty(cargo);
    }

    public String getSalario() {
        return salario.get();
    }

    public void setSalario(String salario) {
        this.salario = new SimpleStringProperty(salario);
    }

    public String getNumeroCuentaBanco() {
        return numeroCuentaBanco.get();
    }

    public void setNumeroCuentaBanco(String nuemroCuentaBanco) {
        this.numeroCuentaBanco = new SimpleStringProperty(nuemroCuentaBanco);
    }

    public String getFechaVinculacion() {
        return fechaVinculacion.get();
    }

    public void setFechaVinculacion(String fechaVinculacion) {
        this.fechaVinculacion = new SimpleStringProperty(fechaVinculacion);
    }
    
    
    
}
