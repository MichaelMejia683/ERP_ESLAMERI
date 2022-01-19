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
public class Nomina_Empleado {
    
    private String idNXE;
    private String idEmpleado;
    private String cargo;
    private String salarioBase;
    private String horasExtra;
    private String recargos;
    private String descuentos;
    private String salarioTotal;
    private String corte;

    public Nomina_Empleado() {
    }

    public Nomina_Empleado(String idNXE, String idEmpleado, String cargo, String salarioBase, String horasExtra, String recargos, String descuentos, String salarioTotal, String corte) {
        this.idNXE = idNXE;
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.horasExtra = horasExtra;
        this.recargos = recargos;
        this.descuentos = descuentos;
        this.salarioTotal = salarioTotal;
        this.corte = corte;
    }

    public String getIdNXE() {
        return idNXE;
    }

    public void setIdNXE(String idNXE) {
        this.idNXE = idNXE;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(String salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(String horasExtra) {
        this.horasExtra = horasExtra;
    }

    public String getRecargos() {
        return recargos;
    }

    public void setRecargos(String recargos) {
        this.recargos = recargos;
    }

    public String getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = descuentos;
    }

    public String getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(String salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }
    
    
    
}
