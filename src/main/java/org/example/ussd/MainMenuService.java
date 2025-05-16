package org.example.ussd;

import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class MainMenuService {
  private final MvolaMenuService mvolaMenuService;
  private final SosCreditMenuService sosCreditMenuService;
  private final ServiceYasMenuService serviceYasMenuService;

  public MainMenuService(
      MvolaMenuService mvolaMenuService,
      SosCreditMenuService sosCreditMenuService,
      ServiceYasMenuService serviceYasMenuService) {
    this.mvolaMenuService = mvolaMenuService;
    this.sosCreditMenuService = sosCreditMenuService;
    this.serviceYasMenuService = serviceYasMenuService;
  }

  public void display(Scanner scanner, UssdSession session) throws InterruptedException {
    while (true) {
      System.out.println("\n1. MVOLA\n2. SOS Credit\n3. Service YAS\nX. Quitter");
      System.out.print("Choix: ");
      String choice = scanner.nextLine();
      switch (choice) {
        case "1" -> mvolaMenuService.display(scanner);
        case "2" -> sosCreditMenuService.display(scanner, session);
        case "3" -> serviceYasMenuService.display(scanner, session);
        case "X", "x" -> {
          System.out.println("Merci d'avoir utilisé notre service.");
          return;
        }
        default -> System.out.println("Choix invalide.");
      }
    }
  }
}
