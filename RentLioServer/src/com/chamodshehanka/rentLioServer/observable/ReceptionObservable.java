package com.chamodshehanka.rentLioServer.observable;

import com.chamodshehanka.rentLioCommon.observer.ReceptionObserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class ReceptionObservable {

    private static ArrayList<ReceptionObserver> receptionObserverArrayList = new ArrayList<>();

    public boolean addReceptionObserver(ReceptionObserver receptionObserver){
        return receptionObserverArrayList.add(receptionObserver);
    }

    public boolean removeReceptionObserver(ReceptionObserver receptionObserver){
        return receptionObserverArrayList.remove(receptionObserver);
    }

    public void loginReception()throws Exception{
        for (ReceptionObserver receptionObserver : receptionObserverArrayList
             ) {
            new Thread(() -> {
                try {
                    receptionObserver.loginReception(receptionObserverArrayList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void logOutReception()throws Exception{
        for (ReceptionObserver receptionObserver: receptionObserverArrayList
             ) {
            new Thread(() -> {
                try {
                    receptionObserver.logOutReception(receptionObserverArrayList);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
