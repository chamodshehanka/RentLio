package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.PaymentDTO;
import com.chamodshehanka.rentLioCommon.observer.PaymentObserver;
import com.chamodshehanka.rentLioCommon.services.custom.PaymentService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.PaymentBO;
import com.chamodshehanka.rentLioServer.observable.AdminObservable;
import com.chamodshehanka.rentLioServer.observable.PaymentObservable;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class PaymentServiceImpl extends UnicastRemoteObject implements PaymentService{

    private PaymentBO paymentBO;
    private static ReservationImpl<PaymentService> paymentServiceReservation = new ReservationImpl<>();
    private static final PaymentObservable PAYMENT_OBSERVABLE = new PaymentObservable();
    private static final AdminObservable ADMIN_OBSERVABLE = new AdminObservable();

    public PaymentServiceImpl() throws RemoteException {
        paymentBO = (PaymentBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.PAYMENT);
    }

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        return paymentBO.addPayment(paymentDTO);
    }

    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        return paymentBO.updatePayment(paymentDTO);
    }

    @Override
    public boolean deletePayment(String payment) throws Exception {
        return paymentBO.deletePayment(payment);
    }

    @Override
    public PaymentDTO findByIdPayment(String id) throws Exception {
        return paymentBO.getPaymentById(id);
    }

    @Override
    public List<PaymentDTO> getAllPayment() throws Exception {
        return paymentBO.getAllPayments();
    }

    @Override
    public boolean addPaymentObserver(PaymentObserver paymentObserver) throws Exception {
        return PAYMENT_OBSERVABLE.addPaymentObserver(paymentObserver);
    }

    @Override
    public boolean removePaymentObserver(PaymentObserver paymentObserver) throws Exception {
        return PAYMENT_OBSERVABLE.removePaymentObserver(paymentObserver);
    }

    @Override
    public List<PaymentDTO> findReservationPayment(String reservationId) throws Exception {
        return paymentBO.findReservationPayment(reservationId);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return paymentServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return paymentServiceReservation.release(id);
    }
}
