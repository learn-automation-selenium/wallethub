package test.selenium.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffSignIn {

	WebDriver driver;

	public RediffSignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login1")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="remember")
	WebElement rememberMe;
	
	@FindBy(name="proceed")
	WebElement login;
	
	@FindBy(linkText="Home")
	WebElement homePageLink;
	
	public RediffSignIn enterUserName(String uName) {
		username.clear();
		username.sendKeys(uName);
		return this;
	}
	
	public RediffSignIn enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
		return this;
	}
	
	public RediffSignIn selectRememberMe() {
		boolean isRememberSelected = rememberMe.isSelected();
		if (!isRememberSelected) {
			rememberMe.click();
		}
		return this;
	}
	
	public RediffSignIn clickLogin() {
		login.click();
		return this;
	}
	
	public RediffHomePage clickHomePageLink() {
		homePageLink.click();
		return new RediffHomePage(this.driver);
	}
}
