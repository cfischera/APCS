/**
 * Summary
 * @author ColinFischer
 * Date Last Modified: 10 November 2016
 */

import java.util.*;
import java.io.*;

public class Divisibility
{
	private int[] fourNums;
	
	/**
	 * 
	 */
	public Divisibility()
	{
		fourNums = new int[4];
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Divisibility d = new Divisibility();
		d.readInts();
		System.out.println(d.greatestCommonFactor(d.fourNums[0], d.fourNums[1]));
		
		System.out.println(d.leastCommonMultiple(d.fourNums[2], d.fourNums[3]));
	}
	
	/**
	 * Summary
	 */
	public void readInts() throws FileNotFoundException
	{
		Scanner intFinder = new Scanner(new File("fourNums.txt"));
		for(int i=0;i<4;i++)
			fourNums[i] = intFinder.nextInt();
		intFinder.close();
	}
	
	/**
	 * 
	 */
	public int greatestCommonFactor(int n1, int n2)
	{
		int tn1 = n1;
		int tn2 = n2;
		if(tn2>tn1)
		{
			int t = tn1;
			tn1 = tn2;
			tn2 = t;
		}
		while(tn1%tn2!=0)
		{
			int t = tn2;
			tn2 = tn1%tn2;
			tn1 = t;
		}
		return tn2;
	}
	
	/**
	 * 
	 */
	public long leastCommonMultiple(int n1, int n2)
	{
		long tn1 = n1;
		long tn2 = n2;
		long counter1 = 1;
		long counter2 = 1;
		while(tn1!=tn2)
		{
			if(tn1>tn2)
			{
				tn2 = n2*counter2;
				counter2++;
			}
			else
			{
				tn1 = n1*counter1;
				counter1++;
			}
		}
		return tn1;
	}
}	
