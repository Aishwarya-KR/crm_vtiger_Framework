package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ValidateData 
{
	@Test
	public void validatedata() throws SQLException
	{
		Connection con=null;
		String name="Aishwarya";
		

		try
		{
		//step 1:Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2:establish connection with database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "root");
		
		//step 3:Issue create statement
        Statement stat=con.createStatement();
		
		//step 4:Execute any query
        ResultSet result=stat.executeQuery("select CustomerName from customer;");
		while(result.next())
		{
			
			if(result.getString(1).equals(name))
			{
				System.out.println("String is same");
			}
			else
			{
				System.out.println("String is not same");
			}
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			con.close();
			System.out.println("Connection closed");
		}
		
		}

	
}
