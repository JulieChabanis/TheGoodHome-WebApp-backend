package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseContractRepository extends JpaRepository<LeaseContractEntity, Long> {
    List<LeaseContractEntity> findByTenantEntityId(Long tenantId);
    List<LeaseContractEntity> findByAppartmentEntityId(Long appartmentId);
}
