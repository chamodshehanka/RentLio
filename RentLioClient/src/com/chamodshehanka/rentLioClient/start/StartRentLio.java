package com.chamodshehanka.rentLioClient.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.vivoxalabs.scenemanager.SceneManager;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class StartRentLio extends Application {

    private static SceneManager sceneManager;
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/com/chamodshehanka/rentLioClient/view/fxml/ManageVehicleUI.fxml"));
        Scene scene = new Scene(parent);

        parent.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        parent.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

//        sceneManager.automate("/com/chamodshehanka/rentLioClient/view/fxml");

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(getClass()
                .getResourceAsStream("/com/chamodshehanka/rentLioClient/view/icon/icon.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
