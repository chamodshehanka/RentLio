package com.chamodshehanka.rentLioServer.observable;

import com.chamodshehanka.rentLioCommon.observer.AdminObserver;

import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class AdminObservable {

    private static ArrayList<AdminObserver> adminObservers = new ArrayList<>();

    public boolean addAdminObserver(AdminObserver adminObserver)throws Exception{
        boolean result = adminObservers.add(adminObserver);
        loginAdmin();
        return result;
    }

    public boolean removeAdminObserver(AdminObserver adminObserver)throws Exception{
        logOutAdmin();
        return adminObservers.remove(adminObserver);
    }

    private void loginAdmin()throws Exception{
        for (AdminObserver adminObserver: adminObservers
             ) {
            new Thread(() -> {
                try {
                    adminObserver.loginAdmin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void logOutAdmin()throws Exception{
        for (AdminObserver adminObserver: adminObservers
             ) {
            new Thread(() -> {
                try {
                    adminObserver.logOutAdmin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void newReservationNotification()throws Exception{
        for (AdminObserver adminObserver: adminObservers
             ) {
            new Thread(() -> {
                try {
                    adminObserver.newReservationNotification();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void newPaymentNotification()throws Exception{
        for (AdminObserver adminObserver: adminObservers
             ) {
            new Thread(() -> {
                try {
                    adminObserver.newPaymentNotification();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
