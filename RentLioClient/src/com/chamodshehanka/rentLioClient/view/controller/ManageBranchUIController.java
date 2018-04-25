package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.BranchController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioClient.view.tableModel.BranchTableModel;
import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/25/2018
 * @project RentLio
 **/
public class ManageBranchUIController implements Initializable{

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtRegisterID;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private TableView<BranchTableModel> tblBranch;

    @FXML
    private TableColumn<BranchTableModel, String> colBranchId;

    @FXML
    private TableColumn<BranchTableModel, String> colRegisterID;

    @FXML
    private TableColumn<BranchTableModel, String> colAddress;

    @FXML
    private TableColumn<BranchTableModel, String> colEmail;

    @FXML
    private TableColumn<BranchTableModel, Integer> colTel;

    @FXML
    private TableColumn<BranchTableModel, String> colPostalCode;

    private ObservableList<BranchTableModel> branchTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateBranchID();
        loadBranchTableView();
    }

    @FXML
    private void addAction() {
        BranchDTO branchDTO = new BranchDTO(
                txtId.getText(),
                txtRegisterID.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtTel.getText(),
                txtPostalCode.getText()
        );

        try {
            boolean isAdded = BranchController.addBranch(branchDTO);
            if (isAdded){
                new AlertBuilder("info","Manage Branch","Branch Add",
                        "Branch added successfully");
                refreshTableView();
                generateBranchID();

                txtRegisterID.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtTel.setText("");
                txtPostalCode.setText("");
            }else {
                new AlertBuilder("error","Manage Branch","Branch Add",
                        "Branch couldn't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAction() {
        try {
            boolean isDeleted = BranchController.deleteBranch(txtId.getText());
            if (isDeleted){
                new AlertBuilder("info","Manage Branch","Branch Delete",
                        "Branch deleted successfully");
            }else {
                new AlertBuilder("error","Manage Branch","Branch Delete",
                        "Branch couldn't delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getSelectedItem() {
        String branchId = tblBranch.getSelectionModel().getSelectedItem().getBranchId();
        txtId.setText(branchId);
        searchById();
    }

    @FXML
    private void searchById() {
        try {
            BranchDTO branchDTO = BranchController.getBranchById(txtId.getText());
            if (branchDTO != null){
                txtRegisterID.setText(branchDTO.getRegisterId());
                txtAddress.setText(branchDTO.getAddress());
                txtEmail.setText(branchDTO.getEmail());
                txtTel.setText(branchDTO.getTel());
                txtPostalCode.setText(branchDTO.getPostalCode());
            }else {
                new AlertBuilder("warn","Manage Branch","Branch Search",
                        "Branch couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateAction() {
        BranchDTO branchDTO = new BranchDTO(
                txtId.getText(),
                txtRegisterID.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                txtTel.getText(),
                txtPostalCode.getText()
        );

        try {
            boolean isUpdated = BranchController.updateBranch(branchDTO);
            if (isUpdated){
                new AlertBuilder("info","Manage Branch","Branch Update",
                        "Branch updated successfully");
            }else {
                new AlertBuilder("error","Manage Branch","Branch Update",
                        "Branch couldn't update");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBranchTableView(){
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("branchId"));
        colRegisterID.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblBranch.setItems(branchTableModelObservableList);

        try {
            List<BranchDTO> branchDTOList = BranchController.getAllBranches();
            for (BranchDTO branchDTO: branchDTOList
                 ) {
                BranchTableModel branchTableModel = new BranchTableModel();
                branchTableModel.setBranchId(branchDTO.getBranchId());
                branchTableModel.setRegisterId(branchDTO.getRegisterId());
                branchTableModel.setAddress(branchDTO.getAddress());
                branchTableModel.setEmail(branchDTO.getEmail());
                branchTableModel.setTel(Integer.parseInt(branchDTO.getTel()));
                branchTableModel.setPostalCode(branchDTO.getPostalCode());

                branchTableModelObservableList.add(branchTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshTableView(){
        tblBranch.setItems(null);
        branchTableModelObservableList.clear();
        loadBranchTableView();
    }

    private void generateBranchID(){
        try {
            txtId.setText(IDGenerator.getNewID("branch","B"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
