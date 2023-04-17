package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;
import com.webapp.thegoodhomebackend.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agencies")
@CrossOrigin(origins = "https://thegoodhome.netlify.app")

public class AgencyController {

    @Autowired
    private AgencyService agencyService;


    @GetMapping("")
    public List<AgencyEntity> getAgencies() {
        return agencyService.getAgencies();
    }

    @GetMapping("/{id}")
    public AgencyEntity getAgency(@PathVariable Long id) {
        return agencyService.getAgency(id);
    }

    @PostMapping("")
    public void createAgency (@RequestBody AgencyEntity agencyEntity) {
        agencyService.createAgency(agencyEntity);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateAgency(@PathVariable Long id, @RequestBody AgencyEntity agencyEntity) {
        agencyService.updateAgency(id, agencyEntity);
        return ResponseEntity.ok ("Agency with id" + id + "has been modified successfully.");
    }

    @DeleteMapping("/{id}")
    String deleteAgencyById(@PathVariable Long id) {
        agencyService.deleteAgencyById(id);
        return "Agency with id" + id + "has been deleted success.";
    }
}
