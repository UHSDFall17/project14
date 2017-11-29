package Eventbrite.Event;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class sortByAll 
{
	public static void showAllEvents()
	{
		System.out.println("Would you like to view all available events or all events");
		System.out.println("========================================================="
				+ "\n(Type available or all)");
		Scanner input = new Scanner(System.in);
		String searchBy = input.nextLine();
		if(searchBy.equalsIgnoreCase("available"))
		{
			//Sorts available events
			availableEvents();	
		}
		else if(searchBy.equalsIgnoreCase("all"))
		{
			//Searches for all/past events
			allEvents();
		}
		else
		{
			System.out.println("Sorry invaild option please enter a correct choice.");
			showAllEvents();
		}
	
	}
	public static void allEvents()
	{
		System.out.println("You are viewing all events");
		ArrayList<Event> eventsName;
		try {
			eventsName = EventDB.getEvents();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("===========================================");
			for(Event e : eventsName) {
				System.out.print("The id for this event is: ");
				System.out.println(e.getEventID());
				System.out.print("Event Name: ");
				System.out.println(e.getEventName());
				System.out.print("Event Type: ");
				System.out.println(e.getEventType());
				System.out.print("Description: ");
				System.out.println(e.getDescription());
				System.out.print("Capacity: ");
				System.out.println(e.getCapacity());
				System.out.print("Host of Event: ");
				System.out.println(e.getHostName());
				System.out.print("Location: ");
				System.out.println(e.getLocation());
				System.out.print("Start Date: ");
				System.out.println(sdf.format(e.getStartDateTime().getTime()));
				System.out.print("Ticket Price: $");
				System.out.println(e.getTicketPrice());
				System.out.println("===========================================");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	

}
