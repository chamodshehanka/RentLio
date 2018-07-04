package com.chamodshehanka.rentLioClient.proxy;

import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.SuperService;
import com.chamodshehanka.rentLioCommon.services.custom.*;

import java.rmi.Naming;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class ProxyHandler implements ServicesFactory {

    private static ProxyHandler proxyHandler;
    private CustomerService customerService;
    private VehicleService vehicleService;
    private BranchService branchService;
    private DriverService driverService;
    private ReceptionService receptionService;
    private AdminService adminService;
    private ReservationService reservationService;
    private PaymentService paymentService;

    private ProxyHandler() {
        try {
            ServicesFactory servicesFactory = (ServicesFactory) Naming.lookup("rmi://localhost:5050/rentLio");
            customerService = (CustomerService) servicesFactory.getService(ServicesType.CUSTOMER);
            vehicleService = (VehicleService) servicesFactory.getService(ServicesType.VEHICLE);
            branchService = (BranchService) servicesFactory.getService(ServicesType.BRANCH);
            driverService = (DriverService) servicesFactory.getService(ServicesType.DRIVER);
            receptionService = (ReceptionService) servicesFactory.getService(ServicesType.RECEPTION);
            adminService = (AdminService) servicesFactory.getService(ServicesType.ADMIN);
            reservationService = (ReservationService) servicesFactory.getService(ServicesType.RESERVATION);
            paymentService = (PaymentService) servicesFactory.getService(ServicesType.PAYMENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProxyHandler getInstance(){
        if (proxyHandler == null)
            proxyHandler = new ProxyHandler();
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServicesType servicesType) {
        switch (servicesType){
            case ADMIN : return adminService;
            case VEHICLE : return vehicleService;
            case BRANCH : return branchService;
            case CUSTOMER : return customerService;
            case DRIVER : return driverService;
            case PAYMENT : return paymentService;
            case RECEPTION : return receptionService;
            case RESERVATION : return reservationService;
            default : return null;
        }
    }
}
