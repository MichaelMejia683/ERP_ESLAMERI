/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Evaluacion_Desempeño;
import Modelo.Evaluacion_DesempeñoDAO;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
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
public class EvaluacionViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableColumn<Evaluacion_Desempeño, String> ID;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldID;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private TextField fieldEva1;
    @FXML
    private TableView<Evaluacion_Desempeño> tableEvalua;
    @FXML
    private TextField fieldEva2;
    @FXML
    private TextField fieldEva3;
    @FXML
    private TextField fieldEva4;
    @FXML
    private TextField fieldEva5;
    @FXML
    private TextField fieldEva6;
    @FXML
    private DatePicker fieldEva7;
    @FXML
    private TextField fieldInd1;
    @FXML
    private TextField fieldInd2;
    @FXML
    private TextField fieldInd3;
    @FXML
    private TextField fieldInd4;
    @FXML
    private DatePicker fieldInd5;
    
    Evaluacion_DesempeñoDAO EVA = new Evaluacion_DesempeñoDAO();
    
    EmpleadoDAO emple = new EmpleadoDAO();
    
    ObservableList<Evaluacion_Desempeño> filtroListEvaluacion_Desempeño;
    
    ObservableList<Evaluacion_Desempeño> listEvaluacion_Desempeño;
    @FXML
    private TextArea fieldRespuestas;
    @FXML
    private TableColumn<Evaluacion_Desempeño, String> clmEmp;
    @FXML
    private TableColumn<Evaluacion_Desempeño, String> clmEva;
    @FXML
    private TableColumn<Evaluacion_Desempeño, String> clmInd;
    @FXML
    private ComboBox<String> cbxEmp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listEvaluacion_Desempeño = FXCollections.observableArrayList();
        EVA.listadoEvaluacion_Desempeño("0", listEvaluacion_Desempeño);
        tableEvalua.setItems(listEvaluacion_Desempeño);
        ID.setCellValueFactory(new PropertyValueFactory<Evaluacion_Desempeño, String>("idED"));
        clmEmp.setCellValueFactory(new PropertyValueFactory<Evaluacion_Desempeño, String>("idEmpleado"));
        clmEva.setCellValueFactory(new PropertyValueFactory<Evaluacion_Desempeño, String>("formulario"));
        clmInd.setCellValueFactory(new PropertyValueFactory<Evaluacion_Desempeño, String>("indicadoresGestion"));
        
        fieldID.setDisable(true);
        
        ObservableList<Empleado> listA = FXCollections.observableArrayList();
        emple.listadoEmpleado("0", listA);
        ArrayList<String> listB = new ArrayList();
        for(int i=0;i < listA.size();i++){
            listB.add(listA.get(i).getIdEmpleado());
        }
        ObservableList empleado = FXCollections.observableArrayList (listB); 
        cbxEmp.setItems(empleado);
        
        cbxEmp.setValue("Seleccionar...");
        
        fieldInd1.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldInd1.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        fieldInd2.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldInd1.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        fieldInd3.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldInd1.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        fieldInd4.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            fieldInd1.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
        
    }    

    @FXML
    private void handlerAction(ActionEvent event) {
        
        /*if(event.getSource()==btnBuscar){
        ArrayList<Evaluacion_Desempeño> list = EVA.listadoEvaluacion_Desempeño("0");
        filtroListEvaluacion_Desempeño = FXCollections.observableArrayList(list);
        tableEvalua.setItems(filtroListEvaluacion_Desempeño);
        listEvaluacion_Desempeño = FXCollections.observableArrayList(list);
        tableEvalua.setItems(listEvaluacion_Desempeño);
            String fil = filtro.getText();
            if(fil.isEmpty()){
                tableEvalua.setItems(listEvaluacion_Desempeño);
                
            }else{
                for(Evaluacion_Desempeño v:this.listEvaluacion_Desempeño){
                    this.filtroListEvaluacion_Desempeño.add(v);
                }
            }
            this.tableEvalua.setItems(filtroListEvaluacion_Desempeño);
            
        }*/
        
        if(event.getSource()==btnCrear){
            Evaluacion_Desempeño EVA1 = new Evaluacion_Desempeño();
            if(fieldID.getText().isEmpty()){
            if(cbxEmp.getValue().isEmpty() || fieldEva1.getText().isEmpty() || fieldInd1.getText().isEmpty() || fieldEva7.getValue().toString().isEmpty() || fieldInd5.getValue().toString().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una evaluacion");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                EVA1.setIdEmpleado(cbxEmp.getValue());
                EVA1.setFormulario(fieldEva1.getText()+","+fieldEva2.getText()+fieldEva3.getText()+","+fieldEva4.getText()+fieldEva5.getText()+","+fieldEva6.getText()+","+fieldEva7.getValue().toString());
                EVA1.setIndicadoresGestion(fieldInd1.getText()+","+fieldInd2.getText()+fieldInd3.getText()+","+fieldInd4.getText()+","+fieldInd5.getValue().toString());
                EVA.crearEvaluacion_Desempeño(EVA1);
                listEvaluacion_Desempeño = FXCollections.observableArrayList();
                EVA.listadoEvaluacion_Desempeño("0", listEvaluacion_Desempeño);
                tableEvalua.setItems(listEvaluacion_Desempeño);
                tableEvalua.refresh();
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
        }
        
        if(event.getSource()==btnModifi){
            Evaluacion_Desempeño EVA1 = new Evaluacion_Desempeño();
            if(fieldID.getText().isEmpty() || cbxEmp.getValue().isEmpty() || fieldEva1.getText().isEmpty() || fieldInd1.getText().isEmpty() || fieldEva7.getValue().toString().isEmpty() || fieldInd5.getValue().toString().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una evaluacion");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar este contrato?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                EVA1.setIdEmpleado(cbxEmp.getValue());
                EVA1.setFormulario(fieldEva1.getText()+","+fieldEva2.getText()+","+fieldEva3.getText()+","+fieldEva4.getText()+","+fieldEva5.getText()+","+fieldEva6.getText()+","+fieldEva7.getValue().toString());
                EVA1.setIndicadoresGestion(fieldInd1.getText()+","+fieldInd2.getText()+fieldInd3.getText()+","+fieldInd4.getText()+","+fieldInd5.getValue().toString());
                EVA1.setIdED(fieldID.getText());
                EVA.modificarEvaluacion_Desempeño(EVA1);
                listEvaluacion_Desempeño = FXCollections.observableArrayList();
                EVA.listadoEvaluacion_Desempeño("0", listEvaluacion_Desempeño);
                tableEvalua.setItems(listEvaluacion_Desempeño);
                tableEvalua.refresh();
            }}
            
        }
        
        if(event.getSource()==btnBorrar){
            Evaluacion_Desempeño EVA1 = new Evaluacion_Desempeño();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione una evaluación para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar este contrato?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                EVA.eliminarEvaluacion_Desempeño(fieldID.getText());
                listEvaluacion_Desempeño = FXCollections.observableArrayList();
                EVA.listadoEvaluacion_Desempeño("0", listEvaluacion_Desempeño);
                tableEvalua.setItems(listEvaluacion_Desempeño);
                tableEvalua.refresh();
            }}
        }
        
        if(event.getSource()==btnNuevo){
            fieldID.setText("");
            cbxEmp.setValue("Seleccionar...");
            fieldInd1.setText("");
            fieldInd2.setText("");
            fieldInd3.setText("");
            fieldInd4.setText("");
            fieldInd5.setValue(LocalDate.now());
            fieldEva1.setText("");
            fieldEva2.setText("");
            fieldEva3.setText("");
            fieldEva4.setText("");
            fieldEva5.setText("");
            fieldEva6.setText("");
            fieldEva7.setValue(LocalDate.now());
            fieldRespuestas.setText("");
        }
        
    }

    @FXML
    private void CargarEvalua(MouseEvent event) {
        if(event.getSource()==tableEvalua){
            Evaluacion_Desempeño EVA1 = new Evaluacion_Desempeño();
            
            cbxEmp.setValue(tableEvalua.getSelectionModel().getSelectedItem().getIdEmpleado());
            fieldRespuestas.setText(tableEvalua.getSelectionModel().getSelectedItem().getFormulario()+"\n"+tableEvalua.getSelectionModel().getSelectedItem().getIndicadoresGestion());
            fieldID.setText(tableEvalua.getSelectionModel().getSelectedItem().getIdED());
        }
    }

    
}
