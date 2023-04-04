package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseContractRepository extends JpaRepository<LeaseContractEntity, Long> {
}
