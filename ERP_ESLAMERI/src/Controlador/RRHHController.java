/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MICHAEL
 */
public class RRHHController implements Initializable {

    @FXML
    private Button btnNomina;
    @FXML
    private Button btnNXE;
    @FXML
    private Button btnEmple;
    @FXML
    private Button btnVacan;
    @FXML
    private Button btnCont;
    @FXML
    private Button btnED;
    @FXML
    private Button btnAtras;
    @FXML
    private AnchorPane base1RRHH;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        if(event.getSource()==btnVacan){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/VacanteView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnCont){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/ContratoView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnED){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/EvaluacionView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnEmple){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/EmpleadoView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnNXE){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/NominaxEmpleadoView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnNomina){
            base1RRHH.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(RRHHController.class.getResource("/Vista/NominaView.fxml"));
            base1RRHH.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnAtras){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea salir del sistema?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
            System.exit(0);
            }
        }
    }

    @FXML
    private void handleClicks(MouseEvent event) {
    }

    
}
