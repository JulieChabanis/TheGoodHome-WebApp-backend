package com.webapp.thegoodhomebackend.controller;

import com.webapp.thegoodhomebackend.entity.PaymentBalanceEntity;
import com.webapp.thegoodhomebackend.service.PaymentBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solde_paiements")
@CrossOrigin( origins = "https://thegoodhome.netlify.app")

public class PaymentBalanceController {

    @Autowired
    private PaymentBalanceService paymentBalanceService;

    @GetMapping("")
    public List<PaymentBalanceEntity> getAllPaymentBalances() {
        return paymentBalanceService.getAllPaymentBalances();
    }

    @GetMapping("{id}")
    public PaymentBalanceEntity getPaymentBalanceById(@PathVariable Long id) {
        return paymentBalanceService.getPaymentBalanceById(id);
    }

    @PostMapping("")
    public void createPaymentBalance(@RequestBody PaymentBalanceEntity paymentBalanceEntity) {
        paymentBalanceService.createPaymentBalance(paymentBalanceEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentBalance(@PathVariable Long id) {
        paymentBalanceService.deletePaymentBalanceById(id);
        return ResponseEntity.noContent().build();
    }

}
