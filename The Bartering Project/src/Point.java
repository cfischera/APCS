/**
 * This Class constructs a Point object that will
 * be the most basic component of a larger bartering
 * experiment.
 * @author ColinFischer
 * Date Last Modified: 28 August 2016
 */
public class Point
{
	private int    	      	   quantity;
	private double 		  	   price;
	public static final double MARGIN = 0.005; 
	
	
	/**
	 * This Constructor creates an original Point object 
	 * with default quantity and price values of (0, 0) 
	 * when no parameters are passed.
	 */
	public Point()
	{
		this.quantity = 0;
		this.price	  = 0;
	}
	
	
	/**
	 * This Constructor creates a Point object with quantity and 
	 * price values according to the parameters (q, p) passed.
	 */
	public Point(int q, double p)
	{
		this.quantity = q;
		this.price 	  = p;
	}
	
	
	/**
	 * This method returns the quantity variable of a Point.
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	
	/**
	 * This method returns the price variable of a Point.
	 */
	public double getPrice()
	{
		return price;
	}
	
	
	/**
	 * This method overloads the default equals() method
	 * in the Object.java Class. It compares two Point 
	 * objects to check for equivalent quantity and price values.
	 */
	public boolean equals(Point otherPoint)
	{
		
		/*
		 * Comparison checks to see if quantity variables are
		 * equivalent, then checks if the difference in price variables
		 * is less than the equality margin 
		 * - five thousandth's of a dollar (half of a cent).
		 */
		return(this.quantity == otherPoint.quantity 
				&& Math.abs(this.price - otherPoint.price) 
				< MARGIN);
	}
	
	
	/**
	 * This method overrides the default equals() method in the
	 * Object.java Class. It casts a passed object into a Point,
	 * then runs it through the previous equals() method.
	 */
	public boolean equals(Object otherObject)
	{
		otherObject = (Point) otherObject; // cast object to a Point
		return(this.equals(otherObject));  
			// send to equals() method with Point parameter
	}
	
	
	/**
	 * This method converts a Point object into a String of words
	 * that can be easily understood by anyone.
	 */
	public String toString()
	{
		double p = this.toDollars(this.price);
		return (this.quantity + " units for $" + p + " each");
	}
	
	
	/**
	 * This method rounds the price variable to the hundreth's place
	 * so it can be evaluated as a real world price in USD.
	 */
	private double toDollars(double p)
	{
		p  = Math.round(p*100); // returns nearest integer with 2 decimals
		p /= 100; 	            // converts decimal places back
		return p;
	}
}