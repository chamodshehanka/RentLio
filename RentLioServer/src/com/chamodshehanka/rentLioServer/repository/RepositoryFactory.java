package com.chamodshehanka.rentLioServer.repository;

import com.chamodshehanka.rentLioServer.repository.custom.impl.*;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class RepositoryFactory {

    public enum RepositoryFactoryTypes{
        ADMIN, BRANCH, CUSTOMER, DRIVER, PAYMENT, RECEPTION, RESERVATION, VEHICLE
    }

    private RepositoryFactory() {
    }

    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null)
            repositoryFactory = new RepositoryFactory();
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryFactoryTypes repositoryFactoryTypes){
        switch (repositoryFactoryTypes){
            case ADMIN: return new AdminRepositoryImpl();
            case BRANCH: return new BranchRepositoryImpl();
            case DRIVER: return new DriverRepositoryImpl();
            case PAYMENT: return new PaymentRepositoryImpl();
            case VEHICLE: return new VehicleRepositoryImpl();
            case CUSTOMER: return new CustomerRepositoryImpl();
            case RECEPTION: return new ReceptionRepositoryImpl();
            case RESERVATION:return new ReservationRepositoryImpl();
            default: return null;
        }
    }
}
