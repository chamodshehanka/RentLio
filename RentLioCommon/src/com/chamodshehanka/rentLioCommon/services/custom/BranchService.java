package com.chamodshehanka.rentLioCommon.services.custom;

import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface BranchService extends SuperService{

    public boolean addBranch(BranchDTO branchDTO)throws Exception;

    public boolean updateBranch(BranchDTO branchDTO) throws Exception;

    public boolean deleteBranch(String branchId) throws Exception;

    public BranchDTO findByIdBranch(String branchId)throws Exception;

    public List<BranchDTO> getAllBranches() throws Exception;

}
