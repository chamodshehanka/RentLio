package com.chamodshehanka.rentlio.client.controller;

import com.chamodshehanka.rentlio.client.proxy.ProxyHandler;
import com.chamodshehanka.rentlio.common.dto.VehicleDTO;
import com.chamodshehanka.rentlio.common.observer.VehicleObserver;
import com.chamodshehanka.rentlio.common.services.ServicesFactory;
import com.chamodshehanka.rentlio.common.services.custom.VehicleService;

import java.util.List;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class VehicleController {

    public static boolean addVehicle(VehicleDTO vehicleDTO)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.addVehicle(vehicleDTO);
    }

    public static boolean updateVehicle(VehicleDTO vehicleDTO)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.updateVehicle(vehicleDTO);
    }

    public static VehicleDTO getVehicleById(String vehicleId)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.getByVehicleId(vehicleId);
    }

    public static boolean deleteVehicle(String vehicleId)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.deleteVehicle(vehicleId);
    }

    public static List<VehicleDTO> getAllVehicles()throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.getAllVehicles();
    }

    public static boolean addVehicleObserver(VehicleObserver vehicleObserver)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.addVehicleObserver(vehicleObserver);
    }

    public static boolean removeVehicleObserver(VehicleObserver vehicleObserver)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.removeVehicleObserver(vehicleObserver);
    }

    public static boolean reserveVehicle(String vehicleId)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.reserve(vehicleId);
    }

    public static boolean releaseVehicle(String vehicleId)throws Exception{
        VehicleService vehicleService = (VehicleService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.VEHICLE);
        return vehicleService.release(vehicleId);
    }

}
