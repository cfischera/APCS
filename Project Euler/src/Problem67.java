import java.util.Scanner;
import java.io.File;

public class Problem67
{

	public static void main(String[] args) throws Exception
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer() throws Exception
	{
		String s ="";
		Scanner sc = new Scanner(new File("p067_triangle.txt"));
		while(sc.hasNextLine())
			s+=sc.nextLine();
		sc.close();
		String x = s.replaceAll("\\p{Z}","");
		String[] strings = new String[x.length()/2];
		int[] nums = new int[x.length()/2];
		int j = 0;
		for(int i=0;i<strings.length;i++)
		{
			strings[i] = x.substring(j, j+2);
			j+=2;
		}
		for(int i=0;i<nums.length;i++)
			nums[i] = Integer.parseInt(strings[i]);
		
		for(int i=0;i<nums.length;i++)
			System.out.println(i+" "+nums[i]);
		
		int y = 4950;
		int z = 99;
		for(int i=100;i>0;i--)
		{
			for(int k=0;k<i-1;k++)
			{
				if(nums[y+k]>nums[y+k+1])
					nums[y-z+k]+=nums[y+k];
				else
					nums[y-z+k]+=nums[y+k+1];
				System.out.println(nums[y-z+k]);
			}
			y-=z;
			z--;
		}
		
		return nums[0];
	}
}
