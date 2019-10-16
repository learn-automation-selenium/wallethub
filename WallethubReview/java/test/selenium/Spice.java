package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.CommonUtils;

public class Spice extends CommonUtils{

	public static void main(String[] args) throws InterruptedException {
		
		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		
		WebElement sourceLocation = driver.findElement(By.xpath("//input[@name='or-src']"));
		Thread.sleep(3000L);
		sourceLocation.clear();
		Thread.sleep(3000L);
		sourceLocation.sendKeys("MUM");
		Thread.sleep(3000L);
		sourceLocation.sendKeys(Keys.ENTER);
		
		WebElement destLocation = driver.findElement(By.xpath("//input[@name='or-dest']"));
		destLocation.clear();
		destLocation.sendKeys("DEL");
		Thread.sleep(2000L);
		destLocation.sendKeys(Keys.ARROW_DOWN);
		destLocation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		Thread.sleep(3000);
		// add three adults
		int i=1;
		while(i<3) {
			driver.findElement(By.xpath("//li[@class='adult-pax-list']/div/button[2]")).click();
			i++;
		}
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector(".btn.btn-primary.pax-done.btn-pad-y")).click();
		WebElement webElement = driver.findElement(By.cssSelector(".btn.btn-primary.pax-done.btn-pad-y"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
		
		Thread.sleep(3000L);
		driver.close();
	}

}
