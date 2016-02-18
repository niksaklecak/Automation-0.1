package test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import lib.Browser;

public class TestOpenCloseGoogle {

	WebDriver driver;
	@Test
	public void test(){

		System.out.println("prosao");
		try {
			driver = Browser.openBrowserOnRemoteMasine("chrome", "127.0.0.1");
			//secondPage = Page.openSignInPage(driver);
			
			
			
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@AfterClass 
	public void tearDown(){
		driver.close();
	}
}
