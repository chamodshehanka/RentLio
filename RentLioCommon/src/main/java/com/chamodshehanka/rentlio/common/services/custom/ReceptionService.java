package com.chamodshehanka.rentlio.common.services.custom;

import com.chamodshehanka.rentlio.common.dto.ReceptionDTO;
import com.chamodshehanka.rentlio.common.observer.ReceptionObserver;
import com.chamodshehanka.rentlio.common.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface ReceptionService extends SuperService{

    public boolean addReception(ReceptionDTO receptionDTO)throws Exception;

    public boolean updateReception(ReceptionDTO receptionDTO)throws Exception;

    public boolean removeReception(String receptionId)throws Exception;

    public ReceptionDTO getById(String receptionId)throws Exception;

    public List<ReceptionDTO> getAllReceptions()throws Exception;

    public boolean addReceptionObserver(ReceptionObserver receptionObserver)throws Exception;

    public boolean removeReceptionObserver(ReceptionObserver receptionObserver)throws Exception;

}
