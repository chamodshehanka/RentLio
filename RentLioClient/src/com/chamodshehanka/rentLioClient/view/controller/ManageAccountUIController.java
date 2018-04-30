package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.AdminController;
import com.chamodshehanka.rentLioClient.controller.ReceptionController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioCommon.dto.AdminDTO;
import com.chamodshehanka.rentLioCommon.dto.ReceptionDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/30/2018
 * @project RentLio
 **/
public class ManageAccountUIController implements Initializable{

    private List<AdminDTO> adminDTOList;
    private List<ReceptionDTO> receptionDTOList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void getAdminByID(){

    }

    @FXML
    private void checkAvailability(){
        loadAdminList();
        loadReceptionList();

        String userName = null;
        String password = null;

        if (!userName.isEmpty() && !password.isEmpty()){
            boolean userAvailable = false;
            for (AdminDTO adminDTO: adminDTOList
                 ) {
                if (adminDTO.getAdminName().equals(userName) && adminDTO.getPassword().equals(password)){
                    userAvailable = true;
                }
            }

            if (!userAvailable){
                for (ReceptionDTO receptionDTO: receptionDTOList
                     ) {
                    if (receptionDTO.getName().equals(userName)){
                        userAvailable = true;
                    }
                }
            }

            if (userAvailable){
                setVisibleEditPane();
            }else {
                new AlertBuilder("error","Manage Account", "Account",
                        "Username and password not match !!");
            }
        }
    }

    private void setVisibleEditPane(){

    }

    private void loadAdminList(){
        try {
            adminDTOList = AdminController.getAllAdmins();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadReceptionList(){
        try {
            receptionDTOList = ReceptionController.getAllReceptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
