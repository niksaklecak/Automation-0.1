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
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

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
    @FindBy(css = " div > div.modal-footer.ng-scope > button")
    private WebElement changeLogoCloseButton;
    @FindBy(css = "#project-info-div > h1")
    private WebElement listingAddress;
    @FindBy(css = "form > div:nth-child(1) > input")
    private WebElement nameInput;
    @FindBy(css = "form > div:nth-child(2) > input")
    private WebElement addressInput;
    @FindBy(css = "form > div:nth-child(3) > input")
    private WebElement cityInput;
    @FindBy(css = "form > div:nth-child(4) > input")
    private WebElement stateInput;
    @FindBy(css = "a.btn.btn-success.pull-left")
    private WebElement applyButton;
    @FindBy(css = "#project-info-div > h3")
    private WebElement addressLabel;
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
	public void uploadFiles() {

		
		HandlingDesktopWindows x = new HandlingDesktopWindows(); 
		x.sleep(1000);
		changeLogoButton.click();
		x.sleep(1000);
		x.setUploadFile();
		x.sleep(1000);
		changeLogoCloseButton.click();
		x.sleep(1000);
	}
	public boolean changedLogoPresent(){
		
		Screen s = new Screen();
		ImagePath.add("C:\\Images");
		
		try {
			s.find("defaultLogo.jpg");
		} catch (FindFailed e) {
			 
			e.printStackTrace();
			return false;
		}
	return true;
	}
	
	public void editListingAddress(String address){
		listingAddress.click();
		addressInput.clear();
		addressInput.sendKeys(address);
		applyButton.click();
	}
	public String getListingAddress(){
		return addressLabel.getText();
	}
	
}
