public class Problem21
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		for(int i=0;i<10000;i++)
		{
			if(getAmicable(i))
				ans+=i;
		}
		return ans;
	}
	
	public static int getSumOfDivs(int n)
	{
		int divs = 1;
		for(int i=2;i<(int)(Math.sqrt(n))+1;i++)
		{
			if(n%i==0)
				divs+=i+(n/i);
		}
		return divs;
	}
	
	public static boolean getAmicable(int n)
	{
		for(int i=0;i<10000;i++)
		{
			if(getSumOfDivs(n)==i && n!=i)
			{
				if(getSumOfDivs(i)==n)
					return true;;
			}
		}
		return false;
	}
}
