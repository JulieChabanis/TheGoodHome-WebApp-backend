package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyEntity, Long> {
}
