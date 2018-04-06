package com.chamodshehanka.rentLioServer.resources;

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
                    "/com/chamodshehanka/rentLioServer/config/hibernate.cfg.xml"
            ).buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
