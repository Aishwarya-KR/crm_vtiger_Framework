package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils
{

	@Test
	public void ExcuteQuery() throws SQLException
	{
		//step 1:Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2:establish connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "root");
		
		//step 3:Issue create statement
		Statement stat=con.createStatement();
		
		//step 4:Execute any query
		ResultSet result=stat.executeQuery("select * from customer;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6));
			
		}
		//int a=stat.executeUpdate("Insert into customer(CustomerName,ContactName,Address,City,PostalCode,Country)values('Rincy','Tom B. Erchsen','TBlock','Georgia','56007','USA')");
		//System.out.println(a);
		//step 5:close database connection
		con.close();
		System.out.println("Connection closed");

			
	}
	@Test
	public void ExcuteUpdate() throws SQLException
	{
		Connection con=null;
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
			int result=stat.executeUpdate("Insert into customer(CustomerName,ContactName,Address,City,PostalCode,Country)values('Sujatha','Tom B. Erchsen','TBlock','Georgia','56007','USA')");
			if(result==1)
			{
				System.out.println("Record is successfully inserted");
			}
			else
			{
				System.out.println("Querry failed");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			//step 5:close database connection
			con.close();
			System.out.println("Connection closed");
				
		}
		
	}
	

}
