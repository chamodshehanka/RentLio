package com.chamodshehanka.rentLioCommon.observer;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface ReceptionObserver extends SuperObserver{

    public void loginReception(ArrayList<ReceptionObserver> receptionObserverArrayList)throws RemoteException;

    public void logOutReception(ArrayList<ReceptionObserver> receptionObserverArrayList)throws RemoteException;

}
