package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface VehicleBO extends SuperBO{

    public boolean addVehicle(VehicleDTO vehicleDTO)throws Exception;

    public boolean updateVehicle(VehicleDTO vehicleDTO)throws Exception;

    public boolean deleteVehicle(String vehicleId)throws Exception;

    public VehicleDTO getVehicleById(String vehicleId)throws Exception;

    public List<VehicleDTO> getAllVehicles()throws Exception;

}
