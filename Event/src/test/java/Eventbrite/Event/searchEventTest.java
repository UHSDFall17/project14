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
	
	@Test
	public void testElseSearchStatement()
	{
		String searchBy = "IsHere";
		if(searchBy.equalsIgnoreCase("search"))
		{
			fail();
		}
		else if(searchBy.equalsIgnoreCase("IsNotHere"))
		{
			fail();
		}
		else if(searchBy.equalsIgnoreCase("IsHere?"))
		{
			fail();
		}
		else
		{
			assertTrue(searchBy.equalsIgnoreCase("isHERE"));
		}
	}
	
	@Test
	public void testIfElseSearchStatement()
	{
		String searchBy = "IsHere";
		if(searchBy.equalsIgnoreCase("search"))
		{
			fail();
		}
		else if(searchBy.equalsIgnoreCase("IsHere?"))
		{
			fail();
		}
		else if(searchBy.equalsIgnoreCase("IsHere"))
		{
			assertTrue(searchBy.equalsIgnoreCase("isHERE"));
		}
		else
		{
			fail();
		}
	}

}
