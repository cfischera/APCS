public class Problem5
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans=1;
		while(!isDivUpToTwenty(ans))
			ans++;
		return ans;
	}
	
	public static boolean isDivUpToTwenty(int n)
	{
		for(int i=1;i<=20;i++)
		{
			if(n%i!=0)
				return false;
		}
		return true;
	}
}
