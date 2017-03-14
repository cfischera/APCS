package oldCurves;
/**
 * This Class creates an ArrayList of Points (a Curve)
 * to be used by a Consumer in a later bargaining process
 * to reach equilibrium with a Producer.
 * @author ColinFischer
 * Date Last Modified: 15 September 2016
 */

import java.util.ArrayList;

public class OldConsumerCurve
{
	private ArrayList<Point> myCurve;
	
	/**
	 * This Constructor creates a generic ConsumerCurve with
	 * ten Points starting from (1, 9.0) to (10 ,0.0) when
	 * no parameters are passed.
	 */
	public OldConsumerCurve()
	{
		myCurve = new ArrayList<Point>();
		for(int i=0;i<10;i++)
		{
			int    q = i+1;
			double p = 9.0-i;
			Point  x = new Point(q, p);
			myCurve.add(x);
		}
	}
	
	/**
	 * This Constructor creates a custom ConsumerCurve - an ArrayList -
	 * with parameters that determine the number of Points as well as the
	 * starting quantity and price values, and the increment between quantity 
	 * and price values.
	 */
	public OldConsumerCurve(int nPoints, int quantityIncrement,
			double startPrice, double priceIncrement)
	{
		myCurve = new ArrayList<Point>();
		for(int i=0;i<nPoints;i++)
		{
			int q    = (i+1)*quantityIncrement;
			double p = startPrice-(i*priceIncrement);
			if (q<=0 || p<0) //if a Point has negative values
				i=10;        //skip to end of loop
			else
			{
				Point x  = new Point(q, p);
				myCurve.add(x);
			}
		}
	}
	
	/**
	 * This method checks if a passed Point is included in
	 * the ArrayList and returns true or false accordingly.
	 */
	public boolean pointOnCurve(Point p)
	{
		for(Point x : myCurve)
		{
			if(x.equals(p))
				return true;
		}
		return false;
	}
	
	/**
	 * This method adds a Point into the ConsumerCurve ArrayList.
	 */
	public void addPoint(Point p)
	{
		for(int i=0;i<myCurve.size();i++)
		{
			if(myCurve.get(i).getQuantity()==p.getQuantity())
				removePoint(myCurve.get(i)); // removes Point with same quantity
		}
		myCurve.add(p);      //adds new Point to end of ArrayList
		bubbleSort(myCurve); //sorts new Point into myCurve
	}
	
	/**
	 * This method removes a Point from the ConsumerCurve ArrayList.
	 */
	public boolean removePoint(Point p)
	{
		for(int i=0;i<myCurve.size();i++)
		{
			if(myCurve.get(i).equals(p))
			{
				myCurve.remove(i);
				return true; //Point removed
			}
		}
		return false; //Point was not removed
	}
	
	/**
	 * This method sorts the ConsumerCurve ArrayList from lowest quantity
	 * value to highest.
	 */
	private void bubbleSort(ArrayList<Point> a)
	{
		boolean swapping = true;
		while (swapping)
		{
			swapping = false;
			for(int i=0;i<myCurve.size()-1;i++)
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
	 * This method converts the ConsumerCurve ArrayList into a String
	 * of words that can be easily understood by anyone.
	 */
	public String toString()
	{
		String s = "Conusmer demands: ";
		for(int i=0;i<myCurve.size();i++)
		{
			s += (myCurve.get(i).toString()+". ");
		}
		return s;
	}
}
