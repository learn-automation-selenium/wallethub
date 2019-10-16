package test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.CommonUtils;

public class CheckboxTest extends CommonUtils{

	WebDriver driver = null;
	boolean checkboxStatus = Boolean.FALSE;
	
	@BeforeMethod
	public void launchBrowser() {
		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
	}
	
	@Test
	public void checkAndUncheckCheckbox() throws InterruptedException {
		Thread.sleep(2000L);
		WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
		checkbox.click();
		checkboxStatus = checkbox.isSelected();
		Assert.assertTrue(checkboxStatus);
		Thread.sleep(2000L);
		
		checkbox.click();
		checkboxStatus = checkbox.isSelected();
		Assert.assertFalse(checkboxStatus);
		Thread.sleep(2000L);
	}
	
	@Test
	public void getNumberOfCheckbox() throws InterruptedException {
		Thread.sleep(2000L);
		List<WebElement> checkboxLst = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int checkboxCount = checkboxLst.size();
		Assert.assertEquals(checkboxCount, 3);
		Thread.sleep(2000L);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
