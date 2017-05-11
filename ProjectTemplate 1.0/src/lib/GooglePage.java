package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

	@FindBy(id="lst-ib")
    private WebElement searchBox;
	
    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchButton;
    
    
    @FindBy(how = How.CLASS_NAME, using = "sbico-c")
    private WebElement search;
    
	public GooglePage(WebDriver driver, String title){
		super(driver,title);
	}
	public GooglePage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return searchButton;
	}
	
	public SearchResultsPage searchGoogle(String item){
		searchBox.clear();
		searchBox.sendKeys(item);
		search.click();
		return  PageFactory.initElements(driver, SearchResultsPage.class);
	}
	@Override
	public String getName() {
		return "GooglePage";
	}
}
