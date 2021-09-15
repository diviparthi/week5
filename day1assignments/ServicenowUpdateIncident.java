package week5.day1assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicenowUpdateIncident extends BaseClassServicenow {
	@Test
	public void updateIncident() throws InterruptedException {
		// Instance URL: https://dev88879.service-now.com
		// Username: admin
		// Password: Divya$1989
		// Step1: Load ServiceNow application URL given above
		// Step2: Enter username as admin
		// Step3: Enter password as Divya$1989
		// Step4: Click Login
		// All the above steps are moved to BaseClassServicenow as a precondition

		// Step5: Search “incident “ Filter Navigator. Then Click All
		Thread.sleep(2000);
		WebElement filternav = driver.findElementByXPath("//input[@id='filter']");
		filternav.sendKeys("Incident");
		Thread.sleep(2000);
		filternav.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='All'])[2]").click();

		// Step6: Search for the existing incident and click on the incident
		WebElement frame2 = driver.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		WebElement searchbox = driver
				.findElementByXPath("//span[@class='input-group-addon input-group-select']/following-sibling::input");
		searchbox.sendKeys("INC0000020");
		searchbox.sendKeys(Keys.ENTER);
		driver.findElementByXPath("//a[@class='linked formlink']").click();

		// Step7: Update the incidents with Urgency as High and State as In Progress
		WebElement urgencydrop1 = driver.findElementByXPath("//select[@id='incident.urgency']");
		Select drpdwn1 = new Select(urgencydrop1);
		drpdwn1.selectByVisibleText("1 - High");
		WebElement statedrop = driver.findElementById("incident.state");
		Select drpdwn2 = new Select(statedrop);
		drpdwn2.selectByIndex(1);
		driver.findElementById("sysverb_update").click();

		// Step8: Verify the priority and state
		String prioritytext = driver.findElementByXPath("(//table)[2]//tbody//td[7]").getText();
		System.out.println("The Priority of the incident is " + prioritytext);
		if (prioritytext.equalsIgnoreCase("3 - Moderate")) {
			System.out.println("Priority is verified");
		} else {
			System.out.println("Priority is not verified");
		}
		String statetext = driver.findElementByXPath("(//table)[2]//tbody//td[8]").getText();
		System.out.println("The State of the incident is " + statetext);
		if (statetext.equalsIgnoreCase("In Progress")) {
			System.out.println("State is verified");
		} else {
			System.out.println("State is not verified");
		}

	}

}
