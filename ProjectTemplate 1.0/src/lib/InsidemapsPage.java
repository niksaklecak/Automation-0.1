package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsidemapsPage extends BasePage {

	@FindBy(css = "#header > div.content > a")
    private WebElement logo;
	@FindBy(css = "#header-get-started > a")
    private WebElement getStartedButton;
	@FindBy(css = "#login-modal-dialog > section > div > article:nth-child(2) > form > div:nth-child(1) > input")
    private WebElement usernameInput;
	@FindBy(css = "#login-modal-dialog > section > div > article:nth-child(2) > form > div:nth-child(2) > input")
    private WebElement passwordInput;
	@FindBy(css = "#login-modal-dialog > section > div > article:nth-child(2) > form > button")
    private WebElement signInButton;
	
	
    
	public InsidemapsPage(WebDriver driver, String title){
		super(driver,title);
	}
	public InsidemapsPage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return getStartedButton;
	}
	
	@Override
	public String getName() {
		return "insidemapsPage";
	}
	
	public boolean isLogoDiplayed(){
		return logo.isDisplayed();
	}
	public InsidemapsProfilePage clickOnGetStartedButton(){
		getStartedButton.click();
		usernameInput.sendKeys("testusernewim@gmail.com");
		passwordInput.sendKeys("123123");
		signInButton.click();
		return  PageFactory.initElements(driver, InsidemapsProfilePage.class);
	}
	
}
