package com.webapp.thegoodhomebackend.service;
import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import com.webapp.thegoodhomebackend.repository.LeaseContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseContractService {

    @Autowired
    private LeaseContractRepository leaseContractRepository;

    public List<LeaseContractEntity> getAllLeaseContracts() {
        return leaseContractRepository.findAll();
    }

    public LeaseContractEntity getLeaseContractById(Long id) {
        Optional<LeaseContractEntity> leaseContractEntity = leaseContractRepository.findById(id);
        if (leaseContractEntity.isPresent()) {
            return leaseContractEntity.get();
        } else {
            throw new RuntimeException("Lease Contract not found with id" + id);
        }

    }

    public void createLeaseContract(LeaseContractEntity leaseContractEntity) {
        leaseContractRepository.save(leaseContractEntity);
    }


    public void deleteLeaseContractById(Long id) {

        leaseContractRepository.deleteById(id);
    }


}
