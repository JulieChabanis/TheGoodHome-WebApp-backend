package com.webapp.thegoodhomebackend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "lease_contracts")
@NoArgsConstructor
public class LeaseContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lease_contract_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private TenantEntity tenantEntity;

    @ManyToOne
    @JoinColumn(name = "appartment_id", nullable = false)
    private AppartmentEntity appartmentEntity;

    @Column (name = "security_deposit_amount")
    private float securityDepositAmount;

    @Column(name = "security_deposit_paid")
    private Boolean securityDepositPaid;

    @Column(name ="created_at", nullable = false)
    private LocalDate createdAt;


    public LeaseContractEntity(Long id, TenantEntity tenantEntity, AppartmentEntity appartmentEntity, float securityDepositAmount, Boolean securityDepositPaid, LocalDate createdAt) {
        this.id = id;
        this.tenantEntity = tenantEntity;
        this.appartmentEntity = appartmentEntity;
        this.securityDepositAmount = securityDepositAmount;
        this.securityDepositPaid = securityDepositPaid;
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

    public float getSecurityDepositAmount() {
        return securityDepositAmount;
    }

    public void setSecurityDepositAmount(float securityDepositAmount) {
        this.securityDepositAmount = securityDepositAmount;
    }

    public Boolean getSecurityDepositPaid() {
        return securityDepositPaid;
    }

    public void setSecurityDepositPaid(Boolean securityDepositPaid) {
        this.securityDepositPaid = securityDepositPaid;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
