package test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.CommonUtils;

public class Test001 extends CommonUtils{

	public static void main(String[] args) {

		String chromeDriverPath = getCurrentWorkingDirectory()+ "\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.close();

	}

}
