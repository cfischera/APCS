/**
 * This Class uses a StackList in order to calculate
 * postfix operations.
 * @author ColinFischer
 * Date Last Modified: 23 January 2017
 */

import java.util.Scanner;

public class Expression
{
	private StackList sl;
	private Scanner sc;
	private String s;
	
	/**
	 * This main method runs the Expression Class's
	 * methods in order to fulfill the postfix operations.
	 */
	public static void main(String[] args)
	{
		Expression ex = new Expression();
		System.out.println("Enter String expression with single "+
							"spaces for separation");
		ex.getString();
		ex.computePostfix();
		System.out.println("Final Stack state: "+ex.getStackList());
	}
	
	/**
	 * This Constructor creates an Expression with
	 * an empty StackList and a Scanner.
	 */
	public Expression()
	{
		sl = new StackList();
		sc = new Scanner(System.in);
	}
	
	/**
	 * Accepts a String input from the console.
	 */
	public void getString()
	{
		s = sc.nextLine();
	}
	
	/**
	 * Uses the String input to calculate a postfix operation.
	 */
	public void computePostfix()
	{
		if(s!=null)
		{
			String[] strings = s.split(" ");
			for(int i=0;i<strings.length;i++)
			{
				if(strings[i].equals("+"))
				{
					int t1 = (int)sl.pop();
					int t2 = (int)sl.pop();
					int t3 = t2+t1;
					sl.push(t3);
				}
				else if(strings[i].equals("-"))
				{
					int t1 = (int)sl.pop();
					int t2 = (int)sl.pop();
					int t3 = t2-t1;
					sl.push(t3);
				}
				else if(strings[i].equals("*"))
				{
					int t1 = (int)sl.pop();
					int t2 = (int)sl.pop();
					int t3 = t2*t1;
					sl.push(t3);
				}
				else if(strings[i].equals("/"))
				{
					int t1 = (int)sl.pop();
					int t2 = (int)sl.pop();
					int t3 = t2/t1;
					sl.push(t3);
				}
				else
				{
					sl.push(Integer.parseInt(strings[i]));
				}
				System.out.println(sl);
			}
		}
	}
	
	/**
	 * Returns the Class's StackList.
	 */
	public StackList getStackList()
	{
		return sl;
	}
}