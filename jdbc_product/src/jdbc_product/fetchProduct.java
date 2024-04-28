package jdbc_product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fetchProduct {

	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load the Driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root"); // Establish
																														// connection

		Statement statement = connection.createStatement(); // create statement

		 ResultSet set=statement.executeQuery("SELECT * FROM product");
		
		 while(set.next())
		 {
			 System.out.print(set.getInt("ID"));
			 System.out.print(set.getString("NAME"));
			 System.out.print(set.getLong("price"));
			 System.out.print(set.getString("manufature"));
			 System.out.print(set.getInt("quantaty"));
			 System.out.println();
		 }

		connection.close();
	}
}
