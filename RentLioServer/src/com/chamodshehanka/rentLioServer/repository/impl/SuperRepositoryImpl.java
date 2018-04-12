package com.chamodshehanka.rentLioServer.repository.impl;

import com.chamodshehanka.rentLioServer.repository.SuperRepository;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class SuperRepositoryImpl <T, ID extends Serializable> implements SuperRepository <T,ID>{

    private Session session;
    private Class<T> entityClass;

    public SuperRepositoryImpl() {
        entityClass = (Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public T findById(ID id) throws Exception {
        return session.get(entityClass, id);
    }

    @Override
    public boolean save(T t) throws Exception {
        return (session.save(t) != null);
    }

    @Override
    public void delete(T t) throws Exception {
        session.delete(t);
    }

    @Override
    public boolean update(T t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery("FROM " + entityClass.getSimpleName()).list();
    }
}
