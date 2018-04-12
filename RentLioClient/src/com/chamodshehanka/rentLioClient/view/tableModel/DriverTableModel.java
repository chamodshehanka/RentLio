package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class DriverTableModel {

    private SimpleStringProperty driverId = new SimpleStringProperty("");
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleIntegerProperty tel = new SimpleIntegerProperty(0);
    private SimpleStringProperty nic = new SimpleStringProperty("");
    private SimpleStringProperty status = new SimpleStringProperty("");

    public DriverTableModel() {
    }

    public DriverTableModel(SimpleStringProperty driverId, SimpleStringProperty name, SimpleStringProperty address, SimpleStringProperty email, SimpleIntegerProperty tel, SimpleStringProperty nic, SimpleStringProperty status) {
        this.driverId = driverId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.nic = nic;
        this.status = status;
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getTel() {
        return tel.get();
    }

    public SimpleIntegerProperty telProperty() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel.set(tel);
    }

    public String getNic() {
        return nic.get();
    }

    public SimpleStringProperty nicProperty() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic.set(nic);
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
