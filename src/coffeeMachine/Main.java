package coffeeMachine;

import java.util.Scanner;

public class Main {
    private static final int WATER_CONSUMPTION = 200;
    private static final int MILK_CONSUMPTION = 50;
    private static final int BEANS_CONSUMPTION = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
          System.out.print("Write how many ml of water the coffee machine has: ");
          int water = scanner.nextInt();
          System.out.print("Write how many ml of milk the coffee machine has: ");
          int milk = scanner.nextInt();
          System.out.print("Write how many grams of coffee the coffee machine has: ");
          int beans = scanner.nextInt();
          System.out.print("Write how many cups of coffee you will need: ");
          int cups = scanner.nextInt();

          CoffeeMachine machine = new CoffeeMachine.Builder(WATER_CONSUMPTION,
          MILK_CONSUMPTION, BEANS_CONSUMPTION).water(water).beans(beans).milk(milk).build();

          int capacity = machine.getBrewCapacity();

          if (capacity > cups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that) %n", capacity-cups);
          } else if (capacity == cups) {
            System.out.println("Yes, I can make that amount of coffee");
          } else {
            System.out.printf("No, I can make only %d cups of coffee %n", capacity);
          }
          
        } catch (Exception ioe) {
          System.out.println("Please enter an an Integer value");
        }
    }
}

class CoffeeMachine {

    int getBrewCapacity() {
      int wLim = water / waterConsumption;
      int mLim = milk / milkConsumption;
      int bLim = beans / beansConsumption;

      if (wLim <= mLim && wLim <= bLim) {
        return wLim;
      } else if (mLim <= wLim && mLim <= bLim) {
        return mLim;
      } else {
        return bLim;
      }
    }

    //capacity
    private final int water;
    private final int milk;
    private final int beans;

    //per cup consumption
    private final int waterConsumption;
    private final int milkConsumption;
    private final int beansConsumption;

    static class Builder {
      //capacity
      private int water = 0;
      private int milk = 0;
      private int beans = 0;

      //per cup consumption
      private final int waterConsumption;
      private final int milkConsumption;
      private final int beansConsumption;

      Builder (int waterConsumption, int milkConsumption, int beansConsumption) {
        this.waterConsumption = waterConsumption;
        this.milkConsumption = milkConsumption;
        this.beansConsumption = beansConsumption;
      }

      Builder water(int val) {
        water = val;
        return this;
      }

      Builder milk(int val) {
        milk = val;
        return this;
      }

      Builder beans(int val) {
        beans = val;
        return this;
      }

      CoffeeMachine build() {
        return new CoffeeMachine(this);
      }
    }

    private CoffeeMachine(Builder builder) {
      waterConsumption = builder.waterConsumption;
      milkConsumption = builder.milkConsumption;
      beansConsumption = builder.beansConsumption;
      water = builder.water;
      milk = builder.milk;
      beans = builder.beans;
    }
}
