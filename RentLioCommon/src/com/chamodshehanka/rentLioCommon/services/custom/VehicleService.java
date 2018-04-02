package com.chamodshehanka.rentLioCommon.services.custom;

import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioCommon.observer.VehicleObserver;
import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface VehicleService extends SuperService{

    public boolean addVehicle(VehicleDTO vehicleDTO)throws Exception;

    public boolean updateVehicle(VehicleDTO vehicleDTO)throws Exception;

    public boolean deleteVehicle(String vehicleId)throws Exception;

    public VehicleDTO getByVehicleId(String vehicleId)throws Exception;

    public List<VehicleDTO> getAllVehicles()throws Exception;

    public boolean addVehicleObserver(VehicleObserver vehicleObserver)throws Exception;

    public boolean removeVehicleObserver(VehicleObserver vehicleObserver)throws Exception;

}
