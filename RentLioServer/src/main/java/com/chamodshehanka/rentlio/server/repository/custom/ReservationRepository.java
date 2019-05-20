package com.chamodshehanka.rentlio.server.repository.custom;

import com.chamodshehanka.rentlio.server.entity.Reservation;
import com.chamodshehanka.rentlio.server.repository.SuperRepository;
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
