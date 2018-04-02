package com.chamodshehanka.rentLioServer.services.impl.custom;

import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioCommon.services.custom.BranchService;
import com.chamodshehanka.rentLioServer.business.BOFactory;
import com.chamodshehanka.rentLioServer.business.custom.BranchBO;
import com.chamodshehanka.rentLioServer.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class BranchServiceImpl extends UnicastRemoteObject implements BranchService{

    private BranchBO branchBO;
    private static ReservationImpl<BranchService> branchServiceReservation = new ReservationImpl<>();

    public BranchServiceImpl() throws RemoteException {
        branchBO = (BranchBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.BRANCH);
    }

    @Override
    public boolean addBranch(BranchDTO branchDTO) throws Exception {
        return branchBO.addBranch(branchDTO);
    }

    @Override
    public boolean updateBranch(BranchDTO branchDTO) throws Exception {
        return branchBO.updateBranch(branchDTO);
    }

    @Override
    public boolean deleteBranch(String branchId) throws Exception {
        return branchBO.deleteBranch(branchId);
    }

    @Override
    public BranchDTO findByIdBranch(String branchId) throws Exception {
        return branchBO.getBranchById(branchId);
    }

    @Override
    public List<BranchDTO> getAllBranches() throws Exception {
        return branchBO.getAllBranches();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return branchServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return branchServiceReservation.release(id);
    }
}
