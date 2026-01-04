/*Design a console-based Bank Management Program in Java that allows a user to create a
bank account and perform basic banking operations such as deposit, withdrawal, balance
enquiry, and account details display. The program should handle exceptions as required. */

package assignment1;

import java.util.*;

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

 
    public void deposit(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Deposit amount must be positive.");
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }


    public void withdraw(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Withdrawal amount must be positive.");
        if (amount > balance)
            throw new Exception("Insufficient balance.");
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }


    public double getBalance() {
        return balance;
    }


    public void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class Prob5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        try {
            System.out.println("----- Create Bank Account -----");
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Account Number: ");
            String accNo = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            account = new BankAccount(name, accNo, balance);
            System.out.println("Account created successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type! Program terminated.");
            sc.close();
            return;
        }

        int choice = 0;

        do {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double d = sc.nextDouble();
                        account.deposit(d);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double w = sc.nextDouble();
                        account.withdraw(w);
                        break;

                    case 3:
                        System.out.println("Current Balance = " + account.getBalance());
                        break;

                    case 4:
                        account.displayDetails();
                        break;

                    case 5:
                        System.out.println("Thank you! Exit Successful...");
                        System.out.println("End of program");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                        System.out.println("End of program");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); 
                choice = 0;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
	}
}
