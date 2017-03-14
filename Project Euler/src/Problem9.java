public class Problem9
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int a=1, b=1, c=1;
		for(int i=1;i<1000;i++)
		{
			c=i;
			for(int j=1;j<1000;j++)
			{
				b=j;
				for(int k=1;k<1000;k++)
				{
					a=k;
					if((a+b+c)==1000 && isPythTrip(a, b, c))
					{
						System.out.println(a+" "+b+" "+c);
						return a*b*c;
					}
				}
			}
		}
		return (a*b*c);
	}
	
	public static boolean isPythTrip(int a, int b, int c)
	{
		return((a<b)&&(b<c)&&((a*a)+(b*b)==(c*c)));
	}
}
