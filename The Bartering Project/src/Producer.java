/**
 * Summary
 * @author ColinFischer
 * Date Last Modified: 22 September 2016
 */
public class Producer
{
	private ProducerCurve myProducer;
	private int initialQ;
	private double deltaP;
	private int nPoints;
	private int qTolerance;
	private double pTolerance;
	
	/**
	 * 
	 */
	public Producer()
	{
		initialQ = 1;
		deltaP = 1;
		nPoints = 10;
		myProducer = new ProducerCurve();
	}
	
	/**
	 * 
	 */
	public Producer(int n, int dx, double b, double dy)
	{
		initialQ = dx;
		deltaP = dy;
		nPoints = n;
		if(dx%2==1)
			qTolerance = (initialQ+1)/2;
		else
			qTolerance = initialQ/2;
		pTolerance = deltaP/2;
		myProducer = new ProducerCurve(n, dx, b, dy);
	}
		
	/**
	 * 
	 */
	public Point respondToBid(Point p)
	{
		if((myProducer.getPoint(p.getQuantity())!=null) && (p.getPrice()>=myProducer.getPoint(p.getQuantity()).getPrice()))
			return new Point(p.getQuantity(), p.getPrice());
		else
		{
			if(this.getNextPoint(p).getPrice()>p.getPrice())
				return this.getNextPoint(p);
			else
				return this.getNewPoint(p);
		}
	}
	
	/**
	 * 
	 */
	public Point initialBid()
	{
		return myProducer.getPoint(this.getDx());
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
	private int getDx()
	{
		return initialQ;
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
	private Point getNextPoint(Point p)
	{
		for(int i=getDx();i<=(getDx()*getNPoints());i+=getDx())
		{
			if(i>p.getQuantity())
				return myProducer.getPoint(i);
		}
		return null;
	}
	
	/**
	 * 
	 */
	private Point getNewPoint(Point p)
	{
		if(this.getNextPoint(p).getPrice()<p.getPrice())
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
