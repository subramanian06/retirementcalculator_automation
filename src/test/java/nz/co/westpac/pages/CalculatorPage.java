package nz.co.westpac.pages;

import org.openqa.selenium.WebElement;
import static org.testng.Reporter.log;

import nz.co.repository.SiteRepository;
import static nz.co.westpac.utils.CommonFunctions.*;
import static nz.co.westpac.utils.Waiting.*;

/**
 * Contains calculator page elements and common functions
 * @author Subramanian_K
 *
 */

public class CalculatorPage extends SitePage {

	SiteRepository repository;

	public CalculatorPage(SiteRepository repository) {
		super(repository);
	}

	private static final String btn_ageInfoIcon = "//div[@label='Current age']//i[@class='icon']";
	private static final String txt_ageField = "//div[@label='Current age']//p[contains(text(),'{0}')]";
	private static final String iframe = "//iframe[contains(@src,'calculator-widgets')]";
	private static final String txt_ageText = "//div[@label='Current age']//input[@type='text']";
	private static final String drpdwn_employeeStatus = "//div[@label='Employment status']//div[@class='control-well']";
	private static final String drpdwn_reusable = "//div[@class='dropdown']//span[contains(text(),'{0}')]";
	private static final String txt_salary = "//div[contains(@label,'Salary')]//input[@type='text']";
	private static final String radiobtn_kiwiSaverContribution = "//div[contains(@label,'KiwiSaver')]//span[contains(text(),'{0}')]";
	private static final String drpdwn_pir = "//div[@label='Prescribed investor rate (PIR)']//div[@class='control-well']";
	private static final String btn_retirementProjection = "//span[contains(text(),'Complete the form to see your KiwiSaver retirement projections.')]/parent::button";
	private static final String lbl_resultsHeading = "//div[@class='results-heading']";
	private static final String lbl_resultsGraphCalculation = "//div[@class='results-graph']";
	private static final String radiobtn_riskProfile = "//div[@label='Risk profile']//span[contains(text(),'{0}')]";
	private static final String txt_kiwiSaverBalance = "//div[@label='Current KiwiSaver balance']//input[@type='text']";
	private static final String txt_vouluntaryContributes = "//div[@label='Voluntary contributions']//input[@type='text']";
	private static final String drpdwn_vouluntaryContributesFrequency = "(//div[@label='Voluntary contributions']//div[@class='control-well'])[2]";
	private static final String txt_savingsGoal = "//div[@label='Savings goal at retirement']//input[@type='text']";

	/*********************************************************************
	 * Method Name : clickAgeCalculatorInformationIcon AUTHOR : Subramanian
	 * DESCRIPTION : click the age calculator info icon
	 * 
	 * @param =
	 *            nil
	 *********************************************************************/
	public CalculatorPage clickAgeCalculatorInfoIcon() {
		sleep(WAITING_MILLISECONDS_HIGH);
		switchFrame(iframe);
		explicitWaitElementToBeClickable(driverFindElementByXpath(btn_ageInfoIcon), WAITING_SECONS_HIGH);
		click(btn_ageInfoIcon);
		consolePrint("Passed:Clicked on the age info icon...");
		log("Passed:Clicked on the age info icon...");
		sleep(WAITING_MILLISECONDS_HIGH);
		return this;
	}

	/*********************************************************************
	 * Method Name : verifyAgeTextFieldInfo AUTHOR : Subramanian DESCRIPTION :
	 * verify the info available after clicking on the info icon
	 * 
	 * @param =
	 *            ageFiledMessage
	 *********************************************************************/
	public CalculatorPage verifyAgeTextFieldInfo(String ageFieldMessage) {
		sleep(WAITING_MILLISECONDS_HIGH);
		WebElement textExpectedElement = driverFindElementByXpath(format(txt_ageField, ageFieldMessage));
		if (textExpectedElement.isDisplayed()) {
			consolePrint("Passed: Field info is present on clicking the info icon..." + ageFieldMessage);
			log("Passed:Field info is present on clicking the info icon..." + ageFieldMessage);
		} else {
			consolePrint("Failed:Field info is not present on clicking the info icon...");
			log("Failed:Field info is not present on clicking the info icon...");
		}
		return this;
	}

	/*********************************************************************
	 * Method Name : enterAgeAndEmploymentStatus AUTHOR : Subramanian
	 * DESCRIPTION : Enters the age and employment status of the user
	 * 
	 * @param =
	 *            age
	 * @param =
	 *            employment status
	 *********************************************************************/

	public CalculatorPage enterAgeAndEmploymentStatus(String age, String employementStatus) {
		sleep(WAITING_MILLISECONDS_HIGH);
		switchFrame(iframe);
		sendKeys(txt_ageText, age);
		consolePrint("Passed:Entered the age as :" + age);
		log("Passed:Entered the age as :" + age);
		sleep(WAITING_MILLISECONDS_LOW);
		click(drpdwn_employeeStatus);
		consolePrint("Passed: Clicked on employee Status drop down");
		log("Passed: Clicked on employee Status drop down");
		click(format(drpdwn_reusable, employementStatus));
		consolePrint("Passed: Selected the employee status as :" + employementStatus);
		log("Passed: Selected the employee status as :" + employementStatus);
		return this;
	}

	/*********************************************************************
	 * Method Name : enterSalaryDetails AUTHOR : Subramanian DESCRIPTION :
	 * Enters salary of the user
	 * 
	 * @param =
	 *            salary
	 *********************************************************************/
	public CalculatorPage enterSalaryDetails(String salary) {
		sendKeys(txt_salary, salary);
		consolePrint("Passed: Entered the employee salary as :" + salary);
		log("Passed: Entered the employee salary as :" + salary);
		sleep(WAITING_MILLISECONDS_LOW);
		return this;
	}

	/*********************************************************************
	 * Method Name : enterKiwiSaverContribution AUTHOR : Subramanian DESCRIPTION
	 * : Selects the kiwi saver contribution %
	 * 
	 * @param =
	 *            kiwisaver
	 *********************************************************************/
	public CalculatorPage enterKiwiSaverContribution(String kiwiSaver) {
		sleep(WAITING_MILLISECONDS_LOW);
		click(format(radiobtn_kiwiSaverContribution, kiwiSaver));
		consolePrint("Passed: Clicked the kiwi saver contribution as :" + kiwiSaver);
		log("Passed: Clicked the kiwi saver contribution as :" + kiwiSaver);
		return this;
	}

	/*********************************************************************
	 * Method Name : enterPIRDetails AUTHOR : Subramanian DESCRIPTION : Enter
	 * the pir %
	 * 
	 * @param =
	 *            pirPercentage
	 *********************************************************************/

	public CalculatorPage enterPIRDetails(String pirPercentage) {
		click(drpdwn_pir);
		consolePrint("Passed: Clicked on PIR(Prescribed investor rate) drop down");
		log("Passed: Clicked on PIR(Prescribed investor rate) drop down");
		sleep(WAITING_MILLISECONDS_LOW);
		click(format(drpdwn_reusable, pirPercentage));
		consolePrint("Passed: Clicked on PIR(Prescribed investor rate) % as :" + pirPercentage);
		log("Passed: Clicked on PIR(Prescribed investor rate) % as :" + pirPercentage);
		return this;
	}

	/*********************************************************************
	 * Method Name : selectRiskProfile AUTHOR : Subramanian DESCRIPTION : select
	 * the risk profile of the user
	 * 
	 * @param =
	 *            riskProfile
	 *********************************************************************/
	public CalculatorPage selectRiskProfile(String riskProfile) {
		click(format(radiobtn_riskProfile, riskProfile));
		consolePrint("Passed: Clicked on risk profile as :" + riskProfile);
		log("Passed: Clicked on risk profile as :" + riskProfile);
		return this;
	}

	/*********************************************************************
	 * Method Name : clickCalculateRetirementsButton AUTHOR : Subramanian
	 * DESCRIPTION : Click the calculate retirement button
	 * 
	 * @param =
	 *            nil
	 *********************************************************************/
	public CalculatorPage clickCalculateRetirementsButton() {
		click(btn_retirementProjection);
		consolePrint("Passed: Clicked on view retirement projection button");
		log("Passed: Clicked on view retirement projection button");
		return this;
	}

	/*********************************************************************
	 * Method Name : verifyCalcResults AUTHOR : Subramanian DESCRIPTION :
	 * Display the calculations and verify if the graph is displayed
	 * 
	 * @param =
	 *            nil
	 *********************************************************************/
	public CalculatorPage verifyCalcResults() {
		sleep(WAITING_MILLISECONDS_HIGH);
		if (driverFindElementByXpath(lbl_resultsHeading).isDisplayed()) {
			consolePrint("Passed: Retirement projection is successfully displayed as: "
					+ driverFindElementByXpath(lbl_resultsHeading).getText());
			log("Passed: Retirement projection is successfully displayed as: "
					+ driverFindElementByXpath(lbl_resultsHeading).getText());
		} else {
			consolePrint("Failed: Retirement projection is not displayed");
			log("Failed: Retirement projection is not displayed");
		}
		if (driverFindElementByXpath(lbl_resultsGraphCalculation).isDisplayed()) {
			consolePrint("Passed: Retirement projection graph is successfully displayed");
			log("Passed: Retirement projection graph is successfully displayed");
		} else {
			consolePrint("Failed: Retirement projection graph is not displayed");
			log("Failed: Retirement projection graph is not displayed");
		}
		return this;
	}

	/*********************************************************************
	 * Method Name : enterKiwiSaverBalance AUTHOR : Subramanian DESCRIPTION :
	 * Enter the kiwi saver balance
	 * 
	 * @param =
	 *            kiwiSaverBalance
	 *********************************************************************/
	public CalculatorPage enterKiwiSaverBalance(String kiwiSaverBalance) {
		sendKeys(txt_kiwiSaverBalance, kiwiSaverBalance);
		consolePrint("Passed: Entered the Kiwi saver balance as : " + kiwiSaverBalance);
		log("Passed: Entered the Kiwi saver balance as : " + kiwiSaverBalance);
		sleep(WAITING_MILLISECONDS_HIGH);
		return this;
	}

	/*********************************************************************
	 * Method Name : enterAndSelectVoluntaryContributesFrequecy AUTHOR :
	 * Subramanian DESCRIPTION : enter voluntary contributes amount and the
	 * freuency
	 * 
	 * @param =
	 *            amount
	 * @param =
	 *            frequency
	 *********************************************************************/
	public CalculatorPage enterAndSelectVoluntaryContributesFrequecy(String amount, String frequency) {
		sendKeys(txt_vouluntaryContributes, amount);
		consolePrint("Passed: Entered the voluntary contributes amount as : " + amount);
		log("Passed: Entered the voluntary contributes amount as : " + amount);
		sleep(WAITING_MILLISECONDS_HIGH);
		click(drpdwn_vouluntaryContributesFrequency);
		consolePrint("Passed: Clicked the voluntary contributes frequency dropdown");
		log("Passed: Clicked the voluntary contributes frequency dropdown");
		click(format(drpdwn_reusable, frequency));
		consolePrint("Passed: Clicked the voluntary contributes frequency as :" + frequency);
		log("Passed: Clicked the voluntary contributes frequency as :" + frequency);
		return this;
	}

	/*********************************************************************
	 * Method Name : enterSavingsGoals AUTHOR : Subramanian DESCRIPTION : enter
	 * the savings goal
	 * 
	 * @param =
	 *            savingsGoal
	 *********************************************************************/

	public CalculatorPage enterSavingsGoals(String savingsGoal) {
		sendKeys(txt_savingsGoal, savingsGoal);
		consolePrint("Passed: Entered the savings goal amount as : " + savingsGoal);
		log("Passed: Entered the savings goal amount as : " + savingsGoal);
		return this;
	}

}
