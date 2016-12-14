package restorant;

import java.util.ArrayList;
/*********************************
 * Klasa e porosis
 * Porosia do te kete nje liste me produkte
 * Do te jete ne gjendje te ktheje keto produkte, te shtoje,
 * te heqe dhe te jape cmimin e tyre.
 * 
 * 
 * @author Ameljo Gjoni
 *
 */
public class Order 
{
	ArrayList<Product> produktet;
	
	public Order()
	{
		produktet = new ArrayList<Product>();
	}
	
	public ArrayList<Product> getProducts()
	{
		return this.produktet;
	}
	
	public float getCmimi()
	{
		float shuma = 0;
		
		for(int i = 0; i < produktet.size(); i++)
		{
			shuma += produktet.get(i).getCmimi() * produktet.get(i).getSasi();
		}
		return shuma;
	}
	
	public void printoProdukte()
	{
		for(int i = 0; i < produktet.size(); i++)
		{
			System.out.println(produktet.get(i).getEmri() + " -- " + produktet.get(i).getSasi());
		}
	}
	
	public void addOrder(Product produkt)
	{
		if(produkt != null)
			this.produktet.add(produkt);
	}
	
	public void removeOrder(String name)
	{
		for (int i = 0; i < produktet.size(); i++)
		{
			if (produktet.get(i).getEmri() == name)
			{
				produktet.remove(i);
			}
		}
	}
}
