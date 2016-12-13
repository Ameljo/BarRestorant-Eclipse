package restorant;

public class Product 
{
	private String emri;
	private int sasi;
	private float cmimi;
	
	public Product(String emri, int sasi, float cmimi)
	{
		this.emri = emri;
		this.sasi = sasi;
		this.cmimi = cmimi;
	}
	
	public String getEmri()
	{
		return this.emri;
	}
	
	public int getSasi()
	{
		return this.sasi;
	}
	
	public float getCmimi()
	{
		return this.cmimi;
	}
}
