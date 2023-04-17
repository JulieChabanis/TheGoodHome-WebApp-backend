package com.webapp.thegoodhomebackend.controller;


import com.itextpdf.text.DocumentException;
import com.webapp.thegoodhomebackend.entity.PaymentBalanceEntity;
import com.webapp.thegoodhomebackend.service.PaymentBalanceService;
import com.webapp.thegoodhomebackend.service.PdfRentReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rent-receipt")
@CrossOrigin( origins = "https://thegoodhome.netlify.app")
public class PdfRentReceiptController {

    private final PaymentBalanceService paymentBalanceService;

    @Autowired
    public PdfRentReceiptController(PaymentBalanceService paymentBalanceService) {
        this.paymentBalanceService = paymentBalanceService;
    }

    @GetMapping( value = ("/{id}"), produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@PathVariable("id") Long id) throws DocumentException {
        PaymentBalanceEntity paymentBalance = paymentBalanceService.getPaymentBalanceById(id);
        byte[] pdfContent = PdfRentReceiptService.generatePdf(paymentBalance);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "document.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return ResponseEntity.ok().headers(headers).body(pdfContent);
    }
}
