/**
 * This Interface sets the methods to be fulfilled in future
 * classes that will act as stack data structures.
 * @author ColinFischer
 * Date Last Modified: 22 January 2017
 */
public interface Stack
{
	public boolean isEmpty();
	public Object push(Object o);
	public Object pop();
	public Object peek();
	public int search(Object o);
}