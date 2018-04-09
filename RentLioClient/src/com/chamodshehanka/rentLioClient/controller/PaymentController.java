package com.chamodshehanka.rentLioClient.controller;

import com.chamodshehanka.rentLioClient.proxy.ProxyHandler;
import com.chamodshehanka.rentLioCommon.dto.PaymentDTO;
import com.chamodshehanka.rentLioCommon.observer.PaymentObserver;
import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.custom.PaymentService;

import java.util.List;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class PaymentController {

    public static boolean addPayment(PaymentDTO paymentDTO)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.addPayment(paymentDTO);
    }

    public static PaymentDTO getPaymentById(String paymentId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.findByIdPayment(paymentId);
    }

    public static boolean updatePayment(PaymentDTO paymentDTO)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.updatePayment(paymentDTO);
    }

    public static boolean deletePayment(String paymentId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.deletePayment(paymentId);
    }

    public static List<PaymentDTO> getAllPayments()throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.getAllPayment();
    }

    public static boolean addPaymentObserver(PaymentObserver paymentObserver)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.addPaymentObserver(paymentObserver);
    }

    public static boolean removePaymentObserver(PaymentObserver paymentObserver)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.removePaymentObserver(paymentObserver);
    }

    public static boolean reservePayment(String paymentId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.reserve(paymentId);
    }

    public static boolean releasePayment(String paymentId)throws Exception{
        PaymentService paymentService = (PaymentService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.PAYMENT);
        return paymentService.release(paymentId);
    }

}
