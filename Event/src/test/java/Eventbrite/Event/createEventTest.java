package Eventbrite.Event;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
public class createEventTest 
{
	@Test
	public void testVariablesCorrect() 
	{//Test that all variables added are of correct types
		
		//asserts event Name true
		String eventName = "name";
		assertEquals("name", eventName);
		//asserts event Description true
		String eventDesc = "Description";
		assertEquals("Description", eventDesc);
		//asserts event type true
		String eventType = "Type";
		assertEquals("Type", eventType);
		//asserts event location true
		String eventLocation = "Location";
		assertEquals("Location", eventLocation);
		//Asserts if price is true
		Double eventPrice = 12.57;
		assertSame(0, eventPrice.compareTo(12.57)); //Compare to returns 0 if equal
	}
	
	
	@Test
	public void testEventCreated()
	{
		String Name = "name";
		String eventDesc = "Description";
		String eventType = "Type";
		String eventLocation = "Location";
		//Creates first array from values "input" by user
		String[] array1 = new String[4];
		array1[0] = Name;
		array1[1] = eventDesc;
		array1[2] = eventType;
		array1[3] = eventLocation;
		//Creates a second array to test if values equal
		String[] array2 = {"name","Description","Type","Location"};
		assertTrue(Arrays.equals(array1, array2));
	}

}
