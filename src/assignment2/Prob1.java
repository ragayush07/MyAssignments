/*Design a Java program where a bank account class implements multiple interfaces to perform
banking and customer-related operations. The program should handle exceptions as required.
*/

package assignment2;

import java.util.Scanner;

//banking operations
interface BankingOperations {
 void deposit(double amount) throws Exception;
 void withdraw(double amount) throws Exception;
 double getBalance();
}

//customer operations
interface CustomerOperations {
 void displayCustomerDetails();
 void updateCustomerName(String name);
}

class BankAccount implements BankingOperations, CustomerOperations {

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


 public void displayCustomerDetails() {
     System.out.println("\n----- Customer Details -----");
     System.out.println("Account Holder : " + accountHolder);
     System.out.println("Account Number : " + accountNumber);
     System.out.println("Balance        : " + balance);
 }


 public void updateCustomerName(String name) {
     this.accountHolder = name;
     System.out.println("Customer name updated successfully.");
 }
}

public class Prob1 {

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

     } catch (Exception e) {
         System.out.println("Error while creating account: " + e.getMessage());
         sc.close();
         return;
     }

     int choice;

     do {
         System.out.println("\n----- BANK MENU -----");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. Balance Enquiry");
         System.out.println("4. Display Customer Details");
         System.out.println("5. Update Customer Name");
         System.out.println("6. Exit");
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
                     account.displayCustomerDetails();
                     break;

                 case 5:
                     sc.nextLine(); 
                     System.out.print("Enter new customer name: ");
                     String newName = sc.nextLine();
                     account.updateCustomerName(newName);
                     break;

                 case 6:
                     System.out.println("Exit Successful");
                     break;

                 default:
                     System.out.println("Invalid choice. Try again.");
             }

         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
             sc.nextLine(); 
             choice = 0;
         }

     } while (choice != 6);

     sc.close();
 }
}
