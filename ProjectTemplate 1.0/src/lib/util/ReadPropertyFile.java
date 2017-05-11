package lib.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ReadPropertyFile {
	
	Properties property = null;
	FileInputStream fis = null;
	
	
	public ReadPropertyFile(String propertyFileName) throws IOException{
		
		fis = new FileInputStream(System.getProperty("user.dir")+ "\\resources\\"+propertyFileName);
		property = new Properties();
		property.load(fis);
		
	}
	
	public String getBrowser() throws IOException{
		return property.getProperty("browser");
	}
	public String getURL() throws IOException{
		return property.getProperty("url");
	}
	public void loadLog4jProperties(){
		PropertyConfigurator.configure(property);
	}
	

}
