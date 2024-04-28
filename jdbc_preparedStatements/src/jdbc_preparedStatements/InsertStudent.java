package jdbc_preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {
     
	public static void main(String args[]) throws Exception
	{
		 String fullClassName="com.mysql.cj.jdbc.Driver";
		 String url="jdbc:mysql://localhost:3306/studentdb";
		 String userName="root";
		 String password="root";
		 String query="insert into student values(?,?,?,?,?,?,?)";
		 
		 Scanner scanner=new Scanner(System.in);
		 System.out.println("Enter the id of student");
		 int id=scanner.nextInt();
		 
		 scanner.nextLine();
		 System.out.println("Enter the name of student");
		 String name=scanner.nextLine();
		 
		 scanner.nextLine();
		 System.out.println("Enter the Father name");
		 String fatherName=scanner.nextLine();
		
		 scanner.nextLine();
		 System.out.println("Enter the Mother name");
		 String motherName=scanner.nextLine();
		 
		 System.out.println("Enter the phone number");
		 long number=scanner.nextLong();
		 
		 scanner.nextLine();
		 System.out.println("Enter the Address of student");
		 String address=scanner.nextLine();
		 
		 System.out.println("Enter the marks of student");
		 double marks=scanner.nextDouble();
		 
		 
		 
		 
		 Class.forName(fullClassName);
		 Connection connection=DriverManager.getConnection(url, userName, password);
		 
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 
		 preparedStatement.setInt(1, id);
		 preparedStatement.setString(2, name);
		 preparedStatement.setString(3, fatherName);
		 preparedStatement.setString(4, motherName);
		 preparedStatement.setLong(5, number);
		 preparedStatement.setString(6, address);
		 preparedStatement.setDouble(7, marks);
				 
				 
         int  result=preparedStatement.executeUpdate()	;
         
         if(result !=0) {
        	 System.out.println("Data Inserted");
         }
         else
         {
        	 System.out.println("Data  Not Inserted");
         }
				 
				 
		connection.close();		 
				 
				 
				 
	}
}
