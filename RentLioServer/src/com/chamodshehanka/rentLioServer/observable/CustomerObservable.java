package com.chamodshehanka.rentLioServer.observable;

import com.chamodshehanka.rentLioCommon.observer.CustomerObserver;

import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class CustomerObservable {

    private static ArrayList<CustomerObserver> customerObserverArrayList = new ArrayList<>();

    public boolean addCustomerObserver(CustomerObserver customerObserver){
        return customerObserverArrayList.add(customerObserver);
    }

    public boolean removeCustomerObserver(CustomerObserver customerObserver){
        return customerObserverArrayList.remove(customerObserver);
    }

    public void updateCustomerForm()throws Exception{
        for (CustomerObserver customerObserver: customerObserverArrayList
             ) {
            new Thread(() -> {
                try {
                    customerObserver.updateCustomerList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
