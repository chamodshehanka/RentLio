package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.ReceptionDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface ReceptionBO extends SuperBO{

    public boolean addReception(ReceptionDTO receptionDTO)throws Exception;

    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;

    public boolean deleteReception(String receptionId)throws Exception;

    public ReceptionDTO getReceptionById(String receptionId)throws Exception;

    public List<ReceptionDTO> getAllReceptions()throws Exception;

}
