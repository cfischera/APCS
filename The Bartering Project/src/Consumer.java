/**
 * This Class 
 * @author ColinFischer
 * Date Last Modified: 22 September 2016
 */
public class Consumer
{
	private ConsumerCurve myConsumer;
	private int initialQ;
	private double deltaP;
	private int nPoints;
	private int qTolerance;
	private double pTolerance;
	
	/**
	 * 
	 */
	public Consumer()
	{
		initialQ = 1;
		deltaP = 1;
		nPoints = 10;
		myConsumer = new ConsumerCurve();
	}
	
	/**
	 * 
	 */
	public Consumer(int n, int dx, double b, double dy)
	{
		initialQ = dx;
		deltaP = dy;
		nPoints = n;
		if(dx%2==1)
			qTolerance = (initialQ+1)/2;
		else
			qTolerance = initialQ/2;
		pTolerance = deltaP/2;
		myConsumer = new ConsumerCurve(n, dx, b, dy);
	}
	
	/**
	 * 
	 */
	public Point respondToBid(Point p)
	{
		if((myConsumer.getPoint(p.getQuantity())!=null) && (p.getPrice()<=myConsumer.getPoint(p.getQuantity()).getPrice()))
			return new Point(p.getQuantity(), p.getPrice());
		else
		{
			if(this.getNextPoint(p).getPrice()<p.getPrice())
				return this.getNextPoint(p);
			else
				return this.getNewPointFront(p);
		}
	}
	
	/**
	 * 
	 */
	public int getDx()
	{
		return initialQ;
	}
	
	/**
	 * 
	 */
	public double getDy()
	{
		return deltaP;
	}
	
	/**
	 * 
	 */
	public int getNPoints()
	{
		return nPoints;
	}
	
	/**
	 * 
	 */
	public double getQTolerance()
	{
		return qTolerance;
	}
	
	/**
	 * 
	 */
	private Point getNextPoint(Point p)
	{
		for(int i=getDx();i<=(getDx()*getNPoints());i+=getDx())
		{
			if(i>p.getQuantity())
				return myConsumer.getPoint(i);
		}
		return null;
	}
	
	/**
	 * 
	 */
	private Point getNewPointFront(Point p)
	{
		if(this.getNextPoint(p).getPrice()>p.getPrice())
		{
			return new Point((this.getNextPoint(p).getQuantity()-qTolerance), (this.getNextPoint(p).getPrice()-pTolerance));
		}
		else if(this.getNextPoint(p).getPrice()==p.getPrice())
		{
			return new Point((this.getNextPoint(p).getQuantity()-qTolerance), (this.getNextPoint(p).getPrice()-pTolerance));
		}
		return null;
	}
	
}
