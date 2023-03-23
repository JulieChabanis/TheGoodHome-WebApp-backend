package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
