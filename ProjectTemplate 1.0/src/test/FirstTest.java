package test;

import java.net.MalformedURLException;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import lib.BaseTest;
import lib.DeployPage;
import lib.Driver;


public class FirstTest extends BaseTest{
	
	@Test
	public void test1() throws MalformedURLException, WebDriverException, ElementNotVisibleException {

		logger.logInfo("FirstTest.test1 - Start tests on deploy page");
		DeployPage deployPage = Driver.openDeployPage(driver);
		verify.pageLoaded(deployPage);
		

	}

}
