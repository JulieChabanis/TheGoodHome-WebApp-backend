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

    @Column (name ="rental_payment_amount")
    private float rentalPaymentAmount;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Column(name = "rental_payment_amount_with_tax")
    private float rentalPaymentAmountWithTax;

    @Column(name= "payment_date", nullable = false)
    private LocalDate paymentDate;

    public PaymentBalanceEntity(Long id, LeaseContractEntity leaseContractEntity, float rentalPaymentAmount, Boolean isPaid, float rentalPaymentAmountWithTax, LocalDate paymentDate) {
        this.id = id;
        this.leaseContractEntity = leaseContractEntity;
        this.rentalPaymentAmount = rentalPaymentAmount;
        this.isPaid = isPaid;
        this.rentalPaymentAmountWithTax =rentalPaymentAmountWithTax;
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

    public float getRentalPaymentAmount() {
        return rentalPaymentAmount;
    }

    public void setRentalPaymentAmount(float rentalPaymentAmount) {

        this.rentalPaymentAmount = rentalPaymentAmount;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
       this.isPaid = isPaid;
    }

    public float getRentalPaymentAmountWithTax() {
        return rentalPaymentAmountWithTax;
    }

    public void setRentalPaymentAmountWithTax(float rentalPaymentAmountWithTax) {
        this.rentalPaymentAmountWithTax = rentalPaymentAmountWithTax;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

}
