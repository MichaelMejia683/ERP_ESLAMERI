/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Vacante;
import Modelo.VacanteDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author MICHAEL
 */
public class VacanteViewController implements Initializable {
    
    VacanteDAO vacan = new VacanteDAO();

    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField filtro;
    @FXML
    private TableView<Vacante> tableVacante;
    @FXML
    private TableColumn<Vacante, String> ID;
    @FXML
    private TableColumn<Vacante, String> clmUsus;
    @FXML
    private TableColumn<Vacante, String> clmCargo;
    @FXML
    private TableColumn<Vacante, String> clmExp;
    @FXML
    private TableColumn<Vacante, String> clmPlazo;
    @FXML
    private TableColumn<Vacante, String> clmDesp;
    @FXML
    private TableColumn<Vacante, String> clmSta;
    
    ObservableList<Vacante> filtroListVacante;
    
    ObservableList<Vacante> listVacante;
    
    @FXML
    private TextField fieldUsus;
    @FXML
    private TextArea fieldDesp;
    @FXML
    private TextField fieldExp;
    @FXML
    private TextField fieldCargo;
    @FXML
    private TextField fieldPlazo;
    @FXML
    private ComboBox<String> cbxEstado;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private TextField fieldID;
    @FXML
    private AnchorPane vacanteView;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listVacante = FXCollections.observableArrayList();
        vacan.listadoVacante("0", listVacante);
        tableVacante.setItems(listVacante);
        ID.setCellValueFactory(new PropertyValueFactory<Vacante, String>("idVacante"));
        clmUsus.setCellValueFactory(new PropertyValueFactory<Vacante, String>("idUsuario"));
        clmCargo.setCellValueFactory(new PropertyValueFactory<Vacante, String>("cargo"));
        clmExp.setCellValueFactory(new PropertyValueFactory<Vacante, String>("experiencia"));
        clmPlazo.setCellValueFactory(new PropertyValueFactory<Vacante, String>("estadoTiempo"));
        clmDesp.setCellValueFactory(new PropertyValueFactory<Vacante, String>("descripcionHabilidad"));
        clmSta.setCellValueFactory(new PropertyValueFactory<Vacante, String>("estado"));
        
        fieldID.setDisable(true);
        
        ObservableList estados = FXCollections.observableArrayList ( 
        "Disponible","Llena","Denegada"); 
        cbxEstado.setItems(estados);
    }

    @FXML
    private void handlerAction(ActionEvent event) {
        
        /*if(event.getSource()==btnBuscar){
        ArrayList<Vacante> list = vacan.listadoVacante("0");
        filtroListVacante = FXCollections.observableArrayList(list);
        tableVacante.setItems(filtroListVacante);
        listVacante = FXCollections.observableArrayList(list);
        tableVacante.setItems(listVacante);
            String fil = filtro.getText();
            if(fil.isEmpty()){
                tableVacante.setItems(listVacante);
                
            }else{
                for(Vacante v:this.listVacante){
                    this.filtroListVacante.add(v);
                }
            }
            this.tableVacante.setItems(filtroListVacante);
            
        }*/
        
        if(event.getSource()==btnCrear){
            Vacante vaca = new Vacante();
            if(fieldID.getText().isEmpty()){
            if(fieldUsus.getText().isEmpty() || fieldDesp.getText().isEmpty() || fieldExp.getText().isEmpty() || fieldCargo.getText().isEmpty() || fieldPlazo.getText().isEmpty() || cbxEstado.getValue().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una vacante");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                vaca.setCargo(fieldCargo.getText());
                vaca.setIdUsuario(fieldUsus.getText());
                vaca.setDescripcionHabilidad(fieldDesp.getText());
                vaca.setEstado(cbxEstado.getValue());
                vaca.setEstadoTiempo(fieldPlazo.getText());
                vaca.setExperiencia(fieldExp.getText());
                vacan.crearVacante(vaca);
                listVacante = FXCollections.observableArrayList();
                vacan.listadoVacante("0", listVacante);
                tableVacante.setItems(listVacante);
                tableVacante.refresh();
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
        }
        
        if(event.getSource()==btnModifi){
            Vacante vaca = new Vacante();
            if(fieldUsus.getText().isEmpty() || fieldDesp.getText().isEmpty() || fieldExp.getText().isEmpty() || fieldCargo.getText().isEmpty() || fieldPlazo.getText().isEmpty() || cbxEstado.getValue().equalsIgnoreCase("Seleccionar...")){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una vacante");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar esta vacante?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                vaca.setCargo(fieldCargo.getText());
                vaca.setIdUsuario(fieldUsus.getText());
                vaca.setDescripcionHabilidad(fieldDesp.getText());
                vaca.setEstado(cbxEstado.getValue());
                vaca.setEstadoTiempo(fieldPlazo.getText());
                vaca.setExperiencia(fieldExp.getText());
                vaca.setIdVacante(fieldID.getText());
                vacan.modificarVacante(vaca);
                listVacante = FXCollections.observableArrayList();
                vacan.listadoVacante("0", listVacante);
                tableVacante.setItems(listVacante);
                tableVacante.refresh();
            }}
            
        }
        
        if(event.getSource()==btnBorrar){
            Vacante vaca = new Vacante();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione una vacante para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar esta vacante?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                vacan.eliminarVacante(fieldID.getText());
                listVacante = FXCollections.observableArrayList();
                vacan.listadoVacante("0", listVacante);
                tableVacante.setItems(listVacante);
                tableVacante.refresh();
            }}
        }
        
        if(event.getSource()==btnNuevo){
            fieldCargo.setText("");
            fieldUsus.setText("");
            fieldDesp.setText("");
            fieldPlazo.setText("");
            fieldExp.setText("");
            fieldID.setText("");
            cbxEstado.setValue("Seleccionar...");
        }
        
        
    }

    @FXML
    private void handlerAction(MouseEvent event) {
        
    }


    @FXML
    private void CargarVacante(MouseEvent event) {
        if(event.getSource()==tableVacante){
            Vacante vaca = new Vacante();
            
            fieldCargo.setText(tableVacante.getSelectionModel().getSelectedItem().getCargo());
            fieldUsus.setText(tableVacante.getSelectionModel().getSelectedItem().getIdUsuario());
            fieldDesp.setText(tableVacante.getSelectionModel().getSelectedItem().getDescripcionHabilidad());
            fieldPlazo.setText(tableVacante.getSelectionModel().getSelectedItem().getEstadoTiempo());
            fieldExp.setText(tableVacante.getSelectionModel().getSelectedItem().getExperiencia());
            fieldID.setText(tableVacante.getSelectionModel().getSelectedItem().getIdVacante());
            cbxEstado.setValue(tableVacante.getSelectionModel().getSelectedItem().getEstado());
        }
    }


}
