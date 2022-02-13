/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Area;
import Modelo.AreaDAO;
import Modelo.Contrato;
import Modelo.ContratoDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class EmpleadoViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableView<Empleado> tableEmple;
    @FXML
    private TableColumn<Empleado, String> ID;
    @FXML
    private TableColumn<Empleado, String> clmCargo;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldCargo;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private ComboBox<String> cbxArea;
    @FXML
    private DatePicker fieldNace;
    @FXML
    private DatePicker fieldVincula;
    @FXML
    private TextField fieldCuenta;
    @FXML
    private TextField fieldSalario;
    
    EmpleadoDAO emple = new EmpleadoDAO();
    
    AreaDAO area = new AreaDAO();
    
    ContratoDAO contra = new ContratoDAO();
            
    ObservableList<Empleado> filtroListEmpleado;
    
    ObservableList<Empleado> listEmpleado;
    @FXML
    private ComboBox<String> cbxContra;
    @FXML
    private TextField fieldID;
    @FXML
    private TableColumn<Empleado, String> clmArea;
    @FXML
    private TableColumn<Empleado, String> clmContra;
    @FXML
    private TableColumn<Empleado, String> clmName;
    @FXML
    private TableColumn<Empleado, String> clmNace;
    @FXML
    private TableColumn<Empleado, String> clmSalario;
    @FXML
    private TableColumn<Empleado, String> clmBanco;
    @FXML
    private TableColumn<Empleado, String> clmVincula;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listEmpleado = FXCollections.observableArrayList();
        emple.listadoEmpleado("0", listEmpleado);
        tableEmple.setItems(listEmpleado);
        ID.setCellValueFactory(new PropertyValueFactory<Empleado, String>("idEmpleado"));
        clmArea.setCellValueFactory(new PropertyValueFactory<Empleado, String>("idArea"));
        clmContra.setCellValueFactory(new PropertyValueFactory<Empleado, String>("idContrato"));
        clmName.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        clmNace.setCellValueFactory(new PropertyValueFactory<Empleado, String>("fechaNacimiento"));
        clmCargo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cargo"));
        clmSalario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("salario"));
        clmBanco.setCellValueFactory(new PropertyValueFactory<Empleado, String>("numeroCuentaBanco"));
        clmVincula.setCellValueFactory(new PropertyValueFactory<Empleado, String>("fechaVinculacion"));
        
        cbxArea.setValue("Seleccionar...");
        cbxContra.setValue("Seleccionar...");
        
        ObservableList<Area> listA = FXCollections.observableArrayList();
        area.listadoArea("0", listA);
        ArrayList<String> listB = new ArrayList();
        for(int i=0;i < listA.size();i++){
            listB.add(listA.get(i).getNombre());
        }
        ObservableList areas = FXCollections.observableArrayList (listB); 
        cbxArea.setItems(areas);
        
        ObservableList<Contrato> listC = FXCollections.observableArrayList();
        contra.listadoContrato("0", listC);
        ArrayList<String> listD = new ArrayList();
        for(int i=0;i < listC.size();i++){
            listD.add(listC.get(i).getNombreContrato());
        }
        ObservableList contratos = FXCollections.observableArrayList (listD); 
        cbxContra.setItems(contratos);
        
        fieldSalario.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldSalario.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
        fieldCuenta.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldCuenta.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
        fieldID.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldID.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
        fieldCuenta.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldCuenta.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
    }    

    @FXML
    private void handlerAction(ActionEvent event) {
        
        /*if(event.getSource()==btnBuscar){
        ArrayList<Empleado> list = emple.listadoEmpleado("0");
        filtroListEmpleado = FXCollections.observableArrayList(list);
        tableEmple.setItems(filtroListEmpleado);
        listEmpleado = FXCollections.observableArrayList(list);
        tableEmple.setItems(listEmpleado);
            String fil = filtro.getText();
            if(fil.isEmpty()){
                tableEmple.setItems(listEmpleado);
                
            }else{
                for(Empleado v:this.listEmpleado){
                    this.filtroListEmpleado.add(v);
                }
            }
            this.tableEmple.setItems(filtroListEmpleado);
            
        }*/
        
        if(event.getSource()==btnCrear){
            Empleado emplea = new Empleado();
            if(fieldID.getText().isEmpty()){
            if(cbxArea.getValue().isEmpty() || cbxContra.getValue().isEmpty() || fieldName.getText().isEmpty() || fieldNace.getValue().toString().isEmpty() || fieldCargo.getText().isEmpty() || fieldSalario.getText().isEmpty() || fieldCuenta.getText().isEmpty() || fieldVincula.getValue().toString().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear un empleado");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                emplea.setIdEmpleado(fieldID.getText());
                ObservableList<Area> listA = FXCollections.observableArrayList();
                area.listadoArea("0", listA);
                String name = cbxArea.getValue();
                String id = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getNombre()).equals(name)){
                        id = listA.get(i).getIdArea();
                        emplea.setIdArea(id);
                    }
                }
                ObservableList<Contrato> listC = FXCollections.observableArrayList();
                contra.listadoContrato("0", listC);
                String name1 = cbxContra.getValue();
                String id1 = "";
                for(int i=0;i < listC.size();i++){
                    if((listC.get(i).getNombreContrato()).equals(name1)){
                        id1 = listC.get(i).getIdContrato();
                        emplea.setIdContrato(id1);
                    }
                }
                emplea.setNombre(fieldName.getText());
                emplea.setFechaNacimiento(fieldNace.getValue().toString());
                emplea.setCargo(fieldCargo.getText());
                emplea.setNumeroCuentaBanco(fieldCuenta.getText());
                emplea.setSalario(fieldSalario.getText());
                emplea.setFechaVinculacion(fieldVincula.getValue().toString());
                emple.crearEmpleado(emplea);
                listEmpleado = FXCollections.observableArrayList();
                emple.listadoEmpleado("0", listEmpleado);
                tableEmple.setItems(listEmpleado);
                tableEmple.refresh();
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
            
        }
        
        if(event.getSource()==btnModifi){
            Empleado emplea = new Empleado();
            if(fieldID.getText().isEmpty() || cbxArea.getValue().isEmpty() || cbxContra.getValue().isEmpty() || fieldName.getText().isEmpty() || fieldNace.getValue().toString().isEmpty() || fieldCargo.getText().isEmpty() || fieldSalario.getText().isEmpty() || fieldCuenta.getText().isEmpty() || fieldVincula.getValue().toString().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para modificar un empleado");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar este empleado?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
                ObservableList<Area> listA = FXCollections.observableArrayList();
                area.listadoArea("0", listA);
                String name = cbxArea.getValue();
                String id = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getNombre()).equals(name)){
                        id = listA.get(i).getIdArea();
                        emplea.setIdArea(id);
                    }
                }
                ObservableList<Contrato> listC = FXCollections.observableArrayList();
                contra.listadoContrato("0", listC);
                String name1 = cbxContra.getValue();
                String id1 = "";
                for(int i=0;i < listC.size();i++){
                    if((listC.get(i).getNombreContrato()).equals(name1)){
                        id1 = listC.get(i).getIdContrato();
                        emplea.setIdContrato(id1);
                    }
                }
                emplea.setNombre(fieldName.getText());
                emplea.setFechaNacimiento(fieldNace.getValue().toString());
                emplea.setCargo(fieldCargo.getText());
                emplea.setSalario(fieldSalario.getText());
                emplea.setNumeroCuentaBanco(fieldCuenta.getText());
                emplea.setFechaVinculacion(fieldVincula.getValue().toString());
                emplea.setIdEmpleado(fieldID.getText());
                emple.modificarEmpleado(emplea);
                listEmpleado = FXCollections.observableArrayList();
                emple.listadoEmpleado("0", listEmpleado);
                tableEmple.setItems(listEmpleado);
                tableEmple.refresh();
            }}  
            
        }
        
        if(event.getSource()==btnBorrar){
            Empleado emplea = new Empleado();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione un empleado para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar este empleado?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                emple.eliminarEmpleado(fieldID.getText());
                listEmpleado = FXCollections.observableArrayList();
                emple.listadoEmpleado("0", listEmpleado);
                tableEmple.setItems(listEmpleado);
                tableEmple.refresh();
            }}
        }
        
        if(event.getSource()==btnNuevo){
            fieldCargo.setText("");
            fieldName.setText("");
            fieldNace.setValue(LocalDate.now());
            fieldCargo.setText("");
            fieldSalario.setText("");
            fieldCuenta.setText("");
            fieldVincula.setValue(LocalDate.now());
            fieldID.setText("");
            cbxArea.setValue("Seleccionar...");
            cbxContra.setValue("Seleccionar...");
        }
        
    }

    @FXML
    private void CargarEmpleados(MouseEvent event) {
        if(event.getSource()==tableEmple){
            fieldID.setText(tableEmple.getSelectionModel().getSelectedItem().getIdEmpleado());
            ObservableList<Area> listA = FXCollections.observableArrayList();
                area.listadoArea("0", listA);
                String id = tableEmple.getSelectionModel().getSelectedItem().getIdArea();
                String name = "";
                for(int i=0;i < listA.size();i++){
                    if((listA.get(i).getIdArea()).equals(id)){
                        name = listA.get(i).getNombre();
                        cbxArea.setValue(name);
                    }
                }
            cbxContra.setValue(tableEmple.getSelectionModel().getSelectedItem().getIdContrato());
            ObservableList<Contrato> listC = FXCollections.observableArrayList();
                contra.listadoContrato("0", listC);
                String id1 = tableEmple.getSelectionModel().getSelectedItem().getIdContrato();
                String name1 = "";
                for(int i=0;i < listC.size();i++){
                    if((listC.get(i).getIdContrato()).equals(id1)){
                        name1 = listC.get(i).getNombreContrato();
                        cbxContra.setValue(name1);
                    }
                }
            fieldName.setText(tableEmple.getSelectionModel().getSelectedItem().getNombre());
            fieldCargo.setText(tableEmple.getSelectionModel().getSelectedItem().getCargo());
            fieldSalario.setText(tableEmple.getSelectionModel().getSelectedItem().getSalario());
            fieldCuenta.setText(tableEmple.getSelectionModel().getSelectedItem().getNumeroCuentaBanco());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(tableEmple.getSelectionModel().getSelectedItem().getFechaNacimiento(), formatter);
            fieldNace.setValue(date);
            LocalDate date1 = LocalDate.parse(tableEmple.getSelectionModel().getSelectedItem().getFechaVinculacion(), formatter);
            fieldVincula.setValue(date1);
        }
    }


    
}
