package week5.day1assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./Data/CreateLead.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);
		int cellCount = ws.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		for (int i = 1; i <=rowCount; i++) //i=0 - gives including header as output or i=1 gives without header
		{
			for (int j = 0; j < cellCount; j++) 
			{
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
			}
			
		}
		wb.close();
	}

}
