/**
 * This Class is a LinkedList that implements the Stack Interface.
 * Data is pushed and popped off of a stack-like list.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public class StackList extends LinkedList implements Stack
{
	LinkedList ll;
	
	/**
	 * This Constructor creates an empty StackList
	 * with an auxiliary LinkedList for temporary storage.
	 */
	public StackList()
	{
		ll = new LinkedList();
	}
	
	/**
	 * Adds to the StackList from the top.
	 */
	public Object push(Object o)
	{
		addFront(o);
		return o;
	}

	/**
	 * Removes off of the StackList from the top.
	 */
	public Object pop()
	{
		if(isEmpty())
			return null;
		return getFront();
	}

	/**
	 * Returns the value of the topmost data unit.
	 */
	public Object peek()
	{
		Object t = pop();
		push(t);
		return t;
	}

	/**
	 * Returns the corresponding position of a data unit
	 * in the StackList. 1 if topmost, continues in ascending
	 * order, -1 if not found.
	 */
	public int search(Object o)
	{
		Object t = null;
		int counter = 0;
		int index = -1;
		while(!isEmpty())
		{
		    t = pop();
			ll.addFront(t);
			counter++;
		}
		while(!ll.isEmpty())
		{
			t = ll.getFront();
			if(t.equals(o))
				index = counter;
			push(t);
			counter--;
		}
		return index;
	}
}