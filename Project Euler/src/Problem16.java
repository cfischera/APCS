import java.math.BigInteger;

public class Problem16
{

	public static void main(String[] args)
	{
		System.out.println("Sum of digits of 2^1000:");
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		BigInteger power = powerOf2(1000);
		int ans = 0;
		String s = power.toString();
		char[] chars = s.toCharArray();
		for(int i=0;i<chars.length;i++)
			ans+= Character.getNumericValue(chars[i]);
		return ans;
	}
	
	public static BigInteger powerOf2(int p)
	{
		BigInteger x = new BigInteger("1");
		for(int i=1;i<=p;i++)
			x = x.multiply(new BigInteger("2"));
		return x;
	}
}
