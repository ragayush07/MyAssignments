/*Write a program to delete of all Students whose records whose year of passing is 2024. and branch is Civil.*/

package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prob4 {

    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "ayush177";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql =
                "DELETE FROM Students " +
                "WHERE year_of_passing = ? AND branch = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 2024);     
            ps.setString(2, "CE");  

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(rows + " Civil students (2024) deleted successfully.");
            else
                System.out.println("No matching records found to delete.");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
