package com.webapp.thegoodhomebackend.service.impl;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.repository.AppartmentRepository;
import com.webapp.thegoodhomebackend.service.AppartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentServiceImpl implements AppartmentService {

    private final AppartmentRepository appartmentRepository;

    public AppartmentServiceImpl(AppartmentRepository appartmentRepository) {
        this.appartmentRepository = appartmentRepository;
    }

    @Override
    public List<AppartmentEntity> findAllAppartments() {
        return appartmentRepository.findAll();
    }

    @Override
    public Optional<AppartmentEntity> findById(Long id) {
        return appartmentRepository.findById(id);
    }

    @Override
    public AppartmentEntity saveAppartment(AppartmentEntity appartmentEntity) {
        return appartmentRepository.save(appartmentEntity);
    }

    @Override
    public AppartmentEntity updateAppartment(AppartmentEntity appartmentEntity) {
        return appartmentRepository.save(appartmentEntity);
    }

    @Override
    public void deleteAppartment(Long id) {
        appartmentRepository.deleteById(id);
    }
}
