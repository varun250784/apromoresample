package util;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InitiateDriver {
	
	    private String sessionId;
	    private String browser;
	   
		private static WebDriver driver = null;
	
		public static WebDriver getDriver() {
			return driver;
		}




	String path = System.getProperty("user.dir") + File.separator + "driver" + File.separator
				+ "chromedriver.exe";
	  
		private static final String CHROME_DRIVER = "src"+ File.separator +"main"+ File.separator + File.separator +"resources"
				+ File.separator +"drivers"+ File.separator +"chromedriver.exe";
		
		

	    public static void setDriver() throws Exception {
	        try {
	        
	            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--remote-allow-origins=*");
	             driver = new ChromeDriver(options);
	    		
	    		if(driver.equals(null)) throw new Exception("could not create driver");
	    		   System.out.println("Driver created successfully");
	    		   
	    		
	        }
	        catch (Exception ex) {
	        	  System.out.println("Driver could not be created");
	           throw (ex);
	        
}
	    }
}
