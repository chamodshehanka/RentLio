package com.chamodshehanka.rentLioClient.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.vivoxalabs.customstage.CustomStage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/5/2018
 * @project RentLio
 **/
public class MenuUIController implements Initializable{

    @FXML
    private AnchorPane rootMenu;

    @FXML
    private JFXButton btnRes;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnGetVehicle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUIComponents();
    }

    @FXML
    private void loadReservationUI(){
        AnchorPane reservationPane = CustomStage.getDefaultSceneManager().getScene("ManageReservationUI");
        rootMenu.getChildren().setAll(reservationPane);
    }

    @FXML
    private void loadPaymentUI(){
        System.out.println("Payment UI");
    }

    @FXML
    private void loadUpdateUI(){
        System.out.println("Update UI");
    }

    @FXML
    private void loadGetVehicleUI(){
        System.out.println("Get Vehicle UI");
    }

    private void setUIComponents(){

        //Reservation Button
        Image reservationImage = new Image(getClass()
                .getResourceAsStream("/com/chamodshehanka/rentLioClient/view/images/reservation.png"));
        btnRes.setGraphic(new ImageView(reservationImage));

        //Payment Button
        Image paymentImage = new Image(getClass()
                .getResourceAsStream("/com/chamodshehanka/rentLioClient/view/images/payment.png"));
        btnPayment.setGraphic(new ImageView(paymentImage));

        //Update Button
        Image updateImage = new Image(getClass()
                .getResourceAsStream("/com/chamodshehanka/rentLioClient/view/images/update.png"));
        btnUpdate.setGraphic(new ImageView(updateImage));

        //Get Vehicle
        Image vehicleImage = new Image(getClass()
                .getResourceAsStream("/com/chamodshehanka/rentLioClient/view/images/car.png"));
        btnGetVehicle.setGraphic(new ImageView(vehicleImage));

    }
}
