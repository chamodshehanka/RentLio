package com.chamodshehanka.rentLioClient.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.scenemanager.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/6/2018
 * @project RentLio
 **/
public class SideMenuUIController implements Initializable{

    @FXML
    private ImageView imgUser;

    private SceneManager sceneManager = CustomStage.getDefaultSceneManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUI();
    }

    @FXML
    private void loadAllReportsUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ReportsUI"));
    }

    @FXML
    private void loadManageAccountUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageAccountUI"));
    }

    @FXML
    private void loadManageBranchUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageBranchUI"));
    }

    @FXML
    public void loadManageCustomerUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageCustomerUI"));
    }

    @FXML
    private void loadManageDriverUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageDriverUI"));
    }

    @FXML
    private void loadManageReceptionUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageReceptionUI"));
    }

    @FXML
    private void loadManageVehicleUI() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageVehicleUI"));
    }

    @FXML
    private void logOutAction() {
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .logOutAction();
    }

    private void setUpUI(){
        Image userImage = new Image("/com/chamodshehanka/rentLioClient/view/images/chamod.jpg");
        Circle circle = new Circle(75);
        ImagePattern imagePattern = new ImagePattern(userImage);
        circle.setFill(imagePattern);
        imgUser.setImage(userImage);
    }
}
