/** Use case **/
/* 
 * Your friend is a chief architect, who is working on building a skyscraper, in Mumbai. The 
construction is in such a way that the floors will be constructed in other factories and they will be 
assembled. All the sizes will be distinct.
The skyscraper needs to be constructed in N days with the following conditions:
a) Every day a floor is constructed in a separate factory of distinct size.
b) The floor with the larger size must be placed at the bottom of the building.
c) The floor with the smaller size must be placed at the top of the building.
Note: A floor cannot be assembled in the building until all floors larger in size are placed.
As a friend, he wants you to build a small program that will help him analyze the construction 
process, to avoid manual work and errors. 
*/

package com.greatlearn.skyscraper;

import java.util.*;

public class Skyscraper {
	
	private int numOfFloors;
	private Queue<Integer> inputFloorSize; // Queue to hold input data
	private Queue<Integer> trackFloorSize; // Queue to track floor size
	
	public Skyscraper(int numFloors)
	{
		inputFloorSize = new LinkedList<>();
		trackFloorSize = new LinkedList<>();
		numOfFloors = numFloors;
	}


	public void setInputFloorSize(int floorSize) {
		Integer flrSizeInteger = Integer.valueOf(floorSize);
		this.inputFloorSize.add(flrSizeInteger);
	}

	public int getNumOfFloors() {
		return numOfFloors;
	}

	public void setNumOfFloors(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}

	// Routine to organize floor construction details
	public void organizeFloors()
	{
		int neededSize = numOfFloors;
		
		// Perform for each floor
        for(int i = 0; i < 	numOfFloors; i++)
        {
        	System.out.println("Day: "+(i + 1));
        	System.out.println("");
        	// Check for needed floor size. If it has been provided by factory the print it
        	// if not, push current size to tracking queue for later use.
        	
        	if(inputFloorSize.peek().intValue() ==  neededSize)
        	{
        		System.out.print(inputFloorSize.peek().intValue() + " ");
        		inputFloorSize.remove();
        		neededSize = neededSize - 1;
        		
        		// If tracking queue is not empty then check for current needed size and print
        	    if(!trackFloorSize.isEmpty())
        	    {
        	    	int trackQueueSize = trackFloorSize.size();
        	    	Integer neededSizeInteger = Integer.valueOf(neededSize);
        	    	for(int j = 0; j < trackQueueSize;j++)
        	    	{
        	    		neededSizeInteger = Integer.valueOf(neededSize);
        	    		if(trackFloorSize.contains(neededSizeInteger))
        	        	{
        	    		    System.out.print(neededSize + " ");
        	    		    trackFloorSize.remove(neededSize);
    		                neededSize = neededSize - 1;
        	        	}
        	    	}
        	    	System.out.println("");
        	    }
        	}
        	else
        	{
        		trackFloorSize.add(inputFloorSize.peek());
        		inputFloorSize.remove();
        	}
        }
	}
}
