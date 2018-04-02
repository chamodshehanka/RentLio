package com.chamodshehanka.rentLioServer.repository.custom;

import com.chamodshehanka.rentLioServer.entity.Payment;
import com.chamodshehanka.rentLioServer.repository.SuperRepository;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface PaymentRepository extends SuperRepository<Payment, String>{
    List<Payment> findReservationPayment(String reservationId);
}
