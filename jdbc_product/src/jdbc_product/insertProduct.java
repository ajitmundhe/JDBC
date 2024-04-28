package jdbc_product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertProduct {

	
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root"); // Establish
																														// connection

		Statement statement = connection.createStatement(); // create statement

		int result = statement.executeUpdate("INSERT INTO product VALUES(4,'one plus 10',65664,'mumbai',1),(5,'iphone ',1321564,'pune',5)");

		if (result != 0) {
			System.out.println("Data Inserted");
		} else {
			System.out.println("Data Not Inserted");
		}

		connection.close();
	}
}
