package com.chamodshehanka.rentLioServer.resources;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.testing.ServiceRegistryBuilder;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;

    static {
        Configuration configuration = new Configuration().configure();
//        standardServiceRegistry = new ServiceRegistryBuilder().
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }
}
