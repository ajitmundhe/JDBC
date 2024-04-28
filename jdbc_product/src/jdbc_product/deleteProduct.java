package jdbc_product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteProduct {

	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root"); // Establish
																														// connection

		Statement statement = connection.createStatement(); // create statement

		int result = statement.executeUpdate("DELETE FROM product  WHERE ID=2");

		if (result != 0) {
			System.out.println("Data deleted");
		} else {
			System.out.println("Data Not deleted");
		}

		connection.close();
	}

}
