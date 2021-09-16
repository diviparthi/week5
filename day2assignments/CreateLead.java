package week5.day2assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClassLeaftaps{
	@Test(dataProvider = "sendDataLeaftaps")
	public void runCreateLead(String first,String last,String company, String phno) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company); 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(first);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(last);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
}
	@DataProvider
	public String[][] sendDataLeaftaps() throws IOException 
	{

		return ReadExcelLeaftaps.readDataLeaftaps("Sheet1");
	}
}
