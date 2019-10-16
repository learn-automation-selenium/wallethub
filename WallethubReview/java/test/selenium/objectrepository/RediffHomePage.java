package test.selenium.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {

	WebDriver driver;
	
	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="srchquery_tbox")
	WebElement searchBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@class='signin']")
	WebElement signIn;
	
	public RediffHomePage enterSearchItem(String searchText) {
		searchBox.clear();
		searchBox.sendKeys(searchText);
		return this;
	}
	
	public RediffSignIn clickSignIn() {
		signIn.click();
		return new RediffSignIn(this.driver); 
	}
	
}
