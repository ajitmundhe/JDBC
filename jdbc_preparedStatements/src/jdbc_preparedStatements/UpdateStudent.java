package jdbc_preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
   
	public static void main(String[] args) throws Exception {
		
		String fullyQualifiedName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String userName="root";
		String password="root";
		String query="update student set student_name=? where id=?";
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the new Name");
		String newName=scanner.nextLine();
		
		System.out.println("Enter the id ");
		int idNumber=scanner.nextInt();
		
		Class.forName(fullyQualifiedName);
		Connection connection=DriverManager.getConnection(url, userName, password);
		
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1,newName);
		 preparedStatement.setInt(2, idNumber);
		 
		 int result=preparedStatement.executeUpdate();
		 if(result!=0)
		 {
			 System.out.println("Data updated");
		 }
		 else
		 {
			 System.out.println("Data Not updated");
		 }
		 
		 connection.close();
		
	}
}
