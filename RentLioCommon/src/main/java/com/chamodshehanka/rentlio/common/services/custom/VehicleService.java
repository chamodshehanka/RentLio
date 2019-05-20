package com.chamodshehanka.rentlio.common.services.custom;

import com.chamodshehanka.rentlio.common.dto.VehicleDTO;
import com.chamodshehanka.rentlio.common.observer.VehicleObserver;
import com.chamodshehanka.rentlio.common.services.SuperService;

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
