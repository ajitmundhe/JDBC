package jdbc_library_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class libraryCRUD {
    
	 
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");
		
		return connection;
	}
	
	public int signUp(User user) throws Exception
	{
		String query="insert into user(id,name,phone,email,password)values(?,?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setLong(3,user.getPhone());
		preparedStatement.setString(4,user.getEmail());
		preparedStatement.setString(5,user.getPassword());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
	
	public String login(String email) throws Exception
	{
		String query="select password from user where email=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
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
	
	public int updatePassword(String email,String password) throws Exception
	{
		String query="update user set password=? where email=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, password);
		preparedStatement.setString(2,email);
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public int addBook(Book book) throws Exception
	{
		String query="insert into book(id,name,author,genre)values(?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,book.getId());
		preparedStatement.setString(2,book.getName());
		preparedStatement.setString(3,book.getAuthor());
		preparedStatement.setString(4,book.getGener());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
}
