package com.chamodshehanka.rentLioServer.business;

import com.chamodshehanka.rentLioServer.business.custom.impl.*;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class BOFactory {

    public enum BOTypes{
        CUSTOMER, VEHICLE, BRANCH, DRIVER, RECEPTION, ADMIN, RESERVATION, PAYMENT
    }

    private BOFactory() {
    }

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory == null)
            boFactory = new BOFactory();
        return boFactory;
    }

    public SuperBO getBOFactory(BOTypes boTypes){
        switch (boTypes){
            case ADMIN: return new AdminBOImpl();
            case BRANCH: return new BranchBOImpl();
            case CUSTOMER:return new CustomerBOImpl();
            case DRIVER: return new DriverBOImpl();
            case PAYMENT: return new PaymentBOImpl();
            case RECEPTION: return new ReceptionBOImpl();
            case RESERVATION: return new ReservationBOImpl();
            case VEHICLE: return new VehicleBOImpl();
            default:return null;
        }
    }
}
