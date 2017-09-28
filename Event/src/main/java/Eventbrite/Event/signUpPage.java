package Eventbrite.Event;



import java.util.Scanner;

public class signUpPage {
	
	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("============================");
		System.out.print("Enter Your First Name: ");
		String firstName = input.next();
		System.out.print("Enter Your Last Name: ");
		String lastName = input.next();
		System.out.print("Enter Your Email Address: ");
		String email = input.next();
		System.out.print("Enter Your Username: ");
		String username = input.next();
		System.out.print("Enter Your Password: ");
		String password = input.next();
		System.out.println("============================");
		
		
		User newUser = new User(firstName, lastName, username, password, email);
		// TODO: add user to database
		
		Home.showMenu();
	}
	
}
