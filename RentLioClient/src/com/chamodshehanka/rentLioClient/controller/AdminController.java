package com.chamodshehanka.rentLioClient.controller;

import com.chamodshehanka.rentLioClient.proxy.ProxyHandler;
import com.chamodshehanka.rentLioCommon.dto.AdminDTO;
import com.chamodshehanka.rentLioCommon.observer.AdminObserver;
import com.chamodshehanka.rentLioCommon.services.ServicesFactory;
import com.chamodshehanka.rentLioCommon.services.custom.AdminService;

import java.util.List;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class AdminController {

    public static boolean addAdmin(AdminDTO adminDTO)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.addAdmin(adminDTO);
    }

    public static boolean updateAdmin(AdminDTO adminDTO)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.updateAdmin(adminDTO);
    }

    public static boolean deleteAdmin(String adminId)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.deleteAdmin(adminId);
    }

    public static AdminDTO findAdminById(String adminId)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.findByIdAdmin(adminId);
    }

    public static List<AdminDTO> getAllAdmins()throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.getAllAdmins();
    }

    public static boolean addAdminObserver(AdminObserver adminObserver)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.addAdminObserver(adminObserver);
    }

    public static boolean removeAdminObserver(AdminObserver adminObserver)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.removeAdminObserver(adminObserver);
    }

    public static boolean reserveAdmin(String adminId)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.reserve(adminId);
    }

    public static boolean releaseAdmin(String adminId)throws Exception{
        AdminService adminService = (AdminService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.ADMIN);
        return adminService.release(adminId);
    }

}
