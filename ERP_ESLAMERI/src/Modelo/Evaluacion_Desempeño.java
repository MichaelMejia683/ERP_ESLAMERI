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
public class Evaluacion_Desempeño {
    
    private StringProperty idED;
    private StringProperty idEmpleado;
    private StringProperty formulario;
    private StringProperty indicadoresGestion;

    public Evaluacion_Desempeño() {
    }

    public Evaluacion_Desempeño(String idED, String idEmpleado, String formulario, String indicadoresGestion) {
        this.idED = new SimpleStringProperty(idED);
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
        this.formulario = new SimpleStringProperty(formulario);
        this.indicadoresGestion = new SimpleStringProperty(indicadoresGestion);
    }

    public String getIdED() {
        return idED.get();
    }

    public void setIdED(String idED) {
        this.idED = new SimpleStringProperty(idED);
    }

    public String getIdEmpleado() {
        return idEmpleado.get();
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = new SimpleStringProperty(idEmpleado);
    }

    public String getFormulario() {
        return formulario.get();
    }

    public void setFormulario(String formulario) {
        this.formulario = new SimpleStringProperty(formulario);
    }

    public String getIndicadoresGestion() {
        return indicadoresGestion.get();
    }

    public void setIndicadoresGestion(String indicadoresGestion) {
        this.indicadoresGestion = new SimpleStringProperty(indicadoresGestion);
    }
    
    
    
}
