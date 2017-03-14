/**
 * This Class contains a main method to test varying types of
 * data structures.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public class Driver
{

	/**
	 * This main method tests the StackList and QueueList data
	 * structures by adding and printing a series of Strings.
	 */
	public static void main(String a[])
	{
		StackList sl = new StackList();
		QueueList ql = new QueueList();
		sl.push("Bill");
		sl.push("Fred");
		sl.push("Joe");
		sl.push("Henrietta");
		sl.push("Mr. M");
		sl.push("Noman");
		System.out.println(sl);
		ql.enqueue("Bill");
		ql.enqueue("Fred");
		ql.enqueue("Joe");
		ql.enqueue("Henrietta");
		ql.enqueue("Mr. M");
		ql.enqueue("Noman");
		System.out.println(ql);
	}
}
