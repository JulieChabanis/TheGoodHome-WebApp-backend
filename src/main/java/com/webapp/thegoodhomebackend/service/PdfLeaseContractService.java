package com.webapp.thegoodhomebackend.service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.webapp.thegoodhomebackend.entity.LeaseContractEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;


@Service
public class PdfLeaseContractService {

    private PdfLeaseContractService() {}

    public static byte[] generatePdf(LeaseContractEntity leaseContractEntity) throws DocumentException {
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
        Paragraph sousTitre1 = new Paragraph("1. DESIGNATION DES PARTIES", new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD));
        sousTitre1.setSpacingAfter(10);
        document.add(sousTitre1);

        Paragraph text1 = new Paragraph("Le présent contrat est conclu entre les soussignés : ", new Font(Font.FontFamily.UNDEFINED, 12, Font.BOLD));
        text1.setSpacingAfter(5);
        document.add(text1);

        List list = new List(List.UNORDERED);
        Font fontBold = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
        Font fontSize = new Font(Font.FontFamily.UNDEFINED, 10);
        list.add(new ListItem("Nom et Prénom du ou des Locataire : " + leaseContractEntity.getTenantEntity().getName()  + " " + leaseContractEntity.getTenantEntity().getLastName(),fontBold));
        list.add(new ListItem("Email : " + leaseContractEntity.getTenantEntity().getEmail(), fontSize));
        list.add(new ListItem("Téléphone : " + leaseContractEntity.getTenantEntity().getPhone(), fontSize));
        list.add(new ListItem("Identifiant Locataire : " + leaseContractEntity.getTenantEntity().getId(), fontSize));
        document.add(list);

        Paragraph text2 = new Paragraph("Désigné(s) « le locataire »", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD ));
        text2.setSpacingAfter(5);
        document.add(text2);

        List list1 = new List(List.UNORDERED);
        list1.add(new ListItem("Nom du Bailleur : ", fontBold));
        list1.add(new ListItem("Adresse : ", fontSize));
        list1.add(new ListItem("Adresse complémentaire : ", fontSize));
        list1.add(new ListItem("Ville et Code Postal : ", fontSize));
        list1.add(new ListItem("Identifiant Bailleur : ", fontSize));
        document.add(list);

        Paragraph text3 = new Paragraph("Désigné(s) « le bailleur »", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD ));
        text3.setSpacingAfter(5);
        document.add(text3);

        Paragraph text4 = new Paragraph("Il a été convenu ce qui suit : ", new Font(Font.FontFamily.UNDEFINED, 12));
        text4.setSpacingAfter(5);
        document.add(text4);


        document.add(new LineSeparator());

        // Partie 2 //
        Paragraph sousTitre2 = new Paragraph("2. OBJET DU CONTRAT", new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD));
        sousTitre2.setSpacingAfter(10);
        document.add(sousTitre2);

        document.add(new LineSeparator());

        // Partie 3 //
        Paragraph sousTitre3 = new Paragraph("3. CONDITIONS FINANCIERES", new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD));
        sousTitre3.setSpacingAfter(10);
        document.add(sousTitre3);

        document.close();
        return outputStream.toByteArray();
    }
}

