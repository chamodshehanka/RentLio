package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.CustomerController;
import com.chamodshehanka.rentLioClient.controller.DriverController;
import com.chamodshehanka.rentLioClient.controller.ReservationController;
import com.chamodshehanka.rentLioClient.controller.VehicleController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.util.IDGenerator;
import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.ReservationDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/30/2018
 * @project RentLio
 **/
public class ManageReservationUIController implements Initializable {

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

    @FXML
    private JFXTextField txtKMRs;

    @FXML
    private ImageView imgVehicle;

    @FXML
    private JFXDatePicker dpkPickUpDate;

    @FXML
    private JFXTextField txtNowMeter;

    @FXML
    private JFXTextField txtDeposit;

    @FXML
    private JFXTextField txtPriceForDay;

    @FXML
    private JFXTextArea txtComment;

    @FXML
    private JFXCheckBox chbxGetVehicleNow;

    private List<CustomerDTO> customerDTOList;

    private boolean isVehicleNow;
    private String receptionID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        generateReservationID();
        txtReservationID.setText("E001");
        setUpUIComponents();
        receptionID = "R001";
    }

    @FXML
    private void needDriverAction() {
        if (chbxDriver.isSelected()) {
            txtDriverID.setDisable(false);
            txtDriverName.setDisable(false);
            txtDriverTel.setDisable(false);
            txtDriverNIC.setDisable(false);
            btnDriverSearch.setDisable(false);
            btnDriverRemove.setDisable(false);
        } else if (!chbxDriver.isSelected()) {
            txtDriverID.setDisable(true);
            txtDriverName.setDisable(true);
            txtDriverTel.setDisable(true);
            txtDriverNIC.setDisable(true);
            btnDriverSearch.setDisable(true);
            btnDriverRemove.setDisable(true);
        }
    }

    @FXML
    private void getDriverByID() {
        try {
            DriverDTO driverDTO = DriverController.getDriverBy(txtDriverID.getText());
            if (driverDTO != null) {
                txtDriverName.setText(driverDTO.getDriverName());
                txtDriverTel.setText(0 + String.valueOf(driverDTO.getTel()));
                txtDriverNIC.setText(driverDTO.getDriverNIC());
            } else {
                new AlertBuilder("warn", "Manage Driver", "Driver Search",
                        "Driver couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeDriverAction() {
        txtDriverID.setText("");
        txtDriverName.setText("");
        txtDriverTel.setText("");
        txtDriverNIC.setText("");
        txtDriverID.requestFocus();
    }

    @FXML
    private void findCustomerAction() {
        try {
            CustomerDTO customerDTO = CustomerController.getCustomerById(txtCustomerID.getText());
            if (customerDTO != null) {
                txtCustomerName.setText(customerDTO.getCustomerName());
                chbxDriver.requestFocus();
            } else {
                new AlertBuilder("warn", "Customer", "Customer Search",
                        "Customer couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getCustomerByName() {
        try {
            customerDTOList = CustomerController.getAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String customerName = txtCustomerName.getText();
        for (CustomerDTO customerDTO : customerDTOList
                ) {
            if (customerDTO.getCustomerName().equals(customerName)) {
                txtCustomerID.setText(customerDTO.getCustomerId());
            } else {
                new AlertBuilder("warn", "Customer", "Customer Search",
                        "Customer couldn't found");
            }
        }
    }

    @FXML
    private void removeCustomerAction() {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerID.requestFocus();
    }

    private void setUpUIComponents() {
        cmbVehicleType.getItems().addAll("Family", "Other");
        cmbVehicleBrand.getItems().addAll("Toyota", "Honda", "Suzuki");

        setVehicleDefaultImage();
        dpkPickUpDate.setValue(LocalDate.now());
    }

    private void setVehicleDefaultImage() {
        imgVehicle.setImage(new Image("/com/chamodshehanka/rentLioClient/view/images/notAvailable.png"));
    }

    private void setImgVehicle(String imgName) {
        if (imgName != null) {
            imgVehicle.setImage(new Image("/com/chamodshehanka/rentLioClient/view/images/" + imgName + ".jpg"));
        } else {
            setVehicleDefaultImage();
        }
    }

    private void generateReservationID() {
        try {
            txtReservationID.setText(IDGenerator.getNewID("reservation", "E"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void filterVehicleNoAction() {

        if (cmbVehicleType.getSelectionModel().isEmpty()) {
            new AlertBuilder("warn", "Vehicle", "Vehicle Type",
                    "Select Vehicle Type");
        } else {
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
            for (VehicleDTO vehicleDTO : vehicleDTOArrayList
                    ) {
                if (vehicleDTO.getVehicleType().equals(vehicleType) && vehicleDTO.getVehicleBrand().equals(vehicleBrand)) {
                    assert filteredVehicleList != null;
                    filteredVehicleList.add(vehicleDTO.getVehicleNumber());
                } else {
                    filteredVehicleList = null;
                }
            }

            if (filteredVehicleList != null) {
                cmbVehicleNo.getItems().addAll(String.valueOf(filteredVehicleList));
            } else {
                new AlertBuilder("error", "Vehicle", "Vehicle Search",
                        "No that this type of vehicles");
            }
        }
    }

    @FXML
    private void vehicleNumberSelectedAction() {

        if (!cmbVehicleNo.getSelectionModel().isEmpty()) {

            String vehicleNo = cmbVehicleNo.getValue().substring(1, cmbVehicleNo.getValue().length() - 1);

            List<VehicleDTO> vehicleDTOList = null;

            try {
                vehicleDTOList = VehicleController.getAllVehicles();
            } catch (Exception e) {
                e.printStackTrace();
            }

            assert vehicleDTOList != null;
            for (VehicleDTO vehicleDTO : vehicleDTOList
                    ) {
                if (vehicleDTO.getVehicleNumber().equals(vehicleNo)) {
                    txtKMRs.setText(String.valueOf(vehicleDTO.getKmrs()));
                    setImgVehicle(vehicleDTO.getImageURL());
                }
            }
        } else {
            new AlertBuilder("warn", "Vehicle", "Vehicle No",
                    "Select Vehicle No");
        }
    }

    @FXML
    private void checkDateAction() {
        LocalDate localDate = dpkPickUpDate.getValue();
        boolean dateStatus = dateDifference(String.valueOf(localDate));

        if (!dateStatus){
            dpkPickUpDate.setValue(LocalDate.now());
            new AlertBuilder("warn", "Date Error", "Selected Date",
                    "Select Date Again!");
        }

    }

    private boolean dateDifference(String pickUpDate){
        String todayDate = String.valueOf(LocalDate.now());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        boolean dateStatus = false;

        try {
            date1 = sdf.parse(todayDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            date2 = sdf.parse(pickUpDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert date1 != null;
        assert date2 != null;

        // before() will return true if and only if date1 is before date2
        if(date1.before(date2)){
            dateStatus = true;
        }

        //equals() returns true if both the dates are equal
        if(date1.equals(date2)){
            dateStatus = true;
        }
        return dateStatus;
    }

    @FXML
    private void removeVehicleSearchAction() {
        txtPriceForDay.setText("");
        txtKMRs.setText("");
    }

    @FXML
    private void getVehicleNowAction() {
        isVehicleNow = chbxGetVehicleNow.isSelected();
    }

    @FXML
    private void confirmReservationAction() {

        String vehicleStatus;
        String vehicleNo = cmbVehicleNo.getValue().substring(1, cmbVehicleNo.getValue().length() - 1);
        if (isVehicleNow) {
            vehicleStatus = "Reserved";
        } else {
            vehicleStatus = "Available";
        }

        //Load Customer Object
        CustomerDTO customerDTO = null;
        try {
            customerDTO = CustomerController.getCustomerById(txtCustomerID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Load Vehicle Object
        VehicleDTO vehicleDTO = null;
        try {
            vehicleDTO = VehicleController
                    .getVehicleById(vehicleNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Load Driver Object
        DriverDTO driverDTO = null;
        try {
            driverDTO = DriverController.getDriverBy(txtDriverID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert customerDTO != null;
        assert vehicleDTO != null;
        ReservationDTO reservationDTO = new ReservationDTO(
                txtReservationID.getText(),
                receptionID,
                txtCustomerID.getText(),
                txtCustomerName.getText(),
                customerDTO.getTel(),
                customerDTO.getCustomerNIC(),

                txtDriverID.getText(),
                txtDriverName.getText(),
                txtDriverTel.getText(),
                txtDriverNIC.getText(),

                vehicleNo,
                cmbVehicleType.getValue(),
                cmbVehicleBrand.getValue(),
                txtKMRs.getText(),
                vehicleDTO.getImageURL(),

                String.valueOf(dpkPickUpDate.getValue()),
                txtNowMeter.getText(),
                vehicleStatus,
                txtComment.getText(),
                Double.valueOf(txtDeposit.getText()),
                Double.valueOf(txtPriceForDay.getText())
        );

        try {
            boolean isReservationAdded = ReservationController.addReservation(reservationDTO,vehicleDTO,driverDTO);
            if (isReservationAdded){
                new AlertBuilder("info", "Manage Reservation", "Reservation Added",
                        "Reservation Confirmed Successfully");
            }else {
                new AlertBuilder("error", "Manage Reservation", "Reservation Text",
                        "Driver couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void cancelReservationAction() {

        //Customer Details
        txtCustomerID.setText("");
        txtCustomerName.setText("");

        //Driver Details
        chbxDriver.setSelected(false);
        txtDriverID.setText("");
        txtDriverName.setText("");
        txtDriverNIC.setText("");
        txtDriverTel.setText("");

        //Vehicle Details
        txtKMRs.setText("");
        txtNowMeter.setText("");
        txtDeposit.setText("");
        txtPriceForDay.setText("");
        chbxGetVehicleNow.setSelected(false);
        txtComment.setText("");
        setVehicleDefaultImage();

        txtCustomerID.requestFocus();
    }

}
