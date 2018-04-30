package com.chamodshehanka.rentLioClient.start;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.vivoxalabs.customstage.CustomStage;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class StartRentLio extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    public static boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) {
        CustomStage.getDefaultSceneManager().automate(getClass()
                .getResource("/com/chamodshehanka/rentLioClient/view/fxml/DashBoardUI.fxml"));
        Parent parent = CustomStage.getDefaultSceneManager().getScene("SplashScreenUI");
        Scene scene = new Scene(parent);

        parent.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        parent.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

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
