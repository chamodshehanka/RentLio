package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface BranchBO extends SuperBO{

    public boolean addBranch(BranchDTO branchDTO)throws Exception;

    public boolean updateBranch(BranchDTO branchDTO)throws Exception;

    public boolean deleteBranch(String branchId)throws Exception;

    public BranchDTO getBranchById(String branchId)throws Exception;

    public List<BranchDTO> getAllBranches()throws Exception;

}
