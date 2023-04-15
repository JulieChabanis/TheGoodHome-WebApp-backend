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
        document.add(list1);

        Paragraph text3 = new Paragraph("Désigné(s) « le bailleur »", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD ));
        text3.setSpacingAfter(5);
        document.add(text3);

        Paragraph text4 = new Paragraph("Il a été convenu ce qui suit : ", new Font(Font.FontFamily.UNDEFINED, 10));
        text4.setSpacingAfter(5);
        document.add(text4);

        document.add(new LineSeparator());

        // Partie 2 //
        Paragraph sousTitre2 = new Paragraph("2. OBJET DU CONTRAT", new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD));
        sousTitre2.setSpacingAfter(10);
        document.add(sousTitre2);

        Paragraph subtitle = new Paragraph("Le présent contrat a pour objet la location d’un logement ainsi déterminé : ", new Font(Font.FontFamily.UNDEFINED, 10));
        subtitle.setSpacingAfter(5);
        document.add(subtitle);

        Paragraph text5 = new Paragraph("Titre : " + leaseContractEntity.getAppartmentEntity().getTitle(), new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD));
        document.add(text5);

        Paragraph text6 = new Paragraph("Description : " + leaseContractEntity.getAppartmentEntity().getDescription(), new Font(Font.FontFamily.UNDEFINED, 10, Font.ITALIC));
        text6.setSpacingAfter(3);
        document.add(text6);

        List list2 = new List(List.UNORDERED);
        list2.add(new ListItem("Adresse du logement : " + leaseContractEntity.getAppartmentEntity().getAddress(), fontSize));
        list2.add(new ListItem("Adresse complémentaire : " + leaseContractEntity.getAppartmentEntity().getAdditionalAddress(), fontSize));
        list2.add(new ListItem("Ville et Code Postal : " + leaseContractEntity.getAppartmentEntity().getCity() + " " + leaseContractEntity.getAppartmentEntity().getZipcode(), fontSize));
        list2.add(new ListItem("Identifient appartement : " + leaseContractEntity.getAppartmentEntity().getId(), fontSize));
        document.add(list2);

        Paragraph text7 = new Paragraph("Internet : Test éligibilité fibre optique et ouverture ligne : 09 72 14 26 00 (non surtaxé)", new Font(Font.FontFamily.UNDEFINED, 8, Font.ITALIC));
        text7.setSpacingAfter(10);
        document.add(text7);

        document.add(new LineSeparator());

        // Partie 3 //
        Paragraph sousTitre3 = new Paragraph("3. CONDITIONS FINANCIERES", new Font(Font.FontFamily.UNDEFINED, 14, Font.BOLD));
        sousTitre3.setSpacingAfter(10);
        document.add(sousTitre3);

        Paragraph text8 = new Paragraph("Les parties conviennent des conditions financières suivantes : ", new Font(Font.FontFamily.UNDEFINED, 10));
        text8.setSpacingAfter(5);
        document.add(text8);

        List list3 = new List(List.UNORDERED);
        list3.add(new ListItem("Montant du Loyer mensuel Charges Comprises : " + leaseContractEntity.getAppartmentEntity().getRental() + "€", fontSize));
        list3.add(new ListItem("Montant des Charges comprises : " + leaseContractEntity.getAppartmentEntity().getRentalCharges() + "€", fontSize ));
        list3.add(new ListItem("Date ou période de paiement : Entre les 1 et 5 du mois", fontSize));
        list3.add(new ListItem("Modalités de paiement : virement bancaire", fontSize));
        list3.add(new ListItem("Montant de la caution à régler : " + leaseContractEntity.getAppartmentEntity().getSecurityDeposit() + "€", fontSize));
        document.add(list3);

        Paragraph text9 = new Paragraph("Montant de la caution déposé ce jour : " + leaseContractEntity.getSecurityDepositAmount() + "€", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD));
        text9.setSpacingAfter(15);
        document.add(text9);

        document.add(new LineSeparator());

        Paragraph text10 = new Paragraph("Date de signature du contrat de location : " + leaseContractEntity.getCreatedAt(), new Font(Font.FontFamily.UNDEFINED, 11, Font.BOLD));
        document.add(text10);

        Paragraph text11 = new Paragraph("Identifiant du contrat de location : " + leaseContractEntity.getId(), new Font(Font.FontFamily.UNDEFINED, 11, Font.UNDERLINE));
        text11.setSpacingAfter(15);
        document.add(text11);

        // Partie 4//
        Paragraph dateAndSignature = new Paragraph("Le ______ / ______ / __________, à _________________________________________,",
                new Font(Font.FontFamily.UNDEFINED, 10));
        dateAndSignature.setSpacingAfter(20);
        document.add(dateAndSignature);

        Paragraph signatures = new Paragraph("Signature du bailleur Signature du locataire",
                new Font(Font.FontFamily.UNDEFINED, 10));
        document.add(signatures);


        Paragraph mandataire = new Paragraph("[ou de son mandataire, le cas échéant]",
                new Font(Font.FontFamily.UNDEFINED, 10, Font.ITALIC));
        mandataire.setAlignment(Element.ALIGN_RIGHT);
        mandataire.setSpacingBefore(20);
        document.add(mandataire);

        // Partie 5 //
        Paragraph notes = new Paragraph("Notes : ", new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD));
        notes.setSpacingBefore(20);
        document.add(notes);

        Paragraph note1 = new Paragraph("Le présent contrat est établi en deux exemplaires originaux, dont chacune des parties reconnaît avoir reçu le sien.", new Font(Font.FontFamily.UNDEFINED, 7));
        note1.setSpacingAfter(5);
        document.add(note1);

        Paragraph note2 = new Paragraph("Il est rappelé au locataire que le fait de donner en location un logement qui ne constitue pas sa résidence principale pour une durée inférieure ou égale à 120 jours par an est soumis à la déclaration préalable en mairie (article L. 324-1-1 du code du tourisme).", new Font(Font.FontFamily.UNDEFINED, 7));
        note2.setSpacingAfter(5);
        document.add(note2);

        Paragraph note3 = new Paragraph("Le locataire doit s'assurer contre les risques locatifs conformément à l'article 7 de la loi n° 89-462 du 6 juillet 1989.", new Font(Font.FontFamily.UNDEFINED, 7));
        note3.setSpacingAfter(5);
        document.add(note3);

        document.close();
        return outputStream.toByteArray();
    }
}

