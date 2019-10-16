package pages.wallethub;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import logger.LoggerHandler;
import wrappers.GenericHandlers;
import wrappers.WaitHandler;

public class WallethubCompanyPage {

	private static final Logger log = LoggerHandler.getLogger(WallethubCompanyPage.class);
	private GenericHandlers handlers;
	private WaitHandler wait;
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='nav-txt'][contains(text(),'Reviews')]")
	WebElement review;
	
	@FindBy(xpath="(//review-star[@class='rvs-svg']//*[4])[1]")
	WebElement fourthStar;
	
	public WallethubCompanyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		handlers = new GenericHandlers(this.driver);
		wait = new WaitHandler(this.driver);
	}
	
	public WallethubCompanyPage goToReviewSection() {
		log.info("Go to review section");
		handlers.clickElement(review);
		return this;
	}
	
	public void hoverOverStar(int starNumber) {
		log.info("Selecting rating");
		wait.waitForElementToBeVisible(fourthStar, 30);
		handlers.mouseOver(fourthStar);
	}
}
