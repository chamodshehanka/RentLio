package com.chamodshehanka.rentLioClient.controller;

import com.chamodshehanka.rentLioClient.proxy.ProxyHandler;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.ReservationDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioCommon.observer.ReservationObserver;
import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.custom.ReservationService;

import java.util.List;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class ReservationController {

    public static boolean addReservation(ReservationDTO reservationDTO, VehicleDTO vehicleDTO, DriverDTO driverDTO)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.addReservation(reservationDTO, vehicleDTO, driverDTO);
    }

    public static boolean updateReservation(ReservationDTO reservationDTO)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.updateReservation(reservationDTO);
    }

    public static ReservationDTO getReservationById(String reservationId)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.findById(reservationId);
    }

    public static boolean deleteReservation(String reservationId)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.deleteReservation(reservationId);
    }

    public static List<ReservationDTO> getAllReservations()throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.getAllReservations();
    }

    public static boolean addReservationObserver(ReservationObserver reservationObserver)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.addReservationObserver(reservationObserver);
    }

    public static boolean removeReservationObserver(ReservationObserver reservationObserver)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.removeReservationObserver(reservationObserver);
    }

    public static List<ReservationDTO> findCustomerReservation(String customerId)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.findCustomerReservation(customerId);
    }

    public static boolean reserveReservation(String reservationId)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.reserve(reservationId);
    }

    public static boolean releaseReservation(String reservationId)throws Exception{
        ReservationService reservationService = (ReservationService) ProxyHandler
                .getInstance().getService(ServicesFactory.ServicesType.RESERVATION);
        return reservationService.release(reservationId);
    }

}
