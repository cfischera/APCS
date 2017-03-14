public class Problem19
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		int counter = 2;
		int year = 1901;
		for(int i=year;i<2001;i++)
		{
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			if(!(year%400==0) && year%4==0)
				counter+=29;
			else
				counter+=28;
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			counter+=30;
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			counter+=30;
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			counter+=30;
			if(counter%7==0)
				ans++;
			counter+=31;
			if(counter%7==0)
				ans++;
			counter+=30;
			if(counter%7==0)
				ans++;
			counter+=31;
		}
		return ans;
	}
}
