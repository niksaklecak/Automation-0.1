package lib.util;

import java.util.logging.Logger;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import lib.pages.Page;

public class Verification {
	private static final Logger log = Logger.getLogger( Verification.class.getName() );
	public static void verifyPageExists(Page page) throws ElementNotVisibleException{
		
		WebElement identifier = page.webPageIndetifier();
		log.info("===================Opened "+page.getTitle()+" Page=======================");
		Assert.assertTrue(identifier.isDisplayed());
		Assert.fail("nije proslo");
		log.info("========================================================================");
	}

}
