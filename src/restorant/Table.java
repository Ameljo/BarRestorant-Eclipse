package restorant;


/***************************
 * Klasa e tavolinave
 * Tavolina do te kete nje porosi dhe nje emer.
 * Gjithashtu nje boolean qe tregon nese eshte e zene
 * 
 * @author Ameljo Gjoni
 *
 */
public class Table 
{
	Order porosi;
	boolean eZene;
	int numer;
	
	public Table(int numer)
	{
		eZene = false;
		this.numer = numer;
		porosi = new Order();
	}
	
	public Order getOrder()
	{
		return porosi;
	}
	
	/****************
	 * Funksion i mbingarkuar per marrjen e porosise
	 * Njeri merr si parameter nje objekt produkt
	 * Tjetri merr tiparet e objektit produkt edhe krijon ate
	 * 
	 * 
	 * Ameljo Gjoni
	 */
	public void merrPorosi(String prodEmri, int sasi, float cmimi)
	{
		if(porosi == null)
			porosi = new Order();
		porosi.addOrder(new Product(prodEmri, sasi, cmimi));
	}
	
	public void merrPorosi(Product product)
	{
		if(product != null)
			porosi.addOrder(product);
	}
	
	public int getNumer()
	{
		return numer;
	}
	
	public void nxirrFatur()
	{
		porosi.printoProdukte();
		System.out.print(porosi.getCmimi());
	}
	
	public void removeOrder(String name)
	{
		porosi.removeOrder(name);
	}
	
	
	/******************
	 * Liron Tavolinen
	 * 
	 * Ameljo Gjoni
	 */
	public void pastroTavoline()
	{
		porosi = null;
		eZene = false;
	}
}
