public class Problem2
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer(4000000));
	}
	
	public static long getAnswer(int lim)
	{
		long ans = 0;
		int i = 0;
		while(fibonacciSequence(i)<=lim)
		{
			if(fibonacciSequence(i)%2==0)
				ans+=fibonacciSequence(i);
			i++;
		}
		return ans;
	}
	
	public static int fibonacciSequence(int n)
	{
		if(n<=1)
			return n;
		return fibonacciSequence(n-1)+fibonacciSequence(n-2);
	}
}
