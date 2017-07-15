package test;

import java.net.MalformedURLException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import autoitx4java.AutoItX;
import lib.BaseTest;
import lib.Driver;
import lib.InsidemapsPage;
import lib.InsidemapsProfilePage;
import lib.InsidemapsListingPage;


public class TestChangingLogo extends BaseTest{
	InsidemapsPage insidemapsPage;
	InsidemapsProfilePage insidemapsProfilePage;
	InsidemapsListingPage insidemapsListingPage;
	
	
	
	@Test (priority=1)
	public void testInsidemapsListingPageLoaded() throws MalformedURLException, WebDriverException, ElementNotVisibleException {
		AutoItX x = new AutoItX();
		logger.logInfo("TestChangingLogo.testInsidemapsPageLoaded - Start test");
		insidemapsPage = Driver.openInsidemapsPage(driver);
		x.sleep(10);
		verify.pageLoaded(insidemapsPage);
		insidemapsProfilePage = insidemapsPage.clickOnGetStartedButton();
		verify.pageLoaded(insidemapsProfilePage);
		insidemapsListingPage = insidemapsProfilePage.openListingPage();
		verify.pageLoaded(insidemapsListingPage);

	}
	@Test (priority=2)
	public void testListingPage() throws Exception {
		insidemapsListingPage.editListing();
		insidemapsListingPage.changeProjectLogo();
		insidemapsListingPage.uploadFiles();
		
		logger.logInfo("FirstTest.testEditSiteLogo - testEditSiteLogo");

		

	}


}
