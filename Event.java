package Eventbrite.Event;


import java.util.Calendar;
import java.util.ArrayList;

public class Event 
{
	private String eventName, location, description;
	private Calendar eventDate;
	private double ticketPrice;
	private int capacity;								//total capacity of event
	private User host;
	private Boolean inviteOnly;
	ArrayList<String> tags;								//tags like music, theater..
	ArrayList<User> usersAttending;
	
	public Event()
	{
		eventDate = Calendar.getInstance();
		tags = new ArrayList<String>();
		usersAttending = new ArrayList<User>();
	}
	
	public String getEventName()
	{
		return eventName;
	}
	
	public Calendar getDate()
	{
		return eventDate;
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
	
	public ArrayList<String> getTags()
	{
		return tags;
	}
	
	public int ticketsLeft()
	{
		int ticketsLeft = capacity - usersAttending.size();
		
		return ticketsLeft;
	}
	
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}

	public void setDate(int year, int month, int day, int hour, int minute)
	{
		eventDate.set(year,month,day,hour,minute);
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
	
	public void addTag(String tag)
	{
		tags.add(tag);
	}
	
	//add a user to userAttending list
	public Boolean addUser(User newUser)
	{
		if(usersAttending.size() < capacity)
		{
			usersAttending.add(newUser);
			return true;
		}
		else
			return false;
	}

}
