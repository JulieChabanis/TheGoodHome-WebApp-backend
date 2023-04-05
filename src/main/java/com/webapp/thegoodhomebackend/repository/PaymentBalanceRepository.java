package com.webapp.thegoodhomebackend.repository;

import com.webapp.thegoodhomebackend.entity.PaymentBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentBalanceRepository extends JpaRepository<PaymentBalanceEntity, Long> {
}
