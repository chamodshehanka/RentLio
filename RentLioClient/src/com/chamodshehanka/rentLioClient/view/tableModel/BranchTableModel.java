package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class BranchTableModel {

    private SimpleStringProperty branchId = new SimpleStringProperty("");
    private SimpleStringProperty registerId = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleIntegerProperty tel = new SimpleIntegerProperty(0);
    private SimpleStringProperty postalCode = new SimpleStringProperty("");

    public BranchTableModel(){
    }

    public BranchTableModel(SimpleStringProperty branchId, SimpleStringProperty registerId, SimpleStringProperty address, SimpleStringProperty email, SimpleIntegerProperty tel, SimpleStringProperty postalCode) {
        this.branchId = branchId;
        this.registerId = registerId;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.postalCode = postalCode;
    }

    public String getBranchId() {
        return branchId.get();
    }

    public SimpleStringProperty branchIdProperty() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId.set(branchId);
    }

    public String getRegisterId() {
        return registerId.get();
    }

    public SimpleStringProperty registerIdProperty() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId.set(registerId);
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

    public String getPostalCode() {
        return postalCode.get();
    }

    public SimpleStringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }
}
