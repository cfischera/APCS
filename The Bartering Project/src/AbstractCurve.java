/**
 * This Class serves as an extendible template for
 * other Classes that wish to create fairly similar
 * Curves (ArrayLists of Points) to eventually be
 * used in a market bargaining scenario.
 * @author ColinFischer
 * Date Last Modified: 21 September 2016
 */

import java.util.ArrayList;

public abstract class AbstractCurve
{
	
	private ArrayList<Point> myCurve;
	
	/**
	 * This Constructor creates a custom ArrayList of Points
	 * (a Curve) dictated by four parameters: number of points,
	 * change in quantity, starting price, and change in price.
	 */
	public AbstractCurve(int n, int dx, double b, double dy)
	{
		myCurve = new ArrayList<Point>();
		for(int i=0;i<n;i++)
		{
			int    q = (i+1)*dx;
			double p = b+(i*dy);
			if(q<=0 || p<=0); //skips negative Points
			else
				myCurve.add(new Point(q, p));
		}
	}
	
	/**
	 * This method adds a Point to the AbstractCurve ArrayList.
	 */
	public void add(Point p)
	{
		for(int i=0;i<myCurve.size();i++)
		{
			if(myCurve.get(i).getQuantity()==p.getQuantity())
				remove(myCurve.get(i)); //removes if same quantity
		}
		for(int i=0;i<myCurve.size();i++)
		{
			if(myCurve.get(i).getQuantity()<p.getQuantity())
			{
				myCurve.add(i+1, p);
			}
		}
	}
	
	/**
	 * This method removes a Point from the AbstractCurve ArrayList.
	 */
	public boolean remove(Point p)
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
	 * This method checks to find if the ArrayList contains
	 * a specific Point.
	 */
	public boolean contains(Point p)
	{
		for(Point x : myCurve)
		{
			if(x.equals(p))
				return true;
		}
		return false;
	}
	
	/**
	 * This method returns the ArrayList - myCurve -
	 * the intended caller being a Child Class that wishes
	 * to manipulate the ArrayList for any reason,
	 * since this is an abstract Class that will be implemented.
	 */
	public ArrayList<Point> getMyCurve()
	{
		return myCurve;
	}
	
	/**
	 * This method converts the AbstractCurve ArrayList of Points
	 * into a String of words that can be easily understood 
	 * by anyone.
	 */
	public String toString()
	{
		String s = "Curve contains: ";
		for(int i=0;i<myCurve.size();i++)
		{
			s += (myCurve.get(i).toString()+". ");
		}
		return s;
	}
	
	/**
	 * This abstract method must be defined by a Child Class
	 * that implements AbstractCurve. It is left abstract so that
	 * each Child can define their own sorting function.
	 */
	public abstract void sort();
	
	/**
	 * Added for Market
	 */
	public Point getPoint(int q)
	{
		for(int i=0;i<myCurve.size();i++)
		{
			if(myCurve.get(i).getQuantity()==q)
				return myCurve.get(i);
		}
		return null;
	}
}
