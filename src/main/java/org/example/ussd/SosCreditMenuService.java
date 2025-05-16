package org.example.ussd;

import static org.example.ussd.MainMenuService.readLineWithTimeout;

import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class SosCreditMenuService {
  public void display(Scanner scanner, UssdSession session) {
    while (true) {
      System.out.println("\nSOS CREDIT\n1. SOS Credit à YAS\n2. Rembourser SOS\nX. Retour");
      System.out.print("Choix: ");
      String choice = readLineWithTimeout(scanner, 10);
      switch (choice) {
        case "1" -> handleSosCredit(scanner, session);
        case "2" -> handleRemboursement(scanner, session);
        case "X", "x" -> {
          return;
        }
        default -> System.out.println("Choix invalide.");
      }
    }
  }

  private void handleSosCredit(Scanner scanner, UssdSession session) {
    if (session.sosCreditEnCours) {
      System.out.println("Crédit SOS en cours. Opération annulée.");
      return;
    }
    System.out.println("1. 500 AR\n2. 1000 AR\n3. 2000 AR");
    String montant = readLineWithTimeout(scanner, 10);
    int montantInt =
        switch (montant) {
          case "1" -> 500;
          case "2" -> 1000;
          case "3" -> 2000;
          default -> 0;
        };
    if (montantInt > 0) {
      session.soldeYas += montantInt;
      session.sosCreditEnCours = true;
      session.montantSos = montantInt;
      System.out.println("Crédit SOS accordé. Nouveau solde : " + session.soldeYas + " AR");
    } else {
      System.out.println("Choix invalide.");
    }
  }

  private void handleRemboursement(Scanner scanner, UssdSession session) {
    if (!session.sosCreditEnCours) {
      System.out.println("Aucun crédit SOS en cours.");
      return;
    }
    System.out.println("Montant dû : " + session.montantSos + " AR");
    if (session.soldeYas >= session.montantSos) {
      session.soldeYas -= session.montantSos;
      session.sosCreditEnCours = false;
      session.montantSos = 0;
      System.out.println("Remboursement réussi. Solde restant : " + session.soldeYas + " AR");
    } else {
      System.out.println("Solde insuffisant");
    }
  }
}
