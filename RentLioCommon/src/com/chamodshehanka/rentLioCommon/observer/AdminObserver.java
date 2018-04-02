package com.chamodshehanka.rentLioCommon.observer;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface AdminObserver extends SuperObserver{

    public void loginAdmin()throws Exception;

    public void logOutAdmin()throws Exception;

    public void newReservationNotification()throws Exception;

    public void newPaymentNotification()throws Exception;

}
