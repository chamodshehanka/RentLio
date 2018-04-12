package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class ReservationTableModel {

    private SimpleStringProperty reservationId = new SimpleStringProperty("");
    private SimpleStringProperty receptionId = new SimpleStringProperty("");
    private SimpleStringProperty customerId = new SimpleStringProperty("");
    private SimpleStringProperty customerName = new SimpleStringProperty("");
    private SimpleStringProperty driverId = new SimpleStringProperty("");
    private SimpleStringProperty driverName = new SimpleStringProperty("");
    private SimpleStringProperty vehicleNumber = new SimpleStringProperty("");
    private SimpleStringProperty pickUpDate = new SimpleStringProperty("");
    private SimpleDoubleProperty deposit = new SimpleDoubleProperty(0.0);
    private SimpleStringProperty status = new SimpleStringProperty("");

    public ReservationTableModel() {
    }

    public ReservationTableModel(SimpleStringProperty reservationId, SimpleStringProperty receptionId, SimpleStringProperty customerId, SimpleStringProperty customerName, SimpleStringProperty driverId, SimpleStringProperty driverName, SimpleStringProperty vehicleNumber, SimpleStringProperty pickUpDate, SimpleDoubleProperty deposit, SimpleStringProperty status) {
        this.reservationId = reservationId;
        this.receptionId = receptionId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.pickUpDate = pickUpDate;
        this.deposit = deposit;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId.get();
    }

    public SimpleStringProperty reservationIdProperty() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId.set(reservationId);
    }

    public String getReceptionId() {
        return receptionId.get();
    }

    public SimpleStringProperty receptionIdProperty() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId.set(receptionId);
    }

    public String getCustomerId() {
        return customerId.get();
    }

    public SimpleStringProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId.set(customerId);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public String getDriverId() {
        return driverId.get();
    }

    public SimpleStringProperty driverIdProperty() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId.set(driverId);
    }

    public String getDriverName() {
        return driverName.get();
    }

    public SimpleStringProperty driverNameProperty() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName.set(driverName);
    }

    public String getVehicleNumber() {
        return vehicleNumber.get();
    }

    public SimpleStringProperty vehicleNumberProperty() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber.set(vehicleNumber);
    }

    public String getPickUpDate() {
        return pickUpDate.get();
    }

    public SimpleStringProperty pickUpDateProperty() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate.set(pickUpDate);
    }

    public double getDeposit() {
        return deposit.get();
    }

    public SimpleDoubleProperty depositProperty() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit.set(deposit);
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
