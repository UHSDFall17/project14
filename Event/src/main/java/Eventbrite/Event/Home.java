package Eventbrite.Event;


import java.util.Scanner;

public class Home {
	
	private static Scanner input;

	public static void main(String args[]) {
		//for testing EventDB	
		try {
		EventDB.getConnection("guest","guest");
//		EventDB.createUser("test6", "test6");
//		EventDB.addUserInfo("root", "bobbito", "bobberito", "root", "abcd@abcedef.com");
//		System.out.println(EventDB.getFirstName("test6"));
//		System.out.println(EventDB.getCurrentUser());
//		EventDB.deleteUser("test3");
//		EventDB.deleteUserInfo("junit4");
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
