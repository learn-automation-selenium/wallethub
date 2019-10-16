package test.selenium.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.CommonUtils;
import test.selenium.objectrepository.RediffHomePage;

public class RediffTestCase extends CommonUtils{
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void launchBrowser() {
		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	}
	
	@Test
	public void testRediff() {
		
		new RediffHomePage(driver)
			.clickSignIn()
			.enterUserName("This is my username")
			.enterPassword("This is my password")
			.selectRememberMe()
			.clickLogin()
			.clickHomePageLink();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000L);
		driver.close();
	}
}
