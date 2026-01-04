/*A class sixth student required to solve basic mathematics problems. For this he/ she needs to
perform operations such as addition, subtraction, multiplication, division, remainder, square,
cube, and absolute. Write a program using methods to perform these basic operations. */

package assignment1;

import java.util.*;

public class Prob1 {

	static int add(int a, int b) {
		return a + b;
	}

	static int subtract(int a, int b) {
		return a - b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	static double divide(int a, int b) {
		return (double) a / b;
	}

	static int remainder(int a, int b) {
		return a % b;
	}

	static int square(int a) {
		return a * a;
	}

	static int cube(int a) {
		return a * a * a;
	}

	static int absolute(int a) {
		return Math.abs(a);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Press 1 for Addition");
		System.out.println("Press 2 for Subtraction");
		System.out.println("Press 3 for Multiplication");
		System.out.println("Press 4 for Division");
		System.out.println("Press 5 for Remainder");
		System.out.println("Press 6 for Square");
		System.out.println("Press 7 for Cube");
		System.out.println("Press 8 for Absolute");

		int operation = sc.nextInt();

		if (operation > 8 || operation < 1) {
			System.out.println("Invalid Operation");
			System.out.println("End of Program");
			sc.close();
			return; //System.exit(0);
		}
		System.out.print("Enter first number: ");
		int num1 = sc.nextInt();

		System.out.print("Enter second number: ");
		int num2 = sc.nextInt();

		switch (operation) {
		case 1:
			System.out.println("Addition = " + add(num1, num2));
			break;
		case 2:
			System.out.println("Subtraction = " + subtract(num1, num2));
			break;
		case 3:
			System.out.println("Multiplication = " + multiply(num1, num2));
			break;
		case 4:
			System.out.println("Division = " + divide(num1, num2));
			break;
		case 5:
			System.out.println("Remainder = " + remainder(num1, num2));
			break;
		case 6:
			System.out.println("Square of first number = " + square(num1));
			break;
		case 7:
			System.out.println("Cube of first number = " + cube(num1));
			break;
		case 8:
			System.out.println("Absolute value of first number = " + absolute(num1));
			break;
		default:
			System.out.println("Invalid Operation");
		}
		System.out.println("End of Program");
		sc.close();

	}

}
