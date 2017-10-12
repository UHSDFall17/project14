package Eventbrite.Event;


import java.util.Scanner;

public class Home {
	
	private static Scanner input;

	public static void main(String args[]) {
		//for testing EventDB	 
		EventDB.getConnection("guest","guest");
		System.out.println(EventDB.getFirstName("green"));
		System.out.println(EventDB.getLastName("green"));
//		EventDB.createUser("test4","tea");
//		EventDB.addUserInfo("green", "guest", "brolic", "tea", "smiffnwessun");
		
		showMenu();	
		EventDB.closeConnection();
	}
	
	public static void showMenu() {
		
		System.out.println("===========================================");
		System.out.println("Select An Option                           ");
		System.out.println("1: Sign Up                                 ");
		System.out.println("2: Log In                                  ");
		System.out.println("3: Browse Events                           ");
		System.out.println("4: Exit Application                        ");
		System.out.println("===========================================");
		
		input = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter The Option Number: ");
		System.out.println();
		int userOption = input.nextInt();
		
		if(userOption >= 1 && userOption <=4) {
			switch(userOption) {
				case(1): {
					//signUpPage newSignUp = new signUpPage();
					signUpPage.showMenu();
					break;
				}
				case(2): {
					//loginPage newLogin = new loginPage();
					loginPage.showMenu();
					break;
				}
				case(3): {
					//EventBrowser new1 = new EventBrowser();
					break;
				}
				case(4): {
					return;
				}
				default:
					// DO NOTHING
			}
			
				
		}
		
	}

}
