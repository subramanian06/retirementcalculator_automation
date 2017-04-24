package nz.co.westpac.utils;

import nz.co.repository.SiteRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Explicit waits can be added here
 * 
 * @author Subramanian_K
 *
 */
public class Waiting extends SiteRepository {
	public static final int WAITING_MILLISECONDS_HIGH = 5000;
	public static final int WAITING_MILLISECONDS_LOW = 1000;
	public static final int WAITING_SECONS_LOW = WAITING_MILLISECONDS_LOW / 100;
	public static final int WAITING_SECONS_HIGH = WAITING_MILLISECONDS_HIGH / 100;

	/**
	 * Methods : Different explicit waits needed during run time
	 * 
	 * @param element
	 * @param time
	 */
	public static void explicitWaitElementToBeClickable(WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void explicitWaitElementToBeSelected(WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void explicitWaitTextToBePresentInElement(WebElement element, int time, String text) {
		new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void explicitWaitTitleContains(WebElement element, int time, String title) {
		new WebDriverWait(driver, time).until(ExpectedConditions.titleContains(title));
	}

	public static void explicitWaitTitleIs(WebElement element, int time, String title) {
		new WebDriverWait(driver, time).until(ExpectedConditions.titleIs(title));
	}

	public static void explicitWaitVisibilityOfElement(WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitSelectionStateToBe(WebElement element, int time, boolean selected) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}

	public static void explicitWaitForAlert(int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.alertIsPresent());
	}
}
