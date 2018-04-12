package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.DriverController;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioClient.view.tableModel.DriverTableModel;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
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

    private ObservableList<DriverTableModel> driverTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDriverTableView();
        try {
            System.out.println(IDGenerator.getNewID("driver","driverId","D"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDriverTableView(){
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

}
