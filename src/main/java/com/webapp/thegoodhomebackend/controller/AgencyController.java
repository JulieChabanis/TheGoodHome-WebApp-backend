package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.AgencyEntity;
import com.webapp.thegoodhomebackend.service.AgencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/agencies")
@CrossOrigin("http://localhost:3000/")
public class AgencyController {

    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public List<AgencyEntity> findAllAgencies() {
        return agencyService.findAllAgencies();
    }

    @GetMapping("/{id}")
    public Optional<AgencyEntity> findAgencyById(@PathVariable("id") Long id) {
        return agencyService.findById(id);
    }

    @PostMapping
    public AgencyEntity saveAgency(@RequestBody AgencyEntity agencyEntity) {
        return agencyService.saveAgency(agencyEntity);
    }

    @PutMapping
    public AgencyEntity updateAgency(@RequestBody AgencyEntity agencyEntity) {
        return agencyService.updateAgency(agencyEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAgency(@PathVariable("id") Long id) {
        agencyService.deleteAgency(id);
    }
}
