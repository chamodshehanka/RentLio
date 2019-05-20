package com.chamodshehanka.rentlio.common.reservation;

import java.rmi.Remote;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface Reservation extends Remote{

    public boolean reserve(Object id)throws Exception;

    public boolean release(Object id)throws Exception;

}
