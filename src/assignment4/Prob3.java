/*Write a program to increase 5% to percentage of all Students whose branch is CSE.
*/

package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prob3 {

    public static void main(String[] args) {

        String url  = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String pass = "ayush177";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql =
            		"UPDATE Students " +
                    "SET marks = ROUND(marks * 1.05) " +
                    "WHERE branch = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "CSE");

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(rows + " CSE students' marks increased by 5%.");
            else
                System.out.println("No CSE students found to update.");

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
