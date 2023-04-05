package com.webapp.thegoodhomebackend.service;

import com.webapp.thegoodhomebackend.entity.PaymentBalanceEntity;
import com.webapp.thegoodhomebackend.repository.PaymentBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentBalanceService {

    @Autowired
    private PaymentBalanceRepository paymentBalanceRepository;

    public List<PaymentBalanceEntity> getAllPaymentBalances() {
        return paymentBalanceRepository.findAll();
    }

    public PaymentBalanceEntity getPaymentBalanceById(Long id) {
        Optional<PaymentBalanceEntity> paymentBalanceEntity = paymentBalanceRepository.findById(id);
        if (paymentBalanceEntity.isPresent()) {
            return paymentBalanceEntity.get();
        } else {
            throw new RuntimeException("Payment Balance not found");
        }
    }

    public void createPaymentBalance(PaymentBalanceEntity paymentBalanceEntity) {
        paymentBalanceRepository.save(paymentBalanceEntity);
    }

    public void deletePaymentBalanceById(Long id) {
        paymentBalanceRepository.deleteById(id);
    }
}


