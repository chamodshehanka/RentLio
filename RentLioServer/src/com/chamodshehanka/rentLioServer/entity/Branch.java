package com.chamodshehanka.rentLioServer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
@Entity
public class Branch {

    @Id
    private String branchId;
    private String registerId;
    private String address;
    private String email;
    private String tel;
    private String postalCode;

    public Branch() {
    }

    public Branch(String branchId, String registerId, String address, String email, String tel, String postalCode) {
        this.branchId = branchId;
        this.registerId = registerId;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
