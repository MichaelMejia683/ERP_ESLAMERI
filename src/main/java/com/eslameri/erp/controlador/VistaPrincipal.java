package com.eslameri.erp.controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class VistaPrincipal {
    public Button btnOverview;
    public Button btnadmin;
    public Button btnSalir;
    public Button btnAdmin;
    public Pane pnlOverview;

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnAdmin) {
            pnlOverview.setStyle("-fx-background-color : #FFFFFF");
            pnlOverview.toFront();
        }
        if (actionEvent.getSource() == btnSalir) {
            pnlOverview.setStyle("-fx-background-color : #53639F");
            pnlOverview.toFront();
            System.exit(0);
        }
    }
}

