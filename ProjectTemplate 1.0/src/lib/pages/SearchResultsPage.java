package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends Page {
	
	public SearchResultsPage (WebDriver driver, String title){
		super(driver,title);
	}
	public SearchResultsPage (WebDriver driver){
		super(driver);
	}
	@Override
	public WebElement webPageIndetifier() {
		return null;
	}

}
