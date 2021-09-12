package week5.day1assignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{

	@Test(dataProvider="sendData")   //we have to create connectivity for @Test and dataprovider
	public void runCreateLead(String fname, String lname, String companyname, String phno) { //args passed order shud be same as sendData method order
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname); //args passed
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
}
	@DataProvider
	public String[][] sendData() {

		String [] [] data = new String [2][4];
		data[0][0] = "Divya";
		data[0][1] = "Parthiban";
		data[0][2] = "TCS";
		data[0][3] = "40107166";
		
		data[1][0] = "Kannan";
		data[1][1] = "Selvam";
		data[1][2] = "Optus";
		data[1][3] = "4261554";
		
		return data;
	}
}






