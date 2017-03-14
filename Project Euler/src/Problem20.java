import java.math.BigInteger;

public class Problem20
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		BigInteger x = factorial(new BigInteger("100"));
		String s = x.toString();
		char[] chars = s.toCharArray();
		for(int i=0;i<chars.length;i++)
			ans+=Character.getNumericValue(chars[i]);
		return ans;
	}
	
	public static BigInteger factorial(BigInteger n)
	{
		BigInteger x = new BigInteger("1");
		if(n.equals(x))
			return x;
		return n.multiply(factorial(n.subtract(x)));
	}
}
