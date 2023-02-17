package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    List<AgencyEntity> findAllAgencies();
    Optional<AgencyEntity> findById(Long id);
    AgencyEntity saveAgency(AgencyEntity agencyEntity);
    AgencyEntity updateAgency(AgencyEntity agencyEntity);
    void deleteAgency(Long id);
}
