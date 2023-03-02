package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin("http://localhost:3000/")
public class TenantController {

    @Autowired
    private TenantService tenantService;


    @GetMapping("")
    public List<TenantEntity> getTenants() {
        return tenantService.getTenants();
    }

    @GetMapping("/{id}")
    public TenantEntity getTenant(@PathVariable Long id) {
        return tenantService.getTenant(id);
    }

    @PostMapping("")
    public void addTenant (@RequestBody TenantEntity tenantEntity){
        tenantService.addTenant(tenantEntity);
    }

    @PutMapping("{id}")
    public void updateTenant(@PathVariable Long id, @RequestBody TenantEntity tenantEntity) {
        tenantService.updateTenant(id, tenantEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }
}
