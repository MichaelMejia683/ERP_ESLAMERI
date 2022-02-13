/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MICHAEL
 */
public class SolicitudInternaViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableView<?> tableSolicitud;
    @FXML
    private TableColumn<?, ?> ID;
    @FXML
    private TableColumn<?, ?> clmUsuario;
    @FXML
    private TableColumn<?, ?> clmSolicitud;
    @FXML
    private TableColumn<?, ?> clmJusti;
    @FXML
    private TableColumn<?, ?> clmFPago1;
    @FXML
    private TableColumn<?, ?> clmFPago11;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldUsus;
    @FXML
    private ComboBox<?> cbxEstado;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private TextField fieldSolicitud;
    @FXML
    private TextField fieldRol;
    @FXML
    private TextArea fieldJusti;
    @FXML
    private TextField fieldTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerAction(ActionEvent event) {
    }

    @FXML
    private void handlerAction(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void CargarNomina(MouseEvent event) {
    }

    @FXML
    private void handlerAction(SortEvent<C> event) {
    }

    @FXML
    private void handlerAction(MouseEvent event) {
    }
    
}
