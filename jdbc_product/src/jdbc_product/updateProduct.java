package jdbc_product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateProduct {
    
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root"); // Establish
																														// connection

		Statement statement = connection.createStatement(); // create statement

		int result = statement.executeUpdate("UPDATE product SET name='samsung' WHERE ID=2");

		if (result != 0) {
			System.out.println("Data updated");
		} else {
			System.out.println("Data Not Inserted");
		}

		connection.close();
	}
}
