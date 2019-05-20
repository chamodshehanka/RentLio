package com.chamodshehanka.rentlio.common.services.custom;

import com.chamodshehanka.rentlio.common.dto.DriverDTO;
import com.chamodshehanka.rentlio.common.dto.ReservationDTO;
import com.chamodshehanka.rentlio.common.dto.VehicleDTO;
import com.chamodshehanka.rentlio.common.observer.ReservationObserver;
import com.chamodshehanka.rentlio.common.services.SuperService;

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
