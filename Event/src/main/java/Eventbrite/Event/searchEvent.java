package Eventbrite.Event;

import java.util.Random;
import java.util.Scanner;

public class searchEvent
{
	public static void showMenu() 
	{
		String[] eventNames = {"EventA","EventB","EventC"};
		String[] eventType = {"Music", "Food", "Networking","Social"};
		String[] eventDate = {"10/1","10/10","11/12"};
		String[] eventLocation = {"Houston","Texas","Earth"};
		String[] eventPrice = {"0.00","10.00","100.00"};
		
		Random rand = new Random();
		
		
		
		/*
		 * Creates an array of events created randomly from the above array
		 */
		
		String Events[][] = new String[10][5];
		for(int i=0;i<Events.length;i++)
		{
			for(int j=0;j<Events[i].length;j++)
			{
				if(j==0)
				{
					Events[i][j] = eventNames[rand.nextInt(3)];
				}
				else if(j==1)
				{
					Events[i][j] = eventType[rand.nextInt(4)];
				}
				else if(j==2)
				{
					Events[i][j] = eventDate[rand.nextInt(3)];
				}
				else if(j==3)
				{
					Events[i][j] = eventLocation[rand.nextInt(3)];
				}
				else
				{
					Events[i][j] = eventPrice[rand.nextInt(3)];
				}
				
			}
		}	
		
		
		/*
		 * Displays the created array
		 */
		for(int i=0;i<Events.length;i++)
		{
			for(int j=0;j<Events[i].length;j++)
			{
				System.out.print(Events[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("===========================================");
		System.out.println("Search by: Name,Type,Location,Price,Date");
		System.out.println("===========================================");
		Scanner input = new Scanner(System.in);
		String searchBy = input.nextLine();
		if(searchBy.equalsIgnoreCase("Name"))
		{
			System.out.println("You are sorting by name.");
			
			
			
			String tempEvents[] = new String[10];
			String tempEvents2[] = new String[10];
			String tempEvents3[] = new String[10];
			String tempEvents4[] = new String[10];
			String tempEvents5[] = new String[10];
			
			
			for(int i =0;i<tempEvents.length;i++)
			{
				tempEvents[i] = Events[i][0];
				tempEvents2[i] = Events[i][1];
				tempEvents3[i] = Events[i][2];
				tempEvents4[i] = Events[i][3];
				tempEvents5[i] = Events[i][4];
			}
			comparisonSort(tempEvents,tempEvents2,tempEvents3,tempEvents4,tempEvents5);
		
			System.out.println();
			
			for(int i=1;i<Events.length;i++)
			{
				for(int j=1;j<Events[i].length;j++)
				{
					if(j==1)
					{
						Events[i][j] = tempEvents2[i];
					}
					else if(j==2)
					{
						Events[i][j] = tempEvents3[i];
					}
					else if(j==3)
					{
						Events[i][j] = tempEvents4[i];
					}
					else
					{
						Events[i][j] = tempEvents5[i];
					}
				}
				
			}
			for(int i=0;i<tempEvents.length;i++)
			{
				Events[i][0] = tempEvents[i];
			}
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=0;j<Events[i].length;j++)
				{
					System.out.print(Events[i][j]+" ");
				}
				System.out.println();
			}
			/*
			 * Waits for 5 seconds for viewing of the new search that was sorted
			 */
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		else if(searchBy.equalsIgnoreCase("Type"))
		{
			System.out.println("You are sorting by type.");
			String tempEvents[] = new String[10];
			String tempEvents2[] = new String[10];
			String tempEvents3[] = new String[10];
			String tempEvents4[] = new String[10];
			String tempEvents5[] = new String[10];
			
			
			for(int i =0;i<tempEvents.length;i++)
			{
				tempEvents[i] = Events[i][0];
				tempEvents2[i] = Events[i][1];
				tempEvents3[i] = Events[i][2];
				tempEvents4[i] = Events[i][3];
				tempEvents5[i] = Events[i][4];
			}
			comparisonSort(tempEvents2,tempEvents,tempEvents3,tempEvents4,tempEvents5);
			System.out.println();
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=1;j<Events[i].length;j++)
				{
					if(j==1)
					{
						Events[i][j] = tempEvents2[i];
					}
					else if(j==2)
					{
						Events[i][j] = tempEvents3[i];
					}
					else if(j==3)
					{
						Events[i][j] = tempEvents4[i];
					}
					else
					{
						Events[i][j] = tempEvents5[i];
					}
				}
				
			}
			for(int i=0;i<tempEvents.length;i++)
			{
				Events[i][0] = tempEvents[i];
			}
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=0;j<Events[i].length;j++)
				{
					System.out.print(Events[i][j]+" ");
				}
				System.out.println();
			}
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
		
			
		}
		else if(searchBy.equalsIgnoreCase("Location"))
		{
			System.out.println("You are sorting by location.");
			String tempEvents[] = new String[10];
			String tempEvents2[] = new String[10];
			String tempEvents3[] = new String[10];
			String tempEvents4[] = new String[10];
			String tempEvents5[] = new String[10];
			
			
			for(int i =0;i<tempEvents.length;i++)
			{
				tempEvents[i] = Events[i][0];
				tempEvents2[i] = Events[i][1];
				tempEvents3[i] = Events[i][2];
				tempEvents4[i] = Events[i][3];
				tempEvents5[i] = Events[i][4];
			}
			comparisonSort(tempEvents4,tempEvents2,tempEvents3,tempEvents,tempEvents5);
		
			System.out.println();
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=1;j<Events[i].length;j++)
				{
					if(j==1)
					{
						Events[i][j] = tempEvents2[i];
					}
					else if(j==2)
					{
						Events[i][j] = tempEvents3[i];
					}
					else if(j==3)
					{
						Events[i][j] = tempEvents4[i];
					}
					else
					{
						Events[i][j] = tempEvents5[i];
					}
				}
				
			}
			for(int i=0;i<tempEvents.length;i++)
			{
				Events[i][0] = tempEvents[i];
			}
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=0;j<Events[i].length;j++)
				{
					System.out.print(Events[i][j]+" ");
				}
				System.out.println();
			}
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
		else if(searchBy.equalsIgnoreCase("Date"))
		{
			System.out.println("You are sorting by date.");
			String tempEvents[] = new String[10];
			String tempEvents2[] = new String[10];
			String tempEvents3[] = new String[10];
			String tempEvents4[] = new String[10];
			String tempEvents5[] = new String[10];
			
			
			for(int i =0;i<tempEvents.length;i++)
			{
				tempEvents[i] = Events[i][0];
				tempEvents2[i] = Events[i][1];
				tempEvents3[i] = Events[i][2];
				tempEvents4[i] = Events[i][3];
				tempEvents5[i] = Events[i][4];
			}
			comparisonSort(tempEvents3,tempEvents2,tempEvents,tempEvents4,tempEvents5);
			
			System.out.println();
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=1;j<Events[i].length;j++)
				{
					if(j==1)
					{
						Events[i][j] = tempEvents2[i];
					}
					else if(j==2)
					{
						Events[i][j] = tempEvents3[i];
					}
					else if(j==3)
					{
						Events[i][j] = tempEvents4[i];
					}
					else
					{
						Events[i][j] = tempEvents5[i];
					}
				}
				
			}
			for(int i=0;i<tempEvents.length;i++)
			{
				Events[i][0] = tempEvents[i];
			}
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=0;j<Events[i].length;j++)
				{
					System.out.print(Events[i][j]+" ");
				}
				System.out.println();
			}
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
		else if(searchBy.equalsIgnoreCase("price"))
		{
			System.out.println("You are sorting by price.");
			String tempEvents[] = new String[10];
			String tempEvents2[] = new String[10];
			String tempEvents3[] = new String[10];
			String tempEvents4[] = new String[10];
			String tempEvents5[] = new String[10];
			
			
			for(int i =0;i<tempEvents.length;i++)
			{
				tempEvents[i] = Events[i][0];
				tempEvents2[i] = Events[i][1];
				tempEvents3[i] = Events[i][2];
				tempEvents4[i] = Events[i][3];
				tempEvents5[i] = Events[i][4];
			}
			comparisonSort(tempEvents5,tempEvents2,tempEvents3,tempEvents4,tempEvents);
			System.out.println();
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=1;j<Events[i].length;j++)
				{
					if(j==1)
					{
						Events[i][j] = tempEvents2[i];
					}
					else if(j==2)
					{
						Events[i][j] = tempEvents3[i];
					}
					else if(j==3)
					{
						Events[i][j] = tempEvents4[i];
					}
					else
					{
						Events[i][j] = tempEvents5[i];
					}
				}
				
			}
			for(int i=0;i<tempEvents.length;i++)
			{
				Events[i][0] = tempEvents[i];
			}
			
			for(int i=0;i<Events.length;i++)
			{
				for(int j=0;j<Events[i].length;j++)
				{
					System.out.print(Events[i][j]+" ");
				}
				System.out.println();
			}
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Sorry invaild option");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Home.showMenu();
		
		
		
	}
	
	
	
	
	
	
	
	/*
	 * Temp sorting array I made from my homework
	 * needs better sorting alg for larger values
	 */
	public static String[] comparisonSort(String[] inputArray, String[] tempEvents2, String[] tempEvents3, String[] tempEvents4, String[] tempEvents5)
	{
		String tempI;
		String tempJ;
		int keepGoing = 0;
		while(keepGoing <= inputArray.length-2) //n-2 comparison loops to fully sort this array in worst case
		{
		for(int i=0;i<=inputArray.length-2;i++)
		{
			tempI = inputArray[i]; //Two values for reordering the array
			tempJ = inputArray[i+1];
			if(tempI.compareTo(tempJ) > 0) // returns value > 0 means I > J
			{ // if lower index is > bigger index switches the two
				inputArray[i] = tempJ;
				inputArray[i+1] = tempI;
				
				
				
				/*
				 * bad switching of events
				 */
				String tempEvent2 = tempEvents2[i];
				tempEvents2[i] = tempEvents2[i+1];
				tempEvents2[i+1] = tempEvent2;
				//3
				String tempEvent3 = tempEvents3[i];
				tempEvents3[i] = tempEvents3[i+1];
				tempEvents3[i+1] = tempEvent3;
				//4
				String tempEvent4 = tempEvents4[i];
				tempEvents4[i] = tempEvents4[i+1];
				tempEvents4[i+1] = tempEvent4;
				//5
				String tempEvent5 = tempEvents5[i];
				tempEvents5[i] = tempEvents5[i+1];
				tempEvents5[i+1] = tempEvent5;
			}
			
		}
		keepGoing++; //how many times to loop has gone on
		}
		
		
		return inputArray;
	}
	

}
