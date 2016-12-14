package menagment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import restorant.Product;
import restorant.RProduct;
import restorant.Table;


/***********************************************
 * Klase qe ka funksionet qe perdoren per te terhequr te dhena 
 * nga database-t e ndryshme.
 * @author Ameljo Gjoni
 *
 */

public class Exctrator 
{
	private String path;
	
	public Exctrator()
	{
		path  = new File("").getAbsolutePath();
		path += "//src//Databases";
	}
	
	
	/***************
	 * Kthen listen e Tavolinave
	 * 
	 * Ameljo Gjoni
	 * @return
	 */
	public ArrayList<Table> getTables()
	{
		ArrayList<Table> temp = new ArrayList<Table>();
		File  file = new File(path + "//TableDatabase.xlsx");
		XSSFWorkbook workbook = null;
		try 
		{
			workbook = new XSSFWorkbook(file);
			
		} catch (InvalidFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		
		if(workbook == null)
			return null;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
				int rowStart = 1;
				int rowLast = sheet.getLastRowNum();
				
				for(int i = rowStart; i < rowLast; i++)
				{
					Row row = sheet.getRow(i);
					if(row == null)
						continue;
					Cell cell = row.getCell(0);
					temp.add(new Table((int) cell.getNumericCellValue()));
				}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	/**************
	 * Kthen produktet qe gjenden ne magazine
	 * 
	 * Ameljo Gjoni
	 * @return
	 */
	public ArrayList<Product> getProducts()
	{
		ArrayList<Product> temp = new ArrayList<Product>();
		File  file = new File(path + "//DepoDatabase.xlsx");
		XSSFWorkbook workbook = null;
		try 
		{
			workbook = new XSSFWorkbook(file);
			
		} catch (InvalidFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		
		if(workbook == null)
			return null;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
				int rowStart = 1;
				int rowLast = sheet.getLastRowNum();
				for(int i = rowStart; i <= rowLast; i++)
				{
					Row row = sheet.getRow(i);
					if(row == null)
						continue;
					Cell cell = row.getCell(0);
					String name = cell.getStringCellValue();
					cell = row.getCell(1);
					int sasi = (int) cell.getNumericCellValue();
					cell = row.getCell(2);
					double cmim = cell.getNumericCellValue();
					temp.add(new Product(name, sasi, cmim));
				}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	/**********************************************
	 * Kthen produktete nga nje raport mujor
	 * 
	 * Ameljo Gjoni
	 * @return
	 */
	public ArrayList<RProduct> getMonthProd()
	{
		//Merr daten e sotme per te kontrolluar se raporti nuk eshte i vjetersuar
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM-yyyy");
		File file = new File(path + "\\" + format.format(date) + ".xlsx");
		
		//Krijo nje raport te ri nese eshte i vjetersuar
		if(!file.exists())
			new DatabaseCreator().createMonthlyReport();
		
		ArrayList<RProduct> temp = new ArrayList<RProduct>();
		XSSFWorkbook workbook = null;
		try 
		{
			workbook = new XSSFWorkbook(file);
			
		} catch (InvalidFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		
		if(workbook == null)
			return null;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Merr rreshtin ne te cilin do te filloje leximi
		int rowStart = 1;
		//Merr rreshtin ne cilin do te mbaroje leximi
		int rowLast = sheet.getLastRowNum();
		for(int i = rowStart; i <= rowLast; i++)
				{
					//Lexo Informacionin
					Row row = sheet.getRow(i);
					if(row == null)
						continue;
					Cell cell = row.getCell(0);
					String name = cell.getStringCellValue();
					cell = row.getCell(1);
					int sasi = (int) cell.getNumericCellValue();
					cell = row.getCell(2);
					double cmim = cell.getNumericCellValue();
					cell = row.getCell(3);
					String dt = cell.getStringCellValue();
					temp.add(new RProduct(name, sasi, cmim, dt));
				}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
