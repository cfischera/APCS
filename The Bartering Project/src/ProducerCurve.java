/**
 * This Class extends the AbstractCurve Class,
 * which it uses to create an ArrayList of Points
 * (a Curve) to be used in a market bargaining scenario
 * by a Producer of a good.
 * @author ColinFischer
 * Date Last Modified: 21 September 2016
 */

import java.util.ArrayList;

public class ProducerCurve extends AbstractCurve
{
	/**
	 * Default Constructor
	 */
	public ProducerCurve()
	{
		super(10, 1, 9.0, -1.0);
	}
	
	/**
	 * This Constructor calls the Super Class - AbstractCurve -
	 * Constructor with variable parameter values to be used for
	 * this Producer Curve.
	 */
	public ProducerCurve(int n, int dx, double b, double m)
	{
		super(n, dx, b, m);
	}
	
	/**
	 * This method is implemented from AbstractCurve, making it
	 * required. It sorts the ArrayList of Points to be listed 
	 * by quantity from lowest to highest.
	 */
	public void sort()
	{
		ArrayList<Point> a = super.getMyCurve();
		boolean swapping = true;
		while(swapping)
		{
			swapping = false;
			for(int i=0;i<super.getMyCurve().size()-1;i++)
			{
				Point t;
				if(a.get(i).getQuantity()>a.get(i+1).getQuantity())
				{
					t = a.get(i);
					a.set(i, a.get(i+1));
					a.set(i+1, t);
					swapping = true;
				}
			}
		}
	}
	
	/**
	 * This method shadows the get() method in the Parent Class
	 * (AbstractCurve), which returns the private ArrayList (Curve).
	 * The shadowing restricts any Child Class or Class which 
	 * instantiates an AbstractProducerCurve access to that ArrayList.
	 */
	public ArrayList<Point> getMyCurve()
	{
		return null;
	}
}
