package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CoffeeMaker machine = new CoffeeMaker(400, 540, 120, 550, 9);
        boolean machineOn = false;

        while (!machineOn){
            System.out.println("");
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = " ";
            if( input.hasNextLine()){
                action = input.nextLine();
            }
            switch (action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = input.nextLine();
                    switch (choice){
                        case "1":
                            machine.makeEspresso();
                            break;
                        case "2":
                            machine.makeLatte();
                            break;
                        case "3":
                            machine.makeCappuccino();
                            break;
                        case "back":
                            break;
                    }
                    break;

                case "fill":
                    machine.fillMachine();
                    break;
                case "take":
                    machine.takeMoney();
                    break;
                case "remaining":
                    machine.coffeeMachineState();
                    break;
                case "exit":
                    machineOn = true;
                    break;
                default:
                    //   System.out.println("Invalid option");
            }
        }

    }
    public static class CoffeeMaker {

        private int waterAvailable;
        private int milkAvailable;
        private int coffeeGroundsAvailable;
        private int moneyAvailable;
        private int disposableCups;

        Scanner input = new Scanner(System.in);

        public CoffeeMaker(int waterAvailable, int milkAvailable, int coffeeGroundsAvailable, int moneyAvailable, int disposableCups) {
            this.waterAvailable = waterAvailable;
            this.milkAvailable = milkAvailable;
            this.coffeeGroundsAvailable = coffeeGroundsAvailable;
            this.moneyAvailable = moneyAvailable;
            this.disposableCups = disposableCups;
        }

        public void coffeeMachineState() {
            System.out.println("");
            System.out.println("The coffee machine has: ");
            System.out.println(waterAvailable + " of water");
            System.out.println(milkAvailable + " of milk");
            System.out.println(coffeeGroundsAvailable + " of coffee beans");
            System.out.println(disposableCups + " of disposable cups");
            System.out.println("$" + moneyAvailable + " of money");

        }

        public void makeEspresso() {
            System.out.println("");
            if (waterAvailable >= 250 && coffeeGroundsAvailable >= 16) {
                System.out.println("I have enough resources, making you a coffee!");
                this.waterAvailable -= 250;
                this.coffeeGroundsAvailable -= 16;
                this.disposableCups -= 1;
                this.moneyAvailable += 4;
            } else {
                if (waterAvailable < 200) {
                    System.out.println("Sorry, not enough water!");
                }
                if (milkAvailable < 100) {
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffeeGroundsAvailable < 12) {
                    System.out.println("Sorry, not enough coffee!");
                }
                if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }
        }

        public void makeLatte() {
            System.out.println("");
            if (waterAvailable >= 350 && milkAvailable >= 75
                    && coffeeGroundsAvailable >= 20) {
                System.out.println("I have enough resources, making you a coffee!");
                this.waterAvailable -= 350;
                this.milkAvailable -= 75;
                this.coffeeGroundsAvailable -= 20;
                this.disposableCups -= 1;
                this.moneyAvailable += 7;

            } else {
                if (waterAvailable < 200) {
                    System.out.println("Sorry, not enough water!");
                }
                if (milkAvailable < 100) {
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffeeGroundsAvailable < 12) {
                    System.out.println("Sorry, not enough coffee!");
                }
                if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }

        }

        public void makeCappuccino() {
            System.out.println("");
            if (waterAvailable >= 200 &&
                    milkAvailable >= 100 && coffeeGroundsAvailable >= 12) {
                System.out.println("I have enough resources, making you a coffee!");
                this.waterAvailable -= 200;
                this.milkAvailable -= 100;
                this.coffeeGroundsAvailable -= 12;
                this.disposableCups -= 1;
                this.moneyAvailable += 6;
            } else {
                if (waterAvailable < 200) {
                    System.out.println("Sorry, not enough water!");
                }
                if (milkAvailable < 100) {
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffeeGroundsAvailable < 12) {
                    System.out.println("Sorry, not enough coffee!");
                }
                if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
            }

        }

        public void takeMoney() {
            System.out.println("");
            System.out.println("I gave you $" + moneyAvailable);
            this.moneyAvailable = 0;
        }

        public void fillMachine() {
            System.out.println("");
            System.out.println("Write how many ml of water do you want to add: ");
            this.waterAvailable += input.nextInt();
            System.out.println("Write how many ml of milk do you want to add:  ");
            this.milkAvailable += input.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            this.coffeeGroundsAvailable += input.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            this.disposableCups += input.nextInt();
        }


    }

}
