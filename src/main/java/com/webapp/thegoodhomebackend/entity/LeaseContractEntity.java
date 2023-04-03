package com.webapp.thegoodhomebackend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "lease_contract")
@NoArgsConstructor
public class LeaseContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenantEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appartment_id", nullable = false)
    private AppartmentEntity appartmentEntity;

    @Column(name ="created_at", nullable = false)
    private LocalDate createdAt;


    public LeaseContractEntity(Long id, TenantEntity tenantEntity, AppartmentEntity appartmentEntity, LocalDate createdAt) {
        this.id = id;
        this.tenantEntity = tenantEntity;
        this.appartmentEntity = appartmentEntity;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenantEntity getTenantEntity() {
        return tenantEntity;
    }

    public void setTenantEntity(TenantEntity tenantEntity) {
        this.tenantEntity = tenantEntity;
    }

    public AppartmentEntity getAppartmentEntity() {
        return appartmentEntity;
    }

    public void setAppartmentEntity(AppartmentEntity appartmentEntity) {
        this.appartmentEntity = appartmentEntity;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
