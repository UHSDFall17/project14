package Eventbrite.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Home {
	
	private static Scanner input;

	public static void main(String args[]) {
		//for testing EventDB	
		try {
		EventDB.getConnection("guest","guest");
		
//		Event event = new Event();
//		event.setStartDateTime(2018, 03, 21, 23, 59);
//		event.setEndDateTime(2018, 3, 22, 0, 0);
//		EventDB.createEvent("Event10", "Toyota Center", event.getStartDateTime(), "Music", event.getEndDateTime(),
//				69.69, 1000, "test7", 1000, "a descriptive description");
		ArrayList<Event> events = EventDB.getValidEvents("music");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Event e : events) {
			System.out.println(e.getEventID());
//			System.out.println(e.getEventName());
			System.out.println(e.getEventType());
//			System.out.println(e.getDescription());
//			System.out.println(e.getCapacity());
//			System.out.println(e.getHostName());
//			System.out.println(e.getLocation());
			System.out.println(sdf.format(e.getStartDateTime().getTime()));
//			System.out.println(e.getTicketPrice());
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		showMenu();	
		EventDB.closeConnection();
	}
	
	public static void showMenu() {
		
		System.out.println("===========================================");
		System.out.println("Select An Option                           ");
		System.out.println("1: Sign Up                                 ");
		System.out.println("2: Log In                                  ");
		System.out.println("3: Search Events                           ");
		System.out.println("4: Create an Event                         ");
		System.out.println("5: Exit Application                        ");
		System.out.println("===========================================");
		
		input = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter The Option Number: ");
		System.out.println();
		int userOption = input.nextInt();
		
		if(userOption >= 1 && userOption <=5) {
			switch(userOption) {
				case(1): {
					signUpPage.showMenu();
					break;
				}
				case(2): {
					loginPage.showMenu();
					break;
				}
				case(3): {
					searchEvent.showMenu();
					break;
				}
				case(4): {
					createEvent.showMenu();
					break;
				}
				case(5): {
					return;
				}
				default:
					// DO NOTHING
			}
			
				
		}
		
	}
	
public static void showMenu(String uName, String pWord) {
		
		System.out.println("===========================================");
		System.out.println("Select An Option                           ");
		System.out.println("1: Browse Events                           ");
		System.out.println("2: Log Out                                 ");
		System.out.println("3: Search Events                           ");
		System.out.println("4: Create an Event                         ");
		System.out.println("5: Exit Application                        ");
		System.out.println("===========================================");
		
		input = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter The Option Number: ");
		System.out.println();
		int userOption = input.nextInt();
		
		if(userOption >= 1 && userOption <= 5) {
			switch(userOption) {
				case(1): {
					EventBrowser.showMenu(uName, pWord);
					break;
				}
				case(2): {
					LogOutPage.logout();
					break;
				}
				case(3): {
					searchEvent.showMenu();
					break;
				}
				case(4): {
					createEvent.showMenu();
					break;
				}
				case(5): {
					return;
				}
				default:
					// DO NOTHING
			}
			
				
		}
		
	}

}
