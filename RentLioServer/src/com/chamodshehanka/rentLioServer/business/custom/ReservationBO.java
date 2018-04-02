package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.dto.ReceptionDTO;
import com.chamodshehanka.rentLioCommon.dto.ReservationDTO;
import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface ReservationBO extends SuperBO{

    public boolean addReservation(ReservationDTO reservationDTO, VehicleDTO vehicleDTO, DriverDTO driverDTO)throws Exception;

    public boolean updateReservation(ReservationDTO reservationDTO)throws Exception;

    public boolean deleteReservation(String reservationId)throws Exception;

    public ReservationDTO getReservationById(String reservationId)throws Exception;

    public List<ReservationDTO> getAllReservations()throws Exception;

    public List<ReservationDTO> findReservationCustomer(String customerId)throws Exception;

}
