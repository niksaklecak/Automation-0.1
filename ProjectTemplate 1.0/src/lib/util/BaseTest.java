package lib.util;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import lib.util.ReadPropertyFile;

public class BaseTest {
	
	protected ReadPropertyFile rpf;
	protected AutomationLogger logger = new AutomationLogger();
	protected Verification verify = new Verification();
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException {
		rpf = new ReadPropertyFile("config.properties");
		logger.logInfo("BaseTest.setUp - create a "+rpf.getBrowser()+" driver");
		
		driver = Driver.openBrowserOnRemoteMasine(rpf.getBrowser(),rpf.getURL());
		
	
	}

	@AfterClass
	public void tearDown() {

		driver.close();
		logger.logInfo("BaseTest.tearDown - tear down");
	}

}
