/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Contrato;
import Modelo.ContratoDAO;
import Modelo.Empresa;
import Modelo.EmpresaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MICHAEL
 */
public class ContratoViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableView<Contrato> tableContrato;
    @FXML
    private TableColumn<Contrato, String> ID;
    @FXML
    private TableColumn<Contrato, String> clmEmpre;
    @FXML
    private TableColumn<Contrato, String> clmType;
    @FXML
    private TableColumn<Contrato, String> clmTime;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldTime;
    @FXML
    private ComboBox<String> cbxTipo;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    
    ObservableList<Contrato> listContrato;

    FilteredList<Contrato> filtroList;
    
    ContratoDAO contrato = new ContratoDAO();
    
    EmpresaDAO empre = new EmpresaDAO();
    @FXML
    private TableColumn<Contrato, String> clmName;
    @FXML
    private ComboBox<String> cbxEmpre;
    @FXML
    private TextField fieldName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listContrato = FXCollections.observableArrayList();
        contrato.listadoContrato("0", listContrato);
        tableContrato.setItems(listContrato);
        ID.setCellValueFactory(new PropertyValueFactory<Contrato, String>("idContrato"));
        clmEmpre.setCellValueFactory(new PropertyValueFactory<Contrato, String>("idEmpresa"));
        clmName.setCellValueFactory(new PropertyValueFactory<Contrato, String>("nombreContrato"));
        clmType.setCellValueFactory(new PropertyValueFactory<Contrato, String>("tipoContrato"));
        clmTime.setCellValueFactory(new PropertyValueFactory<Contrato, String>("tiempoContrato"));

        fieldID.setDisable(true);
        
        ObservableList estados = FXCollections.observableArrayList ( 
        "Temporal","Indefinido"); 
        cbxTipo.setItems(estados);
        
        ObservableList<Empresa> listA = FXCollections.observableArrayList();
        empre.listadoEmpresa("0", listA);
        ArrayList<String> listB = new ArrayList();
        for(int i=0;i < listA.size();i++){
            listB.add(listA.get(i).getNombre());
        }
        ObservableList empresa = FXCollections.observableArrayList (listB); 
        cbxEmpre.setItems(empresa);
        
        cbxEmpre.setValue("Seleccionar...");
        cbxTipo.setValue("Seleccionar...");
        
       fieldTime.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldTime.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
    }    

    @FXML
    private void handlerAction(ActionEvent event) {
        
        /*if(event.getSource()==btnBuscar){
        contrato.listadoContratoFiltrado("0", filtroList);
        tableContrato.setItems(filtroList);
            String fil = filtro.getText();
            if(fil.isEmpty()){
                tableContrato.setItems(listContrato);
                
            }else{
                for(Contrato v:this.listContrato){
                    this.filtroList.add(v);
                }
            }
            this.tableContrato.setItems(filtroList);
            
        }*/
        
        if(event.getSource()==btnCrear){
            Contrato contra = new Contrato();
            if(fieldID.getText().isEmpty()){
            if(cbxEmpre.getValue().isEmpty() || fieldTime.getText().isEmpty() || cbxTipo.getValue().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear un contrato");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                contra.setIdContrato(fieldID.getText());
                ObservableList<Empresa> listA = FXCollections.observableArrayList();
                empre.listadoEmpresa("0", listA);
                String name = cbxEmpre.getValue();
                String id = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getNombre()).equals(name)){
                        id = listA.get(i).getIdEmpresa();
                        contra.setIdEmpresa(id);
                    }
                }
                contra.setNombreContrato(fieldName.getText());
                contra.setTiempoContrato(fieldTime.getText());
                contra.setTipoContrato(cbxTipo.getValue());
                contrato.crearContrato(contra);
                listContrato = FXCollections.observableArrayList();
                contrato.listadoContrato("0", listContrato);
                tableContrato.setItems(listContrato);
                tableContrato.refresh();
                
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
        }
        
        if(event.getSource()==btnModifi){
            Contrato contra = new Contrato();
            if(fieldID.getText().isEmpty() || cbxEmpre.getValue().isEmpty() || fieldTime.getText().isEmpty() || cbxTipo.getValue().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para modificar un contrato");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar este contrato?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
                contra.setIdContrato(fieldID.getText());
                ObservableList<Empresa> listA = FXCollections.observableArrayList();
                empre.listadoEmpresa("0", listA);
                String name = cbxEmpre.getValue();
                String id = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getNombre()).equals(name)){
                        id = listA.get(i).getIdEmpresa();
                        contra.setIdEmpresa(id);
                    }
                }
                contra.setNombreContrato(fieldName.getText());
                contra.setTipoContrato(cbxTipo.getValue());
                contra.setTiempoContrato(fieldTime.getText());
                contrato.modificarContrato(contra);
                listContrato = FXCollections.observableArrayList();
                contrato.listadoContrato("0", listContrato);
                tableContrato.setItems(listContrato);
                tableContrato.refresh();
            }
            }
        }
        
        if(event.getSource()==btnBorrar){
            Contrato contra = new Contrato();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione un contrato para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar este contrato?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
                contrato.eliminarContrato(fieldID.getText());
                listContrato = FXCollections.observableArrayList();
                contrato.listadoContrato("0", listContrato);
                tableContrato.setItems(listContrato);
                tableContrato.refresh();
            }
            }
        }
        
        if(event.getSource()==btnNuevo){
            cbxEmpre.setValue("Seleccionar...");
            cbxTipo.setValue("Seleccionar...");
            fieldName.setText("");
            fieldTime.setText("");
            fieldID.setText("");
        }
        
    }

    @FXML
    private void handlerAction(MouseEvent event) {
    }

    @FXML
    private void CargarContrato(MouseEvent event) {
        
        if(event.getSource()==tableContrato){
            fieldID.setText(tableContrato.getSelectionModel().getSelectedItem().getIdContrato());
            ObservableList<Empresa> listA = FXCollections.observableArrayList();
                empre.listadoEmpresa("0", listA);
                String id = tableContrato.getSelectionModel().getSelectedItem().getIdEmpresa();
                String name = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getIdEmpresa()).equals(id)){
                        name = listA.get(i).getNombre();
                        cbxEmpre.setValue(name);
                    }
                }
            fieldName.setText(tableContrato.getSelectionModel().getSelectedItem().getNombreContrato());
            fieldTime.setText(tableContrato.getSelectionModel().getSelectedItem().getTiempoContrato());
            fieldID.setText(tableContrato.getSelectionModel().getSelectedItem().getIdContrato());
            cbxTipo.setValue(tableContrato.getSelectionModel().getSelectedItem().getTipoContrato());
        }
        
    }

}
