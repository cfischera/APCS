public class Problem12
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static long getAnswer()
	{
		long ans = 62370000;
		while(!(hasOverFiveHundredDivs(ans) && getTriNum(ans)))
		{
			ans+=100;
		}
		return ans;
	}
	
	public static boolean getTriNum(long l)
	{
		long counter = 0;
		long tri = 0;
		while(tri<l)
		{
			counter++;
			tri+=counter;
		}
		return (l==tri);
	}
	
	public static boolean hasOverFiveHundredDivs(long l)
	{
		return ((getDivs(l))>500);
	}
	
	public static int getDivs(long l)
	{
		int divs = 2;
		for(long i=2;i*i<l;i++)
		{
			if(l%i==0)
				divs+=2;
		}
		return divs;
	}
}
