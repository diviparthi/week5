package week5.day2assignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ServicenowDeleteIncident extends BaseClassServicenow {

	@Test
	public void deleteIncident() throws InterruptedException {
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
		WebElement frame2 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		String incidentno = driver.findElementByXPath("(//a[@class='linked formlink'])[1]").getText();
		System.out.println("The Incident number that is going to be deleted is " + incidentno);
		driver.findElementByXPath("(//a[@class='linked formlink'])[1]").click();
		driver.findElementById("sysverb_delete").click();
		driver.findElementById("ok_button").click();
		//WebElement frame3 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		//driver.switchTo().frame(frame3);
		//WebElement searchbox = driver.findElementByXPath("//span[@class='input-group-addon input-group-select']/following-sibling::input");
		WebElement searchbox = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchbox.sendKeys(incidentno);
		searchbox.sendKeys(Keys.ENTER);
		String searchresults = driver.findElementByXPath("(//table)[2]/tbody//td").getText();
		System.out.println("On searching for the deleted incident no it shows " + searchresults);
		if (searchresults.equalsIgnoreCase("No records to display")) {
			System.out.println("Confirming that incident is deleted");
		}
		else {
			System.out.println("Confirming that incident is not deleted");
		}
	
	}

}
