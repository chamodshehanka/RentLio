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
public class Reception {

    @Id
    private String receptionId;
    private String branchId;
    private String name;
    private String address;
    private String email;
    private int tel;
    private String nic;
    private String password;
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    private Branch branch;

    public Reception() {
    }

    public Reception(String receptionId, String branchId, String name, String address, String email, int tel, String nic, String password, String image, Branch branch) {
        this.receptionId = receptionId;
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.nic = nic;
        this.password = password;
        this.image = image;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "receptionId='" + receptionId + '\'' +
                ", branchId='" + branchId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", branch=" + branch +
                '}';
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
