package com.chamodshehanka.rentLioServer.observable;

import com.chamodshehanka.rentLioCommon.observer.VehicleObserver;

import java.util.ArrayList;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class VehicleObservable {

    private static ArrayList<VehicleObserver> vehicleObserverArrayList = new ArrayList<>();

    public boolean addVehicleObserver(VehicleObserver vehicleObserver)throws Exception{
        return vehicleObserverArrayList.add(vehicleObserver);
    }

    public boolean removeVehicleObserver(VehicleObserver vehicleObserver)throws Exception{
        return vehicleObserverArrayList.remove(vehicleObserver);
    }

    public void updateVehicleForm()throws Exception{
        for (VehicleObserver vehicleObserver: vehicleObserverArrayList
             ) {
            new Thread(() -> {
                try {
                    vehicleObserver.updateVehicleForm();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
