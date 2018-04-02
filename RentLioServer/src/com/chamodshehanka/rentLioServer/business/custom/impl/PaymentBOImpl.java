package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.PaymentDTO;
import com.chamodshehanka.rentLioServer.business.custom.PaymentBO;
import com.chamodshehanka.rentLioServer.entity.Payment;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.PaymentRepository;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 3/29/2018
 * @project RentLio
 **/
public class PaymentBOImpl implements PaymentBO {

    private PaymentRepository paymentRepository;

    public PaymentBOImpl(){
        paymentRepository = (PaymentRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.PAYMENT);
    }

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            paymentRepository.setSession(session);

            Payment payment = new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getReservationId(),
                    paymentDTO.getDate(),
                    paymentDTO.getCustomerId(),
                    paymentDTO.getCarNo(),
                    paymentDTO.getReceptionId(),
                    paymentDTO.getDriverId(),
                    paymentDTO.getDriverPayment(),
                    paymentDTO.getDeposit(),
                    paymentDTO.getDamage(),
                    paymentDTO.getAfterKM(),
                    paymentDTO.getExtraKMPrice(),
                    paymentDTO.getPaymentDay(),
                    paymentDTO.getTotalPrice(),
                    paymentDTO.getDiscount(),
                    paymentDTO.getTotalLastPrice()
            );

            boolean result = paymentRepository.save(payment);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            paymentRepository.setSession(session);

            Payment payment = new Payment(
                    paymentDTO.getPaymentId(),
                    paymentDTO.getReservationId(),
                    paymentDTO.getDate(),
                    paymentDTO.getCustomerId(),
                    paymentDTO.getCarNo(),
                    paymentDTO.getReceptionId(),
                    paymentDTO.getDriverId(),
                    paymentDTO.getDriverPayment(),
                    paymentDTO.getDeposit(),
                    paymentDTO.getDamage(),
                    paymentDTO.getAfterKM(),
                    paymentDTO.getExtraKMPrice(),
                    paymentDTO.getPaymentDay(),
                    paymentDTO.getTotalPrice(),
                    paymentDTO.getDiscount(),
                    paymentDTO.getTotalLastPrice()
            );

             paymentRepository.update(payment);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePayment(String paymentId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            paymentRepository.setSession(session);

            Payment payment = paymentRepository.findById(paymentId);
            if (payment != null){
                paymentRepository.delete(payment);
                session.getTransaction().commit();
                return true;
            }else
                return false;
        }
    }

    @Override
    public PaymentDTO getPaymentById(String paymentId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            paymentRepository.setSession(session);

            Payment payment = paymentRepository.findById(paymentId);
            if (payment != null){
                return new PaymentDTO(
                        payment.getPaymentId(),
                        payment.getReservationId(),
                        payment.getDate(),
                        payment.getCustomerId(),
                        payment.getCarNo(),
                        payment.getReceptionId(),
                        payment.getDriverId(),
                        payment.getDriverPayment(),
                        payment.getDeposit(),
                        payment.getDamage(),
                        payment.getAfterKM(),
                        payment.getExtraKMPrice(),
                        payment.getPaymentDay(),
                        payment.getTotalPrice(),
                        payment.getDiscount(),
                        payment.getTotalLastPrice()
                );
            }else
                return null;
        }
    }

    @Override
    public List<PaymentDTO> getAllPayments() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            paymentRepository.setSession(session);

            List<Payment> paymentList = paymentRepository.findAll();
            session.getTransaction().commit();
            if (paymentList != null){
                List<PaymentDTO> paymentDTOList = new ArrayList<>();
                for (Payment payment: paymentList
                     ) {
                    paymentDTOList.add(
                            new PaymentDTO(
                            payment.getPaymentId(),
                            payment.getReservationId(),
                            payment.getDate(),
                            payment.getCustomerId(),
                            payment.getCarNo(),
                            payment.getReceptionId(),
                            payment.getDriverId(),
                            payment.getDriverPayment(),
                            payment.getDeposit(),
                            payment.getDamage(),
                            payment.getAfterKM(),
                            payment.getExtraKMPrice(),
                            payment.getPaymentDay(),
                            payment.getTotalPrice(),
                            payment.getDiscount(),
                            payment.getTotalLastPrice()
                            ));
                }
                return paymentDTOList;
            }else {
                return null;
            }
        }
    }

    @Override
    public List<PaymentDTO> findReservationPayment(String reservationId) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            paymentRepository.setSession(session);
            session.beginTransaction();

            List<Payment> paymentList = paymentRepository.findReservationPayment(reservationId);
            session.getTransaction().commit();
            if (paymentList != null){
                List<PaymentDTO> paymentDTOList = new ArrayList<>();

                for (Payment payment: paymentList
                     ) {
                    paymentDTOList.add(
                            new PaymentDTO(
                                    payment.getPaymentId(),
                                    payment.getReservationId(),
                                    payment.getDate(),
                                    payment.getCustomerId(),
                                    payment.getCarNo(),
                                    payment.getReceptionId(),
                                    payment.getDriverId(),
                                    payment.getDriverPayment(),
                                    payment.getDeposit(),
                                    payment.getDamage(),
                                    payment.getAfterKM(),
                                    payment.getExtraKMPrice(),
                                    payment.getPaymentDay(),
                                    payment.getTotalPrice(),
                                    payment.getDiscount(),
                                    payment.getTotalLastPrice()
                            )
                    );
                }
                return paymentDTOList;
            }else {
                System.out.println();
                return null;
            }
        }
    }
}
