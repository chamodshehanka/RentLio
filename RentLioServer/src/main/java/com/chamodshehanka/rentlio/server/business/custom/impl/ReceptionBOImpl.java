package com.chamodshehanka.rentlio.server.business.custom.impl;

import com.chamodshehanka.rentlio.common.dto.ReceptionDTO;
import com.chamodshehanka.rentlio.server.business.custom.ReceptionBO;
import com.chamodshehanka.rentlio.server.entity.Branch;
import com.chamodshehanka.rentlio.server.entity.Reception;
import com.chamodshehanka.rentlio.server.repository.RepositoryFactory;
import com.chamodshehanka.rentlio.server.repository.custom.BranchRepository;
import com.chamodshehanka.rentlio.server.repository.custom.ReceptionRepository;
import com.chamodshehanka.rentlio.server.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 4/1/2018
 * @project RentLio
 **/
public class ReceptionBOImpl implements ReceptionBO {

    private ReceptionRepository receptionRepository;
    private BranchRepository branchRepository;

    public ReceptionBOImpl() {
        receptionRepository = (ReceptionRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.RECEPTION);

        branchRepository = (BranchRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.BRANCH);
    }

    @Override
    public boolean addReception(ReceptionDTO receptionDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSession(session);
            branchRepository.setSession(session);
            session.beginTransaction();

            Branch branch = branchRepository.findById(receptionDTO.getBranchId());
            Reception reception = new Reception(
                    receptionDTO.getReceptionId(),
                    receptionDTO.getBranchId(),
                    receptionDTO.getName(),
                    receptionDTO.getAddress(),
                    receptionDTO.getEmail(),
                    receptionDTO.getTel(),
                    receptionDTO.getNic(),
                    receptionDTO.getPassword(),
                    receptionDTO.getImage(),
                    branch
            );
            boolean result = receptionRepository.save(reception);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateReception(ReceptionDTO receptionDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            receptionRepository.setSession(session);
            branchRepository.setSession(session);

            Branch branch = branchRepository.findById(receptionDTO.getBranchId());
            Reception reception = new Reception(
                    receptionDTO.getReceptionId(),
                    receptionDTO.getBranchId(),
                    receptionDTO.getName(),
                    receptionDTO.getAddress(),
                    receptionDTO.getEmail(),
                    receptionDTO.getTel(),
                    receptionDTO.getNic(),
                    receptionDTO.getPassword(),
                    receptionDTO.getImage(),
                    branch
            );
            receptionRepository.update(reception);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteReception(String receptionId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Reception reception = receptionRepository.findById(receptionId);
            if (reception != null){
                receptionRepository.delete(reception);
                session.getTransaction().commit();
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public ReceptionDTO getReceptionById(String receptionId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            receptionRepository.setSession(session);
            Reception reception = receptionRepository.findById(receptionId);
            session.getTransaction().commit();
            if (reception != null){
                return new ReceptionDTO(
                        reception.getReceptionId(),
                        reception.getBranchId(),
                        reception.getName(),
                        reception.getAddress(),
                        reception.getEmail(),
                        reception.getTel(),
                        reception.getNic(),
                        reception.getPassword(),
                        reception.getImage()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<ReceptionDTO> getAllReceptions() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            receptionRepository.setSession(session);
            List<Reception> receptionList = receptionRepository.findAll();
            session.getTransaction().commit();
            if (receptionList != null){
                List<ReceptionDTO> receptionDTOList = new ArrayList<>();
                for (Reception reception: receptionList
                     ) {
                    receptionDTOList.add(
                            new ReceptionDTO(
                                    reception.getReceptionId(),
                                    reception.getBranchId(),
                                    reception.getName(),
                                    reception.getAddress(),
                                    reception.getEmail(),
                                    reception.getTel(),
                                    reception.getNic(),
                                    reception.getPassword(),
                                    reception.getImage()
                            )
                    );
                }
                return receptionDTOList;
            }else {
                return null;
            }
        }
    }
}
