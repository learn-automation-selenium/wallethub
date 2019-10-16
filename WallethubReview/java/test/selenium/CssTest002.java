package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.CommonUtils;

public class CssTest002 extends CommonUtils{

	private static final String errorString = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("This is my username");
		driver.findElement(By.cssSelector("#password.input.r4.wide.mb16.mt8.password")).sendKeys("This is my password");
		driver.findElement(By.cssSelector("input[id='Login']")).click();
		
		//TODO: to implement WebDriverWait and wait until the error message is visible and remove Thread.sleep() method
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("#error.loginError")).getText().equalsIgnoreCase(errorString));
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
