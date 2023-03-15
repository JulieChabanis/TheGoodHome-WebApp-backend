package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;
import com.webapp.thegoodhomebackend.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public List <AgencyEntity> getAgencies() {
        return agencyRepository.findAll();
    }

    public AgencyEntity getAgency(Long id) {
        Optional <AgencyEntity> agencyEntity = agencyRepository.findById(id);
        if (agencyEntity.isPresent()) {
            return agencyEntity.get();
        } else {
            throw new RuntimeException("Agency not found wit id" +id);
        }
    }

    public void createAgency (AgencyEntity agencyEntity) {
        agencyRepository.save(agencyEntity);
    }

    public void updateAgency(Long id, AgencyEntity agencyEntity) {
        Optional <AgencyEntity> existingAgency = agencyRepository.findById(id);
        if (existingAgency.isPresent()) {
            agencyEntity.setId(id);
            agencyRepository.save(agencyEntity);
        } else {
            throw new RuntimeException("Agency not found with id" + id);
        }
    }

    public void deleteAgencyById(Long id) {
        Optional<AgencyEntity> agencyEntity = agencyRepository.findById(id);
        if (agencyEntity.isPresent()) {
            agencyRepository.deleteById(id);
        } else {
            throw new RuntimeException("Agency not found with id" + id);
        }
    }

}
