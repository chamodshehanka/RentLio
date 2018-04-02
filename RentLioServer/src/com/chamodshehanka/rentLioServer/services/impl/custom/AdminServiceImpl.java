package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.AdminDTO;
import com.chamodshehanka.rentLioCommon.observer.AdminObserver;
import com.chamodshehanka.rentLioCommon.services.custom.AdminService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.AdminBO;
import com.chamodshehanka.rentLioServer.observable.AdminObservable;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public class AdminServiceImpl extends UnicastRemoteObject implements AdminService{

    private AdminBO adminBO;
    private static final AdminObservable ADMIN_OBSERVABLE = new AdminObservable();
    private static ReservationImpl<AdminService> adminServiceReservation = new ReservationImpl<>();

    public AdminServiceImpl() throws RemoteException {
        adminBO = (AdminBO) BOFactory.getInstance().getBOFactory(
                BOFactory.BOTypes.ADMIN
        );
    }

    @Override
    public boolean addAdmin(AdminDTO adminDTO) throws Exception {
        return adminBO.addAdmin(adminDTO);
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) throws Exception {
        return adminBO.updateAdmin(adminDTO);
    }

    @Override
    public boolean deleteAdmin(String adminId) throws Exception {
        return adminBO.deleteAdmin(adminId);
    }

    @Override
    public AdminDTO findByIdAdmin(String adminId) throws Exception {
        return adminBO.getAdminById(adminId);
    }

    @Override
    public List<AdminDTO> getAllAdmins() throws Exception {
        return adminBO.getAllAdmins();
    }

    @Override
    public boolean addAdminObserver(AdminObserver adminObserver) throws Exception {
        return ADMIN_OBSERVABLE.addAdminObserver(adminObserver);
    }

    @Override
    public boolean removeAdminObserver(AdminObserver adminObserver) throws Exception {
        return ADMIN_OBSERVABLE.removeAdminObserver(adminObserver);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return adminServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return adminServiceReservation.release(id);
    }
}
