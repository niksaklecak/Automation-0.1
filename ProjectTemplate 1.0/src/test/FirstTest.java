package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.BaseTest;
import lib.DeployPage;
import lib.Driver;
import lib.ReadPropertyFile;


public class FirstTest extends BaseTest{
	DeployPage deployPage;
	List<WebElement> titleList;
	List<WebElement> contentList;
	ReadPropertyFile property;
	
	
	@Test (priority=1)
	public void testDeployBlogPage() throws MalformedURLException, WebDriverException, ElementNotVisibleException {

		logger.logInfo("FirstTest.testDeployBlogPage - Start tests on deploy page");
		deployPage = Driver.openDeployPage(driver);
		verify.pageLoaded(deployPage);
		

	}
	@Test (priority=2)
	public void testVerifySiteLogo() throws Exception {

		logger.logInfo("FirstTest.testVerifySiteLogo - testVerifySiteLogo");
		
//		WebElement imagePresent = driver.findElement(By.cssSelector("#logo > a > img"));
//		
//      assertTrue(imagePresent.isDisplayed());
		assertTrue(deployPage.isLogoDiplayed());
		

	}
	@Test (priority=3)
	public void testTitles() throws IOException{
		titleList = driver.findElements(By.cssSelector(".entry-title"));
		ReadPropertyFile property = new ReadPropertyFile("config.properties");
		int i = 1;
		for (WebElement element : titleList ){
			assertEquals(property.getTitle(i).trim(), element.getText().trim());
			i++;
		}
	}
	
	@Test (priority=4)
	public void testStaticContent() throws IOException{
		titleList = driver.findElements(By.cssSelector(".entry-title"));
		contentList = driver.findElements(By.cssSelector("div.article-box-content > section > p"));
	    //div.article-box-content
	    HashMap<String, String> map1 = new HashMap<String, String>();
	    HashMap<String, String> map2 = new HashMap<String, String>();
	    for (int i=0; i<9; i++){
	    	map1.put(titleList.get(i+1).getText(), contentList.get(i).getText());
	    }
	    property = new ReadPropertyFile("config.properties");
	    for (int y=2; y<11; y++){
	    	map2.put(property.getTitle(y), property.getContent(y));
	    } 
	    
	    assertTrue(map1.equals(map2));
	}

}
