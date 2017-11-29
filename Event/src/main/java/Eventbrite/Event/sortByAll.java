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
	
	
	

}
