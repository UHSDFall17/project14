package Eventbrite.Event;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

public class HomeTest 
{

	@Test
	public void testOptionInRange() 
	{
		int userOption = 1;
	
		if(userOption >= 1 && userOption <=5) 
		{
						//Expected,actual
			assertEquals(1, userOption);
			//for 2
			userOption = userOption + 1;
			assertEquals(2, userOption);
			//for 3
			userOption = userOption + 1;
			assertEquals(3, userOption);
			//for 4
			userOption = userOption + 1;
			assertEquals(4, userOption);
			//for 5
			userOption = userOption + 1;
			assertEquals(5, userOption);
		}
		else
		{
			fail();
		}
	}
	
	
	@Test
	public void testOptionNegativeOutRange() 
	{
		int userOption = -1;
		assertFalse(userOption>=1 && userOption <= 5); //fails if in range 1-5
		assertFalse(userOption > 5); // fails if >5 
		assertTrue(userOption <= 0); // passes if < 0
		
	}
	
	
	

	
	
	

}
