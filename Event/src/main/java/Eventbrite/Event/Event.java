package Eventbrite.Event;


import java.util.Calendar;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Event 
{
	private String eventName, location, description, eventType, startDateTimeString, endDateTimeString, hostName;
	private Calendar startDateTime;
	private Calendar endDateTime;
	private double ticketPrice;
	private int capacity, eventID, ticketsRemaining;
	private User host;
	
	public Event()
	{
		startDateTime = Calendar.getInstance();
		endDateTime = Calendar.getInstance();
	}
	
	public void setStartDateTime(Timestamp startDateTime)
	{
		this.startDateTime.setTime(startDateTime);
	}
	
	public void setEndDateTime(Timestamp endDateTime)
	{
		this.endDateTime.setTime(endDateTime);
	}
	
	public int getEventID()
	{
		return eventID;
	}
	
	public void setEventID(int eventID)
	{
		this.eventID = eventID;
	}
	
	public void setTicketsRemaining(int ticketsRemaining)
	{
		this.ticketsRemaining = ticketsRemaining;
	}
	
	public int getTicketsRemaining()
	{
		return ticketsRemaining;
	}
	
	public String getEventName()
	{
		return eventName;
	}
	
	public Calendar getStartDateTime()
	{
		return startDateTime;
	}
	
	public Calendar getEndDateTime()
	{
		return endDateTime;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	
	public User getHost()
	{
		return host;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getEventType()
	{
		return eventType;
	}
	
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public void setStartDateTime(int year, int month, int day, int hour, int minute)
	{
		startDateTime.set(year,month,day,hour,minute);
	}
	
	public void setEndDateTime(int year, int month, int day, int hour, int minute)
	{
		endDateTime.set(year,month,day,hour,minute);
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setTicketPrice(double ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}
	
	public void setHost(User host)
	{
		this.host = host;
	}
	
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
}
