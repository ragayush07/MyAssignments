package minor_project3;

import java.sql.*;
import java.util.*;

class InvalidDataException extends Exception {
    public InvalidDataException(String msg) {
        super(msg);
    }
}

public class MinorProject3 {

    static Scanner sc = new Scanner(System.in);
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "ayush177";

    public static void main(String[] args) {

        if (!login()) return;

        int ch;
        do {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            try {
                switch (ch) {
                    case 1: addStudent(); break;
                    case 2: display(); break;
                    case 3: search(); break;
                    case 4: updateBranch(); break;
                    case 5: deleteStudent(); break;
                    case 6: sortStudents(); break;
                    case 7: System.out.println("Exited"); break;
                    default: System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (ch != 7);
    }

    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    static boolean login() {
        try {
            System.out.print("Username: ");
            String u = sc.next();
            System.out.print("Password: ");
            String p = sc.next();

            Connection con = getConnection();
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");

            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful");
                return true;
            }
            System.out.println("Invalid Login");
            return false;

        } catch (Exception e) {
            System.out.println("Login error");
            return false;
        }
    }

    static void addStudent() throws Exception {

        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = getConnection();
        PreparedStatement chk =
                con.prepareStatement("SELECT eno FROM students WHERE eno=?");
        chk.setInt(1, eno);
        ResultSet rs = chk.executeQuery();
        if (rs.next())
            throw new InvalidDataException("Eno already exists");

        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Percentage: ");
        double per = sc.nextDouble();
        if (per <= 0)
            throw new InvalidDataException("Percentage must be positive");

        sc.nextLine();
        System.out.print("Semester: ");
        String sem = sc.nextLine();
        if (sem.isEmpty())
            throw new InvalidDataException("Semester cannot be empty");

        System.out.print("Branch: ");
        String br = sc.nextLine();
        if (br.isEmpty())
            throw new InvalidDataException("Branch cannot be empty");

        PreparedStatement ps =
                con.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?)");

        ps.setInt(1, eno);
        ps.setString(2, name);
        ps.setDouble(3, per);
        ps.setString(4, sem);
        ps.setString(5, br);

        ps.executeUpdate();
        System.out.println("Student added");
    }

    static void display() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getString(5));
        }
    }

    static void search() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = getConnection();
        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM students WHERE eno=?");

        ps.setInt(1, eno);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getString(5));
        } else
            System.out.println("Student not found");
    }

    static void updateBranch() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        sc.nextLine();
        System.out.print("New Branch: ");
        String br = sc.nextLine();
        if (br.isEmpty())
            throw new InvalidDataException("Branch cannot be empty");

        Connection con = getConnection();
        PreparedStatement ps =
                con.prepareStatement("UPDATE students SET branch=? WHERE eno=?");

        ps.setString(1, br);
        ps.setInt(2, eno);

        if (ps.executeUpdate() > 0)
            System.out.println("Branch updated");
        else
            System.out.println("Student not found");
    }

    static void deleteStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Connection con = getConnection();
        PreparedStatement ps =
                con.prepareStatement("DELETE FROM students WHERE eno=?");

        ps.setInt(1, eno);

        if (ps.executeUpdate() > 0)
            System.out.println("Student deleted");
        else
            System.out.println("Student not found");
    }

    static void sortStudents() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs =
                st.executeQuery("SELECT * FROM students ORDER BY name");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getString(5));
        }
    }
}

