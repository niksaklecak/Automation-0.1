package test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import lib.pages.GooglePage;
import lib.pages.SearchResultsPage;
import lib.util.Browser;
import lib.util.Verification;

public class TestOpenCloseGoogle {
	SearchResultsPage searchResultPage;
	WebDriver driver;
	@Test
	public void test(){

		System.out.println("prosao");
		try {
			driver = Browser.openBrowserOnRemoteMasine("chrome", "127.0.0.1");
			Sleeper.sleepTightInSeconds(5);
			GooglePage googlePage = Browser.openGooglePage(driver);
			Sleeper.sleepTightInSeconds(3);
			Verification.verifyPageExists(googlePage);
			searchResultPage = googlePage.searchGoogle("niksa kralj");
			Verification.verifyPageExists(searchResultPage);
			
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
 