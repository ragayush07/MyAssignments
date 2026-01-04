/*Write a program to create a table called Students using JDBC and insert records into it.
*/

package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Prob2 {

    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "ayush177";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String createTable =
                "CREATE TABLE IF NOT EXISTS Students (" +
                "rollno INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "semester INT, " +
                "marks INT, " +
                "branch VARCHAR(10), " +
                "year_of_passing INT)";

            Statement st = con.createStatement();
            st.executeUpdate(createTable);
            System.out.println("Table created successfully");

            String sql =
                "INSERT INTO Students (rollno, name, semester, marks, branch, year_of_passing) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setInt(1, 101);
            ps.setString(2, "Ayush");
            ps.setInt(3, 4);
            ps.setInt(4, 82);
            ps.setString(5, "CSE");
            ps.setInt(6, 2025);
            ps.executeUpdate();

            
            ps.setInt(1, 102);
            ps.setString(2, "Riya");
            ps.setInt(3, 3);
            ps.setInt(4, 88);
            ps.setString(5, "IT");
            ps.setInt(6, 2024);
            ps.executeUpdate();

            
            ps.setInt(1, 103);
            ps.setString(2, "Rohan");
            ps.setInt(3, 2);
            ps.setInt(4, 75);
            ps.setString(5, "AIDS");
            ps.setInt(6, 2026);
            ps.executeUpdate();

            
            ps.setInt(1, 104);
            ps.setString(2, "Neha");
            ps.setInt(3, 5);
            ps.setInt(4, 91);
            ps.setString(5, "CSE");
            ps.setInt(6, 2025);
            ps.executeUpdate();

         
            ps.setInt(1, 105);
            ps.setString(2, "Kunal");
            ps.setInt(3, 6);
            ps.setInt(4, 69);
            ps.setString(5, "ME");
            ps.setInt(6, 2023);
            ps.executeUpdate();

          
            ps.setInt(1, 106);
            ps.setString(2, "Simran");
            ps.setInt(3, 1);
            ps.setInt(4, 78);
            ps.setString(5, "EC");
            ps.setInt(6, 2027);
            ps.executeUpdate();

          
            ps.setInt(1, 107);
            ps.setString(2, "Rahul");
            ps.setInt(3, 8);
            ps.setInt(4, 84);
            ps.setString(5, "EE");
            ps.setInt(6, 2024);
            ps.executeUpdate();

       
            ps.setInt(1, 108);
            ps.setString(2, "Tanya");
            ps.setInt(3, 7);
            ps.setInt(4, 90);
            ps.setString(5, "IT");
            ps.setInt(6, 2023);
            ps.executeUpdate();

        
            ps.setInt(1, 109);
            ps.setString(2, "Arjun");
            ps.setInt(3, 3);
            ps.setInt(4, 73);
            ps.setString(5, "CE");
            ps.setInt(6, 2026);
            ps.executeUpdate();

        
            ps.setInt(1, 110);
            ps.setString(2, "Sneha");
            ps.setInt(3, 2);
            ps.setInt(4, 95);
            ps.setString(5, "CSE");
            ps.setInt(6, 2025);
            ps.executeUpdate();

            System.out.println("10 student records inserted successfully.");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
