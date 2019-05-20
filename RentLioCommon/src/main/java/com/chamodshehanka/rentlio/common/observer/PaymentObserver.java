package com.chamodshehanka.rentlio.common.observer;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface PaymentObserver extends SuperObserver{

    public void updatePaymentForm()throws Exception;

}
