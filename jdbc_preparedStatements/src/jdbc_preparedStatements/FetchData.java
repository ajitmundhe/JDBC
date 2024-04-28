package jdbc_preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData {
    
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception
	{
		String FQN="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="select * from student";
		
		Class.forName(FQN);
		
		Connection connection=DriverManager.getConnection(url, username, password);
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		
		ResultSet set= preparedStatement.executeQuery();
		
		while(set.next())
		{
			System.out.print(set.getInt("id"));
			System.out.print(" "+set.getString("student_name"));
			System.out.print(" "+set.getString("student_father_name"));
			System.out.print(" "+set.getString("student_mother_name"));
			System.out.print(" "+set.getLong("phone"));
			System.out.print(" "+set.getString("address"));
			System.out.print(" "+set.getDouble("marks"));
			System.out.println();
		}
		connection.close();
	}
}
