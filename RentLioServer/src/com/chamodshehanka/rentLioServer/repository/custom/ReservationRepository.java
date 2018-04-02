package com.chamodshehanka.rentLioServer.repository.custom;

import com.chamodshehanka.rentLioServer.entity.Reservation;
import com.chamodshehanka.rentLioServer.repository.SuperRepository;
import org.hibernate.Session;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface ReservationRepository extends SuperRepository<Reservation, String>{

    public void setSession(Session session)throws Exception;

    List findCustomerRepository(String customerId);

}
