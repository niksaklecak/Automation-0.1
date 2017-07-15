package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import lib.BaseTest;
import lib.Driver;
import lib.InsidemapsPage;
import lib.InsidemapsProfilePage;
import lib.InsidemapsListingPage;

public class TestEditListingPage extends BaseTest {
	InsidemapsPage insidemapsPage;
	InsidemapsProfilePage insidemapsProfilePage;
	InsidemapsListingPage insidemapsListingPage;

	@Test(priority = 1)
	public void testInsidemapsListingPageLoaded() throws Exception {

		logger.logInfo("TestEditListingPage.testInsidemapsPageLoaded - Start test");
		insidemapsPage = Driver.openInsidemapsPage(driver);

		verify.pageLoaded(insidemapsPage);
		insidemapsProfilePage = insidemapsPage.clickOnGetStartedButton();
		verify.pageLoaded(insidemapsProfilePage);
		insidemapsListingPage = insidemapsProfilePage.openListingPage();
		verify.pageLoaded(insidemapsListingPage);

	}

	@Test(priority = 2)
	public void testChangeLogo() throws Exception {
		logger.logInfo("TestEditListingPage.testChangeLogo - testChangeLogo");
		insidemapsListingPage.editListing();
		insidemapsListingPage.changeProjectLogo();
		insidemapsListingPage.uploadFiles();
		assertTrue(insidemapsListingPage.changedLogoPresent());
	}
	
	@Test(priority = 3)
	public void testChangeAddress() throws Exception {
		logger.logInfo("TestEditListingPage.testChangeAddress - testChangeAddress");
		insidemapsListingPage.editListingAddress("New address2");
		assertEquals(insidemapsListingPage.getListingAddress(), "New address2, Belgrade, Serbia");

	}

}
