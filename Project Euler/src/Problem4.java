public class Problem4
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		for(int i=100;i<1000;i++)
		{
			for(int a=100;a<1000;a++)
			{
				int b = i*a;
				if(b>ans && getPalindromeNumber(b))
				{
					ans = b;
				}
			}
		}
		return ans;
	}
	
	public static boolean getPalindromeNumber(int p)
	{
		int tp = p;
		int length = String.valueOf(p).length();
		int[] nums = new int[length];
		for(int i=0;i<nums.length;i++)
		{
			nums[i] = tp%10;
			tp/=10;
		}
		for(int a=0;a<nums.length;a++)
		{
			if(nums[a]!=nums[nums.length-a-1])
				return false;
		}
		return true;
	}
}
