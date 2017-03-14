public class Problem6
{
	
	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		return getSumSquare(100) - getSeparateSquares(100);
	}
	
	public static int getSeparateSquares(int n)
	{
		int sum = 0;
		for(int i=1;i<=n;i++)
		{
			sum += i*i;
		}
		return sum;
	}
	
	public static int getSumSquare(int n)
	{
		int sum = 0;
		for(int i=1;i<=n;i++)
		{
			sum += i;
		}
		return sum*sum; 
	}
}
