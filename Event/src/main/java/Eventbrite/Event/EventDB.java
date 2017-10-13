package Eventbrite.Event;

import java.sql.*;

public class EventDB {
	static private String connectionString = "jdbc:mysql://localhost:3306/eventbritedb";
	// Needed to establish a connection with the MySQL server.
	static private Connection con;
	// Takes SQL statements and executes them.
	static private Statement st;
	// Temporarily holds SQL statements to pass to st.
	static private String query;
	// Holds the results of queries.
	static private ResultSet result;
	
	private EventDB()
	{
	}
	
	public static void getConnection()
	{
		try 
		{
			// Establish connection to MySQL server.
			 con = DriverManager.getConnection(connectionString,"guest","guest");
			 System.out.println("Connection successful.");
			 // Create a Statement object which holds SQL statements. 
			 st = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION: " + e.getMessage());
		}
	}
	
	public static void getConnection(String username, String password) throws SQLException
	{
			con = DriverManager.getConnection(connectionString,username,password);
			System.out.println("Connection successful.");
			st = con.createStatement();
	}
	
	public static void closeConnection()
	{
		try {
			con.close();
			st.close();
			System.out.println("Connection closed.");
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION: " + e.getMessage());
		}
	}
	
	public static void createUser(String username, String password) throws SQLException
	{
		query = "CREATE USER " + username + " IDENTIFIED BY " + "'" + password + "';";
		String grant1 = "GRANT SELECT, UPDATE, DELETE, INSERT ON eventbritedb.* TO " + username +";";
		String grant2 = "GRANT CREATE USER ON *.* TO " + username + ";";
		//Execute multiple line statements.
		st.addBatch(query);
		st.addBatch(grant1);
		st.addBatch(grant2);
		st.executeBatch();
	}
	
	public static void addUserInfo(String username, String firstName,
			String lastName, String password, String email) throws SQLException
	{
		// SQL statements
		query = "INSERT INTO user"
				+ " VALUES ('" + username + "','" + firstName + "','" + lastName + "','" + password +
				"','" + email + "')";

		// Execute SQL statements in the MySQL server.
		st.executeUpdate(query);
	}
	
	public static void deleteUser(String username) throws SQLException
	{
		query = "DELETE FROM user " + 
				"WHERE username=" + "'" + username + "'";
		
		st.executeUpdate(query);
	}
	
	public static String getFirstName(String username) throws SQLException
	{
		query = "SELECT firstName FROM user WHERE username=" + "'" + username + "'";

			result = st.executeQuery(query);
			if(result.next())
			{
				return result.getString("firstName");
			}
			
		return "";
	}
	
	public static String getLastName(String username) throws SQLException
	{
		query = "SELECT lastName FROM user WHERE username=" + "'" + username + "'";
		result = st.executeQuery(query);
		
		if(result.next())
		{
			return result.getString("lastName");
		}
		return "";
	}
	
	

}
