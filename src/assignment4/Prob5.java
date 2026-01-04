/*Write a program to display records of all Students whose semester is 7 and branch is EC.*/

package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prob5 {

    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "ayush177";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql =
                "SELECT * " +
                "FROM Students " +
                "WHERE semester = ? AND branch = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 7);     
            ps.setString(2, "EC"); 

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\nStudents (Semester = 7, Branch = EC)");
            System.out.println("--------------------------------------");

            while (rs.next()) {
                found = true;

                System.out.println(
                    "Roll No : " + rs.getInt("rollno") +
                    ", Name : " + rs.getString("name") +
                    ", Semester : " + rs.getInt("semester") +
                    ", Marks : " + rs.getInt("marks") +
                    ", Branch : " + rs.getString("branch") +
                    ", Year of Passing : " + rs.getInt("year_of_passing")
                );
                
                System.out.println("-----------------------------------------------------------------------------------------------");
            }

            if (!found)
                System.out.println("No matching student records found.");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
