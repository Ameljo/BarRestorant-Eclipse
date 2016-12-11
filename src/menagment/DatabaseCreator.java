package menagment;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;


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
			System.out.print("Could not create database");
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
			System.out.print("sukses!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not find file to write!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not write database!");
		}
		
	}
	
	public void createTableDatabase()
	{
		File file = createFile("TableDatabase");
		if (file == null)
		{
			System.out.println("Could not create database!");
			return;
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet();
		
		try
		{
			FileOutputStream writeDatabase = new FileOutputStream(file);
			workbook.write(writeDatabase);
			System.out.println("Sukses!!!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Could not find file to write!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not write database!");
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
	      XSSFCellStyle style = workbook.createCellStyle();
	      if (row == null)
	          row = sheet.createRow(0);
	      Cell cell;
	      //Resize columns
	      sheet.setColumnWidth(0, 7000);
	      sheet.setColumnWidth(1, 7000);
	   
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
	    XSSFCellStyle style = workbook.createCellStyle();
	    if (row == null)
	        row = sheet.createRow(0);
	    Cell cell;
	    //Resize columns
	    sheet.setColumnWidth(0, 3000);
	 
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
	    cell = row.createCell(0);
	    cell.setCellStyle(style);
	    cell.setCellValue("Numri");
	}
}