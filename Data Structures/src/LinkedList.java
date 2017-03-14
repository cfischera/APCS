/**
 * This Class uses the ListNode Class to create a connected
 * collection or 'LinkedList' of data values.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public class LinkedList
{
	private ListNode start;
	private ListNode end;
	
	/**
	 * This Constructor creates an empty LinkedList object
	 * that can contain ListNodes for holding data.
	 */
	public LinkedList()
	{
		start = null;
		end   = null;
	}
	
	/**
	 * Returns true if LinkedList contains no ListNodes.
	 */
	public boolean isEmpty()
	{
		return(start==null);
	}
	
	/**
	 * Returns and removes the front ListNode from the LinkedList.
	 */
	public Object getFront()
	{
		Object t = start.getValue();
		start    = start.getNext();
		return t;
	}
	
	/**
	 * Returns and removes the back ListNode from the LinkedList.
	 */
	public Object getBack()
	{
		return end.getValue();
	}
	
	/**
	 * Adds a ListNode with a passed value to the front of the
	 * LinkedList. 
	 */
	public void addFront(Object o)
	{
		if(isEmpty())
		{
			start = new ListNode(o, null);
			end   = start;
		}
		else
		{
			ListNode t = start;
			start = new ListNode(o, t);
		}
	}
	
	/**
	 * Adds a ListNode with a passed value to the back of the
	 * LinkedList.
	 */
	public void addBack(Object o)
	{
		if(isEmpty())
		{
			start = new ListNode(o, null);
			end   = start;
		}
		else
		{
			end.setNext(new ListNode(o, null));
			end = end.getNext();
		}
	}
	
	/**
	 * Converts the ListNodes of a LinkedList into a String
	 * containing each of the ListNodes' values.
	 */
	public String toString()
	{
		if(isEmpty())
			return "List is empty.";
		ListNode t = start;
		String list = "";
		while(t!=null)
		{
			list+=""+t.getValue()+" ";
			t = t.getNext();
		}
		return list;
	}
}