package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract  class Page {

	WebDriver _driver;
	String _title;
	
	Page(WebDriver driver, String title){
		this._driver = driver;
		this._title = title;
	}
	Page(WebDriver driver){
		this(driver,null);
	}
	/**
	 * This method must be implemented
	 * 
	 */
	public abstract WebElement webPageIndetifier();
	

}
