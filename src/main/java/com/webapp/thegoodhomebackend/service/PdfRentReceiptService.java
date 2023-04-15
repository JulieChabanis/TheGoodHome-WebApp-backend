package com.webapp.thegoodhomebackend.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.webapp.thegoodhomebackend.entity.PaymentBalanceEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfRentReceiptService {

    private PdfRentReceiptService() {}

    public static byte[] generatePdf(PaymentBalanceEntity paymentBalanceEntity) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Tenant Infos
        PdfPTable tenantTable = new PdfPTable(2);
        tenantTable.setWidthPercentage(100);
        tenantTable.setSpacingBefore(10f);

        Font boldFont = new Font(Font.FontFamily.UNDEFINED, 8, Font.BOLD);
        Font smallFont = new Font(Font.FontFamily.UNDEFINED, 8, Font.NORMAL);

        PdfPCell cell1 = new PdfPCell(new Phrase("Détails Locataire :", boldFont));
        cell1.setColspan(2);
        tenantTable.addCell(cell1);


        tenantTable.addCell(new Phrase("Nom et prénom :", boldFont));
        tenantTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getTenantEntity().getName() + " " + paymentBalanceEntity.getLeaseContractEntity().getTenantEntity().getLastName(), smallFont));
        tenantTable.addCell(new Phrase("Email :", boldFont));
        tenantTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getTenantEntity().getEmail(), smallFont));
        tenantTable.addCell(new Phrase("Téléphone:", boldFont));
        tenantTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getTenantEntity().getPhone(), smallFont));
        tenantTable.addCell(new Phrase("Identifiant Locataire :", boldFont));
        tenantTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getTenantEntity().getId() + "", smallFont));
        tenantTable.addCell(new Phrase("Identifiant Dossier :", boldFont));
        tenantTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getId() + "", smallFont));


        PdfPCell tenantCell = new PdfPCell(tenantTable);
        tenantCell.setBorder(Rectangle.BOX);
        tenantCell.setPadding(10f);

        // Apartment Infos
        PdfPTable apartmentTable = new PdfPTable(2);
        apartmentTable.setWidthPercentage(100);
        apartmentTable.setSpacingBefore(10f);

        PdfPCell cell = new PdfPCell(new Phrase("Détails Logement :", boldFont));
        cell.setColspan(2);
        apartmentTable.addCell(cell);

        apartmentTable.addCell(new Phrase("Titre:", boldFont));
        apartmentTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getTitle(), smallFont));
        apartmentTable.addCell(new Phrase("Adresse :", boldFont));
        apartmentTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getAddress(), smallFont));
        apartmentTable.addCell(new Phrase("Adresse Complémentaire :", boldFont));
        apartmentTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getAdditionalAddress(), smallFont));
        apartmentTable.addCell(new Phrase("Ville et Code Postal :", boldFont));
        apartmentTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getCity() + " " + paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getZipcode(), smallFont));
        apartmentTable.addCell(new Phrase("Identifiant Logement:", boldFont));
        apartmentTable.addCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getId() + " ", smallFont));

        PdfPCell apartmentCell = new PdfPCell(apartmentTable);
        apartmentCell.setBorder(Rectangle.BOX);
        apartmentCell.setPadding(10f);

        // Main Table
        PdfPTable mainTable = new PdfPTable(2);
        mainTable.setWidthPercentage(100);

        mainTable.addCell(tenantCell);
        mainTable.addCell(apartmentCell);

        document.add(mainTable);

        Paragraph titre = new Paragraph("QUITTANCE DE LOYER", new Font(Font.FontFamily.UNDEFINED,22, Font.BOLD));
        titre.setAlignment(Element.ALIGN_CENTER);
        titre.setSpacingBefore(40);
        titre.setSpacingAfter(40);
        document.add(titre);

        // Quittance Rental Receipt
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(80);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setTotalWidth(new float[]{ 120, 120, 120 });
        table.setLockedWidth(true);

        PdfPCell cellPeriodTitle = new PdfPCell(new Phrase("QUITTANCE POUR LA PERIODE :", new Font(Font.FontFamily.UNDEFINED,11, Font.BOLD )));
        cellPeriodTitle.setBorder(Rectangle.NO_BORDER);
        cellPeriodTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellPeriodTitle.setPaddingBottom(10f);

        PdfPCell cellPeriodValue = new PdfPCell(new Phrase("Date :" +paymentBalanceEntity.getLeaseContractEntity().getCreatedAt()));
        cellPeriodValue.setBorder(Rectangle.NO_BORDER);
        cellPeriodValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellPeriodValue.setPaddingBottom(10f);

        PdfPCell cellEmpty = new PdfPCell(new Phrase(""));
        cellEmpty.setBorder(Rectangle.NO_BORDER);

        table.addCell(cellPeriodTitle);
        table.addCell(cellEmpty);
        table.addCell(cellPeriodValue);

        PdfPCell cellRentTitle = new PdfPCell(new Phrase("Le loyer charges comprises :"));
        cellRentTitle.setBorder(Rectangle.NO_BORDER);
        cellRentTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellRentTitle.setPaddingBottom(10f);

        PdfPCell cellRentValue = new PdfPCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getRental() + "€"));
        cellRentValue.setBorder(Rectangle.NO_BORDER);
        cellRentValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellRentValue.setPaddingBottom(10f);


        table.addCell(cellRentTitle);
        table.addCell(cellEmpty);
        table.addCell(cellRentValue);

        PdfPCell cellChargesTitle = new PdfPCell(new Phrase("Dont charges comprises :"));
        cellChargesTitle.setBorder(Rectangle.NO_BORDER);
        cellChargesTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellChargesTitle.setPaddingBottom(10f);

        PdfPCell cellChargesValue = new PdfPCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getRentalCharges() + "€"));
        cellChargesValue.setBorder(Rectangle.NO_BORDER);
        cellChargesValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellChargesValue.setPaddingBottom(10f);

        table.addCell(cellChargesTitle);
        table.addCell(cellEmpty);
        table.addCell(cellChargesValue);

        PdfPCell cellTotalTitle = new PdfPCell(new Phrase("MONTANT TOTAL A PAYER :", new Font(Font.FontFamily.UNDEFINED,11, Font.BOLD )));
        cellTotalTitle.setBorder(Rectangle.NO_BORDER);
        cellTotalTitle.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellTotalTitle.setPaddingBottom(10f);
        cellTotalTitle.setBackgroundColor(BaseColor.LIGHT_GRAY);

        PdfPCell cellTotalValue = new PdfPCell(new Phrase(paymentBalanceEntity.getLeaseContractEntity().getAppartmentEntity().getRental() + "€", new Font(Font.FontFamily.UNDEFINED,11, Font.BOLD)));
        cellTotalValue.setBorder(Rectangle.NO_BORDER);
        cellTotalValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellTotalValue.setPaddingBottom(10f);
        cellTotalValue.setBackgroundColor(BaseColor.LIGHT_GRAY);

        table.addCell(cellTotalTitle);
        table.addCell(cellEmpty);
        table.addCell(cellTotalValue);
        document.add(table);

        Paragraph text1 = new Paragraph("Le Montant a déjà été payé : " + paymentBalanceEntity.getIsPaid(), smallFont);
        text1.setSpacingBefore(30);
        document.add(text1);

        Paragraph text4 = new Paragraph("Montant payé : " + paymentBalanceEntity.getRentalPaymentAmount(), smallFont);
        document.add(text4);

        Paragraph text3 = new Paragraph("Montant Total payé le : " + paymentBalanceEntity.getPaymentDate(), boldFont);
        text3.setSpacingAfter(5);
        document.add(text3);

        document.close();
        return outputStream.toByteArray();
    }
}
