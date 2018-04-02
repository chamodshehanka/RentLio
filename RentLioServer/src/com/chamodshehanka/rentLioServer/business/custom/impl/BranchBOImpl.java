package com.chamodshehanka.rentLioServer.business.custom.impl;

import com.chamodshehanka.rentLioCommon.dto.BranchDTO;
import com.chamodshehanka.rentLioServer.business.custom.BranchBO;
import com.chamodshehanka.rentLioServer.entity.Branch;
import com.chamodshehanka.rentLioServer.repository.RepositoryFactory;
import com.chamodshehanka.rentLioServer.repository.custom.BranchRepository;
import com.chamodshehanka.rentLioServer.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 3/14/2018
 * @project RentLio
 **/
public class BranchBOImpl implements BranchBO{

    private BranchRepository branchRepository;

    public BranchBOImpl() {
        branchRepository = (BranchRepository) RepositoryFactory
                .getInstance().getRepository(RepositoryFactory.RepositoryFactoryTypes.BRANCH);
    }

    @Override
    public boolean addBranch(BranchDTO branchDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            branchRepository.setSession(session);

            Branch branch = new Branch(
                    branchDTO.getBranchId(),
                    branchDTO.getRegisterId(),
                    branchDTO.getAddress(),
                    branchDTO.getEmail(),
                    branchDTO.getTel(),
                    branchDTO.getPostalCode()
            );

            boolean result = branchRepository.save(branch);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateBranch(BranchDTO branchDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            branchRepository.setSession(session);
            session.beginTransaction();

            Branch branch = new Branch(
                    branchDTO.getBranchId(),
                    branchDTO.getRegisterId(),
                    branchDTO.getAddress(),
                    branchDTO.getEmail(),
                    branchDTO.getTel(),
                    branchDTO.getPostalCode()
            );

            branchRepository.update(branch);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteBranch(String branchId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            branchRepository.setSession(session);
            session.beginTransaction();

            Branch branch = branchRepository.findById(branchId);
            if (branch != null){
                branchRepository.delete(branch);
                session.getTransaction().commit();
                System.out.println();
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public BranchDTO getBranchById(String branchId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            branchRepository.setSession(session);
            Transaction transaction = session.beginTransaction();
            Branch branch = branchRepository.findById(branchId);
            session.getTransaction().commit();
            if (branch != null){
                return new BranchDTO(
                        branch.getBranchId(),
                        branch.getRegisterId(),
                        branch.getAddress(),
                        branch.getEmail(),
                        branch.getTel(),
                        branch.getPostalCode()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<BranchDTO> getAllBranches() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            branchRepository.setSession(session);
            session.beginTransaction();
            List<Branch> branchList = branchRepository.findAll();
            session.getTransaction().commit();
            if (branchList != null){
                List<BranchDTO> branchDTOList = new ArrayList<>();

                for (Branch branch: branchList
                     ) {
                    BranchDTO branchDTO = new BranchDTO(
                            branch.getBranchId(),
                            branch.getRegisterId(),
                            branch.getAddress(),
                            branch.getEmail(),
                            branch.getTel(),
                            branch.getPostalCode()
                    );
                    branchDTOList.add(branchDTO);
                }
                return branchDTOList;
            }else {
                return null;
            }
        }
    }
}
