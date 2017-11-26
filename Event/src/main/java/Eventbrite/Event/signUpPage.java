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
		
		
		User newUser = new User(firstName, lastName, username, password, email, false, false);
		// TODO: add user to database
		try {
			EventDB.createUser(newUser.getUsername(), newUser.getPassword());
			EventDB.addUserInfo(newUser.getUsername(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword(), newUser.getEmail());
		}
		catch(Exception e) {
			System.out.println("EXCEPTION: " + e.getMessage());
			Home.showMenu();
		}
		
		Home.showMenu(username, password);
	}
	
}
