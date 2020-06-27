package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int Water_For_One_Cup = 200;
    static int Milk_For_One_Cup = 50;
    static int Coffee_Grounds_For_One_Cup = 15;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CoffeeMaker machine = new CoffeeMaker(400,540,120,550,9);

        machine.coffeeMachineState();
        System.out.println("Write action (buy, fill, take): ");
        String action = input.next();
        switch (action){
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        machine.makeEspresso();
                        break;
                    case 2:
                        machine.makeLatte();
                        break;
                    case 3:
                        machine.makeCappuccino();
                        break;
                    default:
                        //   System.out.println("Invalid option");
                }

                break;
            case "fill":
                machine.fillMachine();
                break;
            case "take":
                machine.takeMoney();
                break;
            default:
             //   System.out.println("Invalid option");
        }



    }



    public static void getCoffeeNeeds (int numberOfCoffees){
        System.out.println("For "+ numberOfCoffees + " cups of coffee you will need:");
        System.out.println(numberOfCoffees * Water_For_One_Cup + " ml of water ");
        System.out.println(numberOfCoffees * Milk_For_One_Cup + " ml of milk ");
        System.out.println(numberOfCoffees * Coffee_Grounds_For_One_Cup + " g of coffee beans");
    }

    public static boolean canMakeRequestedCoffee (int water, int milk, int coffee ,int numberOfCoffees){
       boolean canMakeCoffee = false;
        if((water - (numberOfCoffees * Water_For_One_Cup)) >= 0 &&
               (milk - (numberOfCoffees * Milk_For_One_Cup) >= 0) &&
        (coffee - (numberOfCoffees * Coffee_Grounds_For_One_Cup) >= 0)){
           canMakeCoffee = true;
        }
        return canMakeCoffee;
    }

    public static int coffeeCupsAvailable (int water, int milk, int coffee){
        int waterForNr =  water / Water_For_One_Cup;
        int milkForNr= milk / Milk_For_One_Cup;
        int coffeeGroundsForNr = coffee / Coffee_Grounds_For_One_Cup;
        int numberOfCoffeeCupsAvailable;
        if (waterForNr <= milkForNr && waterForNr <= coffeeGroundsForNr){
            numberOfCoffeeCupsAvailable = waterForNr;
        } else if (milkForNr <= waterForNr && milkForNr <= coffeeGroundsForNr){
            numberOfCoffeeCupsAvailable = milkForNr;
        } else {
            numberOfCoffeeCupsAvailable = coffeeGroundsForNr;
        }
        return numberOfCoffeeCupsAvailable;
    }


}
