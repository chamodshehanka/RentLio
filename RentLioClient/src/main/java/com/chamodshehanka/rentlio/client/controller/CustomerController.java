package com.chamodshehanka.rentlio.client.controller;

import com.chamodshehanka.rentlio.client.proxy.ProxyHandler;
import com.chamodshehanka.rentlio.common.dto.CustomerDTO;
import com.chamodshehanka.rentlio.common.observer.CustomerObserver;
import com.chamodshehanka.rentlio.common.services.ServicesFactory;
import com.chamodshehanka.rentlio.common.services.custom.CustomerService;

import java.util.List;

/**
 * @author chamodshehanka on 4/9/2018
 * @project RentLio
 **/
public class CustomerController {

    public static boolean addCustomer(CustomerDTO customerDTO)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.addCustomer(customerDTO);
    }

    public static boolean updateCustomer(CustomerDTO customerDTO)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.updateCustomer(customerDTO);
    }

    public static boolean deleteCustomer(String customerId)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.deleteCustomer(customerId);
    }

    public static CustomerDTO getCustomerById(String customerId)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.findById(customerId);
    }

    public static List<CustomerDTO> getAllCustomers()throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.getAllCustomers();
    }

    public static boolean addCustomerObserver(CustomerObserver customerObserver)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.addCustomerObserver(customerObserver);
    }

    public static boolean removeCustomerObserver(CustomerObserver customerObserver)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.removeCustomerObserver(customerObserver);
    }

    public static boolean reserveCustomer(String customerId)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.reserve(customerId);
    }

    public static boolean releaseCustomer(String customerId)throws Exception{
        CustomerService customerService = (CustomerService) ProxyHandler.getInstance().getService(ServicesFactory.ServicesType.CUSTOMER);
        return customerService.release(customerId);
    }
}
