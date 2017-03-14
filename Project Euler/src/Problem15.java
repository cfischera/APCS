import java.math.*;

public class Problem15
{
	
	public static void main(String[] args)
	{
		System.out.println("20x20 grid lattice path options:");
		System.out.println(getAnswer());
		System.out.println(factorial(new BigInteger("15")));
	}
	
	public static BigInteger getAnswer()
	{
		BigInteger top = factorial2(new BigInteger("40"));
		BigInteger bottom = factorial(new BigInteger("20"));
		BigInteger ans = top.divide(bottom);
		return ans;
	}
	
	public static BigInteger factorial(BigInteger n)
	{
		BigInteger x = new BigInteger("1");
		if(n.equals(x))
			return x;
		return n.multiply(factorial(n.subtract(x)));
	}
	
	public static BigInteger factorial2(BigInteger n)
	{
		if(n.equals(new BigInteger("21")))
			return new BigInteger("21");
		return n.multiply(factorial2(n.subtract(new BigInteger("1"))));	
	}
}
