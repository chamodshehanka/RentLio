package com.chamodshehanka.rentLioCommon.dto;

/**
 * @author chamodshehanka on 3/12/2018
 * @project RentLio
 **/
public class AdminDTO extends SuperDTO{

    private String adminId;
    private String adminName;
    private String adminAddress;
    private String adminTel;
    private String adminEmail;
    private String adminNIC;
    private String adminDP;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String adminId, String adminName, String adminAddress, String adminTel, String adminEmail, String adminNIC, String adminDP, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminAddress = adminAddress;
        this.adminTel = adminTel;
        this.adminEmail = adminEmail;
        this.adminNIC = adminNIC;
        this.adminDP = adminDP;
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminNIC() {
        return adminNIC;
    }

    public void setAdminNIC(String adminNIC) {
        this.adminNIC = adminNIC;
    }

    public String getAdminDP() {
        return adminDP;
    }

    public void setAdminDP(String adminDP) {
        this.adminDP = adminDP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminAddress='" + adminAddress + '\'' +
                ", adminTel='" + adminTel + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminNIC='" + adminNIC + '\'' +
                ", adminDP='" + adminDP + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
