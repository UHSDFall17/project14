package Eventbrite;

import java.util.Scanner;

public class signUpPage {
	
	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("============================");
		System.out.print("Enter Your Username: ");
		String username = input.next();
		System.out.println();
		System.out.print("Enter Your Password: ");
		String password = input.next();
		System.out.println();
		System.out.println("Cancel (Return to Main Menu)");
		System.out.println("============================");
	}
	
}