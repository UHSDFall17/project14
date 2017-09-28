package Eventbrite.Event;


import java.util.Scanner;

import java.util.Scanner;

public class loginPage {
	
	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("===================================");
		System.out.print("Enter Your Username: ");
		String username = input.next();
		System.out.print("Enter Your Password: ");
		String password = input.next();
		System.out.println("===================================");
		
		
		Home.showMenu();
	}

}

