package com.chamodshehanka.rentLioServer.reservation;

import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class ReservationImpl <T extends SuperService> {

    private static class ResPage<T> {

        private T service;
        private boolean internally;

        public ResPage(T service, boolean internally){
            this.service = service;
            this.internally = internally;
        }

        public T getService() {
            return service;
        }

        public void setService(T service) {
            this.service = service;
        }

        public boolean isInternally() {
            return internally;
        }

        public void setInternally(boolean internally) {
            this.internally = internally;
        }
    }

    private Map<Object, ResPage<T>> resBook = new HashMap<>();

    public boolean reserve(Object key, T service, boolean internally){
        if (resBook.containsKey(key)){
            return resBook.get(key).service == service;
        }else {
            resBook.put(key, new ResPage<>(service, internally));
            return true;
        }
    }

    public boolean isReservedInternally(Object key){
        if (resBook.containsKey(key)){
            resBook.remove(key);
            return true;
        }else {
            return false;
        }
    }

    public boolean release(Object key){
        if (resBook.containsKey(key)){
            resBook.remove(key);
            return true;
        }else {
            return false;
        }
    }

}
