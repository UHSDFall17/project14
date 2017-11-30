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
	
	
	@Test
	public void testSortByLocation()
	{ //swaps values to make test of possible if combinations
		String[] array1 = {"name1","Description1","Type1","Location1"};
		String[] array2 = {"name3","Description3","Type3","Location3"};
		String[] array3 = {"name2","Description2","Type2","Location2"};
		if(array1[3].compareTo(array2[3]) < 0)
		{
			if(array1[3].compareTo(array3[3]) < 0)
			{
				if(array2[3].compareTo(array3[3]) < 0)
				{
					fail(); //fails if array2 is smaller than array3
				}
				else
				{
					assertEquals("Location1",array1[3]);
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
	
	@Test
	public void testSortByType()
	{ //swaps values to make test of possible if combinations
		String[] array1 = {"name2","Description2","Type2","Location2"};
		String[] array2 = {"name3","Description3","Type3","Location3"};
		String[] array3 = {"name1","Description1","Type1","Location1"};
		if(array1[2].compareTo(array2[2]) < 0)
		{
			if(array1[2].compareTo(array3[2]) < 0)
			{
				fail(); //fails if array1 is smaller than array 3
			}
			else
			{
				if(array1[2].compareTo(array3[2]) < 0)
				{
					fail(); //fails if array1 is smaller than array3
				}
				else
				{
					if(array2[2].compareTo(array3[2]) < 0)
					{
						fail(); //fails if array2 is smaller than array3
					}
					else
					{
						assertEquals("Type2",array1[2]);
					}
				}
			}
		}
		else
		{
			fail(); // fails if array2 is smaller than array1
		}
	}
	

}
