package restorant;

public class Table 
{
	Order porosi;
	boolean eZene;
	int numer;
	
	public Table(int numer)
	{
		eZene = false;
		this.numer = numer;
	}
	
	public void merrPorosi(String prodEmri, int sasi, float cmimi)
	{
		if(porosi == null)
			porosi = new Order();
		porosi.addOrder(new Product(prodEmri, sasi, cmimi));
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
	
	public void pastroTavoline()
	{
		porosi = null;
		eZene = false;
	}
}
