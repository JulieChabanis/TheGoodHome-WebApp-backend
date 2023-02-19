package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;

import java.util.List;
import java.util.Optional;

public interface AppartmentService {

    List<AppartmentEntity> findAllAppartments();
    Optional<AppartmentEntity> findById(Long id);
    AppartmentEntity saveAppartment(AppartmentEntity appartmentEntity);
    AppartmentEntity updateAppartment(AppartmentEntity appartmentEntity);
    void deleteAppartment(Long id);
}
