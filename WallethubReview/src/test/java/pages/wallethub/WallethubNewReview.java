package pages.wallethub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallethubNewReview {

	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Select...')]")
	WebElement dropDownList;
	
	@FindBy(xpath="//li[contains(text(),'Health Insurance')]")
	WebElement healthInsurance;
	
	@FindBy(css="textarea.textarea.wrev-user-input.validate")
	WebElement review;
	
	@FindBy(css="div[class='sbn-action semi-bold-font btn fixed-w-c tall']")
	WebElement submit;
	
	public WallethubNewReview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WallethubNewReview clickDropDownList() {
		dropDownList.click();
		return this;
	}
	
	public WallethubNewReview selectHealthInsurance() {
		healthInsurance.click();
		return this;
	}
	
	public WallethubNewReview writeReview(String reviewMsg) {
		review.sendKeys(reviewMsg);
		return this;
	}
	
	public void clickSubmitReview() {
		submit.click();
	}
}
