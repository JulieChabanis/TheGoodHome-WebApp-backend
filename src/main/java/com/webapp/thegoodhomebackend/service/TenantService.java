package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;


    public List<TenantEntity> getTenants() {

        return tenantRepository.findAll();
    }

    public TenantEntity getTenant(Long id) {
        Optional <TenantEntity> tenantEntity = tenantRepository.findById(id);
        if (tenantEntity.isPresent()) {
            return tenantEntity.get();
        } else {
            throw new RuntimeException("Tenant not found with id" + id);
        }
    }

    public void addTenant (TenantEntity tenantEntity) {
        tenantRepository.save(tenantEntity);
    }

   public void updateTenant(Long id, TenantEntity tenantEntity) {
        Optional<TenantEntity> existingTenant = tenantRepository.findById(id);
        if (existingTenant.isPresent()) {
            tenantEntity.setId(id);
            tenantRepository.save(tenantEntity);
        } else {
            throw new RuntimeException("Tenant not found with id" + id);
        }
   }

    public void deleteTenant(long id) {
        Optional<TenantEntity> tenantEntity = tenantRepository.findById(id);
        if (tenantEntity.isPresent()) {
            tenantRepository.deleteById(id);
        } else {
            throw  new RuntimeException("Tenant not found with id" + id);
        }
    }

}