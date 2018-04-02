package com.chamodshehanka.rentLioCommon.services.custom;

import com.chamodshehanka.rentLioCommon.dto.PaymentDTO;
import com.chamodshehanka.rentLioCommon.observer.PaymentObserver;
import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface PaymentService extends SuperService{

    public boolean addPayment(PaymentDTO paymentDTO) throws Exception;

    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception;

    public boolean deletePayment(String payment) throws Exception;

    public PaymentDTO findByIdPayment(String id) throws Exception;

    public List<PaymentDTO> getAllPayment() throws Exception;

    public boolean addPaymentObserver(PaymentObserver paymentObserver) throws Exception;

    public boolean removePaymentObserver(PaymentObserver paymentObserver) throws Exception;

    List<PaymentDTO> findReservationPayment(String reservationId) throws Exception;

}
