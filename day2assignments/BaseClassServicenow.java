package week5.day2assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServicenow {
	public ChromeDriver driver;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String username, String password) {
		// Instance URL: https://dev88879.service-now.com
		// Username: admin
		// Password: Divya$1989
		// Step1: Load ServiceNow application URL given above
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Step2: Enter username as admin
		WebElement frame1 = driver.findElementByXPath("//iframe[@id='gsft_main']"); // Identifying the frame using
																					// //iframe
		driver.switchTo().frame(frame1); // In frame there are 3 ways - chosen 3rd method webelement locator
		driver.findElementById("user_name").sendKeys(username);

		// Step3: Enter password as Divya$1989
		driver.findElementById("user_password").sendKeys(password);

		// Step4: Click Login
		driver.findElementById("sysverb_login").click();
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
