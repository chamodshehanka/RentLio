package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioCommon.observer.VehicleObserver;
import com.chamodshehanka.rentLioCommon.services.custom.VehicleService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.VehicleBO;
import com.chamodshehanka.rentLioServer.observable.VehicleObservable;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class VehicleServiceImpl extends UnicastRemoteObject implements VehicleService{

    private VehicleBO vehicleBO;
    private static ReservationImpl<VehicleService> vehicleServiceReservation = new ReservationImpl<>();
    private static final VehicleObservable VEHICLE_OBSERVABLE = new VehicleObservable();

    public VehicleServiceImpl() throws RemoteException {
        vehicleBO = (VehicleBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.VEHICLE);
    }

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception {
        return vehicleBO.addVehicle(vehicleDTO);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception {
        return vehicleBO.updateVehicle(vehicleDTO);
    }

    @Override
    public boolean deleteVehicle(String vehicleId) throws Exception {
        return vehicleBO.deleteVehicle(vehicleId);
    }

    @Override
    public VehicleDTO getByVehicleId(String vehicleId) throws Exception {
        return vehicleBO.getVehicleById(vehicleId);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() throws Exception {
        return vehicleBO.getAllVehicles();
    }

    @Override
    public boolean addVehicleObserver(VehicleObserver vehicleObserver) throws Exception {
        return VEHICLE_OBSERVABLE.addVehicleObserver(vehicleObserver);
    }

    @Override
    public boolean removeVehicleObserver(VehicleObserver vehicleObserver) throws Exception {
        return VEHICLE_OBSERVABLE.removeVehicleObserver(vehicleObserver);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return vehicleServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return vehicleServiceReservation.release(id);
    }
}
