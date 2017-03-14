public class Problem18
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer
("75"
+"95 64"
+"17 47 82"
+"18 35 87 10"
+"20 04 82 47 65"
+"19 01 23 75 03 34"
+"88 02 77 73 07 63 67"
+"99 65 04 28 06 16 70 92"
+"41 41 26 56 83 40 80 70 33"
+"41 48 72 33 47 32 37 16 94 29"
+"53 71 44 65 25 43 91 52 97 51 14"
+"70 11 33 28 77 73 17 78 39 68 17 57"
+"91 71 52 38 17 14 91 43 58 50 27 29 48"
+"63 66 04 68 89 53 67 30 73 16 69 87 40 31"
+"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"));
	}
	
	public static int getAnswer(String s)
	{
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
		
		int y = 105;
		int z = 14;
		for(int i=15;i>0;i--)
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
	
	/*
	public static int getAmountOfLastRow(int[] a)
	{
		int i = 0;
		int j = 1;
		while(a.length-i>0)
		{
			i+=i+j;
			j++;
		}
		j++;
		System.out.println("i "+i+" j "+j);
		return i/j;
	}
	*/
}