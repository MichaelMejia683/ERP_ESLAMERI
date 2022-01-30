/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author MICHAEL
 */
public class LoginController implements Initializable {


    @FXML
    private Button btnSalir;
    @FXML
    private Button btnSesion;
    @FXML
    private PasswordField ContraField;
    @FXML
    private TextField UsuarioField;
    @FXML
    private AnchorPane LoginView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btnSalir){
            
            Alert alert=new Alert(AlertType.CONFIRMATION,"¿Esta seguro que desea salir del sistema?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
            System.exit(0);
            }
            } 
        
    }
    
    
    }
      
      
      
      
    
