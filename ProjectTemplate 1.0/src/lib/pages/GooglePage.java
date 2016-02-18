package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends Page {

	@FindBy(id="lst-ib")
    private WebElement searchBox;
    @FindBy(xpath = ".//*[@id='sblsbb']/button")
    private WebElement searchButton;
    
	public GooglePage(WebDriver driver, String title){
		super(driver,title);
	}
	public GooglePage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return _driver.findElement(By.id("hplogo"));
	}
	
	public SearchResultsPage searchGoogle(String item){
		searchBox.clear();
		searchBox.sendKeys(item);
		searchButton.click();
		return  PageFactory.initElements(_driver, SearchResultsPage.class);
	}
}
