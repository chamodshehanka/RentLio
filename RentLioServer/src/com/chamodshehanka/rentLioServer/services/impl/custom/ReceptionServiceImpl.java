package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.ReceptionDTO;
import com.chamodshehanka.rentLioCommon.observer.ReceptionObserver;
import com.chamodshehanka.rentLioCommon.services.custom.ReceptionService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.ReceptionBO;
import com.chamodshehanka.rentLioServer.observable.ReceptionObservable;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService{

    private ReceptionBO receptionBO;
    private static ReservationImpl<ReceptionService> receptionServiceReservation = new ReservationImpl<>();
    private static final ReceptionObservable RECEPTION_OBSERVABLE = new ReceptionObservable();

    public ReceptionServiceImpl() throws RemoteException {
        receptionBO = (ReceptionBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.RECEPTION);
    }

    @Override
    public boolean addReception(ReceptionDTO receptionDTO) throws Exception {
        return receptionBO.addReception(receptionDTO);
    }

    @Override
    public boolean updateReception(ReceptionDTO receptionDTO) throws Exception {
        return receptionBO.updateReception(receptionDTO);
    }

    @Override
    public boolean removeReception(String receptionId) throws Exception {
        return receptionBO.deleteReception(receptionId);
    }

    @Override
    public ReceptionDTO getById(String receptionId) throws Exception {
        return receptionBO.getReceptionById(receptionId);
    }

    @Override
    public List<ReceptionDTO> getAllReceptions() throws Exception {
        return receptionBO.getAllReceptions();
    }

    @Override
    public boolean addReceptionObserver(ReceptionObserver receptionObserver) throws Exception {
        return RECEPTION_OBSERVABLE.addReceptionObserver(receptionObserver);
    }

    @Override
    public boolean removeReceptionObserver(ReceptionObserver receptionObserver) throws Exception {
        return RECEPTION_OBSERVABLE.removeReceptionObserver(receptionObserver);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return receptionServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return receptionServiceReservation.release(id);
    }

}
