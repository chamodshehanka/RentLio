package com.chamodshehanka.rentLioClient.controller;

import com.chamodshehanka.rentLioClient.proxy.ProxyHandler;
import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.custom.DriverService;

import java.util.List;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class DriverController {

    public static boolean addDriver(DriverDTO driverDTO)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.addDriver(driverDTO);
    }

    public static boolean updateDriver(DriverDTO driverDTO)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.updateDriver(driverDTO);
    }

    public static DriverDTO getDriverBy(String driverId)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.findByIdDriver(driverId);
    }

    public static boolean deleteDriver(String driverId)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.deleteDriver(driverId);
    }

    public static List<DriverDTO> getAllDrivers()throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.getAllDrivers();
    }

    public static boolean reserveDriver(String driverId)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.reserve(driverId);
    }

    public static boolean releaseDriver(String driverId)throws Exception{
        DriverService driverService = (DriverService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.DRIVER);
        return driverService.release(driverId);
    }

}
