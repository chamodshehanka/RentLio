package com.chamodshehanka.rentlio.common.services;

import java.rmi.Remote;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface ServicesFactory extends Remote {

    enum ServicesType {
        CUSTOMER, VEHICLE, BRANCH, DRIVER, RECEPTION, ADMIN, RESERVATION, PAYMENT
    }

    SuperService getService(ServicesType servicesType) throws Exception;

}
