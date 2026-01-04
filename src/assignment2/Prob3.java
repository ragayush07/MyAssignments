/*Design a Java program to manage Student Records using different ArrayList, Vector, List
collections. The program should Add student records, Display all students, Remove a student
by roll number, Search a student by roll number. The program should handle exceptions, use
interface and REGEX as required.*/

package assignment2;

import java.util.*;
import java.util.regex.*;

//Student Operations
interface StudentOperations {
    void addStudent() throws Exception;
    void displayStudents();
    void removeStudent() throws Exception;
    void searchStudent() throws Exception;
}

class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public String toString() {
        return "Roll No: " + roll + ", Name: " + name;
    }
}

class StudentManager implements StudentOperations {

    Scanner sc = new Scanner(System.in);

    List<Student> list = new ArrayList<>();

    Vector<Student> vector = new Vector<>();

    Pattern rollRegex = Pattern.compile("^[0-9]{1,3}$");
    Pattern nameRegex = Pattern.compile("^[A-Za-z ]{3,20}$");

    public void addStudent() throws Exception {
        System.out.print("Enter Roll Number: ");
        String r = sc.nextLine();

        if (!rollRegex.matcher(r).matches())
            throw new Exception("Invalid Roll Number!");

        int roll = Integer.parseInt(r);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (!nameRegex.matcher(name).matches())
            throw new Exception("Invalid Name!");

        Student s = new Student(roll, name);

        list.add(s);
        vector.add(s);

        System.out.println("Student Added Successfully!");
    }

    public void displayStudents() {
        if (list.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n----- Student Records (ArrayList) -----");
        for (Student s : list)
            System.out.println(s);

        System.out.println("\n----- Student Records (Vector) -----");
        for (Student s : vector)
            System.out.println(s);
    }

    public void removeStudent() throws Exception {
        System.out.print("Enter Roll Number to Remove: ");
        String r = sc.nextLine();

        if (!rollRegex.matcher(r).matches())
            throw new Exception("Invalid Roll Number!");

        int roll = Integer.parseInt(r);
        boolean removed = false;

        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.roll == roll) {
                it.remove();
                vector.remove(s);
                removed = true;
                break;
            }
        }

        if (removed)
            System.out.println("Student Removed Successfully!");
        else
            System.out.println("Student Not Found!");
    }

    public void searchStudent() throws Exception {
        System.out.print("Enter Roll Number to Search: ");
        String r = sc.nextLine();

        if (!rollRegex.matcher(r).matches())
            throw new Exception("Invalid Roll Number!");

        int roll = Integer.parseInt(r);
        boolean found = false;

        for (Student s : list) {
            if (s.roll == roll) {
                System.out.println("Student Found: " + s);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Student Not Found!");
    }
}

public class Prob3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentOperations manager = new StudentManager();

        int choice = 0;

        do {
            System.out.println("\n----- STUDENT RECORD MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Remove Student by Roll Number");
            System.out.println("4. Search Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> manager.addStudent();
                    case 2 -> manager.displayStudents();
                    case 3 -> manager.removeStudent();
                    case 4 -> manager.searchStudent();
                    case 5 -> System.out.println("Exiting Program...");
                    default -> System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}
