package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPage extends BasePage {
	
	@FindBy(how = How.CLASS_NAME, using = "sbico-c")
    private WebElement search;
	
	public SearchResultsPage (WebDriver driver, String title){
		super(driver,title);
	}
	public SearchResultsPage (WebDriver driver){
		super(driver);
	}
	@Override
	public WebElement webPageIndetifier() {
		return search;
	}
	@Override
	public String getName() {
		return "SearchResultsPage";
	}

}
