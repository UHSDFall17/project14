package Eventbrite.Event;
import static org.junit.Assert.*;
import org.junit.Test;
public class sortByTest 
{
	@Test
	public void testSortByName()
	{
		String[] array1 = {"name1","Description1","Type1","Location1"};
		String[] array2 = {"name2","Description2","Type2","Location2"};
		String[] array3 = {"name3","Description3","Type3","Location3"};
		if(array1[0].compareTo(array2[0]) < 0)
		{
			if(array1[0].compareTo(array3[0]) < 0)
			{
				if(array2[0].compareTo(array3[0]) < 0)
				{
					assertEquals("name1",array1[0]);
				}
				else
				{
					fail(); //fails if array3 is smaller than array2
				}
			}
			else
			{
				fail(); //fails if array3 is smaller than array1
			}
		}
		else
		{
			fail(); // fails if array2 is smaller than array1
		}
	}
	

}
