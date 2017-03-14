/**
 * This Class creates the base memory unit for more advanced
 * data structures such as the LinkedList. 
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public class ListNode
{
	private Object data;
	private ListNode next;
	
	/**
	 * This Constructor creates a ListNode which contains a passed
	 * data value and a next ListNode.
	 */
	public ListNode(Object o, ListNode ln)
	{
		data = o;
		next = ln;
	}
	
	/**
	 * This method sets the value of a ListNode.
	 */
	public void setValue(Object v)
	{
		data = v;
	}
	
	/**
	 * This method sets the next ListNode from the current ListNode.
	 */
	public void setNext(ListNode n)
	{
		next = n;
	}
	
	/**
	 * This method returns the value of a ListNode.
	 */
	public Object getValue()
	{
		return data;
	}
	
	/**
	 * This method returns the next ListNode from the current ListNode.
	 */
	public ListNode getNext()
	{
		return next;
	}
}
