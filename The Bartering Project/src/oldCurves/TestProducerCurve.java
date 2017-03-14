package oldCurves;

/**
 * 
 * @author ColinFischer
 * Date Last Modified: 9 September 2016
 */
public class TestProducerCurve
{

	
	/**
	 * 
	 * 
	 */
	public static void main(String[] args) 
	{
		
		OldProducerCurve x = new OldProducerCurve(10, 1, 12.0, -1.0);
		System.out.println(x);
		
		Point p1 = new Point(1, 9.0);
		Point p2 = new Point(10, 0.0);
		
		x.removePoint(p1);
		System.out.println(x);
		
		x.removePoint(p2);
		System.out.println(x);
		
		/*
		ProducerCurve pCurve1 = new ProducerCurve();
		System.out.println(pCurve1);
		
		ProducerCurve pCurve2 = new ProducerCurve(5, 1, 2.0);
		System.out.println(pCurve2);
		
		ProducerCurve pCurve3 = new ProducerCurve(20, 1, 0.5);
		System.out.println(pCurve3);
		
		ProducerCurve pCurve4 = new ProducerCurve(7, 2, 4.3672);
		System.out.println(pCurve4);
		
		Point testPoint1 = new Point(1, 1.0);
		Point testPoint2 = new Point(1, 0.0);
		
		if(pCurve1.pointOnCurve(testPoint1))
		{
			System.out.println("Test Point 1 is on  Producer Curve 1");
		}
		else
		{
			System.out.println("Test Point 1 is not on Producer Curve 1");
		}
		
		if(pCurve1.pointOnCurve(testPoint2))
		{
			System.out.println("Test Point 2 is on  Producer Curve 1");
		}
		else
		{
			System.out.println("Test Point 2 is not on Producer Curve 1");
		}
		*/
		
		/*
		ProducerCurve x = new ProducerCurve();
		System.out.println(x);
		Point p = new Point(6, 6.0);
		x.removePoint(p);
		System.out.println(x);
		x.addPoint(p);
		System.out.println(x);
		*/
		
		/*
		ProducerCurve y = new ProducerCurve(7, 1, 2.67);
		System.out.println(y);
		Point p2 = new Point(5, 13.35);
		y.removePoint(p2);
		System.out.println(y);
		y.addPoint(p2);
		System.out.println(y);
		Point p3 = new Point(5, 1.0);
		y.addPoint(p3);
		System.out.println(y);
		*/
		
		/*
		ProducerCurve z = new ProducerCurve();
		System.out.println(z);
		Point p4 = new Point(1, 0.5);
		if(z.checkOffer(p4))
			System.out.println("Producer accepts offer of "+p4);
		else
			System.out.println("Producer denies offer of "+p4);
		Point p5 = new Point(1, 1.0);
		if(z.checkOffer(p5))
			System.out.println("Producer accepts offer of "+p5);
		else
			System.out.println("Producer denies offer of "+p5);
		Point p6 = new Point(1, 2.0);
		if(z.checkOffer(p6))
			System.out.println("Producer accepts offer of "+p6);
		else
			System.out.println("Producer denies offer of "+p6);
			*/
	}
}
