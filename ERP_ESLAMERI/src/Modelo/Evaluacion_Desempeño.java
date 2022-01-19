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
public class Evaluacion_Desempeño {
    
    private String idED;
    private String idEmpleado;
    private String formulario;
    private String indicadoresGestion;

    public Evaluacion_Desempeño() {
    }

    public Evaluacion_Desempeño(String idED, String idEmpleado, String formulario, String indicadoresGestion) {
        this.idED = idED;
        this.idEmpleado = idEmpleado;
        this.formulario = formulario;
        this.indicadoresGestion = indicadoresGestion;
    }

    public String getIdED() {
        return idED;
    }

    public void setIdED(String idED) {
        this.idED = idED;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getIndicadoresGestion() {
        return indicadoresGestion;
    }

    public void setIndicadoresGestion(String indicadoresGestion) {
        this.indicadoresGestion = indicadoresGestion;
    }
    
    
    
}
