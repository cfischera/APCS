import java.util.*;

public class Test2DArrays
{

	public static void main(String[] args)
	{
		countArraySlots();
		countArrayListSlots();
		
	}
	
	public static void countArraySlots()
	{
		int[] a1 = new int[10];
		int x = 10;
		int[][] a2 = new int[x-5][x];
		for(int i=0;i<a1.length;i++)
		{
			a1[i] = i;
			System.out.println(a1[i]);
		}
		System.out.println();
		int k = 0;
		for(int i=0;i<a2.length;i++)
		{
			for(int j=0;j<a2[i].length;j++)
			{
				a2[i][j] = k;
				System.out.println(a2[i][j]);
				k++;
			}
		}
		System.out.println("Two-Dimensional Array has "+k+" slots");
	}
	
	public static void countArrayListSlots()
	{
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> a2 = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<10;i++)
		{
			a1.add(i);
			System.out.println(a1.get(i));
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<i+1;j++)
			{
				a2.add(new ArrayList<Integer>(i+j));
			}
		}
	}
}
