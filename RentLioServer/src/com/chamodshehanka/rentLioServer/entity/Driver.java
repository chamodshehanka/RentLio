package com.chamodshehanka.rentLioServer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
@Entity
public class Driver {

    @Id
    private String driverId;
    private String driverName;
    private String address;
    private String email;
    private  int tel;
    private String driverNIC;
    private String state;

    public Driver() {
    }

    public Driver(String driverId, String driverName, String address, String email, int tel, String driverNIC, String state) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.driverNIC = driverNIC;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", driverNIC='" + driverNIC + '\'' +
                ", state='" + state + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDriverNIC() {
        return driverNIC;
    }

    public void setDriverNIC(String driverNIC) {
        this.driverNIC = driverNIC;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
