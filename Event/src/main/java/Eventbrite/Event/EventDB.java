package Eventbrite.Event;

import java.sql.*;
import java.util.Calendar;

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
	
	//Create user account (must add user information using addUserInfo())
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
	
	//Adds information for existing user account
	public static void addUserInfo(String username, String firstName,
			String lastName, String password, String email) throws SQLException
	{
		// SQL statements
		query = "INSERT INTO user"
				+ " VALUES ('" + username + "','" + firstName + "','" + lastName + "','" + password +
				"','" + email + "',0,0)";

		// Execute SQL statements in the MySQL server.
		st.executeUpdate(query);
	}
	
	//Deletes user information, not the actual user account
	public static void deleteUserInfo(String username) throws SQLException
	{
		query = "DELETE FROM user " + 
				"WHERE username=" + "'" + username + "'";
		
		st.executeUpdate(query);
	}
	
	//Delete a user account
	public static void deleteUser(String username) throws SQLException
	{
		query ="DROP USER IF EXISTS '" + username + "'@'%'";
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
	
	
	public static void createEvent(String eventName, String location, Calendar startDateTime,
			String type, Calendar endDateTime, double ticketPrice, int capacity, String host, int ticketsRemaining,
			String description) throws SQLException
	{
		query = "INSERT INTO event (eventName, location, startDateTime, type, endDateTime, ticketPrice, capacity, host, ticketsRemaining, "
				+ "description) values ('"
				+ eventName + "','" + location + "','" + startDateTime.get(Calendar.YEAR) + '-' + startDateTime.get(Calendar.MONTH) + '-' +
				startDateTime.get(Calendar.DAY_OF_MONTH) + ' ' + startDateTime.get(Calendar.HOUR_OF_DAY) + ':' + startDateTime.get(Calendar.MINUTE) + 
				":00', '" + type + "','" + endDateTime.get(Calendar.YEAR) + '-' + endDateTime.get(Calendar.MONTH) + '-' + endDateTime.get(Calendar.DAY_OF_MONTH) +
				' ' + endDateTime.get(Calendar.HOUR_OF_DAY) + ':' + endDateTime.get(Calendar.MINUTE) + ":00'," + ticketPrice + 
				',' + capacity + ",'" + host + "'," + ticketsRemaining + ",'" + description + "')";
		System.out.println(query);
				
		st.executeUpdate(query);
		
	}
	
	// Set user to corporate
	public static void setCorporate(String username, boolean isCorporate) throws SQLException
	{
		query = "UPDATE user SET isCorporate=";
		if(isCorporate)
			query += 1;
		else
			query += 0;
		
		query += " WHERE username='" + username + "'";
		st.executeUpdate(query);
		
	}
	
	// Returns true if user is a corporate user, false if otherwise.
	public static boolean isCorporate(String username) throws SQLException
	{
		query = "SELECT isCorporate FROM user WHERE username='" + username + "'";
		result = st.executeQuery(query);
		if(result.next())
		{
			if(result.getInt(1) == 1)
				return true;
			else
				return false;
		}
		return false;
		
	}
	
	// Give a user admin rights.
	public static void setAdmin(String username, boolean isAdmin) throws SQLException
	{
		query = "UPDATE user SET isAdmin=";
		if(isAdmin)
			query += 1;
		else
			query += 0;
		
		query += " WHERE username='" + username + "'";
		st.executeUpdate(query);
	}
	
	
	// Returns true if user is an admin, false if otherwise.
	public static boolean isAdmin(String username) throws SQLException
	{
		query = "SELECT isAdmin FROM user WHERE username='" + username + "'";
		result = st.executeQuery(query);
		if(result.next()) {
			if(result.getInt(1) == 1) {
				return true;
			}
			else
				return false;
		}
		return false;
		
	}
	
	
	//Get the username used to log in
	public static String getCurrentUser() throws SQLException
	{
		query = "SELECT current_user";
		result = st.executeQuery(query);
		
		String nameResult = "";
		String username = "";
		
		if(result.next())
		{
			nameResult = result.getString("current_user");
		}
		for(int i = 0; i < nameResult.length(); i++)
		{
			if(nameResult.charAt(i) == '@')
				break;
			else
				username += nameResult.charAt(i);
		}
		
		return username;
	}
	
	
	
	

}
