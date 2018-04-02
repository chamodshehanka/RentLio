package com.chamodshehanka.rentLioCommon.dto;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public class CustomerDTO extends SuperDTO{

    private String customerId;
    private String customerName;
    private String address;
    private String email;
    private int tel;
    private String customerNIC;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerName, String address, String email, int tel, String customerNIC) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.customerNIC = customerNIC;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
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
