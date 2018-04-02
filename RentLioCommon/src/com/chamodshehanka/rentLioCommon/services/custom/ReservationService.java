package com.chamodshehanka.rentLioCommon.services.custom;

import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.ReservationDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioCommon.observer.ReservationObserver;
import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface ReservationService extends SuperService{

    public boolean addReservation(ReservationDTO reservationDTO, VehicleDTO vehicleDTO, DriverDTO driverDTO)throws Exception;

    public boolean updateReservation(ReservationDTO reservationDTO)throws Exception;

    public boolean deleteReservation(String reservationId)throws Exception;

    public ReservationDTO findById(String reservationId)throws Exception;

    public List<ReservationDTO> getAllReservations()throws Exception;

    public boolean addReservationObserver(ReservationObserver reservationObserver)throws Exception;

    public boolean removeReservationObserver(ReservationObserver reservationObserver)throws Exception;

    public List<ReservationDTO> findCustomerReservation(String customerId)throws Exception;

}
