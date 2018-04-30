package com.chamodshehanka.rentLioClient.view.controller;

import com.chamodshehanka.rentLioClient.controller.VehicleController;
import com.chamodshehanka.rentLioClient.util.AlertBuilder;
import com.chamodshehanka.rentLioClient.view.tableModel.VehicleTableModel;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 4/25/2018
 * @project RentLio
 **/
public class ManageVehicleUIController implements Initializable{

    @FXML
    private JFXComboBox<String> cmbVehicleType;

    @FXML
    private ImageView imgVehicle;

    @FXML
    private JFXTextField txtVehicleNumber;

    @FXML
    private JFXComboBox<String> cmbVehicleBrand;

    @FXML
    private JFXTextField txtVehicleModel;

    @FXML
    private JFXTextField txtChassisNumber;

    @FXML
    private JFXTextField txtFuel;

    @FXML
    private JFXTextField txtKMRS;

    @FXML
    private JFXTextField txtEngineCapacity;

    @FXML
    private JFXColorPicker pkVehicleColor;

    @FXML
    private JFXTextField txtNoOfDoors;

    @FXML
    private JFXTextField txtInsuranceCom;

    @FXML
    private JFXTextField txtComment;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private TableView<VehicleTableModel> tblVehicle;

    @FXML
    private TableColumn<VehicleTableModel, String> colVehicleNo;

    @FXML
    private TableColumn<VehicleTableModel, String> colVehicleType;

    @FXML
    private TableColumn<VehicleTableModel, String> colVehicleBrand;

    @FXML
    private TableColumn<VehicleTableModel, String> colModel;

    @FXML
    private TableColumn<VehicleTableModel, String> colImgURL;

    @FXML
    private TableColumn<VehicleTableModel, String> colModelYear;

    @FXML
    private TableColumn<VehicleTableModel, String> colChassieNo;

    @FXML
    private TableColumn<VehicleTableModel, String> colFuel;

    @FXML
    private TableColumn<VehicleTableModel, Double> colKMRS;

    @FXML
    private TableColumn<VehicleTableModel, String> colCapacity;

    @FXML
    private TableColumn<VehicleTableModel, String> colColor;

    @FXML
    private TableColumn<VehicleTableModel, Integer> colDoors;

    @FXML
    private TableColumn<VehicleTableModel, String> colInsurance;

    @FXML
    private TableColumn<VehicleTableModel, String> colComment;

    @FXML
    private TableColumn<VehicleTableModel, String> colStatus;

    private ObservableList<VehicleTableModel> vehicleTableModelObservableList = FXCollections.observableArrayList();

    private Stage fileChooseStage = new Stage();
    private String fileName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpUIComponents();
    }

    @FXML
    private void addAction() {
        VehicleDTO vehicleDTO = new VehicleDTO(
            txtVehicleNumber.getText(),cmbVehicleType.getValue(),cmbVehicleBrand.getValue()
                ,txtVehicleModel.getText(),fileName,"N/A",txtChassisNumber.getText(),txtFuel.getText(),
                Double.valueOf(txtKMRS.getText()),txtEngineCapacity.getText(),String.valueOf(pkVehicleColor.getValue())
                ,Integer.valueOf(txtNoOfDoors.getText()),txtInsuranceCom.getText(),txtComment.getText(),txtStatus.getText()
        );

        try {
            boolean isAdded = VehicleController.addVehicle(vehicleDTO);
            if (isAdded){
                new AlertBuilder("info","Manage Vehicle","Vehicle Add",
                        "Vehicle added successfully");
            }else {
                new AlertBuilder("error","Manage Vehicle","Vehicle Add",
                        "Vehicle couldn't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchById() {
        try {
            VehicleDTO vehicleDTO = VehicleController.getVehicleById(txtVehicleNumber.getText());
            if (vehicleDTO != null){
                txtVehicleNumber.setText(vehicleDTO.getVehicleNumber());
                cmbVehicleType.getSelectionModel().select(vehicleDTO.getVehicleType());
                cmbVehicleBrand.getSelectionModel().select(vehicleDTO.getVehicleBrand());
                txtVehicleModel.setText(vehicleDTO.getVehicleModel());
                txtFuel.setText(vehicleDTO.getFuel());
                txtChassisNumber.setText(vehicleDTO.getChassiNumber());
                txtStatus.setText(vehicleDTO.getStatus());
                txtKMRS.setText(String.valueOf(vehicleDTO.getKmrs()));
                txtEngineCapacity.setText(vehicleDTO.getEngineCapacity());
                pkVehicleColor.setValue(Color.valueOf(vehicleDTO.getColour()));
                txtNoOfDoors.setText(String.valueOf(vehicleDTO.getDoors()));
                txtInsuranceCom.setText(vehicleDTO.getInsuranceCom());
                txtComment.setText(vehicleDTO.getComment());
                setImgVehicle(vehicleDTO.getImageURL());
            }else {
                new AlertBuilder("warn","Manage Vehicle","Vehicle Add",
                        "Vehicle couldn't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setImgVehicle(String imgName){
        imgVehicle.setImage(new Image("/com/chamodshehanka/rentLioClient/view/images/"+imgName+".jpg"));
    }

    @FXML
    private void updateAction() {
        VehicleDTO vehicleDTO = new VehicleDTO(
                txtVehicleNumber.getText(),cmbVehicleType.getValue(),cmbVehicleBrand.getValue()
                ,txtVehicleModel.getText(),fileName,"N/A",txtChassisNumber.getText(),txtFuel.getText(),
                Double.valueOf(txtKMRS.getText()),txtEngineCapacity.getText(),String.valueOf(pkVehicleColor.getValue())
                ,Integer.valueOf(txtNoOfDoors.getText()),txtInsuranceCom.getText(),txtComment.getText(),txtStatus.getText()
        );

        try {
            boolean isUpdated = VehicleController.updateVehicle(vehicleDTO);
            if (isUpdated){
                new AlertBuilder("info","Manage Vehicle","Vehicle Update",
                        "Vehicle successfully updated");
            }else {
                new AlertBuilder("warn","Manage Vehicle","Vehicle Update",
                        "Vehicle couldn't update");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAction() {
        try {
            boolean isDeleted = VehicleController.deleteVehicle(txtVehicleNumber.getText());
            if (isDeleted){
                new AlertBuilder("info","Manage Vehicle","Vehicle Delete",
                        "Vehicle successfully deleted");
            }else {
                new AlertBuilder("warn","Manage Vehicle","Vehicle Delete",
                        "Vehicle couldn't delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUpUIComponents(){
        cmbVehicleType.getItems().addAll("Family","Other");
        cmbVehicleBrand.getItems().addAll("Toyota","Honda","Suzuki");
        removeImgURL();
        loadVehicleTableView();
    }

    @FXML
    private void browseImgURL(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(fileChooseStage);

        if (file != null){
            fileName = String.valueOf(file);
            String mimeType = null;
            try {
                mimeType = Files.probeContentType(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (mimeType != null && mimeType.split("/")[0].equals("image")) {
                fileName = fileName.substring(24,fileName.length());
                fileChooser.showSaveDialog(fileChooseStage);
                setImgVehicle(fileName);
            }else {
                new AlertBuilder("error","Browse","Image",
                        "Reception couldn't delete !!");
            }
        }else {
            System.out.println("File is null");
        }
    }

    private void loadVehicleTableView(){
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("carNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colVehicleBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colImgURL.setCellValueFactory(new PropertyValueFactory<>("imageURL"));
        colModelYear.setCellValueFactory(new PropertyValueFactory<>("modelYear"));
        colChassieNo.setCellValueFactory(new PropertyValueFactory<>("chasieNo"));
        colFuel.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        colKMRS.setCellValueFactory(new PropertyValueFactory<>("kmRs"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<>("engineCapacity"));
        colColor.setCellValueFactory(new PropertyValueFactory<>("colour"));
        colDoors.setCellValueFactory(new PropertyValueFactory<>("noOfDoors"));
        colInsurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        colComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblVehicle.setItems(vehicleTableModelObservableList);

        try {
            List<VehicleDTO> vehicleDTOList = VehicleController.getAllVehicles();
            for (VehicleDTO vehicleDTO: vehicleDTOList
                 ) {
                VehicleTableModel vehicleTableModel = new VehicleTableModel();
                vehicleTableModel.setCarNumber(vehicleDTO.getVehicleNumber());
                vehicleTableModel.setVehicleType(vehicleDTO.getVehicleType());
                vehicleTableModel.setBrand(vehicleDTO.getVehicleBrand());
                vehicleTableModel.setModel(vehicleDTO.getVehicleModel());
                vehicleTableModel.setImageURL(vehicleDTO.getImageURL());
                vehicleTableModel.setModelYear(vehicleDTO.getModelYear());
                vehicleTableModel.setChasieNo(vehicleDTO.getChassiNumber());
                vehicleTableModel.setFuel(vehicleDTO.getFuel());
                vehicleTableModel.setKmRs(vehicleDTO.getKmrs());
                vehicleTableModel.setEngineCapacity(vehicleDTO.getEngineCapacity());
                vehicleTableModel.setColour(vehicleDTO.getColour());
                vehicleTableModel.setNoOfDoors(vehicleDTO.getDoors());
                vehicleTableModel.setInsurance(vehicleDTO.getInsuranceCom());
                vehicleTableModel.setComment(vehicleDTO.getComment());
                vehicleTableModel.setStatus(vehicleDTO.getStatus());

                vehicleTableModelObservableList.add(vehicleTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removeImgURL(){
        imgVehicle.setImage(new Image("/com/chamodshehanka/rentLioClient/view/images/notAvailable.png"));
    }

    @FXML
    private void getSelectedItem() {
        String vehicleNo = tblVehicle.getSelectionModel().getSelectedItem().getCarNumber();
        txtVehicleNumber.setText(vehicleNo);
        searchById();
    }

}
