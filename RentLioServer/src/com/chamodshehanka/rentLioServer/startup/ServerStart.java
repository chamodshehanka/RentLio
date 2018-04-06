package com.chamodshehanka.rentLioServer.startup;

import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import com.chamodshehanka.rentLioServer.services.impl.ServicesFactoryImpl;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chamodshehanka on 3/12/2018
 * @project RentLio
 **/
public class ServerStart {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        try {
            if (HibernateUtil.getSessionFactory().isOpen()) {
                Registry registry = LocateRegistry.createRegistry(5050);
                registry.rebind("rentLio", ServicesFactoryImpl.getInstance());

                System.out.println("Server has been started successfully");
            } else {
                JOptionPane.showMessageDialog(null, "sql Saver is not connected", "Error", 1);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}