package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.DriverDTO;
import com.chamodshehanka.rentLioServer.business.custom.DriverBO;
import com.chamodshehanka.rentLioServer.entity.Driver;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.DriverRepository;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class DriverBOImpl implements DriverBO{

    private DriverRepository driverRepository;

    public DriverBOImpl() {
        driverRepository = (DriverRepository) RepositoryFactory
                .getInstance().getRepository(RepositoryFactory.RepositoryFactoryTypes.DRIVER);
    }

    @Override
    public boolean addDriver(DriverDTO driverDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            driverRepository.setSession(session);

            Driver driver = new Driver(
                    driverDTO.getDriverId(),
                    driverDTO.getDriverName(),
                    driverDTO.getAddress(),
                    driverDTO.getEmail(),
                    driverDTO.getTel(),
                    driverDTO.getDriverNIC(),
                    driverDTO.getState()
            );

            boolean result = driverRepository.save(driver);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateDriver(DriverDTO driverDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            driverRepository.setSession(session);

            Driver driver = new Driver(
                    driverDTO.getDriverId(),
                    driverDTO.getDriverName(),
                    driverDTO.getAddress(),
                    driverDTO.getEmail(),
                    driverDTO.getTel(),
                    driverDTO.getDriverNIC(),
                    driverDTO.getState()
            );

            driverRepository.update(driver);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteDriver(String driverId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            driverRepository.setSession(session);

            Driver driver = driverRepository.findById(driverId);
            if (driver != null){
                driverRepository.delete(driver);
                session.getTransaction().commit();
                return true;
            }else {
                System.out.println();
                return false;
            }
        }
    }

    @Override
    public DriverDTO getDriverById(String driverId) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            driverRepository.setSession(session);

            Driver driver = driverRepository.findById(driverId);
            session.getTransaction().commit();
            if (driver != null){
                return new DriverDTO(
                        driver.getDriverId(),
                        driver.getDriverName(),
                        driver.getAddress(),
                        driver.getEmail(),
                        driver.getTel(),
                        driver.getDriverNIC(),
                        driver.getState()
                );
            }
        }
        return null;
    }

    @Override
    public List<DriverDTO> getAllDrivers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            driverRepository.setSession(session);
            session.beginTransaction();

            List<Driver> driverList = driverRepository.findAll();
            session.getTransaction().commit();
            if (driverList != null){
                List<DriverDTO> driverDTOList = new ArrayList<>();
                for (Driver driver: driverList
                     ) {
                    driverDTOList.add(new DriverDTO(
                            driver.getDriverId(),
                            driver.getDriverName(),
                            driver.getAddress(),
                            driver.getEmail(),
                            driver.getTel(),
                            driver.getDriverNIC(),
                            driver.getState()
                    ));
                }

                return driverDTOList;
            }else {
                return null;
            }

        }
    }
}
