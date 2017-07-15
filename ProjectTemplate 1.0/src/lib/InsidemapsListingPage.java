package lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import autoitx4java.AutoItX;

public class InsidemapsListingPage extends BasePage {

	@FindBy(css = "#header > div.content > a")
    private WebElement logo;
	@FindBy(css = "#right-side > a:nth-child(3)")
    private WebElement editListing;
	@FindBy(css = "#right-side > a:nth-child(3)")
    private WebElement changeProjectLogo;
	@FindBy(css = "div.modal-body.ng-scope > a:nth-child(4)")
    private WebElement changeLogoButton;
	
    
	public InsidemapsListingPage(WebDriver driver, String title){
		super(driver,title);
	}
	public InsidemapsListingPage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return editListing;
	}
	
	@Override
	public String getName() {
		return "insidemapsPage";
	}
	
	public boolean isLogoDiplayed(){
		return logo.isDisplayed();
	}
	
	public void editListing(){
		editListing.click();
	}
	public void changeProjectLogo(){
		changeProjectLogo.click();
	}
	public void changeLogo(){
		changeLogoButton.click();
	}
	public void uploadFiles() throws AWTException {

		changeLogoButton.click();
		AutoItX x = new AutoItX();
		x.sleep(2000);
	    x.send("C:/Images/newLogo.jpg" );
	    x.send("{ENTER}!n" );
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
