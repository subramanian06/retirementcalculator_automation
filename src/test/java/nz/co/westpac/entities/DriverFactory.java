package nz.co.westpac.entities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static final String chromeProperty = "webdriver.chrome.driver";
    public static final String RELATIVE_APP_PATH = "lib/chromedriver.exe";
	
    private DriverFactory()
    {
       //Do-nothing..Do not allow to initialize this class from outside
    }
    
    private static DriverFactory instance = new DriverFactory();
    
    public static DriverFactory getInstance()
    {
       return instance;
    }
    
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    		   {
    		      @Override
    		      protected WebDriver initialValue()
    		      {
    		    	  System.setProperty(chromeProperty, RELATIVE_APP_PATH);
    		              return new ChromeDriver();
    		      }
    		      
    		   };
    		   
    		   public WebDriver getDriver() // call this method to get the driver object and launch the browser
    		   {
    		      return driver.get();
    		   }
    		   
    		   public void removeDriver() // Quits the driver and closes the browser
    		   {
    		      driver.get().quit();
    		      driver.remove();
    		   }
    		   
}
