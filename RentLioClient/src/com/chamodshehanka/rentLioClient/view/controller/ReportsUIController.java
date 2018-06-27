package com.chamodshehanka.rentLioClient.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.vivoxalabs.customstage.CustomStage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/30/2018
 * @project RentLio
 **/
public class ReportsUIController implements Initializable{

    @FXML
    private AnchorPane rootReports;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void loadTopVehicleUI(){
        AnchorPane topVehicleUIPane = CustomStage.getDefaultSceneManager().getScene("TopVehiclesUI");
        rootReports.getChildren().setAll(topVehicleUIPane);
    }
}
