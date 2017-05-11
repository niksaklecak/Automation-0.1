package lib;

import java.io.IOException;

import org.apache.log4j.Logger;

public class AutomationLogger {
	
	public static Logger log = null;
	public ReadPropertyFile rpf;
	
	
	public AutomationLogger(){
		try {
			
			log = Logger.getLogger(AutomationLogger.class);
			rpf = new ReadPropertyFile("log4j.properties");
			rpf.loadLog4jProperties();
		} catch (IOException e) {
			log.error("AutomationLogger - Loading log4j.properties file error");
			e.printStackTrace();
		}
		
	}
	
	
	public void logInfo(String message){
		log.info(message);
	}
	public void logDebug(String message){
		log.debug(message);
	}
	public void logError(String message){
		log.error(message);
	}
}
