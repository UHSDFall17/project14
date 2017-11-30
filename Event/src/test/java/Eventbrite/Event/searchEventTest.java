package Eventbrite.Event;
import static org.junit.Assert.*;
import org.junit.Test;
public class searchEventTest 
{
	@Test
	public void testSearch()
	{
		String searchBy = "SEARCH";
		if(searchBy.equalsIgnoreCase("search"))
		{
			assertTrue(searchBy.equalsIgnoreCase("SeArCH"));
		}
		else
		{
			fail();
		}
	}
	
	

}
