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
public class Empleado {
    
    private String idEmpleado;
    private String idArea;
    private String idContrato;
    private String nombre;
    private String fechaNacimiento;
    private String cargo;
    private String salario;
    private String numeroCuentaBanco;
    private String fechaVinculacion;

    public Empleado() {
    }

    public Empleado(String idEmpleado, String idArea, String idContrato, String nombre, String fechaNamiento, String cargo, String salario, String nuemroCuentaBanco, String fechaVinculacion) {
        this.idEmpleado = idEmpleado;
        this.idArea = idArea;
        this.idContrato = idContrato;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNamiento;
        this.cargo = cargo;
        this.salario = salario;
        this.numeroCuentaBanco = nuemroCuentaBanco;
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNamiento) {
        this.fechaNacimiento = fechaNamiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNumeroCuentaBanco() {
        return numeroCuentaBanco;
    }

    public void setNumeroCuentaBanco(String nuemroCuentaBanco) {
        this.numeroCuentaBanco = nuemroCuentaBanco;
    }

    public String getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(String fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
    
    
    
}
