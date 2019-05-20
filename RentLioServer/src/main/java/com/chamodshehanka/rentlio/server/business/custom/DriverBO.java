package com.chamodshehanka.rentlio.server.business.custom;

import com.chamodshehanka.rentlio.common.dto.DriverDTO;
import com.chamodshehanka.rentlio.server.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface DriverBO extends SuperBO{

    public boolean addDriver(DriverDTO driverDTO)throws Exception;

    public boolean updateDriver(DriverDTO driverDTO)throws Exception;

    public boolean deleteDriver(String driverId)throws Exception;

    public DriverDTO getDriverById(String driverId)throws Exception;

    public List<DriverDTO> getAllDrivers()throws Exception;

}
