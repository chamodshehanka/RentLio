package com.chamodshehanka.rentLioClient.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass()
                    .getResource("/com/chamodshehanka/rentLioClient/view/fxml/TopVehiclesUI.fxml"));
            rootReports.getChildren().setAll(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* AnchorPane topVehicleUIPane = CustomStage.getDefaultSceneManager().getScene("ReportsUI");
        rootReports.getChildren().setAll(topVehicleUIPane);*/
    }
}
