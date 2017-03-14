/**
 * This class demonstrates swapping the values of variables
 * in five different manners.
 * @author ColinFischer
 * Date Last Modified: 23 October 2016
 */

import java.util.*;

public class Swap
{	
	private static Any sfv1;
	private static Any sfv2;
	private static Any localParameter1;
	private static Any localParameter2;
	private static ArrayList<Any> localVariables;
	private static int[] integerArray;
	private static List<Integer> integerList;
	
	/**
	 * Constructs the Swap object which contains all the variables
	 * and methods to be swapped.
	 */
	public Swap()
	{
		sfv1 			= new Any(17);
		sfv2 			= new Any("hello world!");
		localParameter1 = new Any(false);
		localParameter2 = new Any('z');
		localVariables  = new ArrayList<Any>();
		integerArray    = new int[2];
		int integer1    = 99;
		int integer2    = 1;
		integerArray[0] = integer1;
		integerArray[1] = integer2;
		integerList     = new ArrayList<Integer>();
		int integer3    = 1881;
		int integer4    = 777777777;
		integerList.add(integer3);
		integerList.add(integer4);
	}
	
	/**
	 * The main method prints out each method as well as
	 * variables before and after being swapped.
	 */
	public static void main(String[] args)
	{
		Swap swapper = new Swap();
		System.out.println("Method: swapStaticFieldVariables");
		System.out.println("Before swap...");
		System.out.println("First Variable is "
				+sfv1+
				" , Second Variable is "
				+sfv2);
		swapper.swapStaticFieldVariables();
		System.out.println("After Swap...");
		System.out.println("First Variable is "
				+sfv1+
				" , Second Variable is "
				+sfv2);
		System.out.println();
		System.out.println("Method: swapLocalParameters");
		System.out.println("Before swap...");
		System.out.println("First Variable is "
				+localParameter1+
				" , Second Variable is "
				+localParameter2);
		swapper.swapLocalParameters(localParameter1,
				localParameter2);
		System.out.println("After swap...");
		System.out.println("First Variable is "
				+localParameter1+
				" , Second Variable is "
				+localParameter2);
		System.out.println();
		
		/*
		 * After many attempts with Reflection including Fields and 
		 * Maps to resolve variable values returned inconclusive,
		 * I resorted to using a static ArrayList for value storage.
		 */
		System.out.println("Method: swapLocalVariables");
		System.out.println("Before swap...");
		swapper.swapLocalVariables(false);
		System.out.println("First variable is "
				+localVariables.get(0)+
				" , Second variable is "
				+localVariables.get(1));
		swapper.swapLocalVariables(true);
		System.out.println("After swap...");
		swapper.swapLocalVariables(true);
		System.out.println("First variable is "
				+localVariables.get(0)+
				" . Second variable is "
				+localVariables.get(1));
		System.out.println();
		System.out.println("Method: swapArray");
		System.out.println("Before swap...");
		System.out.println("First variable is "
				+integerArray[0]+
				" , Second variable is "
				+integerArray[1]);
		System.out.println("After swap ...");
		swapper.swapArray(integerArray,
				integerArray[0],
				integerArray[1]);
		System.out.println("First variable is "
				+integerArray[0]+
				" , Second variable is "
				+integerArray[1]);
		System.out.println();
		System.out.println("Method: swapList");
		System.out.println("Before swap ...");
		System.out.println("First variable is "
				+integerList.get(0)+
				" , Second variable is "
				+integerList.get(1));
		System.out.println("After swap...");
		swapper.swapList(integerList, integerList.get(0),
				integerList.get(1));
		System.out.println("First variable is "
				+integerList.get(0)+
				" , Second variable is "
				+integerList.get(1));
	}
	
	/**
	 * Swaps two static field variables.
	 */
	public void swapStaticFieldVariables()
	{	
		Any t = sfv1;
		sfv1 = sfv2;
		sfv2 = t;
	}
	
	/**
	 * Swaps two local parameters.
	 */
	public void swapLocalParameters(Any p1, Any p2)
	{
		Any t = p1;
		p1 = p2;
		p2 = t;
		localParameter1 = p1;
		localParameter2 = p2;
	}
	
	/**
	 * Swaps two local variables by declaring them
	 * and then calling a private method.
	 */
	public void swapLocalVariables(boolean swap)
	{
		Any localVariable1 = new Any(5.8987);
		Any localVariable2 = new Any(7898.5);
		if (swap == false)
		{
			localVariables.add(localVariable1);
			localVariables.add(localVariable2);
		}
		else if (swap == true)
			this.swapLocalVariables2(localVariable1, localVariable2);
	}
	
	/**
	 * Swaps two local variables passed as parameters.
	 */
	private void swapLocalVariables2(Any lv1, Any lv2)
	{
		Any t;
		t = lv1;
		lv1 = lv2;
		lv2 = t;
		localVariables.set(0, lv1);
		localVariables.set(1, lv2);
	}
	
	/**
	 * Swaps to integers contained in an array.
	 */
	public void swapArray(int a[], int index1, int index2)
	{
		int t;
		t = a[0];
		a[0] = a[1];
		a[1] = t;
	}
	
	/**
	 * Swaps two integers contained in a List.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void swapList (List a, int index1, int index2)
	{
		a.set(0, index2);
		a.set(1, index1);
	}
}