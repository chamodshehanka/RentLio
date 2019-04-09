package com.chamodshehanka.rentlio.server.repository.custom.impl;

import com.chamodshehanka.rentlio.server.entity.Admin;
import com.chamodshehanka.rentlio.server.repository.custom.AdminRepository;
import com.chamodshehanka.rentlio.server.repository.impl.SuperRepositoryImpl;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class AdminRepositoryImpl extends SuperRepositoryImpl<Admin, String> implements AdminRepository {

    public AdminRepositoryImpl(){
        System.out.println("Admin Repository IMPL : " + this);
    }

}
