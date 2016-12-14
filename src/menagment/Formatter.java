package menagment;

import java.util.ArrayList;

import restorant.Product;
import restorant.RProduct;

/*********************************************
 *Klase qe ka funksionet qe perdoren per te 
 *formatuar tekstin qe do te printohet ne 
 *formen e fatures 
 *
 * @author Ameljo Gjoni
 *
 */

public class Formatter 
{

	
	/*********************
	 * Krijon formatin e fatures te nje tavoline
	 * Merr listen e produkteve qe ka tavolina
	 * Ameljo Gjoni
	 * @param produkte
	 * @return
	 */
	public String getFaturFormat(ArrayList<Product> produkte)
	{
		String temp = "Fature\n\n\n" + "Produkti\t\t" + "Cmimi\n";
		double shuma = 0;
		for(int i = 0; i < produkte.size(); i++)
		{
			temp += "\n";
			temp += produkte.get(i).getEmri() + "\t\t" + produkte.get(i).getCmimi();
			shuma += produkte.get(i).getCmimi();
		}
		temp += "\n---------------------------------------------------------------\n";
		temp += "Totali\t\t" + shuma;
		return temp;
	}
	
	
	/******************
	 * Krijon formatin e raportit mujor
	 * Merr listen mujore te produkteve
	 * @param produkte
	 * @return
	 */
	public String getRaportFormat(ArrayList<RProduct> produkte)
	{
		String temp = "Raporti Mujor\n\n\n" + "Produkti\t" + "Cmimi\t" + "Data\n";
		double shuma = 0;
		for(int i = 0; i < produkte.size(); i++)
		{
			temp += "\n";
			temp += produkte.get(i).getEmri() + "\t" + produkte.get(i).getCmimi() + "\t" + produkte.get(i).getDate();
			shuma += produkte.get(i).getCmimi();
		}
		temp += "\n---------------------------------------------------------------\n";
		temp += "Totali\t\t" + shuma;
		return temp;
	}
	
	
	
	/********************************
	 * Krijon formatin e raportit ditor.
	 * Merr listen e ditore te produkteve. 
	 *
	 * @param produkte
	 * @return
	 */
	public String getRaportDitorFormat(ArrayList<Product> produkte)
	{
		String temp = "Raporti Mujor\n\n\n" + "Produkti\t\t" + "Cmimi\t";
		double shuma = 0;
		for(int i = 0; i < produkte.size(); i++)
		{
			temp += "\n";
			temp += produkte.get(i).getEmri() + "\t\t" + produkte.get(i).getCmimi();
			shuma += produkte.get(i).getCmimi();
		}
		temp += "\n---------------------------------------------------------------\n";
		temp += "Totali\t\t" + shuma;
		return temp;
	}
}
