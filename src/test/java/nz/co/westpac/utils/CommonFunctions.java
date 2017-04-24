package nz.co.westpac.utils;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import junit.framework.Assert;
import nz.co.repository.SiteRepository;
import nz.co.repository.Starter;
import nz.co.westpac.datacomponents.RetirementCalcData;

/**
 * Contains common functions required to perform different actions during the
 * test
 * 
 * @author Subramanian_K
 *
 */

public class CommonFunctions extends SiteRepository {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

	/**
	 * Method name:Console Print Description : Print the message in the console
	 * 
	 * @param message
	 */
	public static void consolePrint(String message) {
		if (message.toLowerCase().contains("passed")) {
			System.out.println(ANSI_GREEN + message);
		} else if (message.contains("failed")) {
			System.out.println(ANSI_RED + message);
		} else {
			System.out.println(message);
		}
	}

	/**
	 * Method Name : driverFindElementByXpath Descritption : Find a element
	 * using xpath
	 * 
	 * @param xpath
	 * @return
	 */

	public static WebElement driverFindElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * Method Name : mouse hover Description : Use actions to mouse hover on
	 * elements
	 * 
	 * @param xpath
	 */
	public static void mouseHover(String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driverFindElementByXpath(xpath)).perform();
	}

	/**
	 * Method Name: Click Descritption : Click on a element using xpath
	 * 
	 * @param xpath
	 */
	public static void click(String xpath) {
		driverFindElementByXpath(xpath).click();
	}

	/**
	 * Method Name: SendKeys Description : Find element using xpath and send
	 * inputs over it
	 * 
	 * @param xpath
	 * @param value
	 */

	public static void sendKeys(String xpath, String value) {
		if (value != null) {
			driverFindElementByXpath(xpath).click();
			sleep(Waiting.WAITING_SECONS_LOW);
			driverFindElementByXpath(xpath).sendKeys(value);
		}
	}

	/**
	 * Method Name: maximize Description: maximize the window driver
	 */

	public static void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * Method Name: read Description: Read data from the yaml file
	 * 
	 * @param key
	 * @return
	 */

	public static String read(String key) {
		Map dataReturn = RetirementCalcData.fetch("ageCalcMessage");
		return dataReturn.get(key).toString();
	}

	/**
	 * Method Name : isDisplayed Descritpion : Asserts the expected with actual
	 * value(String)
	 * 
	 * @param expected
	 * @param actual
	 */
	public static void isDisplayed(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Method Name: format Descritption : use regex to replace the value with a
	 * expected value
	 * 
	 * @param value
	 * @param expected
	 * @return
	 */
	public static String format(String value, String expected) {
		if (value.contains("{0}")) {
			value = value.replace("{0}", expected);
		} else {
			return value;
		}
		return value;
	}

	/**
	 * Method Name : sleep Description : Sleep using thread class
	 * 
	 * @param seconds
	 */
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method name: switchFrame Descritpion : Switch frame using xpath
	 * 
	 * @param xpath
	 * @return
	 */
	public static WebDriver switchFrame(String xpath) {
		return driver.switchTo().frame(driverFindElementByXpath(xpath));
	}

}
