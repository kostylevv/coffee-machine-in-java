package coffeeMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you will need:");
        try {
          int cups = scanner.nextInt();
          System.out.printf("For %d cups of coffee you will need: %n", cups);
          System.out.printf("%d ml of water %n", cups*WATER);
          System.out.printf("%d ml of milk %n", cups*MILK);
          System.out.printf("%d g of coffee beans %n", cups*BEANS);

        } catch (Exception ioe) {
          System.out.println("Cups should be an Integer value");
        }
    }

  private static final int WATER = 200;
  private static final int MILK = 50;
  private static final int BEANS = 15;

}
