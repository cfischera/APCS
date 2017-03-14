public class Problem10
{
	
	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static long getAnswer()
	{
		long ans = 0;
		for(int i=0;i<2000000;i++)
		{
			if(getPrime(i))
				ans+= i;
		}
		return ans;
	}
	
	public static boolean getPrime(long l)
	{
		for(long i=2;i<(long)Math.sqrt(l)+1;i++)
		{
			if(l%i==0)
				return false;
		}
		return true;
	}
}
