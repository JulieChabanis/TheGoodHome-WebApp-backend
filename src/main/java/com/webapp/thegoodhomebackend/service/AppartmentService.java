package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.repository.AppartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentService {

    private final AppartmentRepository appartmentRepository;

    @Autowired
    public AppartmentService(AppartmentRepository appartmentRepository) {
        this.appartmentRepository = appartmentRepository;
    }

    public List<AppartmentEntity> getAppartments() {
        return appartmentRepository.findAll();
    }

    public AppartmentEntity getAppartment(Long id) {
        Optional<AppartmentEntity> appartmentEntity = appartmentRepository.findById(id);
        if (appartmentEntity.isPresent()) {
            return appartmentEntity.get();
        } else {
            throw new RuntimeException("Appartment not found with id" + id);
        }
    }

    public void createAppartment(AppartmentEntity appartmentEntity) {
        appartmentRepository.save(appartmentEntity);
    }

    public void updateAppartment(Long id, AppartmentEntity appartmentEntity) {
        Optional<AppartmentEntity> existingAppartment = appartmentRepository.findById(id);
        if (existingAppartment.isPresent()) {
            appartmentEntity.setId(id);
            appartmentRepository.save(appartmentEntity);
        } else {
            throw new RuntimeException("Appartment not found with id" + id);
        }
    }

    public void deleteAppartmentById(Long id) {
        Optional<AppartmentEntity> appartmentEntity = appartmentRepository.findById(id);
        if (appartmentEntity.isPresent()) {
            appartmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tenant not found with id" + id);
        }
    }

}
