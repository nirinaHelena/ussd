package org.example.ussd;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAppRunner implements CommandLineRunner {
  private final MainMenuService mainMenuService;

  public ConsoleAppRunner(MainMenuService mainMenuService) {
    this.mainMenuService = mainMenuService;
  }

  @Override
  public void run(String... args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    UssdSession session = new UssdSession();
    mainMenuService.display(scanner, session);
  }
}
