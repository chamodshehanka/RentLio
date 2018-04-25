package com.chamodshehanka.rentLioCommon.dto;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public class ReceptionDTO extends SuperDTO{

    private String receptionId;
    private String branchId;
    private String name;
    private String address;
    private String email;
    private int tel;
    private String nic;
    private String password;
    private String image;

    public ReceptionDTO() {
    }

    public ReceptionDTO(String receptionId, String branchId, String name, String address, String email, int tel, String nic, String password, String image) {
        this.receptionId = receptionId;
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.nic = nic;
        this.password = password;
        this.image = image;
    }

    public ReceptionDTO(String text, String value, String text1, String text2, String text3, Integer integer, String text4) {
        super();
    }

    @Override
    public String toString() {
        return "ReceptionDTO{" +
                "receptionId='" + receptionId + '\'' +
                ", branchId='" + branchId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
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
