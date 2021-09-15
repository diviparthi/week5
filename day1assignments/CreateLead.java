package week5.day1assignments;



import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class CreateLead extends BaseClass{

	@Test
	public void runCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS"); 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Divi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Parthi");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("0481444");
		driver.findElement(By.name("submitButton")).click();

	}
}






