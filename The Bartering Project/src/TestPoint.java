/**
 * This Class is an exclusive test program for
 * the Point Class. It ensures that Points are
 * constructed correctly and will not cause issues
 * in the future.
 * @author ColinFischer
 * Date Last Modified: 28 August 2016
 */
public class TestPoint 
{
	/**
	 * This main method performs tests on different instances
	 * of Points, which includes: equality with expanded decimals,
	 * a negative, an original, and similar values. 
	 * Also, it displays the toString() method and how the Points 
	 * will be displayed in the console. 
	 */
	public static void main(String[] args) 
	{
		
		
		// testing an instance of a Point
		Point point1 = new Point(1, 1.0);
		System.out.println("Point 1 contains quantity " +
				point1.getQuantity() + 
				" and price " + point1.getPrice());
		
		// testing price equality
		Point point2 = new Point(10, 1.1);
		Point point3 = new Point(10, 1.01);
		Point point4 = new Point(10, 1.001);
		
		if(point1.equals(point2))
		{
			System.out.println("Points 1 & 2 are equal");
		}
		else
		{
			System.out.println("Points 1 & 2 are not equal");
		}
		
		if(point1.equals(point3))
		{
			System.out.println("Points 1 & 3 are equal");
		}
		else
		{
			System.out.println("Points 1 & 3 are not equal");
		}
		
		if(point1.equals(point4))
		{
			System.out.println("Points 1 & 4 are equal");
		}
		else
		{
			System.out.println("Points 1 & 4 are not equal");
		}
		
		
		// testing a negative
		Point negativePoint = new Point(-10, -1.0);
		
		if(point1.equals(negativePoint))
		{
			System.out.println(
					"Points 1 & the negative point are equal");
		}
		else
		{
			System.out.println(
					"Points 1 & the negative point are not equal");
		}
		
		// testing Point()
		Point originalPoint = new Point();
		if(point1.equals(originalPoint))
		{
			System.out.println(
					"Points 1 & the original point are equal");
		}
		else
		{
			System.out.println(
					"Points 1 & the original point are not equal");
		}
		
		
		//testing toString & toDollars
		System.out.println("Point 1 is " + point1);
		System.out.println("Point 2 is " + point2);
		System.out.println("Point 3 is " + point3);
		System.out.println("Point 4 is " + point4);
		System.out.println("Negative point is " + negativePoint);
		System.out.println("Original point is " + originalPoint);
		
		
		// testing equals() against toDollars() rounding
		Point similarPoint1 = new Point(20, 5.124);
		Point similarPoint2 = new Point(20, 5.126);
		
		if(similarPoint1.equals(similarPoint2))
		{
			System.out.println("Similar points 1 & 2 are equal");
		}
		else
		{
			System.out.println("Similar points 1 & 2 are not equal");
		}
		
		System.out.println("Similar point 1 is " + similarPoint1);
		System.out.println("Similar point 2 is " + similarPoint2);
		
		/*
		 * The Point Class has one inconsistency that will remain
		 * for logical reasons. If two points contain equivalent
		 * quantity values, and price values within half of a cent
		 * (the price equality margin), they will be recognized as equal
		 * by the equals() method. And, if they are oriented like the 
		 * test points above [(20, 5.124) & (20, 5.126)] they will be
		 * rounded to different dollar amounts [($5.12) & ($5.13)].
		 * Since the price value continues beyond the hundreth's place
		 * and is not permanently rounded during evaluation, 
		 * this discrepancy is unavoidable and effectively insignificant 
		 * to this program's purpose.
		 */
	}
}