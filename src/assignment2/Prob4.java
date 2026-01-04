/*Design a Java program to manage Employee Records using Hashmap, Hashtable, and
TreeMap. The program should Add employee records, Display all employees, Search
employee by employee ID, Remove employee by employee ID, Demonstrate null key and
null value support. The program should handle exceptions, use interface and REGEX as
required.*/

package assignment2;

import java.util.*;
import java.util.regex.*;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

interface EmployeeOperations {
    void addEmployee() throws Exception;
    void displayEmployees();
    void searchEmployee() throws Exception;
    void removeEmployee() throws Exception;
    void demonstrateNullSupport();
}

class EmployeeManager implements EmployeeOperations {

    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashTable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Pattern idRegex = Pattern.compile("^[0-9]{1,4}$");
    Pattern nameRegex = Pattern.compile("^[A-Za-z ]{3,20}$");

    public void addEmployee() throws Exception {

        System.out.print("Enter Employee ID: ");
        String idStr = sc.nextLine();

        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid Employee ID!");

        int id = Integer.parseInt(idStr);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        if (!nameRegex.matcher(name).matches())
            throw new Exception("Invalid Name!");

        Employee emp = new Employee(id, name);

        hashMap.put(id, emp);
        hashTable.put(id, emp);
        treeMap.put(id, emp);

        System.out.println("Employee added successfully!");
    }

    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\n--- HashMap Employees ---");
        hashMap.forEach((k, v) -> System.out.println(v));

        System.out.println("\n--- Hashtable Employees ---");
        hashTable.forEach((k, v) -> System.out.println(v));

        System.out.println("\n--- TreeMap Employees (Sorted) ---");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    public void searchEmployee() throws Exception {

        System.out.print("Enter Employee ID to search: ");
        String idStr = sc.nextLine();

        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid Employee ID!");

        int id = Integer.parseInt(idStr);

        Employee emp = hashMap.get(id);

        if (emp != null)
            System.out.println("Employee Found: " + emp);
        else
            System.out.println("Employee Not Found!");
    }

    public void removeEmployee() throws Exception {

        System.out.print("Enter Employee ID to remove: ");
        String idStr = sc.nextLine();

        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid Employee ID!");

        int id = Integer.parseInt(idStr);

        if (hashMap.containsKey(id)) {
            Employee e = hashMap.remove(id);
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Removed: " + e);
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public void demonstrateNullSupport() {

        System.out.println("\n--- NULL KEY / NULL VALUE DEMO ---");

        try {
            hashMap.put(null, new Employee(0, "NullKeyEmployee"));
            hashMap.put(999, null);
            System.out.println("HashMap allows null key and null values.");
        } catch (Exception e) {
            System.out.println("HashMap null test failed: " + e.getMessage());
        }

        try {
            hashTable.put(null, new Employee(0, "X"));
            System.out.println("Hashtable accepted null key (unexpected)");
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key.");
        }

        try {
            treeMap.put(null, new Employee(0, "Y"));
            System.out.println("TreeMap accepted null key (unexpected)");
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key.");
        }

        try {
            treeMap.put(777, null);
            System.out.println("TreeMap allows null value.");
        } catch (Exception e) {
            System.out.println("TreeMap null value failed: " + e.getMessage());
        }
    }
}


public class Prob4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeOperations manager = new EmployeeManager();

        int choice = 0;

        do {
            System.out.println("\n----- EMPLOYEE MENU -----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Remove Employee by ID");
            System.out.println("5. Demonstrate Null Key / Null Value");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> manager.addEmployee();
                    case 2 -> manager.displayEmployees();
                    case 3 -> manager.searchEmployee();
                    case 4 -> manager.removeEmployee();
                    case 5 -> manager.demonstrateNullSupport();
                    case 6 -> System.out.println("Exiting program...");
                    default -> System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }
}
