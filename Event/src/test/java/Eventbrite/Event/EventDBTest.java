package Eventbrite.Event;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EventDBTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void initialize() {
	EventDB.getConnection("guest","guest");
	}
	
	@AfterClass
	public static void endTest() {
		EventDB.closeConnection();
	}
	
//	@Test
//	public void testGetConnection() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testGetConnectionStringString() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testCloseConnection() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testCreateUser() throws SQLException {
		thrown.expect(Exception.class);
		EventDB.createUser("guest", "guest");
	}

	@Test
	public void testAddUserInfo() throws SQLException {
		thrown.expect(Exception.class);
		EventDB.addUserInfo("junit4", "bob", "saget", "junit4", "fdklkafk@gmail.com");
	}

	@Test
	public void testDeleteUser() throws SQLException{
		EventDB.deleteUser("4327494798327483749832749832478932479328479328473928479328");
	}
//
	@Test
	public void testGetFirstName() throws SQLException{
		EventDB.getFirstName("hellohellohellohello");
	}
//
	@Test
	public void testGetLastName() throws SQLException{
		EventDB.getLastName("fdsafddlkrdsaf");
	}

}
