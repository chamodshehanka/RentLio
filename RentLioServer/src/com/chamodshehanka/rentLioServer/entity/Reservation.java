package com.chamodshehanka.rentLioServer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
@Entity
public class Reservation {

    @Id
    private String reservationId;
    private String receptionId;
    private String customerId;
    private String customerName;
    private int customerTel;
    private String customerNIC;

    private String driverId;
    private String driverName;
    private String driverTel;
    private String driverNIC;

    private String cNumber;
    private String cType;
    private String cBrand;
    private String cKmrs;
    private String cImage;

    private String getDate;
    private String nowMeter;
    private String status;
    private String comment;
    private double deposit;
    private double priceForDay;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @OneToOne (cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    private Reception reception;

    public Reservation() {
    }

    public Reservation(String reservationId, String receptionId, String customerId, String customerName, int customerTel, String customerNIC, String driverId, String driverName, String driverTel, String driverNIC, String cNumber, String cType, String cBrand, String cKmrs, String cImage, String getDate, String nowMeter, String status, String comment, double deposit, double priceForDay, Customer customer, Driver driver, Vehicle vehicle, Payment payment, Reception reception) {
        this.reservationId = reservationId;
        this.receptionId = receptionId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.customerNIC = customerNIC;
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverTel = driverTel;
        this.driverNIC = driverNIC;
        this.cNumber = cNumber;
        this.cType = cType;
        this.cBrand = cBrand;
        this.cKmrs = cKmrs;
        this.cImage = cImage;
        this.getDate = getDate;
        this.nowMeter = nowMeter;
        this.status = status;
        this.comment = comment;
        this.deposit = deposit;
        this.priceForDay = priceForDay;
        this.customer = customer;
        this.driver = driver;
        this.vehicle = vehicle;
        this.payment = payment;
        this.reception = reception;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", receptionId='" + receptionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerTel=" + customerTel +
                ", customerNIC='" + customerNIC + '\'' +
                ", driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverTel='" + driverTel + '\'' +
                ", driverNIC='" + driverNIC + '\'' +
                ", cNumber='" + cNumber + '\'' +
                ", cType='" + cType + '\'' +
                ", cBrand='" + cBrand + '\'' +
                ", cKmrs='" + cKmrs + '\'' +
                ", cImage='" + cImage + '\'' +
                ", getDate='" + getDate + '\'' +
                ", nowMeter='" + nowMeter + '\'' +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", deposit=" + deposit +
                ", priceForDay=" + priceForDay +
                ", customer=" + customer +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", payment=" + payment +
                ", reception=" + reception +
                '}';
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(int customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand;
    }

    public String getcKmrs() {
        return cKmrs;
    }

    public void setcKmrs(String cKmrs) {
        this.cKmrs = cKmrs;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public String getNowMeter() {
        return nowMeter;
    }

    public void setNowMeter(String nowMeter) {
        this.nowMeter = nowMeter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(double priceForDay) {
        this.priceForDay = priceForDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }
}
