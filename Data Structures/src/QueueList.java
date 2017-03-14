/**
 * This Class is a LinkedList that implements the Queue Interface.
 * Data is added to the back and removed from the front similar
 * to a realistic queue.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public class QueueList extends LinkedList implements Queue
{
	
	/**
	 * This Constructor creates an empty QueueList.
	 */
	public QueueList()
	{
		
	}

	/**
	 * Removes the front data from the QueueList.
	 */
	public Object dequeue()
	{
		return getFront();
	}

	/**
	 * Adds data to the back of the QueueList.
	 */
	public Object enqueue(Object o)
	{
		addBack(o);
		return o;
	}
	
}
