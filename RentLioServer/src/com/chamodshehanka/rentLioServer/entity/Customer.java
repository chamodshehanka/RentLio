package com.chamodshehanka.rentLioServer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
@Entity
public class Customer {

    @Id
    private String customerId;
    private String customerName;
    private String address;
    private String email;
    private int tel;
    private String customerNIC;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String address, String email, int tel, String customerNIC) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.customerNIC = customerNIC;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", customerNIC='" + customerNIC + '\'' +
                '}';
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

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }
}
