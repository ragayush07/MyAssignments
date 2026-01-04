/*Write a program to demonstrate JDBC connection establishment to MySQL. 
 If connections is established then "Connection Successful" message will displayed 
 otherwise "Unable to connect" message should be displayed.
*/

package assignment4;

import java.sql.*;

public class Prob1 {
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "ayush177");
			
			if(con != null) {
				System.out.println("Connection Succesful");
			}
			else {
				System.out.println("Unable to connect");
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("JDBC Driver not found: " + e.getMessage());
		}
		catch(SQLException e) {
			System.out.println("Unable to connect: " + e.getMessage());
		}
		finally {
			try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection.");
            }
		}
		
	}
}
