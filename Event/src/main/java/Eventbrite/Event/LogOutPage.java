package Eventbrite.Event;

public class LogOutPage {
	public static void logout() {
		EventDB.closeConnection();
		Home.showMenu();
	}
	
}
