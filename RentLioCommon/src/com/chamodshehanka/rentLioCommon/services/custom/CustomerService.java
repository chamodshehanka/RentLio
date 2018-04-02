package com.chamodshehanka.rentLioCommon.services.custom;

import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
import com.chamodshehanka.rentLioCommon.observer.CustomerObserver;
import com.chamodshehanka.rentLioCommon.services.SuperService;

import java.util.List;

/**
 * @author chamodshehanka on 3/13/2018
 * @project RentLio
 **/
public interface CustomerService extends SuperService{

    public boolean addCustomer(CustomerDTO customer) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;

    public boolean deleteCustomer(String customerId) throws Exception;

    public CustomerDTO findById(String customerId) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;

    public boolean addCustomerObserver(CustomerObserver customerObserver) throws Exception;

    public boolean removeCustomerObserver(CustomerObserver customerObserver) throws Exception;

}
