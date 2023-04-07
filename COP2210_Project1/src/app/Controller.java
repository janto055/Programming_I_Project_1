package app;

import machine.Register;
import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Controller {
    public static void main(String[] args) {
        yourInfoHeader();

        Register register = new Register(15, 20, 10, 20, 50);
        register.cashInfo("Manager");
        register.cashInfo("Staff");

        Apple grannySmith = new Apple("Granny Smith", 1.51, 140);
        grannySmith.displayInfo();
        Payment applePayment1 = new Payment(10, 0, 0, 0, 47);
        applePayment1.displayInfo();
        register.buyApple(grannySmith, applePayment1);
        register.cashInfo("Manager");

        Apple macintosh = new Apple("Macintosh", 1.70, 150);
        macintosh.displayInfo();
        Payment applePayment2 = new Payment(0, 2, 0, 0, 0);
        applePayment2.displayInfo();
        register.buyApple(macintosh, applePayment2);
        register.cashInfo("Manager");

        Sandwich sandwich = new Sandwich(true, true, true);
        sandwich.displayInfo();
        Payment sandwichPayment1 = new Payment(5,2,1,1,2);
        sandwichPayment1.displayInfo();
        register.buySandwich(sandwich, sandwichPayment1);
        register.cashInfo("Manager");


        boolean meat = true;
        boolean cheese = false;
        boolean veggies = false;

        System.out.println("");
        System.out.println("");


        for (int row = 1; row<9; row++) {
            if (row >= 5) {
                meat = false;
            }
            else {
                meat = true;
            }
            if ((row % 2) != 0) {
                cheese = !cheese;
            }

                veggies = !veggies;

                System.out.println("\n================ L O O P =================");
                System.out.println("=================== " + row + " ====================\n");
                Sandwich loopwich = new Sandwich(meat, cheese, veggies);
                loopwich.displayInfo();
                Payment loopwichPayment = new Payment(10, 0, 0, 0, 0);
                loopwichPayment.displayInfo();
                register.buySandwich(loopwich, loopwichPayment);
                register.cashInfo("Manager");
            }
        }


    public static void yourInfoHeader(){

        System.out.println("=========================================");
        System.out.println("PROGRAMMER:  " + "Jaydon Antoine");
        System.out.println("PANTHER ID:  " + "6283821");
        System.out.println();
        System.out.println("CLASS: \t\t COP2210 ");
        System.out.println("SECTION: \t " + "U02");
        System.out.println("SEMESTER: \t " + "Fall 2022");
        System.out.println("CLASSTIME: \t " + "Tues/Thurs 6:25-9:05pm");
        System.out.println();
        System.out.println("Assignment:  " + "Project 1");
        System.out.println();
        System.out.println("CERTFICATION: \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("=========================================");
        System.out.println();
    }
}

