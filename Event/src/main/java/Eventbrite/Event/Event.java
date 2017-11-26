package Eventbrite.Event;


import java.util.Calendar;
import java.util.ArrayList;

public class Event 
{
	private String eventName, location, description, eventType;
	private Calendar startDateTime;
	private Calendar endDateTime;
	private double ticketPrice;
	private int capacity;								//total capacity of event
	private User host;
	private Boolean inviteOnly;
	
	public Event()
	{
		startDateTime = Calendar.getInstance();
		endDateTime = Calendar.getInstance();
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
	
	public Boolean inviteOnly()
	{
		return inviteOnly;
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
		startDateTime.set(year-1,month,day,hour,minute);
	}
	
	public void setEndDateTime(int year, int month, int day, int hour, int minute)
	{
		endDateTime.set(year-1,month,day,hour,minute);
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
	
	public void setInviteOnly(Boolean inviteOnly)
	{
		this.inviteOnly = inviteOnly;
	}
	
	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}
	
}
