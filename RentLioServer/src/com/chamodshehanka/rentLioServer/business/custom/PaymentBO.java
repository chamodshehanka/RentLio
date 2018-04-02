package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.PaymentDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface PaymentBO extends SuperBO{

    public boolean addPayment(PaymentDTO paymentDTO)throws Exception;

    public boolean updatePayment(PaymentDTO paymentDTO)throws Exception;

    public boolean deletePayment(String paymentId)throws Exception;

    public PaymentDTO getPaymentById(String paymentId)throws Exception;

    public List<PaymentDTO> getAllPayments()throws Exception;

    List<PaymentDTO> findReservationPayment(String reservationId)throws Exception;

}
