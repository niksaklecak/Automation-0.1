package lib;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsidemapsProfilePage extends BasePage {

	@FindBy(css = "#header > div.content > a")
    private WebElement logo;
	@FindBy(css = "#project-squares-row > div:nth-child(1) > div > div > a > div > span")
    private WebElement nusicevaProject;
	
	
    
	public InsidemapsProfilePage(WebDriver driver, String title){
		super(driver,title);
	}
	public InsidemapsProfilePage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return nusicevaProject;
	}
	
	@Override
	public String getName() {
		return "insidemapsProfilePage";
	}
	
	public boolean isLogoDiplayed(){
		return logo.isDisplayed();
	}
	
	public InsidemapsListingPage openListingPage(){
		nusicevaProject.click();
		return  PageFactory.initElements(driver, InsidemapsListingPage.class);
	}
}
