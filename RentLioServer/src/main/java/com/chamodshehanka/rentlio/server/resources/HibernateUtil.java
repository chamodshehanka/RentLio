package com.chamodshehanka.rentlio.server.resources;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure(
                    "/config/hibernate.cfg.xml"
            ).buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
