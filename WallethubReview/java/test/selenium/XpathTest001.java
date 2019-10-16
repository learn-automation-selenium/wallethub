package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.CommonUtils;

public class XpathTest001 extends CommonUtils{

	public static void main(String[] args) throws InterruptedException {
		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/index.php");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Interview Guide'][1]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='tablist1-panel1']/ul/li/div/h3/font/b")).getText().equalsIgnoreCase("Appium"));
		
		// now click on SOAP UI using sibling for Appium tab
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='tablist1-panel3']/ul/li/div/h3/b")).getText().equalsIgnoreCase("What is ENDPOINT?"));
		

		Thread.sleep(5000);
		driver.close();
	}

}
