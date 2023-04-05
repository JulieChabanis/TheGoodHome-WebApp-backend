package com.webapp.thegoodhomebackend.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name ="payment_balances")
@NoArgsConstructor
public class PaymentBalanceEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "payment_balance_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "lease_contract_id", nullable =false)
    private LeaseContractEntity leaseContractEntity;

    @Column(name = "is_paid", nullable =false)
    private Boolean isPaid;

    @Column(name= "payment_date", nullable = false)
    private LocalDate paymentDate;

    public PaymentBalanceEntity(Long id, LeaseContractEntity leaseContractEntity, Boolean isPaid, LocalDate paymentDate) {
        this.id = id;
        this.leaseContractEntity = leaseContractEntity;
        this.isPaid = isPaid;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeaseContractEntity getLeaseContractEntity() {
        return leaseContractEntity;
    }

    public void setLeaseContractEntity(LeaseContractEntity leaseContractEntity) {
        this.leaseContractEntity = leaseContractEntity;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

}
