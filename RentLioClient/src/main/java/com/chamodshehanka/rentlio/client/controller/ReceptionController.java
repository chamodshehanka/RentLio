package com.chamodshehanka.rentlio.client.controller;

import com.chamodshehanka.rentlio.client.proxy.ProxyHandler;
import com.chamodshehanka.rentlio.common.dto.ReceptionDTO;
import com.chamodshehanka.rentlio.common.observer.ReceptionObserver;
import com.chamodshehanka.rentlio.common.services.ServicesFactory;
import com.chamodshehanka.rentlio.common.services.custom.ReceptionService;

import java.util.List;

/**
 * @author chamodshehanka on 4/6/2018
 * @project RentLio
 **/
public class ReceptionController {

    public static boolean addReception(ReceptionDTO receptionDTO)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.addReception(receptionDTO);
    }

    public static boolean updateReception(ReceptionDTO receptionDTO)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.updateReception(receptionDTO);
    }

    public static boolean deleteReception(String receptionId)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.removeReception(receptionId);
    }

    public static ReceptionDTO findById(String receptionId)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.getById(receptionId);
    }

    public static List<ReceptionDTO> getAllReceptions()throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.getAllReceptions();
    }

    public static boolean addReceptionObserver(ReceptionObserver receptionObserver)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.addReceptionObserver(receptionObserver);
    }

    public static boolean removeReceptionObserver(ReceptionObserver receptionObserver)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.removeReceptionObserver(receptionObserver);
    }

    public static boolean reserveReception(String receptionId)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.reserve(receptionId);
    }

    public static boolean releaseReception(String receptionId)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.RECEPTION);
        return receptionService.release(receptionId);
    }

}
