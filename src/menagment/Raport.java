package menagment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import restorant.Product;
import restorant.RProduct;

/****************************************************
 * Klase qe menaxhon raportet
 * @author Ameljo Gjoni
 *
 */


public class Raport 
{
	String path;
	
	public Raport()
	{
		path = new File("").getAbsolutePath();	
		path  += "\\src\\Databases\\";
	}
	
	
	/**********************
	 * Shton produkte ne databasen e raportit
	 * Merr listen e produkteve ne tavoline
	 * @param produkte
	 */
	public void shtoProdukt(ArrayList<Product> produkte)
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM-yyyy");
		File file = new File(path + format.format(date) + ".xlsx");
		
		if(!file.exists())
			new DatabaseCreator().createMonthlyReport();
		
		try 
		{
			FileInputStream readDB = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(readDB);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for(Product produkt : produkte)
			{
				int lastRow = sheet.getLastRowNum();
				Row row = sheet.createRow(lastRow + 1);
				row.createCell(0).setCellValue(produkt.getEmri());
				row.createCell(1).setCellValue(produkt.getSasi());
				row.createCell(2).setCellValue(produkt.getCmimi());
				format = new SimpleDateFormat("dd-MM-yyyy");
				row.createCell(3).setCellValue(format.format(date));
			}
			FileOutputStream writeDB = new FileOutputStream(file);
			workbook.write(writeDB);
			workbook.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	/*****************
	 * Kthen tekstin qe do ti paraqitet perdoruesit 
	 * qe kerkon raportin mujor.
	 * @return
	 */
	public String getRaportMujor()
	{
		ArrayList<RProduct> prod = new Exctrator().getMonthProd();
		Formatter format = new Formatter();
		return format.getRaportFormat(prod);
	}
	
	
	/****************************
	 * Kthen tekstin qe do ti paraqitet perdoruesit qe 
	 * kerkon raportin ditor
	 * @return
	 */
	public String getRaportDitor()
	{
		ArrayList<RProduct> prod = new Exctrator().getMonthProd();
		ArrayList<Product> dita = new ArrayList<Product>();
		for(RProduct product : prod)
		{
			//Merr daten e sotme
			Calendar date = Calendar.getInstance();
			int day = date.get(Calendar.DAY_OF_MONTH);
			//Merr daten nga produkti dhe ndaji. [0] eshte dita
			String[] prodDates = product.getDate().split("-");
			int prodDate = Integer.parseInt(prodDates[0]);
			//krahaso daten e sotme me ate te produktit
			if(day == prodDate)
				dita.add(new Product(product.getEmri(), product.getSasi(), product.getCmimi()));
		}
		
		Formatter format = new Formatter();
		return format.getRaportDitorFormat(dita);
	}
}
