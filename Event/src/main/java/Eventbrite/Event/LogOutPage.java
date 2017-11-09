package Eventbrite.Event;

public class LogOutPage {
	public static void maon(String[] args) {
		EventDB.closeConnection();
		Home.showMenu();
	}
	
}
