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
public class ComprasController implements Initializable {

    @FXML
    private Button btnAtras;
    @FXML
    private Button btnSolicitud;
    @FXML
    private Button btnOrden;
    @FXML
    private AnchorPane baseCompra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {

        if(event.getSource()==btnSolicitud){
            baseCompra.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(ComprasController.class.getResource("/Vista/SolicitudInternaView.fxml"));
            baseCompra.getChildren().setAll(segundoPanel);
        }
        
        if(event.getSource()==btnOrden){
            baseCompra.getChildren().clear();
            AnchorPane segundoPanel = FXMLLoader.load(ComprasController.class.getResource("/Vista/OrdenCompraView.fxml"));
            baseCompra.getChildren().setAll(segundoPanel);
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
