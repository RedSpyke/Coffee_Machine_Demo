package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int Water_For_One_Cup = 200;
    static int Milk_For_One_Cup = 50;
    static int Coffee_Grounds_For_One_Cup = 15;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int waterAvailable;
        int milkAvailable;
        int coffeeGroundsAvailable;


        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        System.out.println("Write how many ml of water the coffee machine has: ");
        waterAvailable = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milkAvailable = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        coffeeGroundsAvailable = input.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int numberOfCoffees = input.nextInt();

        if (coffeeCupsAvailable(waterAvailable,milkAvailable,coffeeGroundsAvailable) >= numberOfCoffees){
            int extraCoffee = coffeeCupsAvailable(waterAvailable,milkAvailable,coffeeGroundsAvailable) - numberOfCoffees;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCoffee + " more than that)");
        }
        else if(canMakeRequestedCoffee(waterAvailable, milkAvailable,coffeeGroundsAvailable,numberOfCoffees)){
            System.out.println("Yes, I can make that amount of coffee");
        }else {
            System.out.println("No, I can make only " + coffeeCupsAvailable(waterAvailable,milkAvailable,coffeeGroundsAvailable) + " cup(s) of coffee");
        }

    }

    public static void getCoffeeNeeds (int numberOfCoffees){
        System.out.println("For "+ numberOfCoffees + " cups of coffee you will need:");
        System.out.println(numberOfCoffees * Water_For_One_Cup + " ml of water ");
        System.out.println(numberOfCoffees * + Milk_For_One_Cup + " ml of milk ");
        System.out.println(numberOfCoffees * Coffee_Grounds_For_One_Cup + " g of coffee beans");
    }
    public static boolean canMakeRequestedCoffee (int water, int milk, int coffee , int numberOfCoffees ){
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
