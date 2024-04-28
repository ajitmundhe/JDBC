package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root"); // Establish
																														// connection

		Statement statement = connection.createStatement(); // create statement

		int result = statement.executeUpdate("INSERT INTO EMPLOYEE VALUES(2,'AADESH',9823765456,6000,'NASHIK'),(3,'ANKIT',9723765456,7000,'PUNE'),(4,'AATHRAV',9983765456,10000,'PUNE')");

		if (result != 0) {
			System.out.println("Data Inserted");
		} else {
			System.out.println("Data Not Inserted");
		}

		connection.close();
	}
}
