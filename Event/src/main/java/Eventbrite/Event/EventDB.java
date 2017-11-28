package Eventbrite.Event;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	// Returns a String of the first name of a specified user.
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
	
	// Returns a String of the last name of a specified user.
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
	
	// Create an event.
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
				
		st.executeUpdate(query);
		
	}
	
	// Returns an ArrayList of all events.
	public static ArrayList<Event> getEvents() throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	//Returns an ArrayList of events of the specified eventType.
	public static ArrayList<Event> getEvents(String eventType) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event WHERE type='" + eventType + "'";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	// Returns an ArrayList of Events sorted by price.
	public static ArrayList<Event> getEventsSortedByPrice() throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event ORDER BY ticketPrice";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	// Returns an ArrayList of events of a specific event type, sorted by price.
	public static ArrayList<Event> getEventsSortedByPrice(String eventType) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event WHERE type='" + eventType + "' ORDER BY ticketPrice";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	
	
	// Set user to corporate.
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
	
	
	//Get the username used to log in.
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
	
	// Returns number of tickets remaining for an event ID.
	public static int getTicketsRemaining(int eventID) throws SQLException
	{
		query = "SELECT ticketsRemaining FROM eventbritedb.event WHERE id=" + eventID;
		result = st.executeQuery(query);
		if(result.next()) {
			int ticketsRemaining = result.getInt("ticketsRemaining");
			return ticketsRemaining;
		}
		else
			return -1;
	}
	
	// Returns ArrayList of all events hosted by a specified username.
	public static ArrayList<Event> getEventsByHost(String hostName) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * from event where host='" + hostName + "'";
		result = st.executeQuery(query);
		
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
	}
	
	// Returns ArrayList of events sorted by date from earliest to latest.
	public static ArrayList<Event> getEventsSortedByDate() throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event ORDER BY startDateTime";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	// Returns ArrayList of events of a specified event type, sorted by date.
	public static ArrayList<Event> getEventsSortedByDate(String eventType) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event WHERE type='" + eventType + "' ORDER BY startDateTime";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
		
	}
	
	// Returns true if the date of an event has already passed.
	public static boolean dateHasPassed(int eventID) throws SQLException
	{
		query = "SELECT * FROM eventbritedb.event WHERE id=" + eventID + " AND now() < startDateTime";
		result = st.executeQuery(query);
		if(result.next())
			return false;
		else
			return true;
	}
	
	// Returns true if an event has more than 0 tickets remaining.
	public static boolean hasCapacity(int eventID) throws SQLException
	{
		query = "SELECT * FROM eventbritedb.event WHERE id=" + eventID + " AND ticketsRemaining > 0";
		result = st.executeQuery(query);
		if(result.next())
			return true;
		else
			return false;
	}
	
	// Registers a username with an event.
	public static void registerForEvent(String username, int eventID) throws SQLException
	{
		query = "INSERT INTO eventbritedb.attends (username, eventID) VALUES ('" + username + "'," + eventID + ")";
		st.executeUpdate(query);
	}
	
	// Returns the events that a username is registered for.
	public static ArrayList<Event> getRegisteredEvents(String username) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM eventbritedb.attends, eventbritedb.event WHERE username='" + username + "' AND eventID=id";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
	}
	
	// Change an event name according to the event ID.
	public static void changeEventName(int eventID, String newEventName) throws SQLException
	{
		query = "UPDATE eventbritedb.event SET eventName='" + newEventName + "' WHERE id=" + eventID;
		st.executeUpdate(query);
	}
	
	// Returns a User object of the host of the specified event ID.
	public static User getHost(int eventID) throws SQLException
	{
		User user = new User();
		query = "SELECT username, firstName, lastName, password, email, isCorporate, isAdmin from eventbritedb.event, eventbritedb.user"
				+ " WHERE id=" + eventID + " AND host=username";
		result = st.executeQuery(query);
		
		if(result.next())
		{
			user.setUsername(result.getString("username"));
			user.setFirstName(result.getString("firstName"));
			user.setLastName(result.getString("lastName"));
			user.setPassword(result.getString("password"));
			user.setEmail(result.getString("email"));
			if(result.getInt("isCorporate") == 1)
				user.setCorporate(true);
			else
				user.setCorporate(false);
			
			if(result.getInt("isAdmin") == 1)
				user.setAdminRights(true);
			else
				user.setAdminRights(false);
		}
		
		return user;
	}
	
	// Change the first name of the specified username.
	public static void changeFirstName(String username, String firstName) throws SQLException
	{
		query = "UPDATE eventbritedb.user SET firstName='" + firstName + "' WHERE username='" + username + "'";
		st.executeUpdate(query);
	}
	
	// Change the last name of the specified username.
	public static void changeLastName(String username, String lastName) throws SQLException
	{
		query = "UPDATE eventbritedb.user SET lastName='" + lastName + "' WHERE username='" + username + "'";
		st.executeUpdate(query);
	}
	
	// Change the e-mail of the specified username.
	public static void changeEmail(String username, String email) throws SQLException
	{
		query = "UPDATE eventbritedb.user SET email='" + email + "' WHERE username='" + username + "'";
		st.executeUpdate(query);
	}
	
	// Returns an event associated with the specified eventID.
	public static Event getEvent(int eventID) throws SQLException
	{
		query = "SELECT * FROM eventbritedb.event WHERE id=" + eventID;
		Event event = new Event();
		result = st.executeQuery(query);
		
		if(result.next()) 
		{
			event.setEventID(result.getInt("id"));
			event.setEventName(result.getString("eventName"));
			event.setLocation(result.getString("location"));
			event.setStartDateTime(result.getTimestamp("startDateTime"));
			event.setEventType(result.getString("type"));
			event.setEndDateTime(result.getTimestamp("endDateTime"));
			event.setTicketPrice(result.getDouble("ticketPrice"));
			event.setCapacity(result.getInt("capacity"));
			event.setHostName(result.getString("host"));
			event.setTicketsRemaining(result.getInt("ticketsRemaining"));
			event.setDescription(result.getString("description"));
		}
		
		return event;
		
	}
	
	// Returns ArrayList of all events whose start date/time have not passed
	public static ArrayList<Event> getValidEvents() throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event WHERE startDateTime > now()";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
	}
	
	// Returns ArrayList of events of type eventType whose start date/time have not passed.
	public static ArrayList<Event> getValidEvents(String eventType) throws SQLException
	{
		ArrayList<Event> events = new ArrayList<Event>();
		query = "SELECT * FROM event WHERE startDateTime > now() AND type='" + eventType + "'";
		
		result = st.executeQuery(query);
		while(result.next())
		{

			Event tempEvent = new Event();
			tempEvent.setEventID(result.getInt("id"));
			tempEvent.setEventName(result.getString("eventName"));
			tempEvent.setLocation(result.getString("location"));
			tempEvent.setStartDateTime(result.getTimestamp("startDateTime"));
			tempEvent.setEventType(result.getString("type"));
			tempEvent.setEndDateTime(result.getTimestamp("endDateTime"));
			tempEvent.setTicketPrice(result.getDouble("ticketPrice"));
			tempEvent.setCapacity(result.getInt("capacity"));
			tempEvent.setHostName(result.getString("host"));
			tempEvent.setTicketsRemaining(result.getInt("ticketsRemaining"));
			tempEvent.setDescription(result.getString("description"));
			
			events.add(tempEvent);
			
		}
		return events;
	}

}
