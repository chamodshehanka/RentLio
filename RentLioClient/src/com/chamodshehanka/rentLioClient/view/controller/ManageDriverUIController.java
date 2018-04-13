package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.DriverController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioClient.view.tableModel.DriverTableModel;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
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
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class ManageDriverUIController implements Initializable{

    @FXML
    private TableView<DriverTableModel> tblDriver;

    @FXML
    private TableColumn<DriverTableModel, String> colDriverId;

    @FXML
    private TableColumn<DriverTableModel, String> colDriverName;

    @FXML
    private TableColumn<DriverTableModel, String> colAddress;

    @FXML
    private TableColumn<DriverTableModel, String> colEmail;

    @FXML
    private TableColumn<DriverTableModel, Integer> colTel;

    @FXML
    private TableColumn<DriverTableModel, String> colNIC;

    @FXML
    private TableColumn<DriverTableModel, String> colStatus;

    @FXML
    private JFXTextField txtDriverId;

    @FXML
    private JFXTextField txtDriverName;

    @FXML
    private JFXTextField txtDriverAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXTextField txtNIC;

    private ObservableList<DriverTableModel> driverTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDriverTableView();
        generateDriverId();
    }

    @FXML
    private void addDriverAction(){
        DriverDTO driverDTO = new DriverDTO(
                txtDriverId.getText(),
                txtDriverName.getText(),
                txtDriverAddress.getText(),
                txtEmail.getText(),
                Integer.valueOf(txtTel.getText()),
                txtNIC.getText(),
                "Available"
        );

        try {
            boolean isAdded = DriverController.addDriver(driverDTO);
            if (isAdded){
                new AlertBuilder("info","Manage Driver","Driver Add",
                        "Driver has been successfully added !!");
                refreshTable();
                generateDriverId();
                loadDriverTableView();
                txtDriverName.setText("");
                txtDriverAddress.setText("");
                txtEmail.setText("");
                txtTel.setText("");
                txtNIC.setText("");
                txtDriverName.requestFocus();
            }else {
                new AlertBuilder("error","Manage Driver","Driver Add",
                        "Driver could't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchById(){
        try {
            DriverDTO driverDTO = DriverController.getDriverBy(txtDriverId.getText());
            if (driverDTO != null){
                txtDriverName.setText(driverDTO.getDriverName());
                txtDriverAddress.setText(driverDTO.getAddress());
                txtEmail.setText(driverDTO.getEmail());
                txtTel.setText(String.valueOf(driverDTO.getTel()));
                txtNIC.setText(driverDTO.getDriverNIC());
            }else {
                new AlertBuilder("warn","Manage Driver","Driver Search",
                        "Driver couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateDriverAction(){

        try {
            String driverStatus = DriverController.getDriverBy(txtDriverId.getText()).getState();
            DriverDTO driverDTO = new DriverDTO(
                    txtDriverId.getText(),
                    txtDriverName.getText(),
                    txtDriverAddress.getText(),
                    txtEmail.getText(),
                    Integer.valueOf(txtTel.getText()),
                    txtNIC.getText(),
                    driverStatus
            );

            boolean isUpdated = DriverController.updateDriver(driverDTO);

            if (isUpdated){
                new AlertBuilder("info","Manage Driver","Driver Update",
                        "Driver has been successfully updated !!");
                refreshTable();
            }else {
                new AlertBuilder("error","Manage Driver","Driver Update",
                        "Something wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteDriverAction(){
        try {
            boolean isDeleted = DriverController.deleteDriver(txtDriverId.getText());
            if (isDeleted){
                new AlertBuilder("info","Manage Driver","Driver Delete",
                        "Driver has been successfully deleted !!");
                refreshTable();
            }else {
                new AlertBuilder("error","Manage Driver","Driver Delete",
                        "Driver couldn't delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getSelectedItem(){
        String driverId = tblDriver.getSelectionModel().getSelectedItem().getDriverId();
        txtDriverId.setText(driverId);
        searchById();
    }

    private void generateDriverId(){
        try {
            txtDriverId.setText(IDGenerator.getNewID("driver","D"));
            txtDriverName.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadDriverTableView(){

        tblDriver.refresh();

        colDriverId.setCellValueFactory(new PropertyValueFactory<>("driverId"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblDriver.setItems(driverTableModelObservableList);

        try {
            List<DriverDTO> driverDTOList = DriverController.getAllDrivers();
            for (DriverDTO driverDTO: driverDTOList
                 ) {
                DriverTableModel driverTableModel = new DriverTableModel();
                driverTableModel.setDriverId(driverDTO.getDriverId());
                driverTableModel.setName(driverDTO.getDriverName());
                driverTableModel.setAddress(driverDTO.getAddress());
                driverTableModel.setEmail(driverDTO.getEmail());
                driverTableModel.setTel(driverDTO.getTel());
                driverTableModel.setNic(driverDTO.getDriverNIC());
                driverTableModel.setStatus(driverDTO.getState());

                driverTableModelObservableList.add(driverTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void refreshTable(){
        tblDriver.setItems(null);
        driverTableModelObservableList.clear();
        loadDriverTableView();
    }

}
