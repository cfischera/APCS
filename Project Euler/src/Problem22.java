import java.util.Scanner;
import java.io.File;

public class Problem22
{

	public static void main(String[] args) throws Exception
	{
		System.out.println(getAnswer());
	}
	
	public static long getAnswer() throws Exception
	{
		long ans = 0;
		Scanner sc = new Scanner(new File("p022_names.txt"));
		String s = "";
		while(sc.hasNextLine())
			s+=sc.nextLine();
		sc.close();
		String x = s.replaceAll("\"", "");
		String[] a = x.split(",");
		sort(a);
		for(int i=0;i<a.length;i++)
			ans+=(getScore(a[i])*(i+1));
		return ans;
	}
	
	public static void sort(String[] a)
	{
		boolean swapping = true;
		while(swapping)
		{
			swapping = false;
			for(int i=0;i<a.length-1;i++)
			{
				char[] c1 = a[i].toCharArray();
				char[] c2 = a[i+1].toCharArray();
				int length = c1.length;
				boolean longer = false;
				if(c1.length>c2.length)
				{
					length = c2.length;
					longer = true;
				}
				for(int j=0;j<length;j++)
				{
					if(Character.getNumericValue(c2[j])>Character.getNumericValue(c1[j]))
						break;
					else if(Character.getNumericValue(c1[j])>Character.getNumericValue(c2[j]))
					{
						String t = a[i];
						a[i] = a[i+1];
						a[i+1] = t;
						swapping = true;
						break;
					}
					if(j==length-1)
					{
						if(longer)
						{
							String t = a[i];
							a[i] = a[i+1];
							a[i+1] = t;
							swapping = true;
						}
					}
				}
			}
		}
	}
	
	public static int getScore(String s)
	{
		int score = 0;
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++)
			score+=(Character.getNumericValue(c[i])-9);
		return score;
	}
}