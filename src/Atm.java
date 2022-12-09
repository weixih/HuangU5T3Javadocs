/**
 * This class represents an ATM
 * @author Wei Xi Huang
 */

import java.util.Scanner;

public class Atm {

    /** Amount of money in savings account */
    private double savings;
    /** Amount of money in checking account */
    private double checking;
    /** Scanner to allow user input */
    private Scanner scan;

    /**  Creates an ATM object
     *
     * @param savings Amount of money in savings account
     * @param  checking Amount of money in cheking account
     */
    public Atm(double savings, double checking) {
        this.savings = savings;
        this.checking = checking;
        scan = new Scanner(System.in);
    }

    /** Creates an ATM object
     *
     * @param money The amount of money in both accounts
     */
    public Atm(double money) {
        savings = money;
        checking = money;
        scan = new Scanner(System.in);
    }

    /**
     * Runs the ATM
     */
    public void run() {
        int choice = 0;
        getInfo();
        System.out.println("\nWelcome to the ATM");
        while (choice != 4) {
            menu();
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();
            while(choice > 4 || choice < 1){
                System.out.println("Invalid option.");
                menu();
                System.out.print("Choose an option: ");
                choice = scan.nextInt();
                scan.nextLine();
            }
            if (choice == 1) {
                option1();
            }
            if (choice == 2) {
                option2();
            }
            if (choice == 3) {
                option3();
            }
        }
        System.out.println("goodbye.");

    }

    /**
     * Prints out the menu
     */
    private void menu() {
        System.out.println("------------------------------");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
    }

    /**
     * The account the user chooses
     * @return the account the user chooses
     */
    private int account() {
        System.out.println("------------------------------");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.println("------------------------------");
        System.out.print("Choose an account: ");
        int account = scan.nextInt();
        scan.nextLine();
        while (account > 2 || account < 1) {
            System.out.println("invalid choice.");
            System.out.println("------------------------------");
            System.out.println("1. Savings");
            System.out.println("2. Checking");
            System.out.println("------------------------------");
            System.out.print("Choose an account: ");
            account = scan.nextInt();
            scan.nextLine();
        }
        return account;
    }

    /**
     * Rounds to the nearest hundredth
     * @param number number to round
     * @return number rounded to the nearest hundreth
     */
    private double round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    /**
     * Round to the nearest hundreds
     * @param number number to round
     * @return number rounded to the nearest hundreds
     */
    private int round(int number){
        return (int)Math.round(number/100.0)*100;
    }

    /**
     * Asks the user for the amount of money in their savings account and checking account
     */
    private void getInfo() {
        System.out.print("How much money do you have in the savings account? (Enter a positive value) ");
        savings = round(scan.nextDouble());
        scan.nextLine();
        while (!(savings >= 0)) {
            System.out.print("\nYour number is a negative. Enter a positive number: ");
            savings = scan.nextDouble();
            scan.nextLine();
        }
        System.out.printf("You have $%.2f", savings);
        System.out.println(" in your savings account.");

        System.out.print("\nHow much money do you have in the checking account? (Enter a positive value) ");
        checking = round(scan.nextDouble());
        scan.nextLine();
        for (; checking < 0;) {
            System.out.print("\nYour number is a negative. Enter a positive number: ");
            checking = scan.nextDouble();
            scan.nextLine();
        }
        System.out.printf("You have $%.2f", checking);
        System.out.println(" in your checkings account.");

    }

    /**
     * deposits money
     */
    private void option1() {
        int account = account();
        System.out.print("How much money do you want to deposit? ");
        double money = round(scan.nextDouble());
        scan.nextLine();
        if(money < 0){
            System.out.println("Invalid amount.");
            System.out.print("How much money do you want to deposit? ");
            money = round(scan.nextDouble());
            scan.nextLine();
        }
        if (account == 1) {
            savings += money;
            System.out.printf("Now you have $%.2f", savings);
            System.out.println(" in your savings account.");
        } else {
            checking += money;
            System.out.printf("Now you have $%.2f", checking);
            System.out.println(" in your checking account.");
        }

    }

    /**
     * withdraws money
     */
    private void option2() {
        int account = account();
        System.out.print("How much money do you want to withdraw? ");
        double money = round(scan.nextDouble());
        scan.nextLine();
        if(money < 0){
            System.out.println("Invalid amount.");
            System.out.print("How much money do you want to withdraw? ");
            money = round(scan.nextDouble());
            scan.nextLine();
        }
        if (account == 1) {
            savings -= money;
            if (savings < 0) {
                savings += money;
                System.out.println("You can not withdraw that much money.");
            }
            System.out.printf("You have $%.2f", savings);
            System.out.println(" in your savings account.");
        } else {
            checking -= money;
            if (checking < 0) {
                checking += money;
                System.out.println("You can not withdraw that much money.");
            }
            System.out.printf("You have $%.2f", checking);
            System.out.println(" in your checking account.");
        }
    }

    /**
     * displays how much money in each account
     */
    private void option3() {
        System.out.println("------------------------------");
        System.out.print("Savings account: ");
        System.out.printf("$%.2f", savings);
        System.out.println();
        System.out.print("Checkings account: ");
        System.out.printf("$%.2f", checking);
        System.out.println("\n");
        comment();
    }

    /**
     * the comment in option 3. says if the user is rich or not.
     */
    private void comment(){
        String comment = "You are rich";
        String money  =Integer.toString(round((int)(savings + checking)));
        if(money.length() >= 4){
            System.out.println(comment);
        }else{
            comment = comment.substring(0,8) + "not very" + comment.substring(7);
            System.out.println(comment);
        }
    }

}




