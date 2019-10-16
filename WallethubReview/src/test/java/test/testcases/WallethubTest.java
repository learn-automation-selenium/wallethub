package test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.wallethub.WallethubCompanyPage;
import testcases.common.TC_Common;

import configreader.ObjectRepository;
import configreader.PropertyFileReader;

public class WallethubTest extends TC_Common {


	@Parameters({"url"})
	@BeforeClass
	public void setData(String currentUrl) {
		ObjectRepository.reader = new PropertyFileReader();
		browser = ObjectRepository.reader.getBrowser();
		url = currentUrl;
	}

	@Test
	public void createNewReview() {
		new WallethubCompanyPage(driver)
		.goToReviewSection()
		.hoverOverStar(4);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
