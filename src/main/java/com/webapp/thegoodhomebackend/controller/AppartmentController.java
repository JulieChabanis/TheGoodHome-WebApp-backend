package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.service.AppartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appartments")
@CrossOrigin("http://localhost:3000/")
public class AppartmentController {

    private final AppartmentService appartmentService;

    public AppartmentController(AppartmentService appartmentService) {
        this.appartmentService = appartmentService;
    }

    @GetMapping
    public List<AppartmentEntity> findAllAppartments() {
        return appartmentService.findAllAppartments();
    }

    @GetMapping("{id}")
    public Optional<AppartmentEntity> findAppartmentById(@PathVariable("id")Long id) {
        return appartmentService.findById(id);
    }

    @PostMapping
    public AppartmentEntity saveAppartment(@RequestBody AppartmentEntity appartmentEntity) {
        return appartmentService.saveAppartment(appartmentEntity);
    }

    @PutMapping
    public AppartmentEntity updateAppartment(@RequestBody AppartmentEntity appartmentEntity) {
        return appartmentService.updateAppartment(appartmentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAppartment(@PathVariable("id") Long id) {
        appartmentService.deleteAppartment(id);
    }
}
