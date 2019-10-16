package pages.wallethub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallethubLoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(name="//input[@name='em']")
	WebElement emailId;
	
	@FindBy(name="//input[@name='pw1']")
	WebElement password;
	
	@FindBy(css="button[class='btn blue touch-element-cl']")
	WebElement loginBtn;
	
	public WallethubLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WallethubLoginPage clickLogin() {
		loginLink.click();
		return this;
	}
	
	public WallethubLoginPage enterUsername(String email) {
		emailId.sendKeys(email);
		return this;
	}
	
	public WallethubLoginPage enterPassword(String pwd) {
		password.sendKeys(pwd);
		return this;
	}
	
	public WallethubCompanyPage clickLoginBtn() {
		loginBtn.click();
		return new WallethubCompanyPage(this.driver);
	}
}
