package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.service.AppartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartments")
@CrossOrigin( origins = "http://localhost:3000")

public class AppartmentController {
    @Autowired
    private AppartmentService appartmentService;

    @GetMapping("")
    public List<AppartmentEntity> getAppartments() {
        return appartmentService.getAppartments();
    }

    @GetMapping("/{id}")
    public AppartmentEntity getAppartment(@PathVariable Long id) {

        return appartmentService.getAppartment(id);
    }

    @PostMapping("")
    public void createAppartment (@RequestBody AppartmentEntity appartmentEntity) {
        appartmentService.createAppartment(appartmentEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAppartment(@PathVariable Long id, @RequestBody AppartmentEntity appartmentEntity) {
        appartmentService.updateAppartment(id, appartmentEntity);
        return ResponseEntity.ok("Appartment with id " + id + " has been modified successfully.");
    }

    @DeleteMapping("/{id}")
    String deleteAppartmentById(@PathVariable Long id) {
        appartmentService.deleteAppartmentById(id);
        return "Appartment with id " + id +" has been deleted success.";
    }
}
