package org.example.ussd;

import java.util.Scanner;
import java.util.concurrent.*;
import org.springframework.stereotype.Service;

@Service
public class MainMenuService {
  private final MvolaMenuService mvolaMenuService;
  private final SosCreditMenuService sosCreditMenuService;
  private final ServiceYasMenuService serviceYasMenuService;

  public static String readLineWithTimeout(Scanner scanner, int timeoutSeconds) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<String> future = executor.submit(scanner::nextLine);
    try {
      return future.get(timeoutSeconds, TimeUnit.SECONDS);
    } catch (TimeoutException e) {
      System.out.println(
          "\nAucune entrée détectée pendant "
              + timeoutSeconds
              + " secondes. Fin de l'application.");
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executor.shutdownNow();
    }
    return null;
  }

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
      String choice = readLineWithTimeout(scanner, 10);
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
