package jdbc_user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class userCRUD {

	public Connection loadDriver() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
		return connection;
	}

	public int signUp(User user) throws Exception {
		Connection connection = loadDriver();
		String query = "insert into user(id,name,phone,email,password)values(?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
//		preparedStatement.setString(6, user.getFacebook());
//		preparedStatement.setString(7, user.getInstagram());
//		preparedStatement.setString(8, user.getSnapchat());
//		 preparedStatement.setString(9, user.getTwitter());

		int result = preparedStatement.executeUpdate();
		connection.close();

		return result;
	}
	
	public String login(String email) throws Exception
	{
		Connection connection=loadDriver();
		
		String query="select password from user where email=?";
		
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
	public User showPassword(String email) throws Exception
	{
		Connection connection = loadDriver();
		String query = "select * from user where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
	     
		User user=new User();
		while(set.next())
		{
			user.setFacebook(set.getString("facebook"));
			user.setInstagram(set.getString("instagram"));
			user.setSnapchat(set.getString("snapchat"));
			user.setTwitter(set.getString("twitter"));


		}
		connection.close();
		return user;
		
	}
	public int updateFacebook(String email,String password) throws Exception
	{
		 Connection connection=loadDriver();
		 String query="update user set facebook=? where email=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, password);
		 preparedStatement.setString(2, email);
		 
		 int result=preparedStatement.executeUpdate();
		 connection.close();
		 return result;
	}
	public int updateInstagram(String email,String password) throws Exception
	{
		 Connection connection=loadDriver();
		 String query="update user set instagram=? where email=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, password);
		 preparedStatement.setString(2, email);
		 
		 int result=preparedStatement.executeUpdate();
		 connection.close();
		 return result;
	}
	public int updateSnapchat(String email,String password) throws Exception
	{
		 Connection connection=loadDriver();
		 String query="update user set snapchat=? where email=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, password);
		 preparedStatement.setString(2, email);
		 
		 int result=preparedStatement.executeUpdate();
		 connection.close();
		 return result;
	}
	public int updateTwitter(String email,String password) throws Exception
	{
		 Connection connection=loadDriver();
		 String query="update user set twitter=? where email=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, password);
		 preparedStatement.setString(2, email);
		 
		 int result=preparedStatement.executeUpdate();
		 connection.close();
		 return result;
	}
	public int updatePassword(String email,String password) throws Exception
	{
		 Connection connection=loadDriver();
		 String query="update user set password=? where email=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(query);
		 preparedStatement.setString(1, password);
		 preparedStatement.setString(2, email);
		 
		 int result=preparedStatement.executeUpdate();
		 connection.close();
		 return result;
	}
	
	
}
