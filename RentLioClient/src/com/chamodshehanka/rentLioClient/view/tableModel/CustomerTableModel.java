package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class CustomerTableModel {

    private SimpleStringProperty customerId = new SimpleStringProperty("");;
    private SimpleStringProperty custName = new SimpleStringProperty("");;
    private SimpleStringProperty address = new SimpleStringProperty("");;
    private SimpleStringProperty email = new SimpleStringProperty("");;
    private SimpleIntegerProperty customerTel = new SimpleIntegerProperty(0);
    private SimpleStringProperty customerNIC = new SimpleStringProperty("");;

    public CustomerTableModel() {
    }

    public CustomerTableModel(SimpleStringProperty customerId, SimpleStringProperty custName, SimpleStringProperty address, SimpleStringProperty email, SimpleIntegerProperty customerTel, SimpleStringProperty customerNIC) {
        this.customerId = customerId;
        this.custName = custName;
        this.address = address;
        this.email = email;
        this.customerTel = customerTel;
        this.customerNIC = customerNIC;
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

    public String getCustName() {
        return custName.get();
    }

    public SimpleStringProperty custNameProperty() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName.set(custName);
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

    public int getCustomerTel() {
        return customerTel.get();
    }

    public SimpleIntegerProperty customerTelProperty() {
        return customerTel;
    }

    public void setCustomerTel(int customerTel) {
        this.customerTel.set(customerTel);
    }

    public String getCustomerNIC() {
        return customerNIC.get();
    }

    public SimpleStringProperty customerNICProperty() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC.set(customerNIC);
    }
}
