package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUpdate {
    
	 public static void main(String args[]) throws ClassNotFoundException, SQLException
	 {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		 Statement statement=connection.createStatement();
		 int result=statement.executeUpdate("UPDATE EMPLOYEE SET NAME='AADU' WHERE ID=2");
		 if(result!=0)
		 {
			 System.out.println("Data updated");
		 }
		 else
		 {
			 System.out.println("Data not updated");
		 }
		 connection.close();
	 }
}
