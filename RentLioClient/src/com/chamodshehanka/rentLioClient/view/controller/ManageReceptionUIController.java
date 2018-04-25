package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.BranchController;
import com.chamodshehanka.rentLioClient.controller.ReceptionController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioCommon.dto.ReceptionDTO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/25/2018
 * @project RentLio
 **/
public class ManageReceptionUIController implements Initializable{

    @FXML
    private JFXTextField txtReceptionId;

    @FXML
    private JFXComboBox<String> cmbBranchName;

    @FXML
    private JFXTextField txtReceptionName;

    @FXML
    private JFXTextField txtReceptionAddress;

    @FXML
    private JFXTextField txtReceptionEmail;

    @FXML
    private JFXTextField txtReceptionTel;

    @FXML
    private JFXTextField txtReceptionNIC;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //generateReceptionId();
        setBranches();
    }

    @FXML
    private void AddReceptionAction(){

        ReceptionDTO receptionDTO = new ReceptionDTO(
                txtReceptionId.getText(),
                cmbBranchName.getValue(),
                txtReceptionName.getText(),
                txtReceptionAddress.getText(),
                txtReceptionEmail.getText(),
                Integer.valueOf(txtReceptionTel.getText()),
                txtReceptionNIC.getText()
        );

        try {
            boolean isAdded = ReceptionController.addReception(receptionDTO);
            if (isAdded){
                new AlertBuilder("info","Manage Reception","Reception Add",
                        "Reception has been successfully added !!");
            }else {
                new AlertBuilder("error","Manage Reception","Reception Add",
                        "Reception couldn't add !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getReceptionByID(){
        try {
            ReceptionDTO receptionDTO = ReceptionController.findById(txtReceptionId.getText());
            if (receptionDTO != null){
                cmbBranchName.getItems().setAll(getBranchByID(receptionDTO.getBranchId()));
                txtReceptionName.setText(receptionDTO.getName());
                txtReceptionAddress.setText(receptionDTO.getAddress());
                txtReceptionEmail.setText(receptionDTO.getEmail());
                txtReceptionTel.setText(String.valueOf(receptionDTO.getTel()));
                txtReceptionNIC.setText(receptionDTO.getNic());
            }else {
                new AlertBuilder("warn","Manage Reception","Reception Search",
                        "Reception couldn't find !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getBranchByID(String branchId){
        BranchDTO branchDTO = new BranchDTO();
        try {
            branchDTO = BranchController.getBranchById(branchId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return branchDTO.getAddress();
    }

    @FXML
    private void updateReceptionAction(){

        ReceptionDTO receptionDTO = new ReceptionDTO(
                txtReceptionId.getText(),
                cmbBranchName.getValue(),
                txtReceptionName.getText(),
                txtReceptionAddress.getText(),
                txtReceptionEmail.getText(),
                Integer.valueOf(txtReceptionTel.getText()),
                txtReceptionNIC.getText()
        );

        try {
            boolean isUpdated = ReceptionController.updateReception(receptionDTO);
            if (isUpdated){
                new AlertBuilder("info","Manage Reception","Reception Update",
                        "Reception has been successfully updated !!");
            }else {
                new AlertBuilder("error","Manage Reception","Reception Update",
                        "Reception couldn't update !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteReceptionAction(){
        try {
            boolean isDeleted = ReceptionController.deleteReception(txtReceptionId.getText());
            if (isDeleted){
                new AlertBuilder("info","Manage Reception","Reception Delete",
                        "Reception has been successfully deleted !!");
            }else {
                new AlertBuilder("error","Manage Reception","Reception Delete",
                        "Reception couldn't delete !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateReceptionId(){
        try {
            txtReceptionId.setText(IDGenerator.getNewID("reception","R"));
            //Set Request Focus
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setBranches(){

        List<BranchDTO> branchDTOArrayList = new ArrayList<>();

        try {
            branchDTOArrayList = BranchController.getAllBranches();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList branchList = new ArrayList();

        for (BranchDTO branchDTO: branchDTOArrayList
             ) {
            branchList.add(branchDTO.getAddress());
        }

        cmbBranchName.getItems().addAll(branchList);
    }

}
