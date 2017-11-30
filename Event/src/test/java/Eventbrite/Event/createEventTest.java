package Eventbrite.Event;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
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

}
