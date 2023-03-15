package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "http://localhost:3000")

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
    public ResponseEntity<String> updateTenant(@PathVariable Long id, @RequestBody TenantEntity tenantEntity) {
        tenantService.updateTenant(id, tenantEntity);
        return ResponseEntity.ok("Tenant with id " + id + " has been modified successfully.");
    }


    @DeleteMapping("/{id}")
    String deleteTenantById(@PathVariable Long id) {
        tenantService.deleteTenantById(id);
        return "Tenant with id "+id+" has been deleted success.";
    }
}
