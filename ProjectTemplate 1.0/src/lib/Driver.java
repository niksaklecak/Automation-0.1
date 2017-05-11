package lib;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {
	

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
	Capabilities capability = null;
	AutomationLogger logger = new AutomationLogger();

	public static WebDriver openBrowserOnRemoteMasine(String browser, String remoteMachine)
			throws WebDriverException, MalformedURLException {

		browser = browser.toLowerCase();
		Capabilities capability = null;
		AutomationLogger logger = new AutomationLogger();
		switch (browser){
		
		case"firefox":
			logger.logInfo("Driver.openBrowserOnRemoteMasine - firefox opened");
			capability = DesiredCapabilities.firefox();
			break;
		case"chrome":
			logger.logInfo("Driver.openBrowserOnRemoteMasine - chrome");
			capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			((DesiredCapabilities) capability).setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case"safary":
			logger.logInfo("Driver.openBrowserOnRemoteMasine - safary");
			capability = DesiredCapabilities.safari();
			break;
		case"iexplorer":
			logger.logInfo("Driver.openBrowserOnRemoteMasine - explorer");
			capability = DesiredCapabilities.internetExplorer();
			break;
		case"htmlunit":
			logger.logInfo("Driver.openBrowserOnRemoteMasine - headless Driver htmlUnit");
			capability = DesiredCapabilities.htmlUnit();
			break;
		default:
			logger.logError("Driver.openBrowserOnRemoteMasine - Driver missspelled in config.properties ERROR");
			break;
		}
		logger.logInfo("Driver.openBrowserOnRemoteMasine - Open browser on remote machine " + remoteMachine);
		RemoteWebDriver rWebDriver = new RemoteWebDriver(new URL("http://"+remoteMachine+":4444/wd/hub"), capability);
		logger.logInfo("Driver.openBrowserOnRemoteMasine - Maximize the browser");
		rWebDriver.manage().window().maximize();
		
		return  rWebDriver;
		

	}
	
	
	
	public static GooglePage openGooglePage(WebDriver driver){
		AutomationLogger logger = new AutomationLogger();
		logger.logInfo("Driver.openGooglePage - Open google page");
		driver.get("http://www.google.com");
		return  PageFactory.initElements(driver, GooglePage.class);
	}

}
