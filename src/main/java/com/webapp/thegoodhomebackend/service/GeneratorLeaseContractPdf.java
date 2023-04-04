package com.webapp.thegoodhomebackend.service;

import com.itextpdf.text.PageSize;
import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.entity.TenantEntity;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class GeneratorLeaseContractPdf {

    private GeneratorLeaseContractPdf() {}

    public static void generatePdf(AppartmentEntity appartmentEntity, TenantEntity tenantEntity) throws Exception {

        // Create new PDF with iText
        Document document = new Document(PageSize.A4);

        // Write in the doc
        PdfWriter.getInstance(document, new FileOutputStream("ContratdeLocation.pdf"));

        // Open doc
        document.open();

        // Add content in lease contract
        document.add(new Paragraph("CONTRAT DE LOCATION / COLOCATION"));
        document.add(new Paragraph("(Soumis au titre Ier bis de la loi du 6 juillet 1989 et portant modification de la loi n° 86-1290 du 23 décembre 1986 – bail type conforme aux dispositions de la loi Alur de 2014, mis en application par le décret du 29 mai 2015)"));
        document.add(new Paragraph("I. Désignation des parties"));
        document.add(new Paragraph("Le présent contrat est conclu entre les soussignés :"));
        document.add(new Paragraph("Bailleur :"));
        document.add(new Paragraph("Locataire(s) :"));
        document.add(new Paragraph("Prénom" + tenantEntity.getName()));
        document.add(new Paragraph("Nom" + tenantEntity.getLastName()));
        document.add(new Paragraph("Email" + tenantEntity.getEmail()));
        document.add(new Paragraph("Téléphone" + tenantEntity.getPhone()));
        document.add(new Paragraph("désigné(s) ci-aprés <<Le Locataire>>"));
        document.add(new Paragraph(" II. Object du contrat "));
        document.add(new Paragraph("Le présent contrat a pour object la location d'un logement à durée indeterminée"));
        document.add(new Paragraph("Nom du logement :" + appartmentEntity.getTitle()));
        document.add(new Paragraph("Type d'Habitat :" + appartmentEntity.getDescription()));
        document.add(new Paragraph("Addresse du Logement :" + appartmentEntity.getAddress()));
        document.add(new Paragraph("Complément d'addresse :" + appartmentEntity.getAdditionalAddress()));
        document.add(new Paragraph("Ville:" + appartmentEntity.getCity()));
        document.add(new Paragraph("Code Postal :" + appartmentEntity.getZipcode()));
        document.add(new Paragraph("III. Date de prise d'effet et durée du contrat:"));

        document.close();

        // Open PDF File
        Desktop.getDesktop().open(new File("ContratdeLocation.pdf"));
    }


}
