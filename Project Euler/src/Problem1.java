public class Problem1
{

	public static void main(String[] args)
	{
		System.out.println(getMultiples(1000));
	}
	
	public static int getMultiples(int n)
	{
		int ans = 0;
		for(int i=0;i<n;i++)
		{
			if(i%3==0 || i%5==0)
				ans+=i;
		}
		return ans;
	}
}
