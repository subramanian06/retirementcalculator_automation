package nz.co.westpac.pages;

import static org.testng.Reporter.log;

import nz.co.repository.SiteRepository;

import static nz.co.westpac.utils.CommonFunctions.*;
import static nz.co.westpac.utils.Waiting.*;

/**
 * Contains Homepage elements and common functions
 * @author Subramanian_K
 *
 */
public class HomePage extends SitePage {

	private static final String btn_kiwiSaver = "(//a[contains(text(),'KiwiSaver')])[1]";
	private static final String btn_kiwiSaveCalculator = "(//a[contains(text(),'KiwiSaver calculators')])";
	private static final String txt_headerText = "(//h1[contains(text(),'Westpac KiwiSaver Scheme Risk Profiler and Retirement Calculator')])";
	private static final String btn_clickhere = "//a[contains(text(),'Click here to get started')]";

	public HomePage(SiteRepository repository) {
		super(repository);
	}

	/*********************************************************************
	 * Method Name : clickKiwiSaverCalculator AUTHOR : Subramanian DESCRIPTION :
	 * click on Kiwi Saver Calculator
	 * 
	 * @param =
	 *            null
	 *********************************************************************/
	public HomePage clickKiwiSaverCalculator() {
		log("Passed: Maximizing the window...");
		consolePrint("Passed: Maximizing the window...");
		explicitWaitVisibilityOfElement(driverFindElementByXpath(btn_kiwiSaver), WAITING_SECONS_LOW);
		mouseHover(btn_kiwiSaver);
		log("Passed: Mouse hover on kiwi saver button successfull...");
		consolePrint("Passed: Mouse hover on kiwi saver button successfull...");
		explicitWaitVisibilityOfElement(driverFindElementByXpath(btn_kiwiSaveCalculator), WAITING_SECONS_LOW);
		click(btn_kiwiSaveCalculator);
		log("Passed: Clicked on the kiwi saver calculator button successfully...");
		consolePrint("Passed: Clicked on the kiwi saver calculator button successfully...");
		sleep(WAITING_MILLISECONDS_HIGH);
		explicitWaitVisibilityOfElement(driverFindElementByXpath(txt_headerText), WAITING_SECONS_HIGH);
		sleep(WAITING_MILLISECONDS_HIGH);
		click(btn_clickhere);
		log("Passed: Clicked on the click on to get started button successfully...");
		consolePrint("Passed: Clicked on the click on to get started button successfully...");
		sleep(WAITING_MILLISECONDS_HIGH);
		return this;
	}

}
