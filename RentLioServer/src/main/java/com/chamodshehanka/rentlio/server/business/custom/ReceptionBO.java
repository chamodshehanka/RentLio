package com.chamodshehanka.rentlio.server.business.custom;

import com.chamodshehanka.rentlio.common.dto.ReceptionDTO;
import com.chamodshehanka.rentlio.server.business.SuperBO;

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
