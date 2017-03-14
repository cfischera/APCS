/**
 * This TreeNode Class creates the basic unit of storage
 * for a Tree data structure.
 * @author ColinFischer
 * Date Last Modified: 7 February 2017
 */
public class TreeNode
{
	private Comparable value;
	private TreeNode leftChild, rightChild;

	/**
	 * This Constructor creates a TreeNode Object with
	 * initial passed variables for its value and
	 * TreeNode children.
	 */
	public TreeNode(Comparable c, TreeNode lC, TreeNode rC)
	{
		value = c;
		leftChild = lC;
		rightChild = rC;
	}
	
	/**
	 * Sets the value of a TreeNode.
	 */
	public void setValue(Comparable c)
	{
		this.value = c;
	}
	
	/**
	 * Sets the LeftChild of a TreeNode.
	 */
	public void setLeftChild(TreeNode lC)
	{
		this.leftChild = lC;
	}
	
	/**
	 * Sets the RightChild of a TreeNode.
	 */
	public void setRightChild(TreeNode rC)
	{
		this.rightChild = rC;
	}
	
	/**
	 * Returns the value of a TreeNode.
	 */
	public Comparable getValue()
	{
		return this.value;
	}
	
	/**
	 * Returns the LeftChild of a TreeNode.
	 */
	public TreeNode getLeftChild()
	{
		return this.leftChild;
	}
	
	/**
	 * Returns the RightChild of a TreeNode.
	 */
	public TreeNode getRightChild()
	{
		return this.rightChild;
	}
}