package machine;

import java.util.Scanner;

public class CoffeeMaker {

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

    public void coffeeMachineState (){
        System.out.println("The coffee machine has: ");
        System.out.println(waterAvailable +" of water");
        System.out.println(milkAvailable + " of milk");
        System.out.println(coffeeGroundsAvailable + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(moneyAvailable + " of money");

    }

    public void makeEspresso() {
        if(waterAvailable >= 250 && coffeeGroundsAvailable >= 16){
            this.waterAvailable -= 250;
            this.coffeeGroundsAvailable -= 16;
            this.disposableCups -= 1;
            this.moneyAvailable += 4;
            coffeeMachineState();
        }
    }
    public void makeLatte() {
        if(waterAvailable >= 350 && milkAvailable >= 75
                && coffeeGroundsAvailable >= 20){
            this.waterAvailable -= 350;
            this.milkAvailable -= 75;
            this.coffeeGroundsAvailable -= 20;
            this.disposableCups -= 1;
            this.moneyAvailable += 7;
            coffeeMachineState();
        }

    }

    public void makeCappuccino() {
        if(waterAvailable >= 200 &&
                milkAvailable >= 100 && coffeeGroundsAvailable >= 12){
            this.waterAvailable -= 200;
            this.milkAvailable -= 100;
            this.coffeeGroundsAvailable -= 12;
            this.disposableCups -= 1;
            this.moneyAvailable += 6;
            coffeeMachineState();
        }
    }

    public void takeMoney(){
        System.out.println("I gave you " + moneyAvailable);
        this.moneyAvailable = 0;
        coffeeMachineState();
    }

    public void fillMachine(){
        System.out.println("Write how many ml of water do you want to add: ");
        this.waterAvailable += input.nextInt();
        System.out.println("Write how many ml of milk do you want to add:  ");
        this.milkAvailable += input.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        this.coffeeGroundsAvailable += input.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        this.disposableCups += input.nextInt();
        coffeeMachineState();
    }


}
