package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Register {

    //----------------------------------------------------------
    private static int registerCounter = 1;
    private static final String REGISTERCODE = "US-FL-032020-";
    private static final double DOLLARVALUE = 1.00;
    private static final double QUARTERVALUE = 0.25;
    private static final double DIMEVALUE = 0.10;
    private static final double NICKELVALUE = 0.05;
    private static final double PENNYVALUE = 0.01;

    //-----------------------------------------------------------

    private String registerID;
    private int numberOfOneDollarBills;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;
    private double currentTotal;

    //-----------------------------------------------------------

    public Register (int numberOfOneDollarBills, int numberOfQuarters, int numberOfDimes, int numberOfNickels, int numberOfPennies) {
        registerCounter++;
        registerID = REGISTERCODE + registerCounter;
        currentTotal = 0.0;
        this.numberOfOneDollarBills = numberOfOneDollarBills;
        this.numberOfQuarters = numberOfQuarters;
        this.numberOfDimes = numberOfDimes;
        this.numberOfNickels = numberOfNickels;
        this.numberOfPennies = numberOfPennies;
    }

    //----------------------------------------------------------

    private double cashValue(){

        double total = numberOfOneDollarBills * DOLLARVALUE +
                numberOfQuarters * QUARTERVALUE +
                numberOfDimes * DIMEVALUE +
                numberOfNickels * NICKELVALUE +
                numberOfPennies * PENNYVALUE;

        return total;

    }

    public void cashInfo(String personnel){
        if (personnel=="Manager") {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Valid");
            System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
            System.out.printf("Dollars:\t\t\t\t %-15d\n", numberOfOneDollarBills);
            System.out.printf("Quarters:\t\t\t\t %-15d\n", numberOfQuarters);
            System.out.printf("Dimes:\t\t\t\t\t %-15d\n", numberOfDimes);
            System.out.printf("Nickels:\t\t\t\t %-15d\n", numberOfNickels);
            System.out.printf("Pennies:\t\t\t\t %-15d\n", numberOfPennies);
        }
        else {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Not Valid by " + personnel);
            System.out.println("");
        }
    }

    public void buyApple(Apple apple, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Apple");
        System.out.println("==========================================");
        System.out.printf("Apple Price:\t\t $%-15.2f\n" , apple.price() );
        System.out.printf("Payment:\t\t\t $%-15.2f\n" , payment.paymentValue() );

        if(payment.paymentValue() <= apple.price()) {
            System.out.printf("You need:\t\t\t $%-15.2f\n", (apple.price() - payment.paymentValue()));
            System.out.println(""); 
            System.out.println("Sorry, but you do not have enough money to buy the Apple");
            System.out.println("==========================================");
            System.out.println("\n");
        }
        else {
            giveChange(apple.price(), payment);
        }
    }

    public void buySandwich(Sandwich sandwich, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Sandwich");
        System.out.println("==========================================");
        System.out.printf("Sandwich Price:\t\t $%-15.2f\n" , sandwich.getPrice() );
        System.out.printf("Payment:\t\t\t $%-15.2f\n" , payment.paymentValue() );

        if (payment.paymentValue() <= sandwich.getPrice()) {
            System.out.println("");
            System.out.println("Sorry, but you do not have enough money to buy the Sandwich");
            System.out.println("==========================================");
            System.out.println("\n");
        }
        else {
            giveChange(sandwich.getPrice(), payment);
        }
    }
    private void giveChange(double price, Payment payment){
        numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
        numberOfQuarters += payment.getNumberOfQuarters();
        numberOfDimes += payment.getNumberOfDimes();
        numberOfNickels += payment.getNumberOfNickels();
        numberOfPennies += payment.getNumberOfPennies();

        double neededChange = payment.paymentValue() - price;
        int neededChangeWhole = (int)Math.round(neededChange * 100);
        System.out.printf("Change:\t\t\t\t $%-15.2f\n", neededChange);

        // rounded to whole number so you can use the % operator for the change

        // example 9.65 becomes 965
        int dollarChange = neededChangeWhole / 100;
        neededChangeWhole -= dollarChange * 100;

        int quarterChange = neededChangeWhole / 25;
        neededChangeWhole -= quarterChange * 25;

        int dimeChange = neededChangeWhole / 10;
        neededChangeWhole -= dimeChange * 10;

        int nickelChange = neededChangeWhole / 5;
        neededChangeWhole -= nickelChange * 5;

        int pennyChange = neededChangeWhole;

        numberOfOneDollarBills -= dollarChange;
        numberOfQuarters -= quarterChange;
        numberOfDimes -= dimeChange;
        numberOfNickels -= nickelChange;
        numberOfPennies -= pennyChange;

        System.out.printf("Dollars:\t\t\t %-15d\n", dollarChange);
        System.out.printf("Quarters:\t\t\t %-15d\n", quarterChange);
        System.out.printf("Dimes:\t\t\t\t %-15d\n", dimeChange);
        System.out.printf("Nickels:\t\t\t %-15d\n", nickelChange);
        System.out.printf("Pennies:\t\t\t %-15d\n", pennyChange);
        }
}
