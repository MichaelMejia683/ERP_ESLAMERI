/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.CuentaDAO;
import Modelo.Empresa;
import Modelo.EmpresaDAO;
import Modelo.Nomina;
import Modelo.NominaDAO;
import Modelo.Nomina_Empleado;
import Modelo.Nomina_EmpleadoDAO;
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
 * @author MAICOL MEJIA
 */
public class NominaViewController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filtro;
    @FXML
    private VBox pnItems;
    @FXML
    private TableView<Nomina> tableNomina;
    @FXML
    private TableColumn<Nomina, String> ID;
    @FXML
    private TableColumn<Nomina, String> clmCuenta;
    @FXML
    private TableColumn<Nomina, String> clmSaldo;
    @FXML
    private TableColumn<Nomina, String> clmFPago;
    @FXML
    private ImageView btnBuscar;
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldSaldo;
    @FXML
    private ComboBox<String> cbxCuenta;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModifi;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnCalculo;
    @FXML
    private DatePicker fieldDateI;
    @FXML
    private DatePicker fieldDateF;
    @FXML
    private TextField fieldEmpre;
    
    ObservableList<Nomina> listNomina;
    
    NominaDAO nomina = new NominaDAO();
    
    EmpresaDAO empre = new EmpresaDAO();
    
    CuentaDAO cuenta = new CuentaDAO();
    
    Nomina_EmpleadoDAO nxe = new Nomina_EmpleadoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listNomina = FXCollections.observableArrayList();
        nomina.listadoNomina("0", listNomina);
        tableNomina.setItems(listNomina);
        ID.setCellValueFactory(new PropertyValueFactory<Nomina, String>("idNomina"));
        clmCuenta.setCellValueFactory(new PropertyValueFactory<Nomina, String>("idCuenta"));
        clmSaldo.setCellValueFactory(new PropertyValueFactory<Nomina, String>("pagoTotal"));
        clmFPago.setCellValueFactory(new PropertyValueFactory<Nomina, String>("fechaPago"));

        fieldID.setDisable(true);
        fieldSaldo.setDisable(true);
        fieldEmpre.setDisable(true);
        
        ObservableList<Cuenta> listA = FXCollections.observableArrayList();
        cuenta.listadoCuenta("0", listA);
        ArrayList<String> listB = new ArrayList();
        for(int i=0;i < listA.size();i++){
            listB.add(listA.get(i).getNumeroCuenta());
        }
        ObservableList cuenta = FXCollections.observableArrayList (listB); 
        cbxCuenta.setItems(cuenta);
        
        cbxCuenta.setValue("Seleccionar...");
    }    

    @FXML
    private void handlerAction(ActionEvent event) {
        
        if(event.getSource()==cbxCuenta){
        ObservableList<Cuenta> listA = FXCollections.observableArrayList();
        cuenta.listadoCuenta("0", listA);
        ObservableList<Empresa> listB = FXCollections.observableArrayList();
        empre.listadoEmpresa("0", listB);
        for(int i=0;i < listA.size();i++){
            if(cbxCuenta.getValue().equals(listA.get(i).getNumeroCuenta())){
            for(int e=0;e < listB.size(); e++){
                if(listA.get(i).getIdEmpresa().equals(listB.get(e).getIdEmpresa())){
                    fieldEmpre.setText(listB.get(e).getNombre());
                }
            }        
            }}

        }
        
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
            Nomina nomi = new Nomina();
            if(fieldID.getText().isEmpty()){
            if(cbxCuenta.getValue().equals("Seleccionar...") || fieldSaldo.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una nómina");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
                nomi.setIdNomina(fieldID.getText());
                ObservableList<Cuenta> listA = FXCollections.observableArrayList();
                cuenta.listadoCuenta("0", listA);
                for(int i=0; i < listA.size(); i++){
                    if(cbxCuenta.getValue().equals(listA.get(i).getNumeroCuenta())){
                        nomi.setIdCuenta(listA.get(i).getIdCuenta());
                    }
                }
                if(fieldDateI.getValue().isAfter(fieldDateF.getValue()) || fieldDateF.getValue().isBefore(fieldDateI.getValue())){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Fecha de inicio tiene que ser antes de la Fecha final");
                alert.setHeaderText(null);
                alert.showAndWait(); 
                }else{
                nomi.setPagoTotal(fieldSaldo.getText());
                nomi.setFechaPago(LocalDate.now().toString());
                nomina.crearNomina(nomi);
                listNomina = FXCollections.observableArrayList();
                nomina.listadoNomina("0", listNomina);
                tableNomina.setItems(listNomina);
                tableNomina.refresh();
                
                
                if(fieldSaldo.getText().isEmpty() || cbxCuenta.getValue().equalsIgnoreCase("Seleccionar...")){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione una cuenta y calcule el valor de la nómina para restarcelo a esta");
            alert.setHeaderText(null);
            alert.showAndWait();
            }else{
            ObservableList<Cuenta> listC = FXCollections.observableArrayList();
            cuenta.listadoCuenta("0", listC);
            for(int i = 0; i < listC.size(); i++){
                if(listC.get(i).getNumeroCuenta().equals(cbxCuenta.getValue())){
                    double saldoCuenta = Double.parseDouble(listC.get(i).getSaldo());
                    double nomina_saldo = Double.parseDouble(fieldSaldo.getText());
                    double total = saldoCuenta - nomina_saldo;
                    Cuenta cuen = listC.get(i);
                    cuen.setSaldo(Double.toString(total));
                    cuenta.modificarCuenta(cuen);
                }
            }
            
            }}
                
            }}else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Este ID ya ha sido creado");
            alert.setHeaderText(null);
            alert.showAndWait();
            }
        }
        
        if(event.getSource()==btnModifi){
            Nomina nomi = new Nomina();
            if(cbxCuenta.getValue().equals("Seleccionar...") || fieldSaldo.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Se necesitan todos los campos para crear una nómina");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea modificar esta nómina?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
                nomi.setIdNomina(fieldID.getText());
                ObservableList<Cuenta> listA = FXCollections.observableArrayList();
                cuenta.listadoCuenta("0", listA);
                for(int i=0; i < listA.size(); i++){
                    if(cbxCuenta.getValue().equals(listA.get(i).getNumeroCuenta())){
                        nomi.setIdCuenta(listA.get(i).getIdCuenta());
                    }
                }
                listNomina = FXCollections.observableArrayList();
                nomina.listadoNomina("0", listNomina);
                for(int i = 0; i < listNomina.size(); i++){
                    if(listNomina.get(i).getIdNomina().equals(fieldID.getText())){
                        if(listNomina.get(i).getPagoTotal().equals(fieldSaldo.getText())){
                            nomi.setPagoTotal(fieldSaldo.getText());
                        }else{
                    for(int e=0; e < listA.size(); e++){
                    if(cbxCuenta.getValue().equals(listA.get(e).getNumeroCuenta())){
                        double saldoCuenta = Double.parseDouble(listA.get(e).getSaldo());
                        double nomina_saldo = Double.parseDouble(listNomina.get(i).getPagoTotal());
                        double total = saldoCuenta + nomina_saldo;
                        Cuenta cuen = listA.get(e);
                        cuen.setSaldo(Double.toString(total));
                        cuenta.modificarCuenta(cuen);
                        
                        double saldoCuentaNew = Double.parseDouble(listA.get(e).getSaldo());
                        double nomina_saldoNew = Double.parseDouble(fieldSaldo.getText());
                        double totalNew = saldoCuentaNew - nomina_saldoNew;
                        Cuenta cuent = listA.get(e);
                        cuent.setSaldo(Double.toString(totalNew));
                        cuenta.modificarCuenta(cuent);
                    }
                }
                        }
                    }
                }
                nomi.setFechaPago(LocalDate.now().toString());
                nomina.crearNomina(nomi);
                listNomina = FXCollections.observableArrayList();
                nomina.listadoNomina("0", listNomina);
                tableNomina.setItems(listNomina);
                tableNomina.refresh();
            }
            }
        }
        
        if(event.getSource()==btnBorrar){
            Nomina nomi = new Nomina();
            if(fieldID.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Seleccione una nómina para eliminar");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"¿Esta seguro que desea eliminar esta nómina?",ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(result)) {
                Alert aler=new Alert(Alert.AlertType.CONFIRMATION,"¿Quiere devolver el saldo de la nómina a la cuenta?",ButtonType.YES, ButtonType.NO);
                aler.setHeaderText(null);
                ButtonType resul = aler.showAndWait().orElse(ButtonType.YES);
            if (ButtonType.YES.equals(resul)) {
                listNomina = FXCollections.observableArrayList();
                nomina.listadoNomina("0", listNomina);
                ObservableList<Cuenta> listA = FXCollections.observableArrayList();
                cuenta.listadoCuenta("0", listA);
                
                for(int i =0; i < listNomina.size(); i++){
                     if(listNomina.get(i).getIdNomina().equals(fieldID.getText())){
                         for(int e = 0;e < listA.size(); e++){
                             if(listNomina.get(i).getIdCuenta().equals(listA.get(e).getIdCuenta())){
                                 double saldoCuenta = Double.parseDouble(listA.get(e).getSaldo());
                                 double nomina_saldo = Double.parseDouble(listNomina.get(i).getPagoTotal());
                                 double total = saldoCuenta + nomina_saldo;
                                 Cuenta cuen = listA.get(e);
                                 cuen.setSaldo(Double.toString(total));
                                 cuenta.modificarCuenta(cuen);
                             }
                         }
                     }
                }
                
                
            }
            nomina.eliminarNomina(fieldID.getText());
            listNomina = FXCollections.observableArrayList();
            nomina.listadoNomina("0", listNomina);
            tableNomina.setItems(listNomina);
            tableNomina.refresh();
            
            }
            }
        }
        
        if(event.getSource()==btnNuevo){
            cbxCuenta.setValue("Seleccionar...");
            fieldSaldo.setText("");
            fieldEmpre.setText("");
            fieldID.setText("");
            fieldDateI.setValue(LocalDate.now());
            fieldDateF.setValue(LocalDate.now());
        }
        
        if(event.getSource()==btnCalculo){
            ObservableList<Nomina_Empleado> listA = FXCollections.observableArrayList();
            nxe.listadoNomina_Empleado("0", listA);
            double saldo = 0;
            for(int i=0;i < listA.size();i++){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(listA.get(i).getCorte(), formatter);
                if(fieldDateI.getValue().isEqual(date) || fieldDateF.getValue().isEqual(date)){
                    double salario = Double.parseDouble(listA.get(i).getSalarioTotal());
                        saldo = saldo + salario;
                }
                if(fieldDateI.getValue().isBefore(date) && fieldDateF.getValue().isAfter(date)){
                    double salario = Double.parseDouble(listA.get(i).getSalarioTotal());
                        saldo = saldo + salario;
                }
                
            }
            fieldSaldo.setText(Double.toString(saldo));  
        }
        
    }

    @FXML
    private void CargarNomina(MouseEvent event) {
        
        if(event.getSource()==tableNomina){
            ObservableList<Cuenta> listA = FXCollections.observableArrayList();
            cuenta.listadoCuenta("0", listA);
            for(int i=0; i < listA.size(); i++){
                if(listA.get(i).getIdCuenta().equals(tableNomina.getSelectionModel().getSelectedItem().getIdCuenta())){
                    cbxCuenta.setValue(listA.get(i).getNumeroCuenta());
                }
            }
            fieldID.setText(tableNomina.getSelectionModel().getSelectedItem().getIdNomina());
            fieldSaldo.setText(tableNomina.getSelectionModel().getSelectedItem().getPagoTotal());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(tableNomina.getSelectionModel().getSelectedItem().getFechaPago(), formatter);
            fieldDateF.setValue(date);
        }
        
    }

    
}
