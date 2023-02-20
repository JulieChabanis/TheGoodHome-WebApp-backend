package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.service.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tenants")
@CrossOrigin("http://localhost:3000/")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<TenantEntity> findAllTenants() {
        return tenantService.findAllTenants();
    }

    @GetMapping("/{id}")
    public Optional<TenantEntity> findTenantById(@PathVariable("id") Long id) {
        return tenantService.findById(id);
    }

    @PostMapping
    public TenantEntity saveTenant(@RequestBody TenantEntity tenantEntity) {
        return tenantService.saveTenant(tenantEntity);
    }

    @PutMapping
    public TenantEntity updateTenant(@RequestBody TenantEntity tenantEntity) {
        return tenantService.updateTenant(tenantEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable("id") Long id) {

        tenantService.deleteTenant(id);
    }
}
