package nz.co.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static nz.co.westpac.datacomponents.RetirementCalcInputs.*;

/**
 * Inital setup for webdriver Enabled multiple browser
 *         testing compatability
 * @author Subramanian_K 
 * 
 */
public class Starter {

	public static WebDriver driver = null;
	public static final String chromeProperty = "webdriver.chrome.driver";
	public static final String RELATIVE_APP_PATH = "lib/chromedriver.exe";
	public static final String ieProperty = "webdriver.ie.driver";
	public static final String ie_Relative_App_Path = "lib/IEDriverServer.exe";

	/**
	 * Set the system property for required browsers here
	 */
	@BeforeSuite
	public void Set() {
		System.setProperty(chromeProperty, RELATIVE_APP_PATH);
		System.setProperty(ieProperty, ie_Relative_App_Path);
	}

	/**
	 * Open the browser and maximize it
	 *  MethodName: openBrowser
	 * 
	 */
	@BeforeMethod
	public void openBrowser() {
		if (data_browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();			
		} else if (data_browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (data_browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		launchUrl();
	}

	/**
	 * Launch URL and maximize
	 */
	private void launchUrl() {
		driver.get(data_url);
		driver.manage().window().maximize();
	}


}
