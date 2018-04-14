package com.chamodshehanka.rentLioClient.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/6/2018
 * @project RentLio
 **/
public class SideMenuUIController implements Initializable{

    @FXML
    private ImageView imgUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUI();
    }

    @FXML
    private void loadAllReportsUI() {

    }

    @FXML
    private void loadManageAccountUI() {

    }

    @FXML
    private void loadManageBranchUI() {

    }

    @FXML
    private void loadManageCustomerUI() {
        FXMLLoader customerFxmlLoader = new FXMLLoader(getClass()
                .getResource("/com/chamodshehanka/rentLioClient/view/fxml/ManageCustomerUI.fxml"));
        try {
            Parent customerParent = FXMLLoader.load(getClass()
                    .getResource("/com/chamodshehanka/rentLioClient/view/fxml/ManageCustomerUI.fxml"));
            ManageCustomerUIController manageCustomerUIController = customerFxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadManageDriverUI() {

    }

    @FXML
    private void loadManageReceptionUI() {

    }

    @FXML
    private void loadManageVehicleUI() {

    }

    @FXML
    private void logOutAction() {

    }

    private void setUpUI(){
        Image userImage = new Image("/com/chamodshehanka/rentLioClient/view/images/chamod.jpg");
        Circle circle = new Circle(75);
        ImagePattern imagePattern = new ImagePattern(userImage);
        circle.setFill(imagePattern);
        imgUser.setImage(userImage);
    }
}
