package com.chamodshehanka.rentLioClient.view.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    private void setUpUI(){
        Image userImage = new Image("/com/chamodshehanka/rentLioClient/view/images/chamod.jpg");
        imgUser.setImage(userImage);
    }
}
