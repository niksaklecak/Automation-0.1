package lib.pages;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract  class Page {
	
	protected WebDriver _driver;
	protected String _title;
	
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
	

	public String getTitle(){
		return _driver.getTitle();
	}
}
