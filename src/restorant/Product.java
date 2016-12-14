package restorant;

/************************************
 * Klasa e produkteve
 * 
 * @author Ameljo Gjoni
 *
 */

public class Product 
{
	private String emri;
	private int sasi;
	private double cmimi;
	
	public Product(String emri, int sasi, double cmim)
	{
		this.emri = emri;
		this.sasi = sasi;
		this.cmimi = cmim;
	}
	
	public String getEmri()
	{
		return this.emri;
	}
	
	public int getSasi()
	{
		return this.sasi;
	}
	
	public double getCmimi()
	{
		return this.cmimi;
	}
}
