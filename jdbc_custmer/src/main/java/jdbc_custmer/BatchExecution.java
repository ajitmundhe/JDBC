package jdbc_custmer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Custmer custmer1=new Custmer();
		custmer1.setId(1);
		custmer1.setName("Ajit");
		custmer1.setPhone(987466321);
		custmer1.setAddress("latur");
		
		Custmer custmer2=new Custmer();
		custmer2.setId(2);
		custmer2.setName("omkar");
		custmer2.setPhone(9874654121l);
		custmer2.setAddress("pune");
		
		Custmer custmer3=new Custmer();
		custmer3.setId(3);
		custmer3.setName("Aadesh");
		custmer3.setPhone(9102466321l);
		custmer3.setAddress("nashik");
		
		List<Custmer> list=new ArrayList<Custmer>();
		list.add(custmer1);
		list.add(custmer2);
		list.add(custmer3);

		
		String fqn="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/custmerdb";
		String user="root";
		String password="root";
		String query="insert into custmer(id,name,phone,address)values(?,?,?,?)";
		Class.forName(fqn);
		Connection connection=DriverManager.getConnection(url, user, password);
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		
		for (Custmer custmer : list) {
			
			preparedStatement.setInt(1, custmer.getId());
			preparedStatement.setString(2, custmer.getName());
			preparedStatement.setLong(3, custmer.getPhone());
			preparedStatement.setString(4, custmer.getAddress());
			preparedStatement.addBatch();
		}
		
		preparedStatement.executeBatch();
		System.out.println("Batch Executed");
		connection.close();
	}
}
