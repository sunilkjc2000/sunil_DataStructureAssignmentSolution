package com.greatlearn.driver;

import java.util.Scanner;
import com.greatlearn.skyscraper.*;

// Driver class
public class driver {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building\r\n");
		
		int numFloors = scan.nextInt();
		Skyscraper skyScrap = new Skyscraper(numFloors);
		
		for(int i = 0; i < numFloors;i++)
		{
			System.out.println("enter the floor size given on day : "+(i+1));
			skyScrap.setInputFloorSize(scan.nextInt());
		}
		
		// Organize floor and print
		skyScrap.organizeFloors();
		
		return;
	}

}