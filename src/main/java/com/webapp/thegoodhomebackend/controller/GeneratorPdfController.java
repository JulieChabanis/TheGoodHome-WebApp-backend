package com.webapp.thegoodhomebackend.controller;

import com.itextpdf.text.DocumentException;
import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import com.webapp.thegoodhomebackend.service.LeaseContractService;
import com.webapp.thegoodhomebackend.service.PdfLeaseContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
@CrossOrigin( origins = "http://localhost:3000")
public class GeneratorPdfController {

    private final LeaseContractService leaseContractService;

    @Autowired
    public GeneratorPdfController(LeaseContractService leaseContractService) {
        this.leaseContractService = leaseContractService;
    }

    @GetMapping(value = ("/pdf/{id}"), produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@PathVariable("id") Long id) throws DocumentException {
        LeaseContractEntity leaseContract = leaseContractService.getLeaseContractById(id);
        byte[] pdfContent = PdfLeaseContractService.generatePdf(leaseContract);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "document.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return ResponseEntity.ok().headers(headers).body(pdfContent);
    }
}
