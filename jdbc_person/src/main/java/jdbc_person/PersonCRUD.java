package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;

public class PersonCRUD {

	public Connection loadDriver() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
	}

	public int signUpPerson(Person person) throws Exception {
		Connection connection = loadDriver();
		String query = "insert into person values(?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPassword());

		int result =preparedStatement.executeUpdate();
        connection.close();
		return result;

	}
	
	public String loginPerson(String email) throws Exception
	{ 
		Connection connection = loadDriver();
		String query = "select password from person where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
		String password=null;
		while(set.next())
		{
			password=set.getString("password");
		}
		connection.close();
		return password;
	}
	
	public Person showData(String email) throws Exception
	{
		Connection connection = loadDriver();
		String query = "select * from person where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
	     
		Person person=new Person();
		while(set.next())
		{
			person.setId(set.getInt("id"));
			person.setName(set.getString("name"));
			person.setPhone(set.getLong("phone"));
			person.setEmail(set.getString("email"));
			person.setPassword(set.getString("password"));


		}
		connection.close();
		return person;
		
	}
	public int changePassword(String password ,String email) throws Exception
	{
		Connection connection = loadDriver();
		String query = "update  person set password=? where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		  preparedStatement.setString(1, password);
		  preparedStatement.setString(2, email);
		
		int result=preparedStatement.executeUpdate();
		return result;
	}
	
	public int deleteAccount(String email) throws Exception
	{
		Connection connection = loadDriver();
		String query = "delete from person where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		int result=preparedStatement.executeUpdate();
	//	connection.close();
		return result;
	}
	
}
