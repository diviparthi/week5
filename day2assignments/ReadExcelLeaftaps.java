package week5.day2assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelLeaftaps {

	public static String[][] readDataLeaftaps(String fileName) throws IOException {

		XSSFWorkbook wb= new XSSFWorkbook("./Data/Leaftaps.xlsx");
		XSSFSheet ws = wb.getSheet(fileName);
		int rowCount = ws.getLastRowNum();
		System.out.println("Number of rows is " + rowCount);
		int cellCount = ws.getRow(0).getLastCellNum();
		System.out.println("Number of cells is " + cellCount);
		String [][] data = new String[rowCount][cellCount];
		for (int i = 1; i <=rowCount; i++)
		{
			for (int j = 0; j < cellCount; j++)
			{
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}
			
		}
		wb.close();
		return data;
	}

}
