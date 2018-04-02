package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.VehicleDTO;
import com.chamodshehanka.rentLioServer.business.custom.VehicleBO;
import com.chamodshehanka.rentLioServer.entity.Vehicle;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.VehicleRepository;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 4/2/2018
 * @project RentLio
 **/
public class VehicleBOImpl implements VehicleBO {

    private VehicleRepository vehicleRepository;

    public VehicleBOImpl() {
        vehicleRepository = (VehicleRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.VEHICLE);
    }

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);

            Vehicle vehicle = new Vehicle(
                    vehicleDTO.getVehicleNumber(),
                    vehicleDTO.getVehicleType(),
                    vehicleDTO.getVehicleBrand(),
                    vehicleDTO.getVehicleModel(),
                    vehicleDTO.getImageURL(),
                    vehicleDTO.getModelYear(),
                    vehicleDTO.getChassiNumber(),
                    vehicleDTO.getFuel(),
                    vehicleDTO.getKmrs(),
                    vehicleDTO.getEngineCapacity(),
                    vehicleDTO.getColour(),
                    vehicleDTO.getDoors(),
                    vehicleDTO.getInsuranceCom(),
                    vehicleDTO.getComment(),
                    vehicleDTO.getStatus()
            );

            boolean result = vehicleRepository.save(vehicle);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);

            Vehicle vehicle = new Vehicle(
                    vehicleDTO.getVehicleNumber(),
                    vehicleDTO.getVehicleType(),
                    vehicleDTO.getVehicleBrand(),
                    vehicleDTO.getVehicleModel(),
                    vehicleDTO.getImageURL(),
                    vehicleDTO.getModelYear(),
                    vehicleDTO.getChassiNumber(),
                    vehicleDTO.getFuel(),
                    vehicleDTO.getKmrs(),
                    vehicleDTO.getEngineCapacity(),
                    vehicleDTO.getColour(),
                    vehicleDTO.getDoors(),
                    vehicleDTO.getInsuranceCom(),
                    vehicleDTO.getComment(),
                    vehicleDTO.getStatus()
            );

            vehicleRepository.update(vehicle);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteVehicle(String vehicleId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);
            Vehicle vehicle = vehicleRepository.findById(vehicleId);
            if (vehicle != null){
                vehicleRepository.delete(vehicle);
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public VehicleDTO getVehicleById(String vehicleId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);
            Vehicle vehicle = vehicleRepository.findById(vehicleId);
            session.getTransaction().commit();
            if (vehicle != null){
                return new VehicleDTO(
                        vehicle.getVehicleNumber(),
                        vehicle.getVehicleType(),
                        vehicle.getVehicleBrand(),
                        vehicle.getVehicleModel(),
                        vehicle.getImageURL(),
                        vehicle.getModelYear(),
                        vehicle.getChassiNumber(),
                        vehicle.getFuel(),
                        vehicle.getKmrs(),
                        vehicle.getEngineCapacity(),
                        vehicle.getColour(),
                        vehicle.getDoors(),
                        vehicle.getInsuranceCom(),
                        vehicle.getComment(),
                        vehicle.getStatus()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            vehicleRepository.setSession(session);
            List<Vehicle> vehicleList = vehicleRepository.findAll();
            session.getTransaction().commit();

            if (vehicleList != null){
                List<VehicleDTO> vehicleDTOList = new ArrayList<>();
                for (Vehicle vehicle: vehicleList
                     ) {
                    vehicleDTOList.add(
                            new VehicleDTO(
                                    vehicle.getVehicleNumber(),
                                    vehicle.getVehicleType(),
                                    vehicle.getVehicleBrand(),
                                    vehicle.getVehicleModel(),
                                    vehicle.getImageURL(),
                                    vehicle.getModelYear(),
                                    vehicle.getChassiNumber(),
                                    vehicle.getFuel(),
                                    vehicle.getKmrs(),
                                    vehicle.getEngineCapacity(),
                                    vehicle.getColour(),
                                    vehicle.getDoors(),
                                    vehicle.getInsuranceCom(),
                                    vehicle.getComment(),
                                    vehicle.getStatus()
                            )
                    );
                }
                return vehicleDTOList;
            }else {
                return null;
            }
        }
    }
}
