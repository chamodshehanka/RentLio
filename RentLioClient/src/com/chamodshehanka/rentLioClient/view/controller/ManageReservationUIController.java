package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.CustomerController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
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

    private List<CustomerDTO>  customerDTOList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        generateReservationID();
        txtReservationID.setText("E001");
    }

    @FXML
    private void findCustomerAction(){
        try {
            CustomerDTO customerDTO = CustomerController.getCustomerById(txtCustomerID.getText());
            if (customerDTO != null){
                System.out.println(customerDTO.getCustomerName());
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
        for (CustomerDTO customerDTO: customerDTOList
             ) {
            if (customerDTO.getCustomerName().equals(customerName)){
                txtCustomerID.setText(customerDTO.getCustomerId());
            }else {
                new AlertBuilder("warn","Customer","Customer Search",
                        "Customer couldn't found");
            }
        }
    }


    private void generateReservationID(){
        try {
            txtReservationID.setText(IDGenerator.getNewID("reservation","E"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
