public class Problem14
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		long seqLength = 0;
		for(int i=1;i<1000000;i++)
		{
			if(collatzSeqLength(i)>seqLength)
			{
				seqLength = collatzSeqLength(i);
				ans = i;
			}
				
		}
		return ans;
	}
	
	public static long collatzSeqLength(int n)
	{
		long counter = 0;
		long l = n;
		while(l!=1)
		{
			if(l%2==0)
				l/=2;
			else
				l = (l*3)+1;
			counter++;
		}
		return counter;
	}
}