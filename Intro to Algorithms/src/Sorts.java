/**
 * This Class demonstrates two O(nlogn) sorting algorithms.
 * The QuickSort and the MergeSort
 * @author ColinFischer
 * Date Last Modified: 2 December 2016
 */

import java.util.*;

public class Sorts
{
	private int[] arrayInts;
	private List<Comparable> listInts;
	
	/**
	 * The main method creates a Sorts object that has an array and
	 * an ArrayList of 100 random numbers 0-99. It prints the values,
	 * calls a QuickSort on the array, MergeSort on the List,
	 * and prints the values again.
	 */
	public static void main(String[] args)
	{
		Sorts s = new Sorts();
		s.print(s.arrayInts, s.listInts, "original");
		s.quickSort(s.arrayInts);
		s.mergeSort(s.listInts); // Dysfunctional
		s.print(s.arrayInts, s.listInts, "sorted");
	}
	
	/**
	 * This constructor creates an array and ArrayList, both of
	 * 100 random numbers ranging between 0-99.
	 */
	public Sorts()
	{
		arrayInts = new int[100];
		for(int i=0;i<arrayInts.length;i++)
			arrayInts[i] = (int) (Math.random()*100);
		listInts  = new ArrayList<Comparable>();
		for(int i=0;i<100;i++)
			listInts.add((int) (Math.random()*100));
	}
	
	/**
	 * This method takes in an array and calls helper methods to
	 * complete the sorting in a QuickSort fashion.
	 */
	public void quickSort(int[] a)
	{
		qSort(a, 0, (a.length-1));
	}
	
	/**
	 * This method recursively splits a passed array until each value is
	 * at the correct index.
	 */
	private void qSort(int[]a, int start, int end)
	{
		int sorted;
		if(start<end)
		{
			sorted = qSplit(a, start, end);
			qSort(a, start, sorted-1);
			qSort(a, sorted+1, end);
		}
	}
	
	/**
	 * This method splits an array with a pivot value, those lesser at
	 * lower indices and those greater at higher indices.
	 */
	private int qSplit(int[] a, int start, int end)
	{
		int pivot = a[end];
		int li = start;
		int counter = li;
		while(counter<end)
		{
			if(a[counter]<=pivot)
			{
				int t = a[counter];
				a[counter] = a[li];
				a[li] = t;
				li++;
			}
			counter++;
		}
		int t = a[li];
		a[li] = a[end];
		a[end] = t;
		return li;
	}
	
	/**
	 * This method takes in an ArrayList and calls helper methods to
	 * complete the sorting in a MergeSort fashion.
	 */
	public void mergeSort(List<Comparable> l)
	{
		mSort(l, 0, l.size()-1);
	}
	
	/**
	 * This method recursively splits an ArrayList so that it can
	 * be merged back together in order.
	 */
	private List<Comparable> mSort(
			List<Comparable> l, int start, int end)
	{	
		if(start<end)
		{
			List<Comparable> l1 = mSort(l, 0, (end)/2);
			List<Comparable> l2 = mSort(l, (end/2)+1, end-1);
			merge(l, l1, l2);
		}
		return l;
	}
	
	
	/**
	 * This method merges two sorted Lists by checking the lowest
	 * index of each and adding the lesser value to a third List.
	 */
	private void merge(
			List<Comparable> l, List<Comparable> l1, List<Comparable> l2)
	{
		List<Comparable> a = new ArrayList<Comparable>();
		int size = l1.size()+l2.size();
		int counter1=0, counter2=0;
		for(int i=0;i<size;i++)
		{
			if(counter1<l1.size()&&counter2<l2.size())
			{
				if(l1.get(counter1).compareTo(l2.get(counter2))<0)
				{
					a.add(l1.get(counter1));
					counter1++;
				}
				else
				{
					a.add(l2.get(counter2));
					counter2++;
				}
			}
			else if(counter1>=l1.size())
			{
				a.add(l2.get(counter2));
				counter2++;
			}
			else
			{
				a.add(l1.get(counter1));
				counter1++;
			}
		}
		for(int i=0;i<a.size();i++)
			System.out.print(a.get(i)+" ");
		System.out.println();
	}
	
	/**
	 * This method prints out the contents of an array 
	 * and an ArrayList, 10 values per line.
	 */
	public void print(int[] a, List<Comparable> b,
			String msg)
	{
		System.out.println("The "+msg+" Array is:");
		for(int i=0;i<a.length;i++)
		{
			if(i==a.length-1)
				System.out.print(a[i]);
			else
				System.out.print(a[i]+", ");
			if(i%10==9)
				System.out.println();
		}
		System.out.println();
		System.out.println("The "+msg+" List is:");
		for(int i=0;i<b.size();i++)
		{
			if(i==b.size()-1)
				System.out.print(b.get(i));
			else
				System.out.print(b.get(i)+", ");
			if(i%10==9)
				System.out.println();
		}	
		System.out.println();
	}
}