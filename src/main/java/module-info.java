module com.eslameri.erp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eslameri.erp to javafx.fxml;
    exports com.eslameri.erp;
    exports com.eslameri.erp.controlador;
    opens com.eslameri.erp.controlador to javafx.fxml;
}