package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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

    private Stage fileChooseStage;
    private String fileName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUIComponents();
    }

    @FXML
    private void addAction() {
        VehicleDTO vehicleDTO = new VehicleDTO(

        );
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
    private void browseImgURL(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(fileChooseStage);

        if (file != null){
            fileName = String.valueOf(file);
            String mimeType = null;
            try {
                mimeType = Files.probeContentType(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (mimeType != null && mimeType.split("/")[0].equals("image")) {
                fileName = fileName.substring(24,fileName.length());
                fileChooser.showSaveDialog(fileChooseStage);
            }else {
                new AlertBuilder("error","Browse","Image",
                        "Reception couldn't delete !!");
            }
        }else {
            System.out.println("File is null");
        }
    }

    @FXML
    private void removeImgURL(){
        imgVehicle.setImage(new Image("/com/chamodshehanka/rentLioClient/view/images/notAvailable.png"));
    }

    @FXML
    private void getSelectedItem() {

    }

}
