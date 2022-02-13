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
public class Nomina_Empleado {
    
    private StringProperty idNXE;
    private StringProperty idEmpleado;
    private StringProperty salarioBase;
    private StringProperty horasExtraDiurna;
    private StringProperty recargos;
    private StringProperty descuentos;
    private StringProperty salarioTotal;
    private StringProperty horaExtraNocturno;
    private StringProperty horaDominical;
    private StringProperty corte;

    public Nomina_Empleado() {
    }

    public Nomina_Empleado(String idNXE, String idEmpleado, String salarioBase, String horasExtraDiurna, String recargos, String descuentos, String salarioTotal,String horaExtraNocturno, String horaDominical, String corte) {
        this.idNXE = new SimpleStringProperty(idNXE);
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
 
        this.salarioBase = new SimpleStringProperty(salarioBase);
        this.horasExtraDiurna = new SimpleStringProperty(horasExtraDiurna);
        this.recargos = new SimpleStringProperty(recargos);
        this.descuentos = new SimpleStringProperty(descuentos);
        this.salarioTotal = new SimpleStringProperty(salarioTotal);
        this.horaExtraNocturno = new SimpleStringProperty(horaExtraNocturno);
        this.horaDominical = new SimpleStringProperty(horaDominical);
        this.corte = new SimpleStringProperty(corte);
    }

    public String getIdNXE() {
        return idNXE.get();
    }

    public void setIdNXE(String idNXE) {
        this.idNXE = new SimpleStringProperty(idNXE);
    }

    public String getIdEmpleado() {
        return idEmpleado.get();
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
    }

    public String getSalarioBase() {
        return salarioBase.get();
    }

    public void setSalarioBase(String salarioBase) {
        this.salarioBase = new SimpleStringProperty(salarioBase);
    }

    public String getHorasExtraDiurna() {
        return horasExtraDiurna.get();
    }

    public void setHorasExtraDiurna(String horasExtraDiurna) {
        this.horasExtraDiurna = new SimpleStringProperty(horasExtraDiurna);
    }

    public String getRecargos() {
        return recargos.get();
    }

    public void setRecargos(String recargos) {
        this.recargos = new SimpleStringProperty(recargos);
    }

    public String getDescuentos() {
        return descuentos.get();
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = new SimpleStringProperty(descuentos);
    }

    public String getSalarioTotal() {
        return salarioTotal.get();
    }

    public void setSalarioTotal(String salarioTotal) {
        this.salarioTotal = new SimpleStringProperty(salarioTotal);
    }
    
    public String getHoraExtraNocturno() {
        return horaExtraNocturno.get();
    }

    public void setHoraExtraNocturno(String horaExtraNocturno) {
        this.horaExtraNocturno = new SimpleStringProperty(horaExtraNocturno);
    }
    
    public String getHoraDominical() {
        return horaDominical.get();
    }

    public void setHoraDominical(String horaDominical) {
        this.horaDominical = new SimpleStringProperty(horaDominical);
    }

    public String getCorte() {
        return corte.get();
    }

    public void setCorte(String corte) {
        this.corte = new SimpleStringProperty(corte);
    }
    
    
    
}
