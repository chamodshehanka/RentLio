package com.chamodshehanka.rentLioServer.repository;

import org.hibernate.Session;

import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public interface SuperRepository<T, ID> {

    public void setSession(Session session)throws Exception;

    public boolean save(T t)throws Exception;

    public void delete(T t)throws Exception;

    public boolean update(T t)throws Exception;

    public T findById(ID id)throws Exception;

    public List<T> findAll() throws Exception;

}
