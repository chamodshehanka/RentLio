package com.chamodshehanka.rentLioServer.repository.impl;

import com.chamodshehanka.rentLioServer.repository.SuperRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        entityClass = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
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
    public void update(T t) throws Exception {
        session.update(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery("FROM " + entityClass.getSimpleName()).list();
    }

    @Override
    public String getListId(String rowName) throws Exception {
        Query query = session
                .createQuery("SELECT" + rowName + "FROM" + entityClass.getSimpleName() + "ORDER BY" + rowName + "DESC");

        String lastId = null;
        List list = query.list();
        if (list.size() > 0){
            lastId = (String) list.get(0);
        }else {
            lastId = "[]";
        }

        if (lastId.equals("[]")){
            lastId = "";
        }
        System.out.println("Last ID : " + lastId);
        return lastId;
    }
}
