package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DeleteData {

	@Test
	public void deletedata() throws SQLException
	{
		//step 1:Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2:establish connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "root");
		
		//step 3:Issue create statement
		Statement stat=con.createStatement();
		
		//step 4:execute query
		int result=stat.executeUpdate(" delete from customer where CustomerName='Sujatha';");
		if(result==1)
		{
			System.out.println("Querry successful");
		}
		else
		{
			System.out.println("Querry not successful");

		}
		
		//step 5:Close database connection
		con.close();
		System.out.println("Close database connection");
		
		
		
	}

}
