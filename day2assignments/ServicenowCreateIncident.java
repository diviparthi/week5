package week5.day2assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServicenowCreateIncident extends BaseClassServicenow {
	
	@Test(dataProvider="sendDataServicenow")
	public void createIncident(String description) throws InterruptedException, IOException {

		// Instance URL: https://dev88879.service-now.com
		// Username: admin
		// Password: Divya$1989
		// Step1: Load ServiceNow application URL given above
		// Step2: Enter username as admin
		// Step3: Enter password as Divya$1989
		// Step4: Click Login
		//All the above steps are moved to BaseClassServicenow as a precondition

		// Step5: Search “incident “ Filter Navigator
	
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident");

		// Step6: Click “All”
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='All'])[2]").click();

		// Step7: Click New button
		WebElement frame2 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame2);
		driver.findElementByXPath("//button[@id='sysverb_new']").click();

		// Step8: Select a value for Caller and Enter value for short_description
		driver.findElementById("lookup.incident.caller_id").click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println(driver.getTitle());
		System.out.println("The number of windows is " + windowHandlesList.size());
		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.switchTo().frame(frame2);
		driver.findElementById("incident.short_description").sendKeys(description);

		// Step9: Read the incident number and save it a variable
		String incidentnumber = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
		System.out.println("The Incident number is " + incidentnumber);

		// Step10: Click on Submit button
		driver.findElementById("sysverb_insert").click();

		// Step 11: Search the same incident number in the next search screen as below
		WebElement searchtext = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchtext.sendKeys(incidentnumber);
		searchtext.sendKeys(Keys.ENTER);

		// Step12: Verify the incident is created successful
		String resultincident = driver.findElementByXPath("//a[@class='linked formlink']").getText();
		if (incidentnumber.equalsIgnoreCase(resultincident)) {
			System.out.println("Incident created is successful");
		} else {
			System.out.println("Incident created is not successful");
		}
		System.out.println(driver.getTitle());

        //Step 13: Snapshot of created incident
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/incident.png");
		FileUtils.copyFile(src1, dst);
		
	}
	@DataProvider
	public String[][] sendDataServicenow() throws IOException {
		return ReadExcelServicenow.readDataServicenow("Sheet1");
	}

}
