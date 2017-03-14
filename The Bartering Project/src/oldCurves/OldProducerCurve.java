package oldCurves;

/**
 * This Class creates an array of Points (a Curve)
 * to be used by a Producer in a later bargaining process
 * to reach equilibrium with a Consumer.
 * @author ColinFischer
 * Date Last Modified: 15 September 2016
 */
public class OldProducerCurve
{
	private Point[] myCurve;
	
	/**
	 * This Constructor creates a generic ProduverCurve with
	 * ten Points starting from (1, 1.0) to (10, 10.0) when
	 * no parameters are passed.
	 */
	public OldProducerCurve()
	{
		myCurve = new Point[10];
		for(int i=0;i<10;i++)
		{
			int q 	   = i+1;
			double p   = i+1.0;
			myCurve[i] = new Point(q, p);
		}
	}
	
	/**
	 * This Constructor creates a custom ProducerCurve - an array -
	 * with parameters that determine the number of Points as well as the
	 * starting quantity and price values and the increment between quantity 
	 * and price values.
	 */
	public OldProducerCurve(int nPoints, int quantityIncrement,
			double startPrice, double priceIncrement)
	{
		myCurve        = new Point[nPoints];
		int counter    = 0;
		int lessPoints = nPoints;
		for(int i=0;i<nPoints;i++)
		{
			int q       = (i+1)*quantityIncrement;
			double p    = (i+startPrice)*priceIncrement;
			if (q<=0 || p<=0) //if Point has negative values
			{
				myCurve = new Point[--lessPoints]; //decrease size of array
				counter++;
			}
			else
				myCurve[i-counter] = new Point(q, p);
		}
	}
	
	/**
	 * This method checks if a passed Point is included in
	 * the array and returns true or false accordingly.
	 */
	public boolean pointOnCurve(Point p)
	{
		for(int i=0;i<myCurve.length;i++)
		{
			if(p.equals(myCurve[i]))
				return true;
		}
		return false;
	}
	
	/**
	 * This method adds a Point to the ProducerCurve array.
	 */
	public void addPoint(Point p)
	{
		/* 
		 * This loop will remove a previous point from the curve
		 * if it has the same quantity value as the one to be added
		 * to prevent repeating points of the same quantity.
		 */
		for(int i=0;i<myCurve.length;i++)
		{
			if(myCurve[i].getQuantity()==p.getQuantity())
			{
				removePoint(myCurve[i]);
			}
		}
		Point[] t = new Point[myCurve.length+1]; //temporary array
		for(int i=0;i<myCurve.length;i++)
		{
			t[i] = myCurve[i]; //copy myCurve into temp
		}
		t[myCurve.length] = p; //assign last index to Point that needs to be added
		myCurve = new Point[myCurve.length+1]; //reassign myCurve to include 1 more index
		for(int i=0;i<myCurve.length;i++)
		{
			myCurve[i] = t[i]; //copy temp into new myCurve
		}
		bubbleSort(myCurve); //sort new Point into myCurve
	}
	
	/**
	 * This method removes a Point from the ProducerCurve array.
	 */
	public boolean removePoint(Point p)
	{
		for(int i=0;i<myCurve.length;i++)
		{
			
			/*
			 * When this loop finds the Point in the array to be removed,
			 * it creates two temporary arrays that include all Points in myCurve
			 * besides the specified one being removed. It copies the first part of
			 * myCurve into the first array, and the rest of the array after the Point
			 * being removed into the second array. It then combines the temporaries
			 * back into myCurve.
			 */
			if(p.equals(myCurve[i]))
			{
				int z = myCurve.length-i-1; //length of second temp array
				Point[] tempCurve1 = new Point[i];
				Point[] tempCurve2 = new Point[z];
				
				for(int a=0;a<i;a++)
				{
					tempCurve1[a] = new Point(myCurve[a].getQuantity(),
							myCurve[a].getPrice());
				}
				for(int b=0;b<myCurve.length-i-1;b++)
				{
					tempCurve2[b] = new Point(myCurve[i+b+1].getQuantity(),
							myCurve[i+b+1].getPrice());
				}
				myCurve = new Point[i+z]; //reassign myCurve to include 1 less index
				for(int c=0;c<i;c++)
				{
					myCurve[c] = new Point(tempCurve1[c].getQuantity(),
							tempCurve1[c].getPrice());
				}
				for(int d=i;d<z+i;d++)
				{
					myCurve[d] = new Point(tempCurve2[d-i].getQuantity(),
							tempCurve2[d-i].getPrice());
				}
				return true; //Point removed
			}
		}
		return false; //Point was not removed
	}
	
	/**
	 * This method sorts the ProducerCurve array from highest quantity
	 * value to lowest.
	 */
	private void bubbleSort(Point[] a)
	{
		boolean swapping = true;
		while (swapping)
		{
			swapping = false;
			for(int i=0;i<a.length-1;i++)
			{
				Point t;
				if(a[i].getQuantity()>a[i+1].getQuantity())
				{
					t = a[i];
					a[i] = a[i+1];
					a[i+1] = t;
					swapping = true;
				}
			}
		}
	}
	
	/**
	 * This method converts the ProducerCurve array into a String
	 * of words that can be easily understood by anyone.
	 */
	public String toString()
	{
		String s = "Producer supplies: ";
		for(int i=0;i<myCurve.length;i++)
		{
			s += (myCurve[i].toString()+". ");
		}
		return s;
	}
}
