package SD.Project.EventBrowser;

import java.util.Scanner;
import java.util.Random;

public class EventBrowser 
{
	public void showMenu()//Changed from main method from test to just a method
	{
		int myChoice;
		Random rand = new Random();
		
		int eventAmountMusic = rand.nextInt(50)+1;
		int eventAmountArt = rand.nextInt(50)+1;
		int eventAmountFood = rand.nextInt(50)+1;
		
		
		//Creating an event can update these arrays
		String[] eventNames = {"Event","EVENT","event"};
		String[] eventDate = {"10/1","10/10","11/12"};
		String[] eventLocation = {"Houston","Texas","Pending..."};
		String[] eventPrice = {"Free","$5","$100"};
	
		
		
		
		//Creating random amount of each Array
		String[][] musicArray = new String[eventAmountMusic][4];
		for(int i=0;i<musicArray.length;i++)
		{
			//for event X there are 4 strings Name,Date,Location,Price
			for(int j=0;j<musicArray[i].length;j++)
			{
				if(j==0)
				{
					musicArray[i][j] = eventNames[rand.nextInt(3)];
				}
				else if(j==1)
				{
					musicArray[i][j] = eventDate[rand.nextInt(3)];
				}
				else if(j==2)
				{
					musicArray[i][j] = eventLocation[rand.nextInt(3)];
				}
				else
				{
					musicArray[i][j] = eventPrice[rand.nextInt(3)];
				}
				
			}

		}
		String[][] artArray = new String[eventAmountArt][4];
		for(int i=0;i<artArray.length;i++)
		{
			//for event X there are 4 strings Name,Date,Location,Price
			for(int j=0;j<artArray[i].length;j++)
			{
				if(j==0)
				{
					artArray[i][j] = eventNames[rand.nextInt(3)];
				}
				else if(j==1)
				{
					artArray[i][j] = eventDate[rand.nextInt(3)];
				}
				else if(j==2)
				{
					artArray[i][j] = eventLocation[rand.nextInt(3)];
				}
				else
				{
					artArray[i][j] = eventPrice[rand.nextInt(3)];
				}
			}
		}
		String[][] foodArray = new String[eventAmountFood][4];
		for(int i=0;i<foodArray.length;i++)
		{
			//for event X there are 4 strings Name,Date,Location,Price
			for(int j=0;j<foodArray[i].length;j++)
			{
				if(j==0)
				{
					foodArray[i][j] = eventNames[rand.nextInt(3)];
				}
				else if(j==1)
				{
					foodArray[i][j] = eventDate[rand.nextInt(3)];
				}
				else if(j==2)
				{
					foodArray[i][j] = eventLocation[rand.nextInt(3)];
				}
				else
				{
					foodArray[i][j] = eventPrice[rand.nextInt(3)];
				}
			}
		}
		
		
		
		
		
		
		
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an event to browse.\n1.Music\n2.Art\n3.Food");
		int Choice = keyboard.nextInt();
		System.out.println(Choice);
		if(Choice == 1)
		{
			//for now 
			System.out.println("You are now viewing the Music Event Tab");
			System.out.println("There are currently "+eventAmountMusic+" events.");
			System.out.println("Enter the event you would like to view");
			myChoice = keyboard.nextInt();
			
			//removed here
		}
			
		else if(Choice == 2)
		{
			System.out.println("You are now viewing the Art Event Tab");
			System.out.println("There are currently "+eventAmountArt+" events.");
			System.out.println("Enter the event you would like to view");
			myChoice = keyboard.nextInt();
			
			//removed here
		}
		else if(Choice == 3)
		{
			System.out.println("You are now viewing the Food Event Tab");
			System.out.println("There are currently "+eventAmountFood+" events.");
			System.out.println("Enter the event you would like to view");
			myChoice = keyboard.nextInt();
			
			//removed here
		}
		keyboard.close();
	}
	
	
}
