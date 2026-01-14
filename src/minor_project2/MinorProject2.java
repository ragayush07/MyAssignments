package minor_project2;

import java.io.*;
import java.util.*;

class InvalidDataException extends Exception {
    public InvalidDataException(String msg) {
        super(msg);
    }
}

class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + salary + " | " + department;
    }
}

public class MinorProject2 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> list = new ArrayList<>();
    static File file = new File("employees.dat");

    static final String USERNAME = "admin";
    static final String PASSWORD = "1234";

    public static void main(String[] args) {

        if (!login()) return;

        loadFromFile();

        int ch;
        do {
            System.out.println("\n==== EMPLOYEE MENU ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1: addEmployee(); break;
                    case 2: display(); break;
                    case 3: search(); break;
                    case 4: updateSalary(); break;
                    case 5: deleteEmployee(); break;
                    case 6: sortEmployees(); break;
                    case 7: displayDepartments(); break;
                    case 8: saveToFile(); System.out.println("Exited"); break;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (ch != 8);
    }

    static boolean login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (u.equals(USERNAME) && p.equals(PASSWORD)) {
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Invalid Login");
        return false;
    }

    static void addEmployee() throws Exception {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list)
            if (e.getId() == id)
                throw new InvalidDataException("Employee ID already exists");

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        if (sal <= 0)
            throw new InvalidDataException("Salary must be positive");

        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty())
            throw new InvalidDataException("Department cannot be empty");

        list.add(new Employee(id, name, sal, dept));
        saveToFile();
        System.out.println("Employee added");
    }

    static void display() {
        if (list.isEmpty()) {
            System.out.println("No records");
            return;
        }
        for (Employee e : list)
            System.out.println(e);
    }

    static void search() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list)
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        System.out.println("Employee not found");
    }

    static void updateSalary() throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.getId() == id) {
                System.out.print("New Salary: ");
                double sal = sc.nextDouble();

                if (sal <= 0)
                    throw new InvalidDataException("Salary must be positive");

                e.setSalary(sal);
                saveToFile();
                System.out.println("Salary updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                saveToFile();
                System.out.println("Employee deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void sortEmployees() {
        list.sort(Comparator.comparing(Employee::getName));
        display();
    }

    static void displayDepartments() {
        HashSet<String> set = new HashSet<>();
        for (Employee e : list)
            set.add(e.getDepartment());

        System.out.println("Departments:");
        for (String d : set)
            System.out.println(d);
    }

    static void saveToFile() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            System.out.println("File save error");
        }
    }

    static void loadFromFile() {
        try {
            if (!file.exists()) return;

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<Employee>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("File load error");
        }
    }
}
