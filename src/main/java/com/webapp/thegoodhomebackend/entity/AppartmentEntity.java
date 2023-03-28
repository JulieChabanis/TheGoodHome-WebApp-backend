package com.webapp.thegoodhomebackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "appartments")
@NoArgsConstructor
public class AppartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appartment_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "additional_address")
    private String additionalAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "rental")
    private float rental;

    @Column(name = "rental_charges")
    private float rentalCharges;

    @Column(name = "security_deposit")
    private float securityDeposit;


    public AppartmentEntity(long id, String title, String description, String address, String additionalAddress, String city, String zipcode, float rental, float rentalCharges, float securityDeposit) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.additionalAddress = additionalAddress;
        this.city = city;
        this.zipcode = zipcode;
        this.rental = rental;
        this.rentalCharges = rentalCharges;
        this.securityDeposit = securityDeposit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.title = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public float getRental() {
        return rental;
    }

    public void setRental(float rental) {
        this.rental = rental;
    }

    public float getRentalCharges() {
        return rentalCharges;
    }

    public void setRentalCharges(float rentalCharges) {
        this.rentalCharges = rentalCharges;
    }

    public float getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(float securityDeposit) {
        this.securityDeposit = securityDeposit;
    }
}
