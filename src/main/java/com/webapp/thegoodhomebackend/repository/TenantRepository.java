package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<TenantEntity, Long> {
}
