package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.CustomerController;
import com.chamodshehanka.rentLioClient.controller.DriverController;
import com.chamodshehanka.rentLioClient.controller.VehicleController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/30/2018
 * @project RentLio
 **/
public class ManageReservationUIController implements Initializable{

    @FXML
    private JFXTextField txtReservationID;

    @FXML
    private JFXTextField txtCustomerID;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtDriverID;

    @FXML
    private JFXCheckBox chbxDriver;

    @FXML
    private JFXTextField txtDriverName;

    @FXML
    private JFXTextField txtDriverTel;

    @FXML
    private JFXTextField txtDriverNIC;

    @FXML
    private JFXButton btnDriverSearch;

    @FXML
    private JFXButton btnDriverRemove;

    @FXML
    private JFXComboBox<String> cmbVehicleType;

    @FXML
    private JFXComboBox<String> cmbVehicleBrand;

    @FXML
    private JFXComboBox<String> cmbVehicleNo;

    private List<CustomerDTO>  customerDTOList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        generateReservationID();
        txtReservationID.setText("E001");
        setUpUIComponents();
    }

    @FXML
    private void needDriverAction(){
        if (chbxDriver.isSelected()){
            txtDriverID.setDisable(false);
            txtDriverName.setDisable(false);
            txtDriverTel.setDisable(false);
            txtDriverNIC.setDisable(false);
            btnDriverSearch.setDisable(false);
            btnDriverRemove.setDisable(false);
        }else if (!chbxDriver.isSelected()){
            txtDriverID.setDisable(true);
            txtDriverName.setDisable(true);
            txtDriverTel.setDisable(true);
            txtDriverNIC.setDisable(true);
            btnDriverSearch.setDisable(true);
            btnDriverRemove.setDisable(true);
        }
    }

    @FXML
    private void getDriverByID(){
        try {
            DriverDTO driverDTO = DriverController.getDriverBy(txtDriverID.getText());
            if (driverDTO != null){
                txtDriverName.setText(driverDTO.getDriverName());
                txtDriverTel.setText(0+String.valueOf(driverDTO.getTel()));
                txtDriverNIC.setText(driverDTO.getDriverNIC());
            }else {
                new AlertBuilder("warn","Manage Driver","Driver Search",
                        "Driver couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeDriverAction(){
        txtDriverID.setText("");
        txtDriverName.setText("");
        txtDriverTel.setText("");
        txtDriverNIC.setText("");
        txtDriverID.requestFocus();
    }

    @FXML
    private void findCustomerAction(){
        try {
            CustomerDTO customerDTO = CustomerController.getCustomerById(txtCustomerID.getText());
            if (customerDTO != null){
                txtCustomerName.setText(customerDTO.getCustomerName());
                chbxDriver.requestFocus();
            }else {
                new AlertBuilder("warn","Customer","Customer Search",
                        "Customer couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getCustomerByName(){
        try {
            customerDTOList = CustomerController.getAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String customerName = txtCustomerName.getText();
        for (CustomerDTO customerDTO : customerDTOList
             ) {
            if (customerDTO.getCustomerName().equals(customerName)){
                txtCustomerID.setText(customerDTO.getCustomerId());
            }else {
                new AlertBuilder("warn","Customer","Customer Search",
                        "Customer couldn't found");
            }
        }
    }

    @FXML
    private void removeCustomerAction(){
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerID.requestFocus();
    }

    private void setUpUIComponents(){
        cmbVehicleType.getItems().addAll("Family","Other");
        cmbVehicleBrand.getItems().addAll("Toyota","Honda","Suzuki");
    }

    private void generateReservationID(){
        try {
            txtReservationID.setText(IDGenerator.getNewID("reservation","E"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void filterVehicleNoAction(){

        String vehicleType = cmbVehicleType.getValue();
        String vehicleBrand = cmbVehicleBrand.getValue();
        List<VehicleDTO> vehicleDTOArrayList = null;

        try {
            vehicleDTOArrayList = VehicleController.getAllVehicles();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> filteredVehicleList = new ArrayList<>();

        assert vehicleDTOArrayList != null;
        for (VehicleDTO vehicleDTO: vehicleDTOArrayList
             ) {
                if (vehicleDTO.getVehicleType().equals(vehicleType) && vehicleDTO.getVehicleBrand().equals(vehicleBrand)){
                    filteredVehicleList.add(vehicleDTO.getVehicleNumber());
                }else {
                    filteredVehicleList = null;
                }
        }

        if (filteredVehicleList != null){
            cmbVehicleNo.getItems().addAll(String.valueOf(filteredVehicleList));
        }else{
            new AlertBuilder("error","Vehicle","Vehicle Search",
                    "No that this type of vehicles");
        }
    }
}
