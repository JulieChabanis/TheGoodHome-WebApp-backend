package com.webapp.thegoodhomebackend.service;
import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import com.webapp.thegoodhomebackend.repository.LeaseContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaseContractService {

    private final LeaseContractRepository leaseContractRepository;

    public LeaseContractService(LeaseContractRepository leaseContractRepository) {
        this.leaseContractRepository = leaseContractRepository;
    }

    public List<LeaseContractEntity> getAllLeaseContracts() {
        return leaseContractRepository.findAll();
    }

    // Search Contract by Tenant ID
    public List<LeaseContractEntity> getLeaseContractsByTenantId(Long tenantId) {
        return leaseContractRepository.findByTenantEntityId(tenantId);
    }

    // Search Contract by Appart ID
    public List<LeaseContractEntity> getLeaseContractsByAppartmentId(Long appartmentId) {
        return leaseContractRepository.findByAppartmentEntityId(appartmentId);
    }

    public LeaseContractEntity createLeaseContract(LeaseContractEntity leaseContractEntity) {
        return leaseContractRepository.save(leaseContractEntity);
    }

    public Optional<LeaseContractEntity> getLeaseContractById(Long id) {
        return leaseContractRepository.findById(id);
    }

    public void deleteLeaseContractById(Long id) {
        leaseContractRepository.deleteById(id);
    }


}
