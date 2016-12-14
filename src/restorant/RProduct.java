package restorant;

/*********************************
 * RProduct perdor trashigimine per te zgjeruar produktin
 * RProduct perdoret ne raporte ne te cilin duhet data
 * ne te cilin u shit.
 * 
 * @author Ameljo Gjoni
 *
 */

public class RProduct extends Product
{
	String date;
	public RProduct(String name, int sasi, double cmimi, String date)
	{
		super(name, sasi, cmimi);
		this.date = date;
	}
	
	public String getDate()
	{
		return date;
	}
}
