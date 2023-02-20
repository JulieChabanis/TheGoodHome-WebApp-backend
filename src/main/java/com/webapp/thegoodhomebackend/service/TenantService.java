package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.TenantEntity;

import java.util.List;
import java.util.Optional;

public interface TenantService {
    List<TenantEntity> findAllTenants();
    Optional<TenantEntity> findById(Long id);
    TenantEntity saveTenant(TenantEntity tenantEntity);
    TenantEntity updateTenant(TenantEntity tenantEntity);
    void deleteTenant(Long id);
}
