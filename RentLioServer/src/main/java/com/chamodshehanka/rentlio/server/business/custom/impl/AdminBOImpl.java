package com.chamodshehanka.rentlio.server.business.custom.impl;

import com.chamodshehanka.rentlio.common.dto.AdminDTO;
import com.chamodshehanka.rentlio.server.business.custom.AdminBO;
import com.chamodshehanka.rentlio.server.entity.Admin;
import com.chamodshehanka.rentlio.server.repository.RepositoryFactory;
import com.chamodshehanka.rentlio.server.repository.custom.AdminRepository;
import com.chamodshehanka.rentlio.server.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class AdminBOImpl implements AdminBO{

    private AdminRepository adminRepository;

    public AdminBOImpl() {
        adminRepository = (AdminRepository) RepositoryFactory
                .getInstance().getRepository(RepositoryFactory.RepositoryFactoryTypes.ADMIN);
    }

    @Override
    public boolean addAdmin(AdminDTO adminDTO) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            adminRepository.setSession(session);

            Admin admin = new Admin(
                    adminDTO.getAdminId(),
                    adminDTO.getAdminName(),
                    adminDTO.getAdminAddress(),
                    adminDTO.getAdminEmail(),
                    adminDTO.getAdminTel(),
                    adminDTO.getAdminNIC(),
                    adminDTO.getAdminDP(),
                    adminDTO.getPassword()
            );

            boolean result = adminRepository.save(admin);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) throws Exception {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            adminRepository.setSession(session);
            session.beginTransaction();

            Admin admin = new Admin(
                    adminDTO.getAdminId(),
                    adminDTO.getAdminName(),
                    adminDTO.getAdminAddress(),
                    adminDTO.getAdminEmail(),
                    adminDTO.getAdminTel(),
                    adminDTO.getAdminNIC(),
                    adminDTO.getAdminDP(),
                    adminDTO.getPassword()
            );

            adminRepository.update(admin);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(String adminId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            adminRepository.setSession(session);
            session.beginTransaction();

            Admin admin = adminRepository.findById(adminId);
            if (admin != null){
                adminRepository.delete(admin);
                session.getTransaction().commit();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AdminDTO getAdminById(String adminId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            adminRepository.setSession(session);

            Transaction transaction = session.beginTransaction();
            Admin admin = adminRepository.findById(adminId);
            session.getTransaction().commit();

            if (admin != null){
                return new AdminDTO(
                        admin.getAdminId(),
                        admin.getAdminName(),
                        admin.getAdminAddress(),
                        admin.getAdminEmail(),
                        admin.getAdminTel(),
                        admin.getAdminNIC(),
                        admin.getAdminDP(),
                        admin.getPassword()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            adminRepository.setSession(session);
            session.beginTransaction();
            List<Admin> adminAll = adminRepository.findAll();
            session.getTransaction().commit();
            if (adminAll != null){
                List<AdminDTO> adminDTOS = new ArrayList<>();
                for (Admin admin: adminAll
                     ) {
                    AdminDTO adminDTO = new AdminDTO(
                            admin.getAdminId(),
                            admin.getAdminName(),
                            admin.getAdminAddress(),
                            admin.getAdminEmail(),
                            admin.getAdminTel(),
                            admin.getAdminNIC(),
                            admin.getAdminDP(),
                            admin.getPassword()
                    );
                    adminDTOS.add(adminDTO);
                }
                return adminDTOS;
            }else {
                return null;
            }
        }
    }
}
