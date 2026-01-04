/*Write a simple Java Program which demonstrate the use of REGEX in Java and provides
Input Validation Using Regular Expressions. The program should have following menu
1. Validate Mobile Number
2. Validate Email ID
3. Validate Username
4. Validate Password
5. Exit.
After validation a simple welcome message displayed and if validation failed then invalid
input message should displayed. The program should handle exceptions as required.*/


package assignment2;

import java.util.Scanner;
import java.util.regex.*;

public class Prob2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n----- REGEX VALIDATION MENU -----");
            System.out.println("1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();   

                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();

             
                        String mobileRegex = "^[6-9][0-9]{9}$";

                        if (mobile.matches(mobileRegex))
                            System.out.println("Welcome! Mobile Number is Valid.");
                        else
                            System.out.println("Invalid Mobile Number!");
                    }

                    case 2 -> {
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();

               
                        String emailRegex =
                                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

                        if (email.matches(emailRegex))
                            System.out.println("Welcome! Email ID is Valid.");
                        else
                            System.out.println("Invalid Email ID!");
                    }

                    case 3 -> {
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();

                       
                        String userRegex = "^[A-Za-z0-9_]{3,15}$";

                        if (user.matches(userRegex))
                            System.out.println("Welcome " + user + " — Username is Valid.");
                        else
                            System.out.println("Invalid Username!");
                    }

                    case 4 -> {
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();

                       
                        String passRegex =
                                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

                        if (pass.matches(passRegex))
                            System.out.println("Welcome! Password is Strong & Valid.");
                        else
                            System.out.println("Invalid Password!");
                    }

                    case 5 -> System.out.println("Exiting program...");

                    default -> System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter valid values.");
                sc.nextLine(); 
            }

        } while (choice != 5);

        sc.close();
    }
}
