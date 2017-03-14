/**
 * This Class demonstrates the utility of the insertion sort
 * as well as the selection sort on a List and primitive array of
 * Integers. It also demonstrates the utility of File Output.
 * @author ColinFischer
 * Date Last Modified: 17 November 2016
 */

import java.util.*;
import java.io.*;

public class InsSelSorts
{
	private List<Integer> listOfInts;
	private Integer[] arrayOfInts;

	/**
	 * This main method creates a Sort object that contains a
	 * List of Integers as well as a primitive array of Integers.
	 * It then prints (and outputs) the two collections before and after
	 * a specified sort method is applied to each.
	 */
	public static void main(String[] args) throws Exception
	{
		InsSelSorts s = new InsSelSorts();
		s.print(s.getList(), s.getArray(), "randomized");
		s.insertionSort(s.getList());
		s.selectionSort(s.getArray());
		s.print(s.getList(), s.getArray(), "sorted");
	}
	
	/**
	 * This constructor creates a Sort Object that includes a
	 * primitive array of Integers as well as a List of Integers,
	 * both containing 100 random values ranging from 0-99.
	 */
	public InsSelSorts()
	{
		listOfInts  = new ArrayList<Integer>();
		for(int i=0;i<100;i++)
			listOfInts.add((int)(Math.random()*100));
		arrayOfInts = new Integer[100];
		for(int i=0;i<arrayOfInts.length;i++)
			arrayOfInts[i] = (int)(Math.random()*100);
	}
	
	/**
	 * This method returns the List of Integers.
	 */
	private List<Integer> getList()
	{
		return listOfInts;
	}
	
	/**
	 * This method returns the primitive array of Integers.
	 */
	private Integer[] getArray()
	{
		return arrayOfInts;
	}
	
	/**
	 * This method takes a List of Integers and sorts it in ascending
	 * order using an insertion sort.
	 */
	public void insertionSort(List<Integer> a)
	{
		for(int i=1;i<a.size();i++)
		{
			for(int j=i;j>0;j--)
			{
				if(a.get(j)<a.get(j-1))
				{
					int t = a.get(j);
					a.set(j, a.get(j-1));
					a.set(j-1, t);
				}
			}
		}
	}
	
	/**
	 * This method takes a Comparable primitive array of Integers
	 * and sorts it in ascending order using a selection sort.
	 */
	public void selectionSort(Comparable<Integer> a[])
	{
		for(int i=0;i<a.length-1;i++)
		{
			Integer min = (Integer)a[i];
			int minInd = i;
			for(int j=i+1;j<a.length;j++)
			{
				if((a[j].compareTo(min))<0)
				{
					min = (Integer)a[j];
					minInd = j;
				}
			}
			int t = (Integer)a[i];
			a[i] = min;
			a[minInd] = t;
		}
	}
	
	/**
	 * This method first outputs a List of Integers and a
	 * primitive array of Integers into a file called "sort.txt."
	 * It then prints the aforementioned data to the console.
	 */
	public void print(List<Integer> a, Comparable<Integer> b[],
			String msg) throws Exception
	{
		boolean append = false;
		if(msg=="sorted")
			append = true;
		FileWriter fw = new FileWriter("sort1.txt", append);
		//
		fw.write("The "+msg+" List is:\n");
		for(int i=0;i<a.size();i++)
		{
			if(i==a.size()-1)
				fw.write(a.get(i));
			else
				fw.write(a.get(i)+", ");
			if(i%10==9)
				fw.write("\n");
		}
		fw.write("\n");
		fw.write("The "+msg+" array is:\n");
		for(int i=0;i<b.length;i++)
		{
			if(i==b.length-1)
				fw.write(""+b[i]);
			else
				fw.write(b[i]+", ");
			if(i%10==9)
				fw.write("\n");
		}	
		fw.write("\n");;
		//
		fw.close();
		System.out.println("The "+msg+" List is:");
		for(int i=0;i<a.size();i++)
		{
			if(i==a.size()-1)
				System.out.print(a.get(i));
			else
				System.out.print(a.get(i)+", ");
			if(i%10==9)
				System.out.println();
		}
		System.out.println();
		System.out.println("The "+msg+" Array is:");
		for(int i=0;i<b.length;i++)
		{
			if(i==b.length-1)
				System.out.print(b[i]);
			else
				System.out.print(b[i]+", ");
			if(i%10==9)
				System.out.println();
		}	
		System.out.println();
	}
}
