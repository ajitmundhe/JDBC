package jdbc_preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
   
	public static void main(String args[]) throws Exception
	{
		String fullyQualifiedName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String username="root";
		String password="root";
		String query="delete from student where id=?";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id number that you want to delete");
		int idNumber=scanner.nextInt();
		
		Class.forName(fullyQualifiedName);
		
		Connection connection=DriverManager.getConnection(url, username, password);
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, idNumber);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0)
		{
			System.out.println("Data Deleted");
		}
		else
		{
			System.out.println("Data Not Deleted");
		}
		connection.close();
	}
}
