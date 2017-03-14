/**
 * This BSTree Interface defines the methods to be implemented
 * in another Class that contains a Binary Search Tree.
 * @author ColinFischer
 * Date Last Modified: 7 February 2017
 */
public interface BSTree
{
	public void add(Comparable c);
	public boolean search(Comparable c);
	public int height();
	public String toStringPreOrder();
	public String toStringInOrder();
	public void remove(Comparable c);
}