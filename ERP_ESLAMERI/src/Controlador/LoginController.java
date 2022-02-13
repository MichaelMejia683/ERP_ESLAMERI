/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author MICHAEL
 */
public class LoginController implements Initializable {
    

    UsuarioDAO modelo = new UsuarioDAO();

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
    @FXML
    private CheckBox checkContra;
    @FXML
    private TextField fieldContra;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fieldContra.setVisible(false);
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==btnSalir){
            
            Alert alert=new Alert(AlertType.CONFIRMATION,"¿Esta seguro que desea salir del sistema?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
            System.exit(0);
            }}
            
            if(event.getSource()==btnSesion){
            String Usu = UsuarioField.getText();
            String pass = ContraField.getText();
            if(UsuarioField.getText().isEmpty() || ContraField.getText().isEmpty()){
            Alert alert=new Alert(AlertType.INFORMATION,"Se necesitan el usuario y la contraseña para iniciar sesión");
            alert.setHeaderText(null);
            alert.showAndWait();
            }else{
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
           ArrayList<Usuario> list;
            list = modelo.loginUsuario(Usu, pass);
                if(list.size()>0){
                    Alert alert=new Alert(AlertType.INFORMATION,"Bienvenido a ERP ESLAMERI");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/RRHH.fxml"));

                    Parent root = loader.load();
                    RRHHController control = loader.getController();
                    Scene escena = new Scene(root);
                    Stage stage = new Stage();
                    stage.getIcons().add( new Image("/Recursos/iconoESLAMERI.png"));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(escena);
                    stage.showAndWait();
                    
            
        }else{
            Alert alert=new Alert(AlertType.ERROR,"Usuario o Contraseña incorrectos");
            alert.setHeaderText(null);
            alert.showAndWait(); 
                }}}
            
        }
        
    

    @FXML
    private void handlerAction(ActionEvent event) {
    }

    @FXML
    private void handlerClick(MouseEvent event) {
                
        if(checkContra.isSelected()){
            fieldContra.setText(ContraField.getText());
            ContraField.setVisible(false);
            fieldContra.setVisible(true);
            
            }else{
            ContraField.setText(fieldContra.getText());
            ContraField.setVisible(true);
            fieldContra.setVisible(false);
                
            }
    }
    
}
      
      
      
      
    
