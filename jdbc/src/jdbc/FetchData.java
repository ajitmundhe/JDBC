package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchData {
     
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		
		Statement statement=connection.createStatement();
	    
		 ResultSet set=statement.executeQuery("SELECT * FROM EMPLOYEE");
		 
		 while(set.next())
		 {
			 System.out.print(set.getInt("ID"));
			 System.out.print(set.getString("NAME"));
			 System.out.print(set.getLong("PHONE"));
			 System.out.print(set.getDouble("SALARY"));
			 System.out.print(set.getString("ADDRESS"));
			 System.out.println();
		 }
		 connection.close();
		 
	}
}
