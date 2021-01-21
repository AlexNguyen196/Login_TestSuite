package LoginSuite;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_005_WrongEmail {

	WebDriver driver;

	@Before 
	public void SetUp()	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://anotepad.com/");
	}

	@Test
	public void Login() {
		// login button
		driver.findElement(By.linkText("Register/Login")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		// input username
		driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("viet@gmail.com");
		// input pwd
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]")).sendKeys("abcd1234");
		// remember me
		driver.findElement(By.xpath("body/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/label[1]")).click();
		

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		// click Login btn
		driver.findElement(By.id("submit")).click();

		
		//compare text after login fail
		String expectedMSg = "Email and password do not match";
		String actualMsg = driver.findElement(By.xpath("//strong[contains(text(),'Email and password do not match')]")).getText();
		Assert.assertEquals(expectedMSg, actualMsg);
	}

	@After
	public void tearDown()	{
		driver.close();
	}
}

