/*Write a program to perform addition, subtraction, multiplication, transpose, to check square
matrix, to check matrix is diagonal, and to check matrix is identity. */


package assignment1;

import java.util.*;

public class Prob3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows of matrix: ");
        int r = sc.nextInt();
        System.out.print("Enter columns of matrix: ");
        int c = sc.nextInt();

        int[][] A = new int[r][c];

        System.out.println("\nEnter Matrix Elements:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                A[i][j] = sc.nextInt();

        int choice;

        do {
            System.out.println("\n----- MATRIX MENU -----");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose");
            System.out.println("5. Check Square Matrix");
            System.out.println("6. Check Diagonal Matrix");
            System.out.println("7. Check Identity Matrix");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // Addition
                    System.out.println("\nEnter elements of same size matrix:");
                    int[][] B1 = new int[r][c];
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            B1[i][j] = sc.nextInt();

                    int[][] add = new int[r][c];
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            add[i][j] = A[i][j] + B1[i][j];

                    System.out.println("Result (Addition):");
                    printMatrix(add, r, c);
                    break;

                case 2: // Subtraction
                    System.out.println("\nEnter elements of same size matrix:");
                    int[][] B2 = new int[r][c];
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            B2[i][j] = sc.nextInt();

                    int[][] sub = new int[r][c];
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            sub[i][j] = A[i][j] - B2[i][j];

                    System.out.println("Result (Subtraction):");
                    printMatrix(sub, r, c);
                    break;

                case 3: // Multiplication
                    System.out.print("\nEnter rows of 2nd matrix: ");
                    int r2 = sc.nextInt();
                    System.out.print("Enter columns of 2nd matrix: ");
                    int c2 = sc.nextInt();

                    if (c != r2) {
                        System.out.println("Matrix multiplication not possible.");
                        break;
                    }

                    int[][] B3 = new int[r2][c2];
                    System.out.println("Enter 2nd matrix elements:");
                    for (int i = 0; i < r2; i++)
                        for (int j = 0; j < c2; j++)
                            B3[i][j] = sc.nextInt();

                    int[][] mul = new int[r][c2];

                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c2; j++) {
                            mul[i][j] = 0;
                            for (int k = 0; k < c; k++)
                                mul[i][j] += A[i][k] * B3[k][j];
                        }
                    }

                    System.out.println("Result (Multiplication):");
                    printMatrix(mul, r, c2);
                    break;

                case 4: // Transpose
                    int[][] t = new int[c][r];

                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            t[j][i] = A[i][j];

                    System.out.println("Transpose of Matrix:");
                    printMatrix(t, c, r);
                    break;

                case 5: // Check Square
                    if (r == c)
                        System.out.println("Matrix is Square.");
                    else
                        System.out.println("Matrix is NOT Square.");
                    break;

                case 6: // Check Diagonal
                    if (r != c) {
                        System.out.println("Not a Square Matrix → Cannot be Diagonal.");
                        break;
                    }

                    boolean diag = true;
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            if (i != j && A[i][j] != 0)
                                diag = false;

                    System.out.println(diag ? "Matrix is Diagonal." : "Matrix is NOT Diagonal.");
                    break;

                case 7: // Identity Check
                    if (r != c) {
                        System.out.println("Not a Square Matrix → Cannot be Identity.");
                        break;
                    }

                    boolean id = true;
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            if ((i == j && A[i][j] != 1) || (i != j && A[i][j] != 0))
                                id = false;

                    System.out.println(id ? "Matrix is Identity." : "Matrix is NOT Identity.");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }

    static void printMatrix(int[][] m, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }

	}

}
