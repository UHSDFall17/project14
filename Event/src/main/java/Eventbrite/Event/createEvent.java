package Eventbrite.Event;

import java.util.Scanner;

public class createEvent 
{
	public static void showMenu() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("===========================================");
		
		System.out.println("Enter The Name Of The Event: ");
		String eventName = input.nextLine();
		System.out.print("Enter A Description For The Event: ");
		String eventDesc = input.nextLine();
		
		System.out.print("Enter The Type Of Event: ");
		String eventType = input.nextLine();
		
		System.out.print("Enter The Location For The Event: ");
		String eventLocation = input.nextLine();
		
		System.out.print("Enter The Price Of Tickets: ");
		Double eventPrice = input.nextDouble(); 
		
		
		/*EventDate Start block */
		System.out.println("============================");
		System.out.println("*Enter The Start Date Of The Event*");
		System.out.println("============================");
		System.out.print("Enter Start Date Year: ");
		int eventStartYear = input.nextInt();
		System.out.print("Enter Start Date Month: ");
		int eventStartMonth = input.nextInt();
		System.out.print("Enter Start Date Day: ");
		int eventStartDay = input.nextInt();
		System.out.print("Enter Start Date Hour: ");
		int eventStartHour = input.nextInt();
		System.out.print("Enter Start Date Minute: ");
		int eventStartMinute = input.nextInt();
		System.out.println("============================");
		
		
		/*EventDate End block */
		System.out.println("*Enter The End Date Of The Event*");
		System.out.println("============================");
		System.out.print("Enter End Date Year: ");
		int eventEndYear = input.nextInt();
		System.out.print("Enter End Date Month: ");
		int eventEndMonth = input.nextInt();
		System.out.print("Enter End Date Day: ");
		int eventEndDay = input.nextInt();
		System.out.print("Enter End Date Hour: ");
		int eventEndHour = input.nextInt();
		System.out.print("Enter End Date Minute: ");
		int eventEndMinute = input.nextInt();
		System.out.println("============================");
		System.out.println("");//Added space to look better
		
		
		
		
		System.out.print("Enter The Capacity Of The Event: ");
		int eventCapacity = input.nextInt();
		System.out.println("===========================================");
		
		Event newEvent = new Event();
		newEvent.setEventName(eventName);
		newEvent.setEventType(eventType);
		newEvent.setLocation(eventLocation);
		newEvent.setTicketPrice(eventPrice);
		newEvent.setDescription(eventDesc);
		newEvent.setCapacity(eventCapacity);
		newEvent.setStartDateTime(eventStartYear,eventStartMonth,eventStartDay,eventStartHour,eventStartMinute);
		newEvent.setEndDateTime(eventEndYear,eventEndMonth,eventEndDay,eventEndHour,eventEndMinute);
		
		// TODO: add event to database
		
		Home.showMenu();
	}

}
