import java.util.*;

public class Problem23
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=1;i<=28123;i++)
		{
			if(getAbundant(i))
				a.add(i);
		}
		for(int i=0;i<a.size();i++)
			System.out.println(a.get(i));
		System.out.println("Size: "+a.size());
		//System.out.println(getAnswer());
	}
	
	public static long getAnswer()
	{
		long ans = 276;
		for(int i=24;i<=28123;i++)
		{
			if(nonAbundant(i))
				ans+=i;
		}
		return ans;
	}
	
	//TODO
	public static boolean nonAbundant(int n)
	{
		int[] a = new int[6971];
		// for(int i=1;i<28123;i++)
			return false;
	}
	
	public static boolean getAbundant(int n)
	{
		if(getSumOfDivs(n)>n)
			return true;
		return false;
	}
	
	public static int getSumOfDivs(int n)
	{
		int divs = 1;
		if(n%2==0)
			divs+=2+(n/2);
		for(int i=3;i<(int)(Math.sqrt(n))+1;i++)
		{
			if(n%i==0 && i!=(n/2))
				divs+=i+(n/i);
		}
		return divs;
	}
}
