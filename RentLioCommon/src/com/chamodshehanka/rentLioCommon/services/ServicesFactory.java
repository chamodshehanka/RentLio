package com.chamodshehanka.rentLioCommon.services;

import java.rmi.Remote;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface ServicesFactory extends Remote{

    public enum ServicesType{
        CUSTOMER, VEHICLE, BRANCH, DRIVER, RECEPTION, ADMIN, RESERVATION, PAYMENT
    }

    public SuperService getService(ServicesType servicesType)throws Exception;

}
