package com.chamodshehanka.rentLioClient.util;

import com.chamodshehanka.rentLioClient.controller.*;
import com.chamodshehanka.rentLioCommon.dto.*;

import java.util.Collections;
import java.util.List;

/**
 * @author chamodshehanka on 4/12/2018
 * @project RentLio
 **/
public class IDController {

    public static String getLastID(String tblName, String colName) throws Exception {

        List list;
        AdminDTO adminDTO;
        BranchDTO branchDTO;
        CustomerDTO customerDTO;
        DriverDTO driverDTO;
        PaymentDTO paymentDTO;
        ReceptionDTO receptionDTO;
        ReservationDTO reservationDTO;
        VehicleDTO vehicleDTO;

        String lastId = null;

        switch (tblName){
            case "admin" : list = AdminController.getAllAdmins();
                Collections.sort(list);
                adminDTO = (AdminDTO) list.get(0);
                lastId = adminDTO.getAdminId();
                break;
            case "branch": list = BranchController.getAllBranches();
                Collections.sort(list);
                branchDTO = (BranchDTO) list.get(0);
                lastId = branchDTO.getBranchId();
                break;
            case "customer": list = CustomerController.getAllCustomers();
                Collections.sort(list);
                customerDTO = (CustomerDTO) list.get(0);
                lastId = customerDTO.getCustomerId();
                break;
            case "driver":list = DriverController.getAllDrivers();
                Collections.sort(list);
                driverDTO = (DriverDTO) list.get(0);
                lastId = driverDTO.getDriverId();
                break;
            case "payment":list = PaymentController.getAllPayments();
                Collections.sort(list);
                paymentDTO = (PaymentDTO) list.get(0);
                lastId = paymentDTO.getPaymentId();
                break;
            case "reception":list = ReceptionController.getAllReceptions();
                Collections.sort(list);
                receptionDTO = (ReceptionDTO) list.get(0);
                lastId = receptionDTO.getReceptionId();
                break;
            case "reservation":list = ReservationController.getAllReservations();
                Collections.sort(list);
                reservationDTO = (ReservationDTO) list.get(0);
                lastId = reservationDTO.getReservationId();
                break;
            case "vehicle":list = VehicleController.getAllVehicles();
                Collections.sort(list);
                vehicleDTO = (VehicleDTO) list.get(0);
                lastId = vehicleDTO.getVehicleNumber();
                break;
            default:
                System.out.println("Invalid table");

        }

        return lastId;
    }

}
