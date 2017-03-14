
/**
 * This class serves the purpose to analyze Big-Oh ratios.
 * An Analysis object contains an integer array that is constructed,
 * sorted, and searched. The times for each operation are then used
 * to determine O(n).
 * @author ColinFischer
 * Date Last Modified: 8 November 2016
 */

import java.io.*;
import java.util.Scanner;

public class Analysis
{
	private static long tTimeBefore, tTimeAfter;
	private static double ratioTimeSorted1, ratioTimeScrambled1,
							ratioTimeSorted2, ratioTimeScrambled2,
							ratioTimeBubbleSort1, 
							ratioTimeBubbleSort2,
							ratioTimeBinarySearch1,
							ratioTimeBinarySearch2;
	private static double bigOhRatio1, bigOhRatio2;
	private int[] intArray;
	private int target;
	
	/**
	 * This constructor creates an Analysis object - an array with a
	 * passed amount of integers that can either be constructed
	 * sorted or randomized: For analyzing Big-Oh properties.
	 */
	public Analysis(int n, boolean sorted)
	{
		if(sorted)
		{
			intArray = new int[n];
			for(int i=0;i<intArray.length;i++)
			{
				intArray[i] = i;
			}
		}
		else
		{
			intArray = new int[n];
			for(int i=0;i<intArray.length;i++)
			{
				intArray[i] = (int) (Math.random()*n);
			}
		}
	}
	
	/**
	 * This main method calculates all the T(n) values
	 * for computing processes like construction,
	 * sorting, and searching.
	 */
	public static void main(String[] args)
	{
		tTimeBefore = System.nanoTime();
		Analysis analysisTestSorted = new Analysis(10000, true);
		tTimeAfter = System.nanoTime();
		ratioTimeSorted1 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for pre-sorted construction"
					+" of 10,000 elements: "
					+ratioTimeSorted1+" nanoseconds");
		System.out.println();
		tTimeBefore = System.nanoTime();
		Analysis analysisTestSorted2 = new Analysis(10000, true);
		tTimeAfter = System.nanoTime();
		ratioTimeSorted2 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for pre-sorted construction"
				+" of 100,000 elements: "
				+ratioTimeSorted2+" nanoseconds");
		System.out.println();
		tTimeBefore = System.nanoTime();
		Analysis analysisTestScrambled = new Analysis(10000, false);
		tTimeAfter = System.nanoTime();
		ratioTimeScrambled1 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for scrambled construction"
				+" of 10,000 elements: "
				+ratioTimeScrambled1+" nanoseconds");
		System.out.println();
		tTimeBefore = System.nanoTime();
		Analysis analysisTestScrambled2 = 
				new Analysis(100000, false);
		tTimeAfter = System.nanoTime();
		ratioTimeScrambled2 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for scrambled construction"
				+" of 100,000 elements: "
				+ratioTimeScrambled2+" nanoseconds");
		System.out.println();
		tTimeBefore = System.nanoTime();
		analysisTestScrambled.bubbleSort();
		tTimeAfter = System.nanoTime();
		ratioTimeBubbleSort1 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for bubble sort"
				+" of 10,000 elements: "
				+ratioTimeBubbleSort1+" nanoseconds");
		System.out.println();		
		tTimeBefore = System.nanoTime();
		analysisTestScrambled2.bubbleSort();
		tTimeAfter = System.nanoTime();
		ratioTimeBubbleSort2 = (tTimeAfter-tTimeBefore);
		System.out.println("Time elapsed for bubble sort"
				+" of 100,000 elements: "
				+ratioTimeBubbleSort2+" nanoseconds");
		System.out.println();
		bigOhRatio1 = (ratioTimeBubbleSort2/ratioTimeBubbleSort1);
		System.out.println("Big-Oh ratio of sorting 100,000 elements"
			+" to sorting 10,000 elements: "+bigOhRatio1);
		System.out.println();
		analysisTestSorted.getTarget();
		tTimeBefore = System.nanoTime();
		analysisTestSorted.binarySearch();
		tTimeAfter = System.nanoTime();
		ratioTimeBinarySearch1 = (tTimeAfter-tTimeBefore);
		if(analysisTestSorted.binarySearch()==false)
			System.out.println("Target was not found.");
		else
			System.out.println("Target was found.");
		System.out.println();
		System.out.println("Time elapsed for binary search"
				+" of 10,000 elements: "
				+ratioTimeBinarySearch1+" nanoseconds");
		System.out.println();
		analysisTestSorted2.getTarget();
		tTimeBefore = System.nanoTime();
		analysisTestSorted2.binarySearch();
		tTimeAfter = System.nanoTime();
		ratioTimeBinarySearch2 = (tTimeAfter-tTimeBefore);
		if(analysisTestSorted2.binarySearch()==false)
			System.out.println("Target was not found.");
		else
			System.out.println("Target was found.");
		System.out.println();
		System.out.println("Time elapsed for binary search"
				+" of 100,000 elements: "
				+ratioTimeBinarySearch2+" nanoseconds");
		System.out.println();
		bigOhRatio2 =
				(ratioTimeBinarySearch2/ratioTimeBinarySearch1);
		System.out.println("Big-Oh ratio of "
				+"searching 100,000 elements"
				+" to searching 10,000 elements: "+bigOhRatio2);
	}
	
	/**
	 * This method sorts a passed array using the "bubble up" method.
	 */
	public void bubbleSort()
	{
		boolean swapping = true;
		while(swapping)
		{
			swapping = false;
			for(int i=0;i<intArray.length-1;i++)
			{
				if(intArray[i]>intArray[i+1])
				{
					int t = intArray[i];
					intArray[i] = intArray[i+1];
					intArray[i+1] = t;
					swapping = true;
				}
			}
		}
	}
	
	/**
	 * This method reads a file called "data.txt" to find
	 * an integer to search for in an array.
	 */
	private void getTarget()
	{
		try
		{
			Scanner targetFile = new Scanner(new File("data.txt"));
			target = targetFile.nextInt();
			targetFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("data.txt file not found.");
		}
	}
	
	/**
	 * This method searches the array for the target integer using a
	 * binary search.
	 */
	public boolean binarySearch()
	{
		int currentIndex;
		int frontIndex = 0;
		int endIndex = (intArray.length-1);
		while(frontIndex<endIndex)
		{
			if(intArray[frontIndex]==target)
				return true;
			if(intArray[endIndex]==target)
				return true;
			currentIndex = ((frontIndex+endIndex)/2);
			if(intArray[currentIndex]==target)
				return true;
			else if(intArray[currentIndex]<target)
				frontIndex = (currentIndex+1);
			else if(intArray[currentIndex]>target)
				endIndex = (currentIndex-1);
		}
		return false;
	}
	
	/*
	For the constructor method :
	
		What "n" did you choose for the problem and what is O(n)?
			n = 10,000, O(n) = n for random
			n = 10,000, O(n) = n for pre-sorted
		
		What was the time the constructor took to run?
			t1 = 3263990 nanoseconds for random
			t1 = 297676 nanoseconds for pre-sorted
		
		Run the simulation again using using 10 times the number 
		of elements in question 1
		
		What was the time the constructor took to run?
			t2 = 9240945 nanoseconds for random
			t2 = 1830462 nanoseconds for pre-sorted
		
		For the sort method :
		
		What "n" did you choose for the problem and what is O(n)?
			n = 10,000, O(n) = n^2
		
		What was the time the sort took to run?
			t1 = 217674603 nanoseconds
		
		Run the simulation again using 10 times the number 
		of elements in question 1
		
		What was the time the sort took to run?
			t2 = 21808143986 nanoseconds
		
		What is t2 / t1 and how does it relate to O(n)
		from question (i)?
			t2/t1 = 100: the second array is 10 times larger, but the 
			bubble sort method takes 100 times longer to execute...
			This proves the O(n^2) for the bubble sort method.
		
		For search method:
		
		What "n" did you choose for the problem and what is O(n)?
			n = 10,000, O(n) = log(n)
		
		What was the time the search took to run?
			t1 = 5772 nanoseconds
		
		Run the simulation again using using 10 times the number 
		of elements in question 1
		
		What was the time the search took to run?
			t2 = 3610 nanoseconds
		
		What is t2 / t1 and how does it relate to O(n)
		from question (i)?
			t2/t1 = 0.625: The longer the array, the shorter
			time it takes to execute the search.
		
		Based upon the above answers, did the time correspond 
		with the "Big-Oh" calculations for each of the three methods?
			constructor? yes, sorting? yes, searching? no
		
		Clarify any discrepancies between O(n) theory and what you
		found in practice:
			In the constructors, the randomized arrays had a larger
			T(n) since a method call of the Math.random() method was
			necessary. This subtlety did not make a significant
			difference in time and therefore didn't change the O(n).
			Also, the times for binary search that I collected did
			not align with that of the O(n) theory. The T(n) for my
			longer array was less than the T(n) of the shorter array.
			The O(n) theory predicted a larger T(n) for the longer
			array, where O(n) = log(n).
	*/
}