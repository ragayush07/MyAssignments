package minor_project1;

import java.io.*;
import java.util.*;

abstract class BankAccount {
    protected int accNo;
    protected String name;
    protected double balance;

    public BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    abstract void deposit(double amt);
    abstract void withdraw(double amt);

    public double getBalance() {
        return balance;
    }

    public void display() {
        System.out.println("\nAccount No : " + accNo);
        System.out.println("Name       : " + name);
        System.out.println("Balance    : " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Amount withdrawn successfully");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amt) {
        if (balance - amt >= 500) {
            balance -= amt;
            System.out.println("Amount withdrawn successfully");
        } else {
            System.out.println("Minimum balance of 500 required");
        }
    }
}

public class MinorProject1 {

    static Scanner sc = new Scanner(System.in);
    static File file = new File("BankData.txt");

    static void saveData(BankAccount acc) throws Exception {
        FileWriter fw = new FileWriter(file, true);
        fw.write(acc.accNo + "," + acc.name + "," + acc.balance + "\n");
        fw.close();
    }

    static void saveData(String msg) throws Exception {
        FileWriter fw = new FileWriter(file, true);
        fw.write(msg + "\n");
        fw.close();
    }

    static BankAccount createAccount() {
        System.out.print("Enter Account Number: ");
        int no = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose Account Type: ");
        int ch = sc.nextInt();

        BankAccount acc;
        if (ch == 1)
            acc = new SavingsAccount(no, name, bal);
        else
            acc = new CurrentAccount(no, name, bal);

        return acc;
    }

    static void displayFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        System.out.println("\n--- ACCOUNT RECORDS ---");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println("AccNo: " + data[0] +
                    " Name: " + data[1] +
                    " Balance: " + data[2]);
        }
        br.close();
    }

    public static void main(String[] args) {

        try {
            int choice;
            BankAccount acc = null;

            do {
                System.out.println("\n===== BANK MENU =====");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Balance Enquiry");
                System.out.println("5. Display Account Details");
                System.out.println("6. Display File Data");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        acc = createAccount();
                        saveData(acc);
                        System.out.println("Account created successfully");
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        acc.deposit(sc.nextDouble());
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        acc.withdraw(sc.nextDouble());
                        break;

                    case 4:
                        System.out.println("Balance: " + acc.getBalance());
                        break;

                    case 5:
                        acc.display();
                        break;

                    case 6:
                        displayFile();
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 0);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
