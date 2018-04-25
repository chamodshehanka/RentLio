package com.chamodshehanka.rentLioClient.view.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/25/2018
 * @project RentLio
 **/
public class ManageVehicleUIController implements Initializable{

    @FXML
    private JFXComboBox<String> cmbVehicleType;

    @FXML
    private ImageView imgVehicle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUIComponents();
    }

    @FXML
    private void addAction() {

    }

    @FXML
    private void searchById() {

    }

    @FXML
    private void updateAction() {

    }

    @FXML
    private void deleteAction() {

    }

    private void setUpUIComponents(){
        cmbVehicleType.getItems().addAll("Family","Other");
    }

    @FXML
    private void browseImgURL(){}

    @FXML
    private void removeImgURL(){}

    @FXML
    private void getSelectedItem() {

    }

}
