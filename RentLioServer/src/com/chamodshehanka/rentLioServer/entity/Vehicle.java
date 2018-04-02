package com.chamodshehanka.rentLioServer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
@Entity
public class Vehicle {

    @Id
    private String vehicleNumber;
    private String vehicleType;
    private String vehicleBrand;
    private String vehicleModel;
    private String imageURL;
    private String modelYear;
    private String chassiNumber;
    private String fuel;
    private double kmrs;
    private String engineCapacity;
    private String colour;
    private int doors;
    private String insuranceCom;
    private String comment;
    private String status;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleType, String vehicleBrand, String vehicleModel, String imageURL, String modelYear, String chassiNumber, String fuel, double kmrs, String engineCapacity, String colour, int doors, String insuranceCom, String comment, String status) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.imageURL = imageURL;
        this.modelYear = modelYear;
        this.chassiNumber = chassiNumber;
        this.fuel = fuel;
        this.kmrs = kmrs;
        this.engineCapacity = engineCapacity;
        this.colour = colour;
        this.doors = doors;
        this.insuranceCom = insuranceCom;
        this.comment = comment;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", chassiNumber='" + chassiNumber + '\'' +
                ", fuel='" + fuel + '\'' +
                ", kmrs=" + kmrs +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", colour='" + colour + '\'' +
                ", doors=" + doors +
                ", insuranceCom='" + insuranceCom + '\'' +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getChassiNumber() {
        return chassiNumber;
    }

    public void setChassiNumber(String chassiNumber) {
        this.chassiNumber = chassiNumber;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getKmrs() {
        return kmrs;
    }

    public void setKmrs(double kmrs) {
        this.kmrs = kmrs;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getInsuranceCom() {
        return insuranceCom;
    }

    public void setInsuranceCom(String insuranceCom) {
        this.insuranceCom = insuranceCom;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
