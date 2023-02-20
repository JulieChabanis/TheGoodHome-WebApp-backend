package com.webapp.thegoodhomebackend.service.impl;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.repository.TenantRepository;
import com.webapp.thegoodhomebackend.service.TenantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<TenantEntity> findAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public Optional<TenantEntity> findById(Long id) {
        return tenantRepository.findById(id);
    }

    @Override
    public TenantEntity saveTenant(TenantEntity tenantEntity) {
        return tenantRepository.save(tenantEntity);
    }

    @Override
    public TenantEntity updateTenant(TenantEntity tenantEntity) {
        return tenantRepository.save(tenantEntity);
    }

    @Override
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);

    }
}
