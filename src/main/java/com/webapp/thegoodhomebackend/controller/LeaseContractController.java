package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import com.webapp.thegoodhomebackend.service.LeaseContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin( origins = "http://localhost:3000")

public class LeaseContractController {

    @Autowired
    private LeaseContractService leaseContractService;


    @GetMapping("")
    public List<LeaseContractEntity> getAllLeaseContracts() {
        return leaseContractService.getAllLeaseContracts();
    }

    @GetMapping("{id}")
    public LeaseContractEntity getLeaseContractById(@PathVariable Long id) {
        return leaseContractService.getLeaseContractById(id);

    }

    @PostMapping("")
    public void createLeaseContract(@RequestBody LeaseContractEntity leaseContractEntity) {
        leaseContractService.createLeaseContract(leaseContractEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaseContractById(@PathVariable Long id) {
        leaseContractService.deleteLeaseContractById(id);
        return ResponseEntity.noContent().build();
    }

}
