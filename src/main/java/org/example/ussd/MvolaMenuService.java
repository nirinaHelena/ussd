package org.example.ussd;

import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class MvolaMenuService {
  private int soldeMvola = 10000;
  private final String numeroMvola = "+261 34 56 789 00";

  public void display(Scanner scanner) {
    while (true) {
      System.out.println(
          "\n"
              + "MVOLA\n"
              + "1. Acheter Crédit/Offre YAS\n"
              + "2. Transfert d'argent\n"
              + "3. MVola Crédit/Épargne\n"
              + "4. Retrait d'argent\n"
              + "5. Mon compte\n"
              + "X. Retour");
      System.out.print("Choix: ");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1" -> acheterCreditYas(scanner);
        case "2" -> transfertArgent(scanner);
        case "3" -> mvolaCreditEpargne(scanner);
        case "4" -> retraitArgent(scanner);
        case "5" -> monCompte();
        case "X", "x" -> {
          return;
        }
        default -> System.out.println("Choix invalide.");
      }
    }
  }

  private void acheterCreditYas(Scanner scanner) {
    System.out.print("Montant à acheter (AR) : ");
    try {
      int montant = Integer.parseInt(scanner.nextLine());
      if (montant <= soldeMvola) {
        soldeMvola -= montant;
        System.out.println(
            "Achat de crédit YAS réussi. Solde MVOLA restant : " + soldeMvola + " AR");
      } else {
        System.out.println("Solde MVOLA insuffisant.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide.");
    }
  }

  private void transfertArgent(Scanner scanner) {
    System.out.print("Numéro destinataire : ");
    String destinataire = scanner.nextLine();
    System.out.print("Montant à transférer (AR) : ");
    try {
      int montant = Integer.parseInt(scanner.nextLine());
      if (montant <= soldeMvola) {
        soldeMvola -= montant;
        System.out.println(
            "Transfert de " + montant + " AR à " + destinataire + " effectué avec succès.");
        System.out.println("Nouveau solde : " + soldeMvola + " AR");
      } else {
        System.out.println("Solde insuffisant.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide.");
    }
  }

  private void mvolaCreditEpargne(Scanner scanner) {
    System.out.println("Fonctionnalité non encore disponible.");
  }

  private void retraitArgent(Scanner scanner) {
    System.out.print("Montant à retirer (AR) : ");
    try {
      int montant = Integer.parseInt(scanner.nextLine());
      if (montant <= soldeMvola) {
        soldeMvola -= montant;
        System.out.println(
            "Retrait de " + montant + " AR effectué. Nouveau solde : " + soldeMvola + " AR");
      } else {
        System.out.println("Solde insuffisant.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide.");
    }
  }

  private void monCompte() {
    System.out.println("Numéro MVOLA : " + numeroMvola);
    System.out.println("Solde : " + soldeMvola + " AR");
  }
}
