package week5.day1assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicenowAssignIncident extends BaseClassServicenow {

	@Test
	public void assignIncident() throws InterruptedException {
		// Instance URL: https://dev88879.service-now.com
		// Username: admin
		// Password: Divya$1989
		// Step1: Load ServiceNow application URL given above
		// Step2: Enter username as admin
		// Step3: Enter password as Divya$1989
		// Step4: Click Login
		// All the above steps are moved to BaseClassServicenow as a precondition

		// Step5: Search “incident “ Filter Navigator
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident");

		// Step6: click on open and Search for the existing incident and click on the
		// incident
		driver.findElementByXPath("(//div[contains(text(),'Open') and @class='sn-widget-list-title'])[1]").click();
		WebElement frame2 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@class='linked formlink'])[2]").click();

		// Step7: Assign the incident to Software group
		driver.findElementById("lookup.incident.assignment_group").click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		Thread.sleep(2000);
		WebElement searchbar = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		searchbar.sendKeys("software");
		searchbar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();

		// Step8: Update the incident with Work Notes
		driver.switchTo().window(windowHandlesList.get(0));
		WebElement frame3 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame3);
		driver.findElementById("activity-stream-textarea").sendKeys("Updating the Assignment group");
		driver.findElementById("sysverb_update").click();

		// Step9: Verify the Assignment group and Assigned for the incident

		String assigngroup = driver.findElementByXPath("(//a[@class='linked'])[4]").getText();
		System.out.println("The Assignment group is " + assigngroup);

	}

}
