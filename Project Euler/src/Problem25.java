import java.math.BigInteger;

public class Problem25
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static BigInteger getAnswer()
	{
		BigInteger ans = new BigInteger("0");
		while(fibonacciSequence(ans).toString().length()<1000)
		{
			ans = ans.add(new BigInteger("1"));
		}
		return ans;
	}
	
	public static BigInteger fibonacciSequence(BigInteger n)
	{
		if(n.intValue()<=1)
			 return n;
		BigInteger fibo = new BigInteger("1");
        BigInteger fiboPrev = new BigInteger("1");
	    for(int i=2; i<n.intValue(); ++i)
		{
	    	BigInteger temp = fibo;
			fibo = fibo.add(fiboPrev);
			fiboPrev = temp;
		}
	    return fibo;
	}
}
