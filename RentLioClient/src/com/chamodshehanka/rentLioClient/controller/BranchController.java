package com.chamodshehanka.rentLioClient.controller;

import com.chamodshehanka.rentLioClient.proxy.ProxyHandler;
import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.custom.BranchService;

import java.util.List;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class BranchController {

    public static boolean addBranch(BranchDTO branchDTO)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.addBranch(branchDTO);
    }

    public static boolean updateBranch(BranchDTO branchDTO)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.updateBranch(branchDTO);
    }

    public static BranchDTO getBranchById(String branchId)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.findByIdBranch(branchId);
    }

    public static boolean deleteBranch(String branchId)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.deleteBranch(branchId);
    }

    public static List<BranchDTO> getAllBranches()throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.getAllBranches();
    }

    public static boolean reserveBranch(String branchId)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.reserve(branchId);
    }

    public static boolean releaseBranch(String branchId)throws Exception{
        BranchService branchService = (BranchService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.BRANCH);
        return branchService.release(branchId);
    }

}
