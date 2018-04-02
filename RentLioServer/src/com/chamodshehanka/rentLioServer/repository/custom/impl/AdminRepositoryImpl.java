package com.chamodshehanka.rentLioServer.repository.custom.impl;

import com.chamodshehanka.rentLioServer.entity.Admin;
import com.chamodshehanka.rentLioServer.repository.custom.AdminRepository;
import com.chamodshehanka.rentLioServer.repository.impl.SuperRepositoryImpl;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class AdminRepositoryImpl extends SuperRepositoryImpl<Admin, String> implements AdminRepository{

    public AdminRepositoryImpl(){
        System.out.println("Admin Repository IMPL : " + this);
    }

}
