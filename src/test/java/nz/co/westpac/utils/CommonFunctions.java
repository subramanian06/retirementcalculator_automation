package nz.co.westpac.utils;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import junit.framework.Assert;

import nz.co.westpac.datacomponents.RetirementCalcData;
import nz.co.westpac.entities.DriverFactory;

public class CommonFunctions {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static WebDriver driver = DriverFactory.getInstance().getDriver();

	public static void consolePrint(String message) {
		if (message.toLowerCase().contains("passed")) {
			System.out.println(ANSI_GREEN + message);
		} else if (message.contains("failed")) {
			System.out.println(ANSI_RED + message);
		} else {
			System.out.println(message);
		}
	}

	public static WebElement driverFindElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void mouseHover(String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driverFindElementByXpath(xpath)).perform();
	}

	public static void click(String xpath) {
		driverFindElementByXpath(xpath).click();
	}

	public static void sendKeys(String xpath, String value) {
		if (value != null) {
			driverFindElementByXpath(xpath).click();
			sleep(Waiting.WAITING_SECONS_LOW);
			driverFindElementByXpath(xpath).sendKeys(value);
		}
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static String read(String key) {
		Map dataReturn = RetirementCalcData.fetch("ageCalcMessage");
		return dataReturn.get(key).toString();
	}

	public static void isDisplayed(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	public static String format(String value, String expected) {
		if (value.contains("{0}")) {
			value = value.replace("{0}", expected);
		} else {
			return value;
		}
		return value;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver switchFrame(String xpath) {
		return driver.switchTo().frame(driverFindElementByXpath(xpath));
	}

	public static void isDisplayedBoolean(boolean b, boolean displayed) {
		Assert.assertEquals(b, displayed);

	}
}
