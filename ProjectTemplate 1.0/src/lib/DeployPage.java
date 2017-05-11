package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeployPage extends BasePage {

	@FindBy(id="logo")
    private WebElement logo;
	
    
    
	public DeployPage(WebDriver driver, String title){
		super(driver,title);
	}
	public DeployPage(WebDriver driver){
		super(driver);
	}
	
	@Override
	public WebElement webPageIndetifier(){
		return logo;
	}
	
	@Override
	public String getName() {
		return "DeployPage";
	}
}
