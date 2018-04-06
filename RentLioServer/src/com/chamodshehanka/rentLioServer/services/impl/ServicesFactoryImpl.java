package com.chamodshehanka.rentLioServer.services.impl;

import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.SuperService;
import com.chamodshehanka.rentLioServer.services.impl.custom.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public class ServicesFactoryImpl extends UnicastRemoteObject implements ServicesFactory {

    private static ServicesFactory servicesFactory;

    private ServicesFactoryImpl() throws RemoteException {
    }

    public static ServicesFactory getInstance()throws RemoteException{
        if (servicesFactory == null)
            servicesFactory = new ServicesFactoryImpl();
        return servicesFactory;
    }

    @Override
    public SuperService getService(ServicesType servicesType) throws Exception {
        switch (servicesType){
            case ADMIN: return new AdminServiceImpl();
            case RESERVATION: return new ReservationServiceImpl();
            case RECEPTION: return new ReceptionServiceImpl();
            case CUSTOMER: return new CustomerServiceImpl();
            case VEHICLE: return new VehicleServiceImpl();
            case PAYMENT: return new PaymentServiceImpl();
            case DRIVER: return new DriverServiceImpl();
            case BRANCH: return new BranchServiceImpl();
            default: return null;
        }
    }
}
