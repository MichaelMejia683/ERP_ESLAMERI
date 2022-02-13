/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Nomina_Empleado;
import Modelo.Nomina_EmpleadoDAO;
import Modelo.VolantePago;
import com.itextpdf.text.DocumentException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
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
public class NominaxEmpleadoViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableView<Nomina_Empleado> tableNXE;
    @FXML
    private TableColumn<Nomina_Empleado, String> ID;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldNameEmp;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private TextField fieldSalario;
    @FXML
    private TextField fieldRecargo;
    @FXML
    private TextField fieldDesc;
    @FXML
    private TextField fieldSTotal;
    @FXML
    private DatePicker fieldCorte;
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnVolante;
    
    Nomina_EmpleadoDAO NXE = new Nomina_EmpleadoDAO();
    
    ObservableList<Nomina_Empleado> filtroListNomina_Empleado;
    
    ObservableList<Nomina_Empleado> listNomina_Empleado;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmEmp;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmSalario;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmCorte;
    @FXML
    private TextField fieldExtraDi;
    @FXML
    private TextField fieldExtraNo;
    @FXML
    private TextField fieldDomi;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmDiur;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmNoc;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmDom;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmRecar;
    @FXML
    private TableColumn<Nomina_Empleado, String> clmDesc;
    @FXML
    private ComboBox<String> cbxEmp;
    
    EmpleadoDAO emple = new EmpleadoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listNomina_Empleado = FXCollections.observableArrayList();
        NXE.listadoNomina_Empleado("0", listNomina_Empleado);
        tableNXE.setItems(listNomina_Empleado);
        ID.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("idNXE"));
        clmEmp.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("idEmpleado"));
        clmDiur.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("horasExtraDiurna"));
        clmNoc.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("horaExtraNocturno"));
        clmDom.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("horaDominical"));
        clmRecar.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("recargos"));
        clmDesc.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("descuentos"));
        clmSalario.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("salarioTotal"));
        clmCorte.setCellValueFactory(new PropertyValueFactory<Nomina_Empleado, String>("corte"));
        
        fieldSTotal.setDisable(true);
        fieldID.setDisable(true);
        fieldSalario.setDisable(true);
        fieldNameEmp.setDisable(true);
        
        ObservableList<Empleado> listA = FXCollections.observableArrayList();
        emple.listadoEmpleado("0", listA);
        ArrayList<String> listB = new ArrayList();
        for(int i=0;i < listA.size();i++){
            listB.add(listA.get(i).getIdEmpleado());
        }
        ObservableList empleado = FXCollections.observableArrayList (listB); 
        cbxEmp.setItems(empleado);
        
        cbxEmp.setValue("Seleccionar...");
        
    }    

    @FXML
    private void handlerAction(ActionEvent event) throws DocumentException {

        if(event.getSource()==cbxEmp){
        ObservableList<Empleado> listA = FXCollections.observableArrayList();
        emple.listadoEmpleado("0", listA);
        for(int i=0;i < listA.size();i++){
        if(cbxEmp.getValue().equals(listA.get(i).getIdEmpleado())){
        fieldSalario.setText(listA.get(i).getSalario());
        fieldNameEmp.setText(listA.get(i).getNombre());
        }
        }
        }
        
        /*if(event.getSource()==btnBuscar){
        ArrayList<Nomina_Empleado> list = NXE.listadoNomina_Empleado("0");
        filtroListNomina_Empleado = FXCollections.observableArrayList(list);
        tableNXE.setItems(filtroListNomina_Empleado);
        listNomina_Empleado = FXCollections.observableArrayList(list);
        tableNXE.setItems(listNomina_Empleado);
            String fil = filtro.getText();
            if(fil.isEmpty()){
                tableNXE.setItems(listNomina_Empleado);
                
            }else{
                for(Nomina_Empleado v:this.listNomina_Empleado){
                    this.filtroListNomina_Empleado.add(v);
                }
            }
            this.tableNXE.setItems(filtroListNomina_Empleado);
            
        }*/
        
        if(event.getSource()==btnCrear){
            Nomina_Empleado NXE1 = new Nomina_Empleado();
            if(fieldID.getText().isEmpty()){
            if(cbxEmp.equals("Seleccionar...") || fieldSalario.getText().isEmpty() || fieldExtraDi.getText().isEmpty() || fieldRecargo.getText().isEmpty() || fieldSTotal.getText().isEmpty() || fieldCorte.getValue().toString().isEmpty() || fieldExtraNo.getText().isEmpty() || fieldDomi.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una NXE");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                NXE1.setIdEmpleado(cbxEmp.getValue());
                NXE1.setSalarioBase(fieldSalario.getText());
                NXE1.setHorasExtraDiurna(fieldExtraDi.getText());
                NXE1.setHoraExtraNocturno(fieldExtraNo.getText());
                NXE1.setHoraDominical(fieldDomi.getText());
                NXE1.setRecargos(fieldRecargo.getText());
                NXE1.setDescuentos(fieldDesc.getText());
                NXE1.setSalarioTotal(fieldSTotal.getText());
                NXE1.setCorte(fieldCorte.getValue().toString());
                NXE.crearNomina_Empleado(NXE1);
                listNomina_Empleado = FXCollections.observableArrayList();
                NXE.listadoNomina_Empleado("0", listNomina_Empleado);
                tableNXE.setItems(listNomina_Empleado);
                tableNXE.refresh();
                
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
        }
        
        if(event.getSource()==btnModifi){
            Nomina_Empleado NXE1 = new Nomina_Empleado();
            if(fieldID.getText().isEmpty() || cbxEmp.getValue().equals("Seleccionar...") || fieldSalario.getText().isEmpty() || fieldExtraDi.getText().isEmpty() || fieldRecargo.getText().isEmpty() || fieldSTotal.getText().isEmpty() || fieldCorte.getValue().toString().isEmpty() || fieldExtraNo.getText().isEmpty() || fieldDomi.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una NXE");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar esta NXE?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                NXE1.setIdEmpleado(cbxEmp.getValue());
                NXE1.setSalarioBase(fieldSalario.getText());
                NXE1.setHorasExtraDiurna(fieldExtraDi.getText());
                NXE1.setHoraExtraNocturno(fieldExtraNo.getText());
                NXE1.setHoraDominical(fieldDomi.getText());
                NXE1.setRecargos(fieldRecargo.getText());
                NXE1.setDescuentos(fieldDesc.getText());
                NXE1.setSalarioTotal(fieldSTotal.getText());
                NXE1.setCorte(fieldCorte.getValue().toString());
                NXE1.setIdNXE(fieldID.getText());
                NXE.modificarNomina_Empleado(NXE1);
                listNomina_Empleado = FXCollections.observableArrayList();
                NXE.listadoNomina_Empleado("0", listNomina_Empleado);
                tableNXE.setItems(listNomina_Empleado);
                tableNXE.refresh();
            }}
            
        }
        
        if(event.getSource()==btnBorrar){
            Nomina_Empleado NXE1 = new Nomina_Empleado();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione una evaluación para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar esta NXE?",ButtonType.YES, ButtonType.NO);
                alert.setHeaderText(null);
                ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
                if (ButtonType.YES.equals(result)) {
                NXE.eliminarNomina_Empleado(fieldID.getText());
                listNomina_Empleado = FXCollections.observableArrayList();
                NXE.listadoNomina_Empleado("0", listNomina_Empleado);
                tableNXE.setItems(listNomina_Empleado);
                tableNXE.refresh();
            }}
        }
        
        if(event.getSource()==btnNuevo){
            fieldID.setText("");
            cbxEmp.setValue("Seleccionar...");
            fieldSalario.setText("");
            fieldExtraDi.setText("");
            fieldExtraNo.setText("");
            fieldDomi.setText("");
            fieldRecargo.setText("");
            fieldDesc.setText("");
            fieldSTotal.setText("");
            fieldCorte.setValue(LocalDate.now());
        }
        
        if(event.getSource()==btnCalcular){
            int base = Integer.parseInt(fieldSalario.getText());
            int extraDi = Integer.parseInt(fieldExtraDi.getText());
            int extraNo = Integer.parseInt(fieldExtraNo.getText());
            int Domi = Integer.parseInt(fieldDomi.getText());
            int recargo = Integer.parseInt(fieldRecargo.getText());
            int descuen = Integer.parseInt(fieldDesc.getText());
            double salarioTotal = ((base+((3785*1.25)*extraDi)+((3785*1.75)*extraNo)+((3785*2)*Domi)+((3785*0.35)*recargo))-(3785*descuen));
            fieldSTotal.setText(Double.toString(salarioTotal));
            
        }

        if(event.getSource()==btnVolante){
            Nomina_Empleado NXE1 = new Nomina_Empleado();
            if(fieldID.getText().isEmpty() || cbxEmp.getValue().equals("Seleccionar...") || fieldSalario.getText().isEmpty() || fieldExtraDi.getText().isEmpty() || fieldRecargo.getText().isEmpty() || fieldSTotal.getText().isEmpty() || fieldCorte.getValue().toString().isEmpty() || fieldExtraNo.getText().isEmpty() || fieldDomi.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para imprimir un volante de pago");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                NXE1.setIdEmpleado(cbxEmp.getValue());
                NXE1.setSalarioBase(fieldSalario.getText());
                NXE1.setHorasExtraDiurna(fieldExtraDi.getText());
                NXE1.setHoraExtraNocturno(fieldExtraNo.getText());
                NXE1.setHoraDominical(fieldDomi.getText());
                NXE1.setRecargos(fieldRecargo.getText());
                NXE1.setDescuentos(fieldDesc.getText());
                NXE1.setSalarioTotal(fieldSTotal.getText());
                NXE1.setCorte(fieldCorte.getValue().toString());
                NXE1.setIdNXE(fieldID.getText());
            VolantePago volan = new VolantePago();
            volan.crearVolante(NXE1);
            volan.abrirarchivo("volante.pdf");
        }}
        
    }

    @FXML
    private void CargarNXE(MouseEvent event) {
        
        if(event.getSource()==tableNXE){
            cbxEmp.setValue(tableNXE.getSelectionModel().getSelectedItem().getIdEmpleado());
            fieldID.setText(tableNXE.getSelectionModel().getSelectedItem().getIdNXE());
            fieldSalario.setText(tableNXE.getSelectionModel().getSelectedItem().getSalarioBase());
            fieldExtraDi.setText(tableNXE.getSelectionModel().getSelectedItem().getHorasExtraDiurna());
            fieldExtraNo.setText(tableNXE.getSelectionModel().getSelectedItem().getHoraExtraNocturno());
            fieldDomi.setText(tableNXE.getSelectionModel().getSelectedItem().getHoraDominical());
            fieldRecargo.setText(tableNXE.getSelectionModel().getSelectedItem().getRecargos());
            fieldDesc.setText(tableNXE.getSelectionModel().getSelectedItem().getDescuentos());
            fieldSTotal.setText(tableNXE.getSelectionModel().getSelectedItem().getSalarioTotal());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(tableNXE.getSelectionModel().getSelectedItem().getCorte(), formatter);
            fieldCorte.setValue(date);
        }
        
    }

    
}
