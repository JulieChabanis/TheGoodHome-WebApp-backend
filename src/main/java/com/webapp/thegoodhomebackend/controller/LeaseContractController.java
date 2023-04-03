package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import com.webapp.thegoodhomebackend.service.LeaseContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin( origins = "http://localhost:3000")

public class LeaseContractController {

    private final LeaseContractService leaseContractService;

    public LeaseContractController(LeaseContractService leaseContractService) {
        this.leaseContractService = leaseContractService;
    }

    @GetMapping("")
    public ResponseEntity<List<LeaseContractEntity>> getAllLeaseContracts() {
        List<LeaseContractEntity> leaseContracts = leaseContractService.getAllLeaseContracts();
        return ResponseEntity.ok(leaseContracts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaseContractEntity> getLeaseContractById(@PathVariable Long id) {
        LeaseContractEntity leaseContractEntity = leaseContractService.getLeaseContractById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(leaseContractEntity);
    }

    @GetMapping("tenants/{tenantId}/contracts")
    public List<LeaseContractEntity> getLeaseContractsByTenantId(@PathVariable Long tenantId) {
        return leaseContractService.getLeaseContractsByTenantId(tenantId);
    }

    @GetMapping("appartments/{appartmentId}/contracts")
    public List<LeaseContractEntity> getLeaseContractsByAppartmentId(@PathVariable Long appartmentId) {
        return leaseContractService.getLeaseContractsByAppartmentId(appartmentId);
    }

    @PostMapping
    public ResponseEntity<LeaseContractEntity> createLeaseContract(@RequestBody LeaseContractEntity leaseContractEntity) {
        LeaseContractEntity createdLeaseContract = leaseContractService.createLeaseContract(leaseContractEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeaseContract);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaseContract(@PathVariable Long id) {
        leaseContractService.deleteLeaseContractById(id);
        return ResponseEntity.noContent().build();
    }

}
