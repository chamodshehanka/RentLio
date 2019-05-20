package com.chamodshehanka.rentlio.server.repository.custom;

import com.chamodshehanka.rentlio.server.entity.Payment;
import com.chamodshehanka.rentlio.server.repository.SuperRepository;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface PaymentRepository extends SuperRepository<Payment, String>{
    List<Payment> findReservationPayment(String reservationId);
}
