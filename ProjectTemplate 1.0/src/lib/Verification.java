package lib;

  
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Verification {
	
	AutomationLogger logger = new AutomationLogger();
	
	public void pageLoaded(BasePage page) {
		
		
		WebElement identifier = page.webPageIndetifier();
		WebDriverWait wait = new WebDriverWait(page.driver, 15);
		wait.until(ExpectedConditions.visibilityOf(identifier));

		try{
			Assert.assertTrue(identifier.isDisplayed());
			logger.logInfo("Verification.pageLoaded - page " +page.getName()+" is loaded" );
		}catch (ElementNotVisibleException e){
			logger.logError("Verification.pageLoaded - page " +page.getName()+" didn't load" + e.getMessage());
			Assert.fail("Verification.pageLoaded - Page cannot be loaded");
		}
		
	
	}

}
