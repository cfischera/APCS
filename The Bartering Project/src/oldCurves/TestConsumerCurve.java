package oldCurves;

/**
 * 
 * @author ColinFischer
 * Date Last Modified: 31 August 2016
 */
public class TestConsumerCurve
{

	
	/**
	 * 
	 * 
	 */
	public static void main(String[] args) 
	{
		/*
		ConsumerCurve cCurve1 = new ConsumerCurve();
		System.out.println(cCurve1);
		
		ConsumerCurve cCurve2 = new ConsumerCurve(5, 4, 2.0);
		System.out.println(cCurve2);
		*/
		
		OldConsumerCurve x = new OldConsumerCurve();
		System.out.println(x);
		OldProducerCurve y = new OldProducerCurve();
		System.out.println(y);
		
		Point p1 = new Point(4, 5.0);
		
		y.addPoint(p1);
		System.out.println();
		
		
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
