package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.CustomerDTO;
import com.chamodshehanka.rentLioServer.business.custom.CustomerBO;
import com.chamodshehanka.rentLioServer.entity.Customer;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.CustomerRepository;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class CustomerBOImpl implements CustomerBO{

    private CustomerRepository customerRepository;

    public CustomerBOImpl() {
        customerRepository = (CustomerRepository) RepositoryFactory
                .getInstance().getRepository(RepositoryFactory.RepositoryFactoryTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            Customer customer = new Customer(
                    customerDTO.getCustomerId(),
                    customerDTO.getCustomerName(),
                    customerDTO.getAddress(),
                    customerDTO.getEmail(),
                    customerDTO.getTel(),
                    customerDTO.getCustomerNIC()
            );
            boolean result = customerRepository.save(customer);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            Customer customer = new Customer(
                    customerDTO.getCustomerId(),
                    customerDTO.getCustomerName(),
                    customerDTO.getAddress(),
                    customerDTO.getEmail(),
                    customerDTO.getTel(),
                    customerDTO.getCustomerNIC()
            );
            customerRepository.update(customer);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteCustomer(String customerId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            Customer customer = customerRepository.findById(customerId);
            if (customer != null){
                System.out.println();
                customerRepository.delete(customer);
                session.getTransaction().commit();
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public CustomerDTO getCustomerById(String customerId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSession(session);
            session.beginTransaction();
            Customer customer =  customerRepository.findById(customerId);
            session.getTransaction().commit();
            if (customer != null){
                return new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getAddress(),
                        customer.getEmail(),
                        customer.getTel(),
                        customer.getCustomerNIC()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            customerRepository.setSession(session);
            List<Customer> customerList = customerRepository.findAll();
            session.getTransaction().commit();
            if (customerList != null){
                List<CustomerDTO> customerDTOList = new ArrayList<>();

                for (Customer customer: customerList
                     ) {
                    customerDTOList.add(
                            new CustomerDTO(
                                    customer.getCustomerId(),
                                    customer.getCustomerName(),
                                    customer.getAddress(),
                                    customer.getEmail(),
                                    customer.getTel(),
                                    customer.getCustomerNIC()
                            )
                    );
                }
                return customerDTOList;
             }else {
                return null;
            }
        }
    }
}
