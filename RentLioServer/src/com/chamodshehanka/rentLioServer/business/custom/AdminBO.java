package com.chamodshehanka.rentLioServer.business.custom;

import com.chamodshehanka.rentLioCommon.dto.AdminDTO;
import com.chamodshehanka.rentLioServer.business.SuperBO;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface AdminBO extends SuperBO{

    public boolean addAdmin(AdminDTO adminDTO)throws Exception;

    public boolean updateAdmin(AdminDTO adminDTO)throws Exception;

    public boolean deleteAdmin(String adminId)throws Exception;

    public AdminDTO getAdminById(String adminId)throws Exception;

    public List<AdminDTO> getAllAdmins()throws Exception;

}
