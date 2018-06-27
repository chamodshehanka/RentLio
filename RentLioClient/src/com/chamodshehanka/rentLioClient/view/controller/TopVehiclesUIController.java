package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 6/27/2018
 * @project RentLio
 **/
public class TopVehiclesUIController implements Initializable{

    @FXML
    private PieChart topVehiclesChart;

    @FXML
    private JFXComboBox<Integer> chbxTest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setComboBoxValues();
    }

    @FXML
    private void setPieChartGraph(){
        Integer chartType = chbxTest.getValue();

        //switch by vehicle type
        switch (chartType){
            case 1 : break;
            case 2 : break;
            case 3 : break;
            default : new AlertBuilder("warn","Top Vehicles","Top Vehicle Graph",
                    "Invalid type of graph !!");
        }
    }

    private void setComboBoxValues(){
        chbxTest.getItems().addAll(1,2,3);
    }
}
