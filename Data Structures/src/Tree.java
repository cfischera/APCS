/**
 * This Tree Class implements a Binary Search Tree
 * Interface which stores data in a fashion so that
 * all values less than the root are stored on the left,
 * and all the values greater are stored on the right.
 * @author ColinFischer
 * Date Last Modified: 7 February 2017
 */
public class Tree implements BSTree
{
	private TreeNode root;
	
	/**
	 * This constructor creates an empty Tree.
	 */
	public Tree()
	{
		root = null;
	}
	
	/**
	 * Adds a TreeNode to the Tree Object.
	 */
	public void add(Comparable c)
	{
		root = add(root, c);
	}
	
	/**
	 * Private helper to add a TreeNode to the Tree recursively.
	 */
	private TreeNode add(TreeNode r, Comparable c)
	{
		if (r==null)
			r = new TreeNode(c, null, null);
		else
			if (c.compareTo((Comparable)(r.getValue()))<0)
				r.setLeftChild(add(r.getLeftChild(), c));
			else
				r.setRightChild(add(r.getRightChild(), c));
		return r;
	}

	/**
	 * Searches for a specific element in the Tree.
	 */
	public boolean search(Comparable c)
	{
		return search(c, root);
	}
	
	/**
	 * Private helper to search for a value recursively.
	 */
	private boolean search(Comparable c, TreeNode r)
	{
		if (r==null)
			return false;
		else
		{
		      if(c.equals((Comparable)r.getValue()))
		    	  return true;
		      else
		    	  return (search(c, r.getLeftChild()) 
		    			  || search(c, r.getRightChild()));
		}
	}

	/**
	 * Returns the maximum levels of TreeNodes.
	 */
	public int height()
	{
		return height(root);
	}
	
	/**
	 * Private helper to return the height of the Tree.
	 */
	private int height(TreeNode r)
	{
		if(r==null)
			return 0;
		else
			return 1 + Math.max(height(r.getLeftChild()),
					height(r.getRightChild()));
	}

	/**
	 * Converts the values contained in a Tree into a
	 * String in order from Parent, LeftChild, RightChild.
	 */
	public String toStringPreOrder()
	{
		if(root==null)
			return "Tree is empty.";
		else
			return toStringPreOrder(root);
	}
	
	/**
	 * Private helper to convert values in the Tree to String
	 * in order from Parent, LeftChild, RightChild.
	 */
	private String toStringPreOrder(TreeNode r)
	{
		if(r==null)
			return "";
		else
			return	"( "+r.getValue()+
					  " "+toStringPreOrder
					  	(r.getLeftChild())+
					  	toStringPreOrder
				      	(r.getRightChild())+")";
	}
	
	/**
	 * Converts the values contained in a Tree into a
	 * String in order from LeftChild, Parent, RightChild.
	 */
	public String toStringInOrder()
	{
		if(root==null)
			return "Tree is empty.";
		else
			return toStringInOrder(root);
	}
	
	/**
	 * Private helper to convert values in the Tree to String
	 * in order from LeftChild, Parent, RightChild.
	 */
	private String toStringInOrder(TreeNode r)
	{
		if(r==null)
			return "";
		else
			return "("+toStringInOrder
						(r.getLeftChild())+
		             " "+ r.getValue()+
		             " "+ toStringInOrder
		             	(r.getRightChild())+")";
	}
	
	/**
	 * Removes a TreeNode with the passed value.
	 */
	public void remove(Comparable c)
	{
		remove(c, root);
	}

	/**
	 * Private recursive method that removes TreeNodes depending
	 * on how many children they have.
	 */
	private void remove(Comparable c, TreeNode r)
	{
		TreeNode delNode    = findDelNode(c, r);
		TreeNode delParent  = findDelParent(c, r);
		boolean isLeftChild = false;
		if(delParent.getLeftChild()==delNode)
			isLeftChild = true;
		if(delNode.getLeftChild()==null
				&&delNode.getRightChild()==null)
		{
			if(delNode==root)
				root = null;
			else
			{
				if(isLeftChild)
					delParent.setLeftChild(null);
				else
					delParent.setRightChild(null);
			}
		}
		else if(delNode.getLeftChild()==null
				||delNode.getRightChild()==null)
		{
			if(delNode==root)
			{
				if(delNode.getLeftChild()==null)
				{
					if(root.getLeftChild()!=null)
						root = root.getLeftChild();
					else
						root = root.getRightChild();
				}
			}
			else
			{
				if(delNode.getLeftChild()==null)
				{
					if(isLeftChild)
						delParent.setLeftChild(delNode.getRightChild());
					else
						delParent.setRightChild(delNode.getLeftChild());
				}
			}
		}
		else
		{
			TreeNode smallRight  = findSmallRight(delNode);
			TreeNode parentRight = findParentRight(delNode);
			remove(smallRight.getValue(), parentRight);
			if(delNode==root)
			{
				root = smallRight;
			}
			else
			{
				if(isLeftChild)
					delParent.setLeftChild(smallRight);
				else
					delParent.setRightChild(smallRight);
			}
			smallRight.setLeftChild(delNode.getLeftChild());
			if(delNode.getRightChild()!=smallRight)
			smallRight.setRightChild(delNode.getRightChild());
		}
	}
	
	/**
	 * Returns the TreeNode that is to be deleted.
	 */
	private TreeNode findDelNode(Comparable c, TreeNode r)
	{
		TreeNode t = null;
		if(search(c))
		{
			t = r;
			while(!t.getValue().equals(c))
			{
				if(t.getValue().compareTo(c)<0)
					t = t.getRightChild();
				else
					t = t.getLeftChild();
			}
		}
		return t;
	}
	/**
	 * Returns the parent of the TreeNode that is to be deleted.
	 */
	private TreeNode findDelParent(Comparable c, TreeNode r)
	{
		TreeNode t = null;
		TreeNode p = null;
		if(search(c))
		{
			t = r;
			if(t.getValue().equals(c)
					||t.getLeftChild().getValue().equals(c)
					||t.getRightChild().getValue().equals(c))
				return t;
			else
			{
				if(t.getValue().compareTo(c)<0)
					t = t.getRightChild();
				else
					t = t.getLeftChild();
			}
			while(!t.getValue().equals(c))
			{
				p = t;
				if(t.getValue().compareTo(c)<0)
					t = t.getRightChild();
				else
					t = t.getLeftChild();
			}
		}
		return p;
	}
	
	/**
	 * Returns the least valued TreeNode in the right subtree
	 * of the TreeNode that is to be deleted.
	 */
	private TreeNode findSmallRight(TreeNode d)
	{
		TreeNode s = d.getRightChild();
		while(s.getLeftChild()!=null)
			s = s.getLeftChild();
		return s;
	}
	
	/**
	 * Returns the parent of the least valued TreeNode in the right
	 * subtree of the TreeNode that is to be deleted.
	 */
	private TreeNode findParentRight(TreeNode d)
	{
		TreeNode s = d.getRightChild();
		TreeNode p = s;
		if(s.getLeftChild()!=null)
			s = s.getLeftChild();
		while(s.getLeftChild()!=null)
		{
			p = s;
			s = s.getLeftChild();
		}
		return p;
	}
}