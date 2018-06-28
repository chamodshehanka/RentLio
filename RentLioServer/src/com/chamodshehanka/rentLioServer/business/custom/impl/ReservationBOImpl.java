package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.ReservationDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioServer.business.custom.ReservationBO;
import com.chamodshehanka.rentLioServer.entity.*;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.*;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 4/1/2018
 * @project RentLio
 **/
public class ReservationBOImpl implements ReservationBO {

    private ReservationRepository reservationRepository;
    private CustomerRepository customerRepository;
    private DriverRepository driverRepository;
    private VehicleRepository vehicleRepository;
    private ReceptionRepository receptionRepository;

    public ReservationBOImpl() {
        reservationRepository = (ReservationRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.RESERVATION);
        customerRepository = (CustomerRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.CUSTOMER);
        driverRepository = (DriverRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.DRIVER);
        vehicleRepository = (VehicleRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.VEHICLE);
        receptionRepository = (ReceptionRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.RECEPTION);
        PaymentRepository paymentRepository = (PaymentRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.PAYMENT);
    }

    @Override
    public boolean addReservation(ReservationDTO reservationDTO, VehicleDTO vehicleDTO, DriverDTO driverDTO) throws Exception {
        Customer customer;
        Driver driver;
        Vehicle vehicle;
        Payment payment = new Payment("PPPP","RRRR","2018-06-28","CCCC","XXXX","RRRR","DDDD",0.0,0.0,0.0,"",0.0,"",0.0,0.0,0.0);
        Reception reception;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            customer = customerRepository.findById(reservationDTO.getCustomerId());
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            driverRepository.setSession(session);
            driver = driverRepository.findById(reservationDTO.getDriverId());
        }
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);
            vehicle = vehicleRepository.findById(reservationDTO.getcNumber());
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            receptionRepository.setSession(session);
            reception = receptionRepository.findById(reservationDTO.getReceptionId());
        }
        Session sessionOuter = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            reservationRepository.setSession(session);
            sessionOuter = session;

            Reservation reservation = new Reservation(
                    reservationDTO.getReservationId(),
                    reservationDTO.getReceptionId(),
                    reservationDTO.getCustomerId(),
                    reservationDTO.getCustomerName(),
                    reservationDTO.getCustomerTel(),
                    reservationDTO.getCustomerNIC(),
                    reservationDTO.getDriverId(),
                    reservationDTO.getDriverName(),
                    reservationDTO.getDriverTel(),
                    reservationDTO.getDriverNIC(),
                    reservationDTO.getcNumber(),
                    reservationDTO.getcType(),
                    reservationDTO.getcBrand(),
                    reservationDTO.getcKmrs(),
                    reservationDTO.getcImage(),
                    reservationDTO.getGetDate(),
                    reservationDTO.getNowMeter(),
                    reservationDTO.getStatus(),
                    reservationDTO.getComment(),
                    reservationDTO.getDeposit(),
                    reservationDTO.getPriceForDay(),
                    customer,
                    driver,
                    vehicle,
                    payment,
                    reception
            );

            if (reservationRepository.save(reservation)){
                vehicle.setStatus("Reserved");
                vehicleRepository.setSession(session);
                vehicleRepository.update(vehicle);

                if (driverDTO != null){
                    driverRepository.setSession(session);
                    driver.setState(driverDTO.getState());
                    if (driverRepository.update(driver)){
                        transaction.commit();
                        return true;
                    }else {
                        transaction.rollback();
                        return false;
                    }
                }else {
                    transaction.rollback();
                    return false;
                }
            }else {
                transaction.rollback();
                return false;
            }
        }finally {
            if (sessionOuter != null) {
                sessionOuter.close();
            }else {
                System.out.println("Outer Session is null !");
            }
        }
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            reservationRepository.setSession(session);
            customerRepository.setSession(session);
            driverRepository.setSession(session);
            vehicleRepository.setSession(session);
            receptionRepository.setSession(session);

            Customer customer = customerRepository.findById(reservationDTO.getCustomerId());
            Driver driver = null;

            if (reservationDTO.getDriverId() != null){
                driver = driverRepository.findById(reservationDTO.getDriverId());
            }

            Vehicle vehicle = vehicleRepository.findById(reservationDTO.getcNumber());
            Payment payment = null;

            Reception reception = receptionRepository.findById(reservationDTO.getReceptionId());

            Reservation reservation = new Reservation(
                    reservationDTO.getReservationId(),
                    reservationDTO.getReceptionId(),
                    reservationDTO.getCustomerId(),
                    reservationDTO.getCustomerName(),
                    reservationDTO.getCustomerTel(),
                    reservationDTO.getCustomerNIC(),
                    reservationDTO.getDriverId(),
                    reservationDTO.getDriverName(),
                    reservationDTO.getDriverTel(),
                    reservationDTO.getDriverNIC(),
                    reservationDTO.getcNumber(),
                    reservationDTO.getcType(),
                    reservationDTO.getcBrand(),
                    reservationDTO.getcKmrs(),
                    reservationDTO.getcImage(),
                    reservationDTO.getGetDate(),
                    reservationDTO.getNowMeter(),
                    reservationDTO.getStatus(),
                    reservationDTO.getComment(),
                    reservationDTO.getDeposit(),
                    reservationDTO.getPriceForDay(),
                    customer,
                    driver,
                    vehicle,
                    payment,
                    reception
            );

            reservationRepository.update(reservation);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteReservation(String reservationId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            reservationRepository.setSession(session);
            session.beginTransaction();

            Reservation reservation = reservationRepository.findById(reservationId);

            if (reservation != null){
                reservationRepository.delete(reservation);
                session.getTransaction().commit();
                System.out.println("\b");
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public ReservationDTO getReservationById(String reservationId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            reservationRepository.setSession(session);
            session.beginTransaction();

            Reservation reservation = reservationRepository.findById(reservationId);
            session.getTransaction().commit();
            if (reservation != null){
                return new ReservationDTO(
                        reservation.getReservationId(),
                        reservation.getReceptionId(),
                        reservation.getCustomerId(),
                        reservation.getCustomerName(),
                        reservation.getCustomerTel(),
                        reservation.getCustomerNIC(),
                        reservation.getDriverId(),
                        reservation.getDriverName(),
                        reservation.getDriverTel(),
                        reservation.getDriverNIC(),
                        reservation.getcNumber(),
                        reservation.getcType(),
                        reservation.getcBrand(),
                        reservation.getcKmrs(),
                        reservation.getcImage(),
                        reservation.getGetDate(),
                        reservation.getNowMeter(),
                        reservation.getStatus(),
                        reservation.getComment(),
                        reservation.getDeposit(),
                        reservation.getPriceForDay()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<ReservationDTO> getAllReservations() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            reservationRepository.setSession(session);
            List<Reservation> reservationList = reservationRepository.findAll();
            session.getTransaction().commit();
            if (reservationList != null){
                List<ReservationDTO> reservationDTOList = new ArrayList<>();

                for (Reservation reservation: reservationList
                     ) {
                    reservationDTOList.add(
                            new ReservationDTO(
                                    reservation.getReservationId(),
                                    reservation.getReceptionId(),
                                    reservation.getCustomerId(),
                                    reservation.getCustomerName(),
                                    reservation.getCustomerTel(),
                                    reservation.getCustomerNIC(),
                                    reservation.getDriverId(),
                                    reservation.getDriverName(),
                                    reservation.getDriverTel(),
                                    reservation.getDriverNIC(),
                                    reservation.getcNumber(),
                                    reservation.getcType(),
                                    reservation.getcBrand(),
                                    reservation.getcKmrs(),
                                    reservation.getcImage(),
                                    reservation.getGetDate(),
                                    reservation.getNowMeter(),
                                    reservation.getStatus(),
                                    reservation.getComment(),
                                    reservation.getDeposit(),
                                    reservation.getPriceForDay()
                            )
                    );
                }
                return reservationDTOList;
            }else {
                return null;
            }
        }
    }

    @Override
    public List<ReservationDTO> findReservationCustomer(String customerId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            reservationRepository.setSession(session);

            List<Reservation> reservationList = reservationRepository.findCustomerRepository(customerId);
            session.getTransaction().commit();

            return reservationToDTO(reservationList);

            /*if (reservationList != null){
                List<ReservationDTO> reservationDTOList = new ArrayList<>();

                for (Reservation reservation: reservationList
                     ) {
                    reservationDTOList.add(
                            new ReservationDTO(
                                    reservation.getReservationId(),
                                    reservation.getReceptionId(),
                                    reservation.getCustomerId(),
                                    reservation.getCustomerName(),
                                    reservation.getCustomerTel(),
                                    reservation.getCustomerNIC(),
                                    reservation.getDriverId(),
                                    reservation.getDriverName(),
                                    reservation.getDriverTel(),
                                    reservation.getDriverNIC(),
                                    reservation.getcNumber(),
                                    reservation.getcType(),
                                    reservation.getcBrand(),
                                    reservation.getcKmrs(),
                                    reservation.getcImage(),
                                    reservation.getGetDate(),
                                    reservation.getNowMeter(),
                                    reservation.getStatus(),
                                    reservation.getComment(),
                                    reservation.getDeposit(),
                                    reservation.getPriceForDay()
                            )
                    );
                }
                return reservationDTOList;
            }else {
                return null;
            }*/
        }
    }

    private List<ReservationDTO> reservationToDTO(List<Reservation> reservationList){
        assert reservationList != null;
        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (Reservation reservation: reservationList
                ) {
            reservationDTOList.add(
                    new ReservationDTO(
                            reservation.getReservationId(),
                            reservation.getReceptionId(),
                            reservation.getCustomerId(),
                            reservation.getCustomerName(),
                            reservation.getCustomerTel(),
                            reservation.getCustomerNIC(),
                            reservation.getDriverId(),
                            reservation.getDriverName(),
                            reservation.getDriverTel(),
                            reservation.getDriverNIC(),
                            reservation.getcNumber(),
                            reservation.getcType(),
                            reservation.getcBrand(),
                            reservation.getcKmrs(),
                            reservation.getcImage(),
                            reservation.getGetDate(),
                            reservation.getNowMeter(),
                            reservation.getStatus(),
                            reservation.getComment(),
                            reservation.getDeposit(),
                            reservation.getPriceForDay()
                    )
            );
        }
        return reservationDTOList;
    }
}
