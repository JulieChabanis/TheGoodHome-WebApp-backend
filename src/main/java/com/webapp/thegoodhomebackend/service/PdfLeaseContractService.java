package com.webapp.thegoodhomebackend.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.ByteArrayOutputStream;


public class PdfLeaseContractService {

    public static byte[] generatePdf() throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        Paragraph titre = new Paragraph("Contrat de Location", new Font(Font.FontFamily.UNDEFINED,22, Font.BOLD));
        titre.setAlignment(Element.ALIGN_CENTER);
        document.add(titre);

        Paragraph soustitre = new Paragraph("Soumis au titre Ier bis de la loi du 6 juillet 1989 et portant modification de la loi n° 86-1290 du 23 décembre 1986 – bail type conforme aux dispositions de la loi Alur de 2014, mis en application par le décret du 29 mai 2015",
            new Font(Font.FontFamily.UNDEFINED, 9, Font.ITALIC));
        soustitre.setAlignment(Element.ALIGN_CENTER);
        soustitre.setSpacingAfter(10);
        document.add(soustitre);

        document.add(new LineSeparator());

        // Partie 1 //
        Paragraph sousTitre1 = new Paragraph("1. Désignation des Parties", new Font(Font.FontFamily.UNDEFINED, 13, Font.BOLD));
        sousTitre1.setSpacingAfter(10);
        document.add(sousTitre1);

        Paragraph text1 = new Paragraph("Le présent contrat est conclu entre les soussignés : ", new Font(Font.FontFamily.UNDEFINED, 12));
        text1.setSpacingAfter(5);
        document.add(text1);

        document.add(new LineSeparator());

        // Partie 2 //
        Paragraph sousTitre2 = new Paragraph("2. Objet du Contrat", new Font(Font.FontFamily.UNDEFINED, 13, Font.BOLD));
        sousTitre2.setSpacingAfter(10);
        document.add(sousTitre2);

        document.add(new LineSeparator());

        // Partie 3 //
        Paragraph sousTitre3 = new Paragraph("3. Conditions financières", new Font(Font.FontFamily.UNDEFINED, 13, Font.BOLD));
        sousTitre3.setSpacingAfter(10);
        document.add(sousTitre3);

        document.close();
        return outputStream.toByteArray();
    }
}

