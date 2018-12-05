package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            case 1 :
                    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                            new PieChart.Data("Prius", 13),
                            new PieChart.Data("Audi A7", 25),
                            new PieChart.Data("Audi R8", 10),
                            new PieChart.Data("BMW i8", 22),
                            new PieChart.Data("Premio", 30));

                    topVehiclesChart.setData(pieChartData);
                    topVehiclesChart.setTitle("Top Vehicles");
                break;
            case 2 :
                pieChartData = FXCollections.observableArrayList(
                        new PieChart.Data("Prius", 73),
                        new PieChart.Data("Audi A7", 25),
                        new PieChart.Data("Audi R8", 17),
                        new PieChart.Data("BMW i8", 45),
                        new PieChart.Data("Premio", 90));

                topVehiclesChart.setData(pieChartData);
                break;
            case 3 : break;
            default : new AlertBuilder("warn","Top Vehicles","Top Vehicle Graph",
                    "Invalid type of graph !!");
        }
    }

    private void getPieChartData(){

    }

    private void setComboBoxValues(){
        chbxTest.getItems().addAll(1,2,3);
    }
}
