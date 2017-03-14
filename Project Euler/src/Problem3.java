public class Problem3
{
	public static long time1, time2;
	public static double x;
	public static void main(String[] args)
	{
		time1 = System.nanoTime();
		System.out.println(getLargestPrimeFactor(600851475143L));
		time2 = System.nanoTime();
		x = (time2-time1);
		x/=1000000000;
		System.out.println(x);
	}
	
	public static long getLargestPrimeFactor(long l)
	{
		long largestPrime = 1L;
		for(long i=2;i<(long)Math.sqrt(l)+1;i++)
		{
			if(l%i==0 && getPrime(i))
				largestPrime = i;
		}
		return largestPrime;
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
