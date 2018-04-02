package com.chamodshehanka.rentLioServer.repository.custom.impl;

import com.chamodshehanka.rentLioServer.entity.Payment;
import com.chamodshehanka.rentLioServer.repository.custom.PaymentRepository;
import com.chamodshehanka.rentLioServer.repository.impl.SuperRepositoryImpl;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class PaymentRepositoryImpl extends SuperRepositoryImpl<Payment, String> implements PaymentRepository{
    @Override
    public List<Payment> findReservationPayment(String reservationId) {
        return null;
    }
}
