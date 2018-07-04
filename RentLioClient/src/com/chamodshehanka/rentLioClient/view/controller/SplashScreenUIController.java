package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.start.StartRentLio;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.vivoxalabs.customstage.CustomStage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/30/2018
 * @project RentLio
 **/
public class SplashScreenUIController implements Initializable{

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!StartRentLio.isSplashLoaded){
            loadSplashScreen();
        }
    }

    private void loadSplashScreen(){
        
        StartRentLio.isSplashLoaded = true;
        AnchorPane splashPane = null;
        try {
            splashPane = FXMLLoader.load(getClass()
                    .getResource("/com/chamodshehanka/rentLioClient/view/fxml/SplashScreenUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().setAll(splashPane);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), splashPane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), splashPane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.play();

        fadeIn.setOnFinished((e) -> fadeOut.play());

        fadeOut.setOnFinished((e) -> {
            AnchorPane parentContent = CustomStage.getDefaultSceneManager().getScene("LoginUI");
            root.getChildren().setAll(parentContent);
        });
    }
}
