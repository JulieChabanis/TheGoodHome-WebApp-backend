package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartmentRepository extends JpaRepository<AppartmentEntity, Long> {
}
