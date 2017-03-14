/**
 * This Class is used to simulate a Market scenario,
 * letting a Producer and Consumer interact to reach
 * an equilibrium and a deal.
 * @author ColinFischer
 * Date Last Modified: 22 September 2016
 */
public class Market
{
	private Producer pro1;
	private Consumer con1;
	private Point    ep1;
	private Point    ep2;
	
	
	/**
	 * This Constructor instantiates the objects to be
	 * utilized in the negotiation sequence.
	 */
	public Market()
	{
		pro1 = new Producer();
		con1 = new Consumer();
		ep1  = new Point();
		ep2  = new Point();
	}
	
	/**
	 * This main method tests the base case of a Producer
	 * and Consumer reaching equilibrium.
	 */
	public static void main(String[] args)
	{
		Market m = new Market();
		m.negotiate();
	}
	
	/**
	 * This method compares the Point objects of a
	 * Producer and a Consumer to reach - or discover the
	 * absence of - an equilibrium.
	 */
	public void negotiate()
	{
		int oscCounter = 0;
		System.out.println();
		try
		{
			ep1 = pro1.initialBid();
			System.out.println("Producer suggests "+ep1);
			ep2 = con1.respondToBid(ep1);
			System.out.println("Consumer offers "+ep2);
			System.out.println();
			while(!(ep1.equals(ep2)))
			{
				ep1=pro1.respondToBid(ep2);
				System.out.println("Producer suggests "+ep1);
				ep2=con1.respondToBid(ep1);
				System.out.println("Consumer offers "+ep2);
				System.out.println();
				oscCounter++;
				if(oscCounter>pro1.getNPoints()&&
						oscCounter>con1.getNPoints())
				{
					Point eqPoint = new Point(
							((ep1.getQuantity()+ep2.getQuantity())/2),
							((ep1.getPrice()+ep2.getPrice())/2));
					ep1 = eqPoint;
					ep2 = eqPoint;
				}
			}
			System.out.println("Equilibrium found at: "+ep1);
		}
		catch(NullPointerException e)
		{
			System.out.println("Equilibrium could not be found");
		}
	}
}
