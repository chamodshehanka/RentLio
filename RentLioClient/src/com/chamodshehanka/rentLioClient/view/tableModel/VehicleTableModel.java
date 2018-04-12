package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class VehicleTableModel {

    private SimpleStringProperty carNumber = new SimpleStringProperty("");
    private SimpleStringProperty vehicleType = new SimpleStringProperty("");
    private SimpleStringProperty brand = new SimpleStringProperty("");
    private SimpleStringProperty model = new SimpleStringProperty("");
    private SimpleStringProperty imageURL = new SimpleStringProperty("");
    private SimpleStringProperty modelYear = new SimpleStringProperty("");
    private SimpleStringProperty chasieNo = new SimpleStringProperty("");
    private SimpleStringProperty fuel = new SimpleStringProperty("");
    private SimpleDoubleProperty kmRs = new SimpleDoubleProperty(0.0);
    private SimpleStringProperty engineCapacity = new SimpleStringProperty("");
    private SimpleStringProperty colour = new SimpleStringProperty("");
    private SimpleIntegerProperty noOfDoors = new SimpleIntegerProperty(0);
    private SimpleStringProperty insurance = new SimpleStringProperty("");
    private SimpleStringProperty comment = new SimpleStringProperty("");
    private SimpleStringProperty status = new SimpleStringProperty("");

    public VehicleTableModel() {
    }

    public VehicleTableModel(SimpleStringProperty carNumber, SimpleStringProperty vehicleType, SimpleStringProperty brand, SimpleStringProperty model, SimpleStringProperty imageURL, SimpleStringProperty modelYear, SimpleStringProperty chasieNo, SimpleStringProperty fuel, SimpleDoubleProperty kmRs, SimpleStringProperty engineCapacity, SimpleStringProperty colour, SimpleIntegerProperty noOfDoors, SimpleStringProperty insurance, SimpleStringProperty comment, SimpleStringProperty status) {
        this.carNumber = carNumber;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.imageURL = imageURL;
        this.modelYear = modelYear;
        this.chasieNo = chasieNo;
        this.fuel = fuel;
        this.kmRs = kmRs;
        this.engineCapacity = engineCapacity;
        this.colour = colour;
        this.noOfDoors = noOfDoors;
        this.insurance = insurance;
        this.comment = comment;
        this.status = status;
    }

    public String getCarNumber() {
        return carNumber.get();
    }

    public SimpleStringProperty carNumberProperty() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber.set(carNumber);
    }

    public String getVehicleType() {
        return vehicleType.get();
    }

    public SimpleStringProperty vehicleTypeProperty() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType.set(vehicleType);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getImageURL() {
        return imageURL.get();
    }

    public SimpleStringProperty imageURLProperty() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL.set(imageURL);
    }

    public String getModelYear() {
        return modelYear.get();
    }

    public SimpleStringProperty modelYearProperty() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear.set(modelYear);
    }

    public String getChasieNo() {
        return chasieNo.get();
    }

    public SimpleStringProperty chasieNoProperty() {
        return chasieNo;
    }

    public void setChasieNo(String chasieNo) {
        this.chasieNo.set(chasieNo);
    }

    public String getFuel() {
        return fuel.get();
    }

    public SimpleStringProperty fuelProperty() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel.set(fuel);
    }

    public double getKmRs() {
        return kmRs.get();
    }

    public SimpleDoubleProperty kmRsProperty() {
        return kmRs;
    }

    public void setKmRs(double kmRs) {
        this.kmRs.set(kmRs);
    }

    public String getEngineCapacity() {
        return engineCapacity.get();
    }

    public SimpleStringProperty engineCapacityProperty() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity.set(engineCapacity);
    }

    public String getColour() {
        return colour.get();
    }

    public SimpleStringProperty colourProperty() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour.set(colour);
    }

    public int getNoOfDoors() {
        return noOfDoors.get();
    }

    public SimpleIntegerProperty noOfDoorsProperty() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors.set(noOfDoors);
    }

    public String getInsurance() {
        return insurance.get();
    }

    public SimpleStringProperty insuranceProperty() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance.set(insurance);
    }

    public String getComment() {
        return comment.get();
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
