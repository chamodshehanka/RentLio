package com.chamodshehanka.rentlio.server.services.impl.custom;

import com.chamodshehanka.rentlio.common.dto.CustomerDTO;
import com.chamodshehanka.rentlio.common.observer.CustomerObserver;
import com.chamodshehanka.rentlio.common.services.custom.CustomerService;
import com.chamodshehanka.rentlio.server.business.BOFactory;
import com.chamodshehanka.rentlio.server.business.custom.CustomerBO;
import com.chamodshehanka.rentlio.server.observable.CustomerObservable;
import com.chamodshehanka.rentlio.server.reservation.ReservationImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService{

    private CustomerBO customerBO;
    private static ReservationImpl<CustomerService> customerServiceReservation = new ReservationImpl<>();
    private static final CustomerObservable CUSTOMER_OBSERVABLE = new CustomerObservable();

    public CustomerServiceImpl() throws RemoteException {
        customerBO = (CustomerBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerBO.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerBO.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(String customerId) throws Exception {
        return customerBO.deleteCustomer(customerId);
    }

    @Override
    public CustomerDTO findById(String customerId) throws Exception {
        return customerBO.getCustomerById(customerId);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.getAllCustomers();
    }

    @Override
    public boolean addCustomerObserver(CustomerObserver customerObserver) {
        return CUSTOMER_OBSERVABLE.addCustomerObserver(customerObserver);
    }

    @Override
    public boolean removeCustomerObserver(CustomerObserver customerObserver) {
        return CUSTOMER_OBSERVABLE.removeCustomerObserver(customerObserver);
    }

    @Override
    public boolean reserve(Object id) {
        return customerServiceReservation.reserve(id,this,false);
    }

    @Override
    public boolean release(Object id) {
        return customerServiceReservation.release(id);
    }
}
