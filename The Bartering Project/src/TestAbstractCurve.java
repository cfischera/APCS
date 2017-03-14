
public class TestAbstractCurve
{
	/**
	 * 
	 */
	public static void main(String[] args)
	{
		ConsumerCurve x = new ConsumerCurve(5, 1, 1, 1);
		System.out.println(x);
		
		Point p1 = new Point(2, 5);
		
		x.add(p1);
		
		System.out.println(x);
		
		x.sort();
		
		System.out.println(x);
	}

}
