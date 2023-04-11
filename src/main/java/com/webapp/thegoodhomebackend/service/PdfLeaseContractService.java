package com.webapp.thegoodhomebackend.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

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
        document.add(soustitre);

        document.close();
        return outputStream.toByteArray();
    }
}

