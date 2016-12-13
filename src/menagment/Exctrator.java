package menagment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import restorant.Table;

public class Exctrator 
{
	private String path;
	
	public Exctrator()
	{
		path  = new File("").getAbsolutePath();
		path += "//src//Databases";
	}
	
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
}
