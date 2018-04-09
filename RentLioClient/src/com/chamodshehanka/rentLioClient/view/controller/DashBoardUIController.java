package com.chamodshehanka.rentLioClient.view.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class DashBoardUIController implements Initializable {

    @FXML
    public AnchorPane rootPane;

    @FXML
    private AnchorPane parameterizedPane;

    @FXML
    public AnchorPane paneTopHeader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMenuUI();
    }

    private void loadMenuUI(){
        try {
            AnchorPane paneLogin = FXMLLoader
                    .load(getClass().getResource("/com/chamodshehanka/rentLioClient/view/fxml/ManageDriverUI.fxml"));
            parameterizedPane.getChildren().setAll(paneLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void windowClose(ActionEvent event) {
        Platform.exit();
    }
}
