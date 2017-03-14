public class Problem17
{

	public static void main(String[] args)
	{
		System.out.println(getAnswer());
		//for(int i=100;i<=999;i++)
			//System.out.println(getLetters(i)+" letters in "+i);
	}
	
	public static int getAnswer()
	{
		int ans = 0;
		for(int i=1;i<=1000;i++)
		{
			ans+=getLetters(i);
		}
		return ans;
	}
	
	public static int getLetters(int n)
	{
		int letters = 0;
		String s = Integer.toString(n);
		char[] chars = s.toCharArray();
		int c = 1;
		for(int i=0;i<chars.length;i++)
		{
			if(c==chars.length)
			{
				if( (Character.getNumericValue(chars[i])==1)
						|| (Character.getNumericValue(chars[i])==2)
						|| (Character.getNumericValue(chars[i])==6))
					letters+=3;
				else if( (Character.getNumericValue(chars[i])==4)
						|| (Character.getNumericValue(chars[i])==5)
						|| (Character.getNumericValue(chars[i])==9))
					letters+=4;
				else if( (Character.getNumericValue(chars[i])==3)
						|| (Character.getNumericValue(chars[i])==7)
						|| (Character.getNumericValue(chars[i])==8))
					letters+=5;
				c++;
			}
			else if(c==chars.length-1)
			{
				if( (Character.getNumericValue(chars[i])==1))
				{
					if( (Character.getNumericValue(chars[i+1])==0))
					{
						letters+=3; break;
					}
					else if( (Character.getNumericValue(chars[i+1])==1)
							|| (Character.getNumericValue(chars[i+1])==2))
					{
						letters+=6; break;
					}
					else if( (Character.getNumericValue(chars[i+1])==5)
							|| (Character.getNumericValue(chars[i+1])==6))
					{
						letters+=7; break;
					}
					else if( (Character.getNumericValue(chars[i+1])==3)
							|| (Character.getNumericValue(chars[i+1])==4)
							|| (Character.getNumericValue(chars[i+1])==9)
							|| (Character.getNumericValue(chars[i+1])==8))
					{
						letters+=8; break;
					}
					else if ( (Character.getNumericValue(chars[i+1])==7))
					{
						letters+=9; break;
					}
				}
				else if( (Character.getNumericValue(chars[i])==4)
						|| (Character.getNumericValue(chars[i])==5)
						|| (Character.getNumericValue(chars[i])==6))
					letters+=5;
				else if( (Character.getNumericValue(chars[i])==2)
						|| (Character.getNumericValue(chars[i])==3)
						|| (Character.getNumericValue(chars[i])==8)
						|| (Character.getNumericValue(chars[i])==9))
					letters+=6;
				else if( (Character.getNumericValue(chars[i])==7))
					letters+=7;
				c++;
			}
			else if(c==chars.length-2)
			{
				if( (Character.getNumericValue(chars[i])==1)
						|| (Character.getNumericValue(chars[i])==2)
						|| (Character.getNumericValue(chars[i])==6))
					letters+=10;
				else if( (Character.getNumericValue(chars[i])==4)
						|| (Character.getNumericValue(chars[i])==5)
						|| (Character.getNumericValue(chars[i])==9))
					letters+=11;
				else if( (Character.getNumericValue(chars[i])==3)
						|| (Character.getNumericValue(chars[i])==7)
						|| (Character.getNumericValue(chars[i])==8))
					letters+=12;
				if( (Character.getNumericValue(chars[i+1])==0)
						&& (Character.getNumericValue(chars[i+2])==0));
				else
					letters+=3;
					
				c++;
			}
			else
			{
				return 11;
			}
		}
		return letters;
	}
}