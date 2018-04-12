package com.chamodshehanka.rentLioClient.view.tableModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class PaymentTableModel {

    private SimpleStringProperty paymentId = new SimpleStringProperty("");
    private SimpleStringProperty reservationID = new SimpleStringProperty("");
    private SimpleStringProperty date = new SimpleStringProperty("");
    private SimpleStringProperty customerId = new SimpleStringProperty("");
    private SimpleStringProperty carNumber = new SimpleStringProperty("");
    private SimpleStringProperty receptionId = new SimpleStringProperty("");
    private SimpleStringProperty driverId = new SimpleStringProperty("");
    private SimpleDoubleProperty driverPayment = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty deposit = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty damage = new SimpleDoubleProperty(0.0);
    private SimpleStringProperty afterKM = new SimpleStringProperty("");
    private SimpleDoubleProperty extraKmPrice = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty dayPayment = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty totalPrice = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty discount = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty totalLastPrice = new SimpleDoubleProperty(0.0);

    public PaymentTableModel() {
    }

    public PaymentTableModel(SimpleStringProperty paymentId, SimpleStringProperty reservationID, SimpleStringProperty date, SimpleStringProperty customerId, SimpleStringProperty carNumber, SimpleStringProperty receptionId, SimpleStringProperty driverId, SimpleDoubleProperty driverPayment, SimpleDoubleProperty deposit, SimpleDoubleProperty damage, SimpleStringProperty afterKM, SimpleDoubleProperty extraKmPrice, SimpleDoubleProperty dayPayment, SimpleDoubleProperty totalPrice, SimpleDoubleProperty discount, SimpleDoubleProperty totalLastPrice) {
        this.paymentId = paymentId;
        this.reservationID = reservationID;
        this.date = date;
        this.customerId = customerId;
        this.carNumber = carNumber;
        this.receptionId = receptionId;
        this.driverId = driverId;
        this.driverPayment = driverPayment;
        this.deposit = deposit;
        this.damage = damage;
        this.afterKM = afterKM;
        this.extraKmPrice = extraKmPrice;
        this.dayPayment = dayPayment;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.totalLastPrice = totalLastPrice;
    }

    public String getPaymentId() {
        return paymentId.get();
    }

    public SimpleStringProperty paymentIdProperty() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId.set(paymentId);
    }

    public String getReservationID() {
        return reservationID.get();
    }

    public SimpleStringProperty reservationIDProperty() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID.set(reservationID);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
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

    public String getCarNumber() {
        return carNumber.get();
    }

    public SimpleStringProperty carNumberProperty() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber.set(carNumber);
    }

    public String getReceptionId() {
        return receptionId.get();
    }

    public SimpleStringProperty receptionIdProperty() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId.set(receptionId);
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

    public double getDriverPayment() {
        return driverPayment.get();
    }

    public SimpleDoubleProperty driverPaymentProperty() {
        return driverPayment;
    }

    public void setDriverPayment(double driverPayment) {
        this.driverPayment.set(driverPayment);
    }

    public double getDeposit() {
        return deposit.get();
    }

    public SimpleDoubleProperty depositProperty() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit.set(deposit);
    }

    public double getDamage() {
        return damage.get();
    }

    public SimpleDoubleProperty damageProperty() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage.set(damage);
    }

    public String getAfterKM() {
        return afterKM.get();
    }

    public SimpleStringProperty afterKMProperty() {
        return afterKM;
    }

    public void setAfterKM(String afterKM) {
        this.afterKM.set(afterKM);
    }

    public double getExtraKmPrice() {
        return extraKmPrice.get();
    }

    public SimpleDoubleProperty extraKmPriceProperty() {
        return extraKmPrice;
    }

    public void setExtraKmPrice(double extraKmPrice) {
        this.extraKmPrice.set(extraKmPrice);
    }

    public double getDayPayment() {
        return dayPayment.get();
    }

    public SimpleDoubleProperty dayPaymentProperty() {
        return dayPayment;
    }

    public void setDayPayment(double dayPayment) {
        this.dayPayment.set(dayPayment);
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    public SimpleDoubleProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public double getDiscount() {
        return discount.get();
    }

    public SimpleDoubleProperty discountProperty() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public double getTotalLastPrice() {
        return totalLastPrice.get();
    }

    public SimpleDoubleProperty totalLastPriceProperty() {
        return totalLastPrice;
    }

    public void setTotalLastPrice(double totalLastPrice) {
        this.totalLastPrice.set(totalLastPrice);
    }
}
