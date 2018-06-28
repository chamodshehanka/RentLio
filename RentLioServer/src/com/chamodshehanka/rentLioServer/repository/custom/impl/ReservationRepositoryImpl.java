package com.chamodshehanka.rentLioServer.repository.custom.impl;

import com.chamodshehanka.rentLioServer.entity.Reservation;
import com.chamodshehanka.rentLioServer.repository.custom.ReservationRepository;
import com.chamodshehanka.rentLioServer.repository.impl.SuperRepositoryImpl;
import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class ReservationRepositoryImpl extends SuperRepositoryImpl<Reservation, String> implements ReservationRepository{

    private Session session;
    private Class<Reservation> reservationClass;

    public ReservationRepositoryImpl() {
        reservationClass = (Class<Reservation>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public List findCustomerRepository(String customerId) {
        List list = session.createQuery("from "+reservationClass.getSimpleName()+" where=customerId'" + customerId + "'").list();
        if (list != null){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public void setSession(Session session){
        this.session = session;
    }
}
