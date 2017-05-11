package lib.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract  class BasePage {
	
	protected WebDriver driver;
	protected String title;
	
	BasePage(WebDriver driver, String title){
		this.driver = driver;
		this.title = title;
	}
	BasePage(WebDriver driver){
		this(driver,null);
	}
	/**
	 * This method must be implemented
	 * 
	 */
	public abstract WebElement webPageIndetifier();
	
	public abstract String getName();
	
}
