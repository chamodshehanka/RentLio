package com.chamodshehanka.rentlio.server.observable;

import com.chamodshehanka.rentlio.common.observer.PaymentObserver;

import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class PaymentObservable {

    private static ArrayList<PaymentObserver> paymentObserverArrayList = new ArrayList<>();

    public boolean addPaymentObserver(PaymentObserver paymentObserver){
        return paymentObserverArrayList.add(paymentObserver);
    }

    public boolean removePaymentObserver(PaymentObserver paymentObserver){
        return paymentObserverArrayList.remove(paymentObserver);
    }

    public void updatePaymentForm()throws Exception{
        for (PaymentObserver paymentObserver: paymentObserverArrayList
             ) {
            paymentObserver.updatePaymentForm();
        }
    }

}
