package Eventbrite.Event;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class searchEvent
{
	public static void showMenu() 
	{
		System.out.println("===========================================");
		System.out.println("Search by: All,Name,Type,Location,Price,Date");
		System.out.println("===========================================");
		Scanner input = new Scanner(System.in);
		String searchBy = input.nextLine();
		if(searchBy.equalsIgnoreCase("Name"))
		{
			//Sorts events
			sortByName.sortName();
		}
		else if(searchBy.equalsIgnoreCase("Type"))
		{
			//Searches for specific types of events
			sortByType.sortType();
		}
		else if(searchBy.equalsIgnoreCase("All"))
		{
			//Displays all events
			sortByAll.showAllEvents();	
		}
		else if(searchBy.equalsIgnoreCase("Location"))
		{
			//Searches by location
			sortByLocation.sortLocation();
		}
		else if(searchBy.equalsIgnoreCase("Date"))
		{
			//Searches by date
			sortByDate.sortDate();
		}
		else if(searchBy.equalsIgnoreCase("Price"))
		{
			//Searches by price
			sortByPrice.sortPrice();
		}
		else
		{
			System.out.println("Sorry invaild option");
		}
		Home.showMenu();	
	}
}
