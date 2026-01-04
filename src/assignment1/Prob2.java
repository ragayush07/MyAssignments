/*Write a menu driven program in Java to perform insertion, deletion, linear search, binary
search, to find maximum value, to count even/ odd and to perform insertion sort operation in
one dimensional array. */



package assignment1;

import java.util.*;

public class Prob2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter total array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int size;

        System.out.print("Enter number of elements to store (should be <= " + n + "): "); //Array input
        size = sc.nextInt();

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Maximum Value");
            System.out.println("6. Count Even / Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // Inserting at last index
                    if (size == n) {
                        System.out.println("Array is full.");
                    } else {
                        System.out.print("Enter element to insert: ");
                        arr[size++] = sc.nextInt();
                        System.out.println("Inserted.");
                    }
                    break;

                case 2: // Deleting a particular element
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Enter element to delete: ");
                        int d = sc.nextInt();
                        boolean found = false;

                        for (int i = 0; i < size; i++) {
                            if (arr[i] == d) {
                                for (int j = i; j < size - 1; j++)
                                    arr[j] = arr[j + 1];
                                size--;
                                found = true;
                                break;
                            }
                        }

                        if (found) System.out.println("Deleted.");
                        else System.out.println("Element not found.");
                    }
                    break;

                case 3: // Linear Search
                    System.out.print("Enter element to search: ");
                    int x = sc.nextInt();
                    boolean flag = false;

                    for (int i = 0; i < size; i++) {
                        if (arr[i] == x) {
                            System.out.println("Found at index " + i);
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) System.out.println("Not found.");
                    break;

                case 4: // Binary Search
                    if (size == 0) {
                        System.out.println("Array is empty.");
                        break;
                    }

                    Arrays.sort(arr, 0, size);   
                    
                    System.out.print("Enter element: ");
                    int key = sc.nextInt();
                    int low = 0, high = size - 1;
                    boolean bs = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arr[mid] == key) {
                            System.out.println("Found at index " + mid);
                            bs = true;
                            break;
                        } else if (arr[mid] < key)
                            low = mid + 1;
                        else
                            high = mid - 1;
                    }

                    if (!bs) System.out.println("Not found.");
                    break;

                case 5: // Maximum
                    if (size == 0) System.out.println("Array empty.");
                    else {
                        int max = arr[0];
                        for (int i = 1; i < size; i++)
                            if (arr[i] > max) max = arr[i];
                        System.out.println("Maximum = " + max);
                    }
                    break;

                case 6: // Count even / odd
                    int even = 0, odd = 0;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] % 2 == 0) even++;
                        else odd++;
                    }
                    System.out.println("Even = " + even);
                    System.out.println("Odd  = " + odd);
                    break;

                case 7: // Insertion sort
                    for (int i = 1; i < size; i++) {
                        int k = arr[i], j = i - 1;
                        while (j >= 0 && arr[j] > k) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = k;
                    }
                    System.out.println("Array sorted.");
                    break;

                case 8: // Display
                    if (size == 0) System.out.println("Array empty.");
                    else {
                        System.out.print("Array: ");
                        for (int i = 0; i < size; i++)
                            System.out.print(arr[i] + " ");
                        System.out.println();
                    }
                    break;

                case 9:
                    System.out.println("Exit Succesfull");
                    System.out.println("End of Program");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    System.out.println("End of Program");
            }

        } while (choice != 9);
        sc.close();
	}
}
