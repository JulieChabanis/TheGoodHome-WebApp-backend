package com.webapp.thegoodhomebackend.service.impl;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;
import com.webapp.thegoodhomebackend.repository.AgencyRepository;
import com.webapp.thegoodhomebackend.service.AgencyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository= agencyRepository;
    }

    @Override
    public List<AgencyEntity> findAllAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public Optional<AgencyEntity> findById(Long id) {
        return agencyRepository.findById(id);
    }

    @Override
    public AgencyEntity saveAgency(AgencyEntity agencyEntity) {
        return agencyRepository.save(agencyEntity);
    }

    @Override
    public AgencyEntity updateAgency(AgencyEntity agencyEntity) {
        return agencyRepository.save(agencyEntity);
    }

    @Override
    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }
}
