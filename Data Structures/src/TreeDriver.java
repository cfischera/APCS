/**
 * This TreeDriver Class acts as a module for testing the
 * functionality of the Tree Class.
 * @author ColinFischer
 * Date Last Modified: 7 February 2017
 */
public class TreeDriver
{

	/**
	 * This main method constructs a Tree Object and tests
	 * its vital mechanisms.
	 */
	public static void main(String[] args)
	{
		/*
		Tree t = new Tree();
		System.out.println(t.toStringInOrder());
		t.add(7);
		t.add(8);
		t.add(6);
		System.out.println(t.toStringInOrder());
		System.out.println(t.toStringPreOrder());
		System.out.println(t.search(8));
		System.out.println(t.search(9));
		System.out.println(t.height());
		
		System.out.println();
		System.out.println();
		*/
		
		Tree t2 = new Tree();
		t2.add("Bill");
		t2.add("Fred");
		t2.add("Joe");
		t2.add("Henrietta");
		t2.add("Mr. M");
		t2.add("Noman");
		t2.add("Alfred");
		t2.add("Al");
		t2.add("Fred");
		System.out.println(t2.toStringPreOrder());
		System.out.println(t2.toStringInOrder());
		System.out.println(t2.height());
		
		System.out.println();
		
		Tree t3 = new Tree();
		t3.add("Bill");
		t3.add("Henrietta");
		t3.add("Joe");
		t3.add("Fred");
		t3.add("Mr. M");
		t3.add("Noman");
		t3.add("Alfred");
		t3.add("Al");
		t3.add("Fred");
		System.out.println(t3.toStringPreOrder());
		System.out.println(t3.toStringInOrder());
		System.out.println(t3.height());
		
		System.out.println();
		
		Tree t4 = new Tree();
		t4.add("L");
		t4.add("D");
		t4.add("A");
		t4.add("F");
		t4.add("B");
		t4.add("R");
		t4.add("M");
		t4.add("U");
		t4.add("T");
		t4.add("V");
		System.out.println(t4.toStringPreOrder());
		System.out.println(t4.toStringInOrder());
		System.out.println(t4.height());
		
		System.out.println();
		
		t4.remove("A");
		System.out.println(t4.toStringPreOrder());
		t4.remove("B");
		System.out.println(t4.toStringPreOrder());
		t4.remove("U");
		System.out.println(t4.toStringPreOrder());
		t4.remove("R");
		System.out.println(t4.toStringPreOrder());
		t4.remove("L");
		System.out.println(t4.toStringPreOrder());
	}
}