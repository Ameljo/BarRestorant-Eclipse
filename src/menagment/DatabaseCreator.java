package menagment;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

/*********************************
 * Klasa qe permbajne funksionet te cilet krijojne Database te ndryshme
 * 
 * 
 * @author Ameljo Gjoni
 *
 */
public class DatabaseCreator 
{
	private String path; //Path for relative path
	
	public DatabaseCreator()
	{
		path = new File("").getAbsolutePath(); // get project path
	}
	
	
	/*********
	 * Funksion per krijimin e database te kamariereve
	 * Ameljo Gjoni
	 */
	public void createWaiterDatabase()
	{
		File file = createFile("WaiterDatabase");
		if(file == null)
		{
			System.out.print("Could not create WaiterDatabase");
			return; //ndal funksionin nese nuk mund te krijohet file
		}
		///test
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		try 
		{
			// Stilo dhe shkruaj database
			FileOutputStream writeDatabase = new FileOutputStream(file);
			styleWaiter(workbook);
			workbook.write(writeDatabase);
			writeDatabase.close();
			System.out.println("Sukses WaiterDatabase!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not find WaiterDatabase to write!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write WaiterDatabase!");
		}
		
	}
	
	public void createTableDatabase()
	{
		File file = createFile("TableDatabase");
		if (file == null)
		{
			System.out.println("Could not create TableDatabase!");
			return;
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		
		try
		{
			FileOutputStream writeDatabase = new FileOutputStream(file);
			styleTables(workbook);
			workbook.write(writeDatabase);
			System.out.println("Sukses TableDatabase!!!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Could not find TableDatabase to write!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not write TableDatabase!");
		}
	}
	
	public void createDepoDatabase()
	{
		File file = createFile("DepoDatabase");
		if (file == null)
		{
			System.out.println("Could not create DepoDatabase!!!");
			return; 
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		try
		{
			FileOutputStream writeDatabase = new FileOutputStream(file);
			styleDepo(workbook);
			workbook.write(writeDatabase);
			System.out.println("Sukses DepoDatabase!!!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Could not find file DepoDatabase to write!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not write DepoDatabase!");
		}
	}
	
	public void createMonthlyReport()
	{
		//Merr daten e sotme
		Date date = new Date();
		//Formato daten e forme stringu (Muaji-1999)
		SimpleDateFormat format = new SimpleDateFormat("MMMM-yyyy");
		//Vendos daten si emer te raportit
		File file = createFile(format.format(date));
		if(file == null)
		{
			System.out.println("Could not create MonthlyReport");
			return;
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		
		try
		{
			FileOutputStream writeDatabase = new FileOutputStream(file);
			styleMonthlyReport(workbook);
			workbook.write(writeDatabase);
			System.out.println("Sukses MonthlyReport!!!");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Could not find MonthlyReport");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not find MonthlyReport");
		}
	}
	
	/***
	 * Funksion per krijimin e nje file qe do te kthehet ne database
	 * @param name emri i file
	 * @return return null nese nuk krijohet ose File nese krijohet me 
	 * sukses
	 * 
	 * Ameljo Gjoni
	 */
	private File createFile(String name)
	{
		// parse path ku do te krijohet file, emri plus extension i dokumentit excel
		File file = new File(path + "\\src\\Databases\\" + name + ".xlsx");
		try {
			file.createNewFile(); 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not create database");
			return null;
		}
		
		return file;
	}
	
	
	/******************
	 * Funksion ndihmes per stilimin e database
	 * 
	 * @param workbook
	 * Ameljo Gjoni
	 */
	private XSSFCellStyle createStyle(XSSFWorkbook workbook)
	{
		  XSSFCellStyle style = workbook.createCellStyle();
	      //color and name first cells;
	      style.setFillForegroundColor(new XSSFColor(Color.YELLOW));
	      style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	      style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	      style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	      style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
	      style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
	      style.setBorderRight(XSSFCellStyle.BORDER_THIN);
	      style.setRightBorderColor(IndexedColors.BLUE.getIndex());
	      style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM_DASHED);
	      style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	      
	      return style;
	}
	
	private void styleDepo(XSSFWorkbook workbook)
	{
		XSSFSheet sheet = workbook.getSheetAt(0);
	      Row row = sheet.getRow(0);
	      XSSFCellStyle style = createStyle(workbook);
	      if (row == null)
	          row = sheet.createRow(0);
	      Cell cell;
	      //Resize columns
	      sheet.setColumnWidth(0, 7000);
	      sheet.setColumnWidth(1, 7000);
	      sheet.setColumnWidth(2, 7000);
	   
	      cell = row.createCell(0);
	      cell.setCellStyle(style);
	      cell.setCellValue("Produkti");
	      cell = row.createCell(1);
	      cell.setCellStyle(style);
	      cell.setCellValue("Sasia");
	      cell = row.createCell(2);
	      cell.setCellStyle(style);
	      cell.setCellValue("Cmimi");
	}
	
	private void styleMonthlyReport(XSSFWorkbook workbook)
	{
		XSSFSheet sheet = workbook.getSheetAt(0);
	      Row row = sheet.getRow(0);
	      XSSFCellStyle style = createStyle(workbook);
	      if (row == null)
	          row = sheet.createRow(0);
	      Cell cell;
	      //Resize columns
	      sheet.setColumnWidth(0, 7000);
	      sheet.setColumnWidth(1, 7000);
	      sheet.setColumnWidth(2, 7000);
	      sheet.setColumnWidth(3, 9000);
	      sheet.setColumnWidth(4, 14000);

	      cell = row.createCell(0);
	      cell.setCellStyle(style);
	      cell.setCellValue("Produkti");
	      cell = row.createCell(1);
	      cell.setCellStyle(style);
	      cell.setCellValue("Cmimi");
	      cell = row.createCell(2);
	      cell.setCellStyle(style);
	      cell.setCellValue("Sasia");
	      cell = row.createCell(3);
	      cell.setCellStyle(style);
	      cell.setCellValue("Data");
	      cell = row.createCell(4);
	      cell.setCellStyle(style);
	      cell.setCellValue("Kamarieri");
	}
	
	
	/*******
	 * Funksion ndihmes per stilim 
	 * @param workbook database qe do te stilohet
	 * 
	 * Ameljo Gjoni
	 */
	private void styleWaiter(XSSFWorkbook workbook)
	{
		  XSSFSheet sheet = workbook.getSheetAt(0);
	      Row row = sheet.getRow(0);
	      XSSFCellStyle style = createStyle(workbook);
	      if (row == null)
	          row = sheet.createRow(0);
	      Cell cell;
	      //Resize columns
	      sheet.setColumnWidth(0, 7000);
	      sheet.setColumnWidth(1, 7000);
	   
	      cell = row.createCell(0);
	      cell.setCellStyle(style);
	      cell.setCellValue("Emri");
	      cell = row.createCell(1);
	      cell.setCellStyle(style);
	      cell.setCellValue("Mbiemri");
	}
	

	private void styleTables(XSSFWorkbook workbook)
	{
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
	    XSSFCellStyle style = createStyle(workbook);
	    if (row == null)
	        row = sheet.createRow(0);
	    Cell cell;
	    //Resize columns
	    sheet.setColumnWidth(0, 3000);
	 
	    cell = row.createCell(0);
	    cell.setCellStyle(style);
	    cell.setCellValue("Numri");
	}
}