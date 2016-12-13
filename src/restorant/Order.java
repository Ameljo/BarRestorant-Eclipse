package restorant;

import java.util.ArrayList;

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
		this.produktet.add(produkt);
	}
}
