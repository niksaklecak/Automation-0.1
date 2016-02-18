package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends Page {

	@FindBy(xpath ="//input[contains(@id,'idOfInputField')]")
    private WebElement someWebElement;
	
	GooglePage(WebDriver driver, String title){
		super(driver,title);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return _driver.findElement(By.id("hplogo"));
	}
}
