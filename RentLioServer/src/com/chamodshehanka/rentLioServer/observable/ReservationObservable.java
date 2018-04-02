package com.chamodshehanka.rentLioServer.observable;

import com.chamodshehanka.rentLioCommon.observer.ReservationObserver;

import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class ReservationObservable {

    private static ArrayList<ReservationObserver> reservationObserverArrayList = new ArrayList<>();

    public boolean addReservationObserver(ReservationObserver reservationObserver)throws Exception{
        return reservationObserverArrayList.add(reservationObserver);
    }

    public boolean removeReservationObserver(ReservationObserver reservationObserver)throws Exception{
        return reservationObserverArrayList.remove(reservationObserver);
    }

    public void updateReservationForm()throws Exception{
        for (ReservationObserver reservationObserver: reservationObserverArrayList
             ) {
            new Thread(() -> {
                try {
                    reservationObserver.updateReservationList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
