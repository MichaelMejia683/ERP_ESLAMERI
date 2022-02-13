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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MICHAEL
 */
public class ContabilidadController implements Initializable {

    @FXML
    private Button btnAtras;
    @FXML
    private AnchorPane base1Conta;
    @FXML
    private Button btnFacturaC;
    @FXML
    private Button btnFacturaP;
    @FXML
    private Button btnRecibo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
        
        if(event.getSource()==btnFacturaC){
            AnchorPane segundoPanel = FXMLLoader.load(ContabilidadController.class.getResource("/Vista/FacturaCView.fxml"));
            base1Conta.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnFacturaP){
            AnchorPane segundoPanel = FXMLLoader.load(ContabilidadController.class.getResource("/Vista/FacturaPView.fxml"));
            base1Conta.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnRecibo){
            AnchorPane segundoPanel = FXMLLoader.load(ContabilidadController.class.getResource("/Vista/ReciboView.fxml"));
            base1Conta.getChildren().setAll(segundoPanel);
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
