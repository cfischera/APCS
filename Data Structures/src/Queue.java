/**
 * This Interface sets the methods to be fulfilled in future
 * classes that will act as queue data structures.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public interface Queue
{
	public boolean isEmpty();
	public Object dequeue();
	public Object enqueue(Object o);
	public Object getBack();
	public Object getFront();
}