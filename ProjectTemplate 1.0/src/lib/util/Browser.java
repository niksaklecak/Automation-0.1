package lib.util;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import lib.pages.GooglePage;

public class Browser {
	//WebDriver _driver;
	

	/**
	 * Open specific browser on specific remote machine.
	 * 
	 * @param browser
	 * @param remoteMachine
	 * @return WebDriver for specific remote machine.
	 * 
	 * @throws WebDriverException
	 * @throws MalformedURLException
	 */
	public static WebDriver openBrowserOnRemoteMasine(String browser, String remoteMachine)
			throws WebDriverException, MalformedURLException {

		browser = browser.toLowerCase();
		Capabilities capability = null;
		switch (browser){
		
		case"firefox":
			System.out.println("firefox");
			capability = DesiredCapabilities.firefox();
			break;
		case"chrome":
			System.out.println("chrome");
			capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			((DesiredCapabilities) capability).setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case"safary":
			System.out.println("safary");
			capability = DesiredCapabilities.safari();
			break;
		case"iexplorer":
			System.out.println("internetExplorer");
			capability = DesiredCapabilities.internetExplorer();
			break;
		default:
			System.out.println("misspelled browser");
			break;
		}
		//System.out.println("http://"+remoteMachine+":4444/grid/console"); 
		System.out.println("http://"+remoteMachine+":4444/wd/hub");
		RemoteWebDriver rWebDriver = new RemoteWebDriver(new URL("http://"+remoteMachine+":4444/wd/hub"), capability);
		rWebDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		rWebDriver.manage().window().maximize();

		return rWebDriver;		

	}
	
	public static GooglePage openGooglePage(WebDriver driver){
		driver.get("http://www.google.com");
		return  PageFactory.initElements(driver, GooglePage.class);
	}

}
