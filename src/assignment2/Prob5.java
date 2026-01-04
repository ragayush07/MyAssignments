/*Design a console-based University Student Management System using Java Collection
Framework that manages students, courses, and marks using ArrayList, Vector, Stack, list,
set & map, Hashmap, Hashtable, TreeMap.
Add student records, Display all students, Remove student by ID, Search student by ID, Sort
students by marks, Convert HashMap to TreeMap, Count students course-wise, Store unique
course names, Prevent duplicate entries and Display all courses. The program should handle
exceptions, use interface and REGEX as required.*/

package assignment2;

import java.util.*;
import java.util.regex.*;

class Students {
    int id;
    String name;
    String course;
    int marks;

    Students(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}

interface StudentsOperations {
    void addStudent() throws Exception;
    void displayStudents();
    void searchStudent() throws Exception;
    void removeStudent() throws Exception;
    void sortStudentsByMarks();
    void convertHashMapToTreeMap();
    void countStudentsCourseWise();
    void displayUniqueCourses();
}

class UniversityManager implements StudentsOperations {

    Scanner sc = new Scanner(System.in);

    List<Students> list = new ArrayList<>();
    Vector<Students> vector = new Vector<>();
    Stack<Students> stack = new Stack<>();

    Map<Integer, Students> hashMap = new HashMap<>();
    Hashtable<Integer, Students> hashTable = new Hashtable<>();
    TreeMap<Integer, Students> treeMap = new TreeMap<>();

    Set<String> courseSet = new HashSet<>();

    Pattern idRegex = Pattern.compile("^[0-9]{1,4}$");
    Pattern nameRegex = Pattern.compile("^[A-Za-z ]{3,20}$");
    Pattern courseRegex = Pattern.compile("^[A-Za-z ]{2,20}$");

    public void addStudent() throws Exception {
        System.out.print("Enter Student ID: ");
        String idStr = sc.nextLine();
        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid ID!");
        int id = Integer.parseInt(idStr);

        if (hashMap.containsKey(id))
            throw new Exception("Duplicate ID! Student already exists.");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        if (!nameRegex.matcher(name).matches())
            throw new Exception("Invalid Name!");

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();
        if (!courseRegex.matcher(course).matches())
            throw new Exception("Invalid Course Name!");

        System.out.print("Enter Marks: ");
        int marks = Integer.parseInt(sc.nextLine());

        Students s = new Students(id, name, course, marks);

        list.add(s);
        vector.add(s);
        stack.push(s);

        hashMap.put(id, s);
        hashTable.put(id, s);
        courseSet.add(course);

        System.out.println("Student Added Successfully!");
    }

    public void displayStudents() {
        if (list.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("\n--- ArrayList Students ---");
        list.forEach(System.out::println);

        System.out.println("\n--- Vector Students ---");
        vector.forEach(System.out::println);

        System.out.println("\n--- Stack (Insertion Order) ---");
        stack.forEach(System.out::println);

        System.out.println("\n--- HashMap Students ---");
        hashMap.forEach((k,v)-> System.out.println(v));
    }

    public void searchStudent() throws Exception {
        System.out.print("Enter Student ID to Search: ");
        String idStr = sc.nextLine();
        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid ID!");
        int id = Integer.parseInt(idStr);

        Students s = hashMap.get(id);

        if (s != null)
            System.out.println("Student Found: " + s);
        else
            System.out.println("Student Not Found!");
    }

    public void removeStudent() throws Exception {
        System.out.print("Enter Student ID to Remove: ");
        String idStr = sc.nextLine();
        if (!idRegex.matcher(idStr).matches())
            throw new Exception("Invalid ID!");
        int id = Integer.parseInt(idStr);

        Students s = hashMap.remove(id);
        hashTable.remove(id);
        treeMap.remove(id);

        if (s == null) {
            System.out.println("Student Not Found!");
            return;
        }

        list.removeIf(st -> st.id == id);
        vector.removeIf(st -> st.id == id);
        stack.removeIf(st -> st.id == id);

        System.out.println("Student Removed: " + s);
    }

    public void sortStudentsByMarks() {
        if (list.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        list.sort((a,b) -> b.marks - a.marks);
        System.out.println("Students Sorted by Marks (High → Low):");
        list.forEach(System.out::println);
    }

    public void convertHashMapToTreeMap() {
        treeMap.clear();
        treeMap.putAll(hashMap);
        System.out.println("HashMap converted to TreeMap (Sorted by ID):");
        treeMap.forEach((k,v)-> System.out.println(v));
    }

    public void countStudentsCourseWise() {
        Map<String,Integer> courseCount = new HashMap<>();

        for (Students s : list)
            courseCount.put(s.course, courseCount.getOrDefault(s.course,0)+1);

        System.out.println("Course-wise Student Count:");
        courseCount.forEach((c,n)-> System.out.println(c+" = "+n));
    }

    public void displayUniqueCourses() {
        if (courseSet.isEmpty()) {
            System.out.println("No courses stored.");
            return;
        }

        System.out.println("Unique Courses (No Duplicates):");
        courseSet.forEach(System.out::println);
    }
}

public class Prob5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentsOperations manager = new UniversityManager();
        int choice = 0;

        do {
            System.out.println("\n----- UNIVERSITY STUDENT MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Convert HashMap to TreeMap");
            System.out.println("7. Count Students Course-wise");
            System.out.println("8. Display Unique Courses");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> manager.addStudent();
                    case 2 -> manager.displayStudents();
                    case 3 -> manager.searchStudent();
                    case 4 -> manager.removeStudent();
                    case 5 -> manager.sortStudentsByMarks();
                    case 6 -> manager.convertHashMapToTreeMap();
                    case 7 -> manager.countStudentsCourseWise();
                    case 8 -> manager.displayUniqueCourses();
                    case 9 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 9);

        sc.close();
    }
}

