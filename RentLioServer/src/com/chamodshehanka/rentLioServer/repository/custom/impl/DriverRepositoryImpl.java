package com.chamodshehanka.rentLioServer.repository.custom.impl;

import com.chamodshehanka.rentLioServer.entity.Driver;
import com.chamodshehanka.rentLioServer.repository.custom.DriverRepository;
import com.chamodshehanka.rentLioServer.repository.impl.SuperRepositoryImpl;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class DriverRepositoryImpl extends SuperRepositoryImpl<Driver, String> implements DriverRepository{

    private Session session;
    private Class<Driver> driverClass;

    /*public DriverRepositoryImpl() {
        driverClass = (Class<Driver>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }*/

    /*@Override
    public boolean updateDriver(Driver driver) throws Exception {
        session.update(driver);
        return true;
    }*/

    /*@Override
    public void setSession(Session session) throws Exception {
        this.session = session;
    }*/
}
