package org.example.ussd;

import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class ServiceYasMenuService {
  public void display(Scanner scanner, UssdSession session) throws InterruptedException {
    while (true) {
      System.out.println(
          """

SERVICE YAS
1. Info crédit
2. Recharge
6. Acheter une offre
7. Mon numéro
X. Retour""");

      System.out.print("Choix: ");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1" -> {
          System.out.println("Solde YAS : " + session.soldeYas + " AR");
          Thread.sleep(3000);
        }
        case "2" -> {
          System.out.print("Entrez le montant (AR) : ");
          try {
            int montant = Integer.parseInt(scanner.nextLine());
            session.soldeYas += montant;
            System.out.println("Recharge réussie. Nouveau solde : " + session.soldeYas + " AR");
          } catch (NumberFormatException e) {
            System.out.println("Montant invalide.");
          }
        }
        case "6" -> {
          System.out.println("1. 100Mo – 1 000 AR\n2. Appel illimité – 5 000 AR");
          String opt = scanner.nextLine();
          int prix = opt.equals("1") ? 1000 : opt.equals("2") ? 5000 : 0;
          if (prix > 0 && session.soldeYas >= prix) {
            session.soldeYas -= prix;
            System.out.println("Offre achetée. Nouveau solde : " + session.soldeYas + " AR");
          } else if (prix > 0) {
            System.out.println("Solde insuffisant");
          } else {
            System.out.println("Choix invalide");
          }
        }
        case "7" -> System.out.println("Votre numéro YAS : " + session.numeroYas);
        case "X", "x" -> {
          return;
        }
        default -> System.out.println("Choix invalide.");
      }
    }
  }
}
