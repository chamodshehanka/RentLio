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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUI();
    }

    @FXML
    private void loadAllReportsUI() {

    }

    @FXML
    private void loadManageAccountUI() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageAccountUI"));
    }

    @FXML
    private void loadManageBranchUI() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageBranchUI"));
    }

    @FXML
    public void loadManageCustomerUI() {
        SceneManager manager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)manager.getController("DashBoardUI"))
                .setAnchorPaneTo(manager.getScene("ManageCustomerUI"));
    }

    @FXML
    private void loadManageDriverUI() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageDriverUI"));
    }

    @FXML
    private void loadManageReceptionUI() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageReceptionUI"));
    }

    @FXML
    private void loadManageVehicleUI() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("ManageVehicleUI"));
    }

    @FXML
    private void logOutAction() {
        SceneManager sceneManager = CustomStage.getDefaultSceneManager();
        ((DashBoardUIController)sceneManager.getController("DashBoardUI"))
                .setAnchorPaneTo(sceneManager.getScene("LoginUI"));
    }

    private void setUpUI(){
        Image userImage = new Image("/com/chamodshehanka/rentLioClient/view/images/chamod.jpg");
        Circle circle = new Circle(75);
        ImagePattern imagePattern = new ImagePattern(userImage);
        circle.setFill(imagePattern);
        imgUser.setImage(userImage);
    }
}
