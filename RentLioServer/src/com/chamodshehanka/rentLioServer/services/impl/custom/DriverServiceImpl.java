package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.services.custom.DriverService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.DriverBO;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class DriverServiceImpl extends UnicastRemoteObject implements DriverService{

    private DriverBO driverBO;
    private static ReservationImpl<DriverService> driverServiceReservation = new ReservationImpl<>();

    public DriverServiceImpl() throws RemoteException {
        driverBO = (DriverBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.DRIVER);
    }

    @Override
    public boolean addDriver(DriverDTO driverDTO) throws Exception {
        return driverBO.addDriver(driverDTO);
    }

    @Override
    public boolean updateDriver(DriverDTO driverDTO) throws Exception {
        return driverBO.updateDriver(driverDTO);
    }

    @Override
    public boolean deleteDriver(String driverDTO) throws Exception {
        return driverBO.deleteDriver(driverDTO);
    }

    @Override
    public DriverDTO findByIdDriver(String driverId) throws Exception {
        return driverBO.getDriverById(driverId);
    }

    @Override
    public List<DriverDTO> getAllDrivers() throws Exception {
        return driverBO.getAllDrivers();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return driverServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return driverServiceReservation.release(id);
    }
}
