public class Problem7
{
	
	public static void main(String[] args)
	{
		System.out.println(getPrimethDigit(10001));
	}
	
	public static long getPrimethDigit(int p)
	{
		long[] primes = new long[p];
		int i=0;
		long n=2;
		while(primes[p-1]==0)
		{
			if(getPrime(n))
			{
				primes[i] = n;
				i++;
			}
			n++;
		}
		return primes[p-1];
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
