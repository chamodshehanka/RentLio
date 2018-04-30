package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.CustomerController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioClient.util.ValidationController;
import com.chamodshehanka.rentLioClient.view.tableModel.CustomerTableModel;
import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
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
 * @author chamodshehanka on 4/14/2018
 * @project RentLio
 **/
public class ManageCustomerUIController implements Initializable {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private TableView<CustomerTableModel> tblCustomer;

    @FXML
    private TableColumn<CustomerTableModel, String> colCustomerId;

    @FXML
    private TableColumn<CustomerTableModel, String> colCustomerName;

    @FXML
    private TableColumn<CustomerTableModel, String> colAddress;

    @FXML
    private TableColumn<CustomerTableModel, String> colEmail;

    @FXML
    private TableColumn<CustomerTableModel, Integer> colTel;

    @FXML
    private TableColumn<CustomerTableModel, String> colNIC;

    private ObservableList<CustomerTableModel> customerTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCustomerTableView();
        generateCustomerId();
    }

    @FXML
    private void validatePhone(){
        boolean isValidated = new ValidationController().validateTelephone(txtTel.getText());
        txtTel.getStyleClass().add("text-field-white");
        if (isValidated){
            txtTel.getStyleClass().add("text-field-green");
        }else {
            txtTel.getStyleClass().add("text-field-red");
        }
    }

    @FXML
    private void addAction() {
        CustomerDTO customerDTO = new CustomerDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtTel.getText()),
                txtNIC.getText()
        );

        try {
            boolean isAdded = CustomerController.addCustomer(customerDTO);
            if (isAdded){
                new AlertBuilder("info","ManageCustomer","Customer Add",
                        "Customer added successfully");
                refreshTableView();
                generateCustomerId();

                txtName.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtTel.setText("");
                txtNIC.setText("");
            }else {
                new AlertBuilder("error","Manage Customer", "Customer Add",
                        "Customer couldn't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAction() {
        try {
            boolean isDeleted = CustomerController.deleteCustomer(txtId.getText());

            if (isDeleted){
                new AlertBuilder("info","ManageCustomer","Customer Delete",
                        "Customer deleted successfully");
                refreshTableView();
            }else {
                new AlertBuilder("error","ManageCustomer","Customer Delete",
                        "Customer couldn't delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchById() {
        try {
            CustomerDTO customerDTO = CustomerController.getCustomerById(txtId.getText());
            if (customerDTO != null){
                txtName.setText(customerDTO.getCustomerName());
                txtAddress.setText(customerDTO.getAddress());
                txtEmail.setText(customerDTO.getEmail());
                txtTel.setText(String.valueOf(customerDTO.getTel()));
                txtNIC.setText(customerDTO.getCustomerNIC());
            }else {
                new AlertBuilder("warn","Manage Customer","Customer Search",
                        "Customer couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateAction() {
        CustomerDTO customerDTO = new CustomerDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtTel.getText()),
                txtNIC.getText()
        );

        try {
            boolean isUpdated = CustomerController.updateCustomer(customerDTO);

            if (isUpdated){
                new AlertBuilder("info","Manage Customer","Customer Update",
                        "Customer updated successfully");
                refreshTableView();
            }else {
                new AlertBuilder("info","Manage Customer","Customer Update",
                        "Customer couldn't update.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerTableView(){
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("customerTel"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));

        tblCustomer.setItems(customerTableModelObservableList);

        try {
            List<CustomerDTO> customerDTOList = CustomerController.getAllCustomers();
            for (CustomerDTO customerDTO: customerDTOList
                 ) {
                CustomerTableModel customerTableModel = new CustomerTableModel();
                customerTableModel.setCustomerId(customerDTO.getCustomerId());
                customerTableModel.setCustName(customerDTO.getCustomerName());
                customerTableModel.setEmail(customerDTO.getEmail());
                customerTableModel.setAddress(customerDTO.getAddress());
                customerTableModel.setCustomerTel(customerDTO.getTel());
                customerTableModel.setCustomerNIC(customerDTO.getCustomerNIC());

                customerTableModelObservableList.add(customerTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getSelectedItem() {
        String customerId = tblCustomer.getSelectionModel().getSelectedItem().getCustomerId();
        txtId.setText(customerId);
        searchById();
    }

    private void generateCustomerId(){
        try {
            txtId.setText(IDGenerator.getNewID("customer","C"));
            txtName.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshTableView(){
        tblCustomer.setItems(null);
        customerTableModelObservableList.clear();
        loadCustomerTableView();
    }
}
