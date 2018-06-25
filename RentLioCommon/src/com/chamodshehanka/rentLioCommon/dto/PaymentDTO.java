package com.chamodshehanka.rentLioCommon.dto;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public class PaymentDTO extends SuperDTO{

    private String paymentId;
    private String reservationId;
    private String date;
    private String customerId;
    private String carNo;
    private String receptionId;
    private String driverId;
    private double driverPayment;
    private double deposit;
    private double damage;
    private String afterKM;
    private double extraKMPrice;
    private String paymentDay;
    private double totalPrice;
    private double discount;
    private double totalLastPrice;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentId, String reservationId, String date, String customerId, String carNo, String receptionId, String driverId, double driverPayment, double deposit, double damage, String afterKM, double extraKMPrice, String paymentDay, double totalPrice, double discount, double totalLastPrice) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.date = date;
        this.customerId = customerId;
        this.carNo = carNo;
        this.receptionId = receptionId;
        this.driverId = driverId;
        this.driverPayment = driverPayment;
        this.deposit = deposit;
        this.damage = damage;
        this.afterKM = afterKM;
        this.extraKMPrice = extraKMPrice;
        this.paymentDay = paymentDay;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.totalLastPrice = totalLastPrice;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId='" + paymentId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", carNo='" + carNo + '\'' +
                ", receptionId='" + receptionId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", driverPayment=" + driverPayment +
                ", deposit=" + deposit +
                ", damage=" + damage +
                ", afterKM='" + afterKM + '\'' +
                ", extraKMPrice=" + extraKMPrice +
                ", paymentDay='" + paymentDay + '\'' +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", totalLastPrice=" + totalLastPrice +
                '}';
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getDriverPayment() {
        return driverPayment;
    }

    public void setDriverPayment(double driverPayment) {
        this.driverPayment = driverPayment;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getAfterKM() {
        return afterKM;
    }

    public void setAfterKM(String afterKM) {
        this.afterKM = afterKM;
    }

    public double getExtraKMPrice() {
        return extraKMPrice;
    }

    public void setExtraKMPrice(double extraKMPrice) {
        this.extraKMPrice = extraKMPrice;
    }

    public String getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalLastPrice() {
        return totalLastPrice;
    }

    public void setTotalLastPrice(double totalLastPrice) {
        this.totalLastPrice = totalLastPrice;
    }
}
