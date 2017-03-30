package nz.co.westpac.pages;

import org.openqa.selenium.WebElement;
import static org.testng.Reporter.log;


import nz.co.repository.SiteRepository;
import static nz.co.westpac.utils.CommonFunctions.*;
import static nz.co.westpac.utils.Waiting.*;



public class CalculatorPage extends SitePage{
	
	SiteRepository repository;
	public CalculatorPage(SiteRepository repository) {
		super(repository);
	}
	
	
	private static final String btn_ageInfoIcon = "//div[@label='Current age']//i[@class='icon']";
	private static final String txt_ageField ="//div[@label='Current age']//p[contains(text(),'{0}')]";
	private static final String iframe ="//iframe[contains(@src,'calculator-widgets')]";
	private static final String txt_ageText = "//div[@label='Current age']//input[@type='text']";
	private static final String drpdwn_employeeStatus = "//div[@label='Employment status']//div[@class='control-well']";
	private static final String drpdwn_reusable ="//div[@class='dropdown']//span[contains(text(),'{0}')]";
	private static final String txt_salary ="//div[contains(@label,'Salary')]//input[@type='text']";
	private static final String radiobtn_kiwiSaverContribution = "//div[contains(@label,'KiwiSaver')]//span[contains(text(),'{0}')]";
	private static final String drpdwn_pir = "//div[@label='Prescribed investor rate (PIR)']//div[@class='control-well']";
	private static final String btn_retirementProjection = "//span[contains(text(),'Complete the form to see your KiwiSaver retirement projections.')]/parent::button";
	private static final String lbl_resultsHeading = "//div[@class='results-heading']";
	private static final String lbl_resultsGraphCalculation = "//div[@class='results-graph']";
	private static final String radiobtn_riskProfile = "//div[@label='Risk profile']//span[contains(text(),'{0}')]";
	private static final String txt_kiwiSaverBalance = "//div[@label='Current KiwiSaver balance']//input[@type='text']";
	private static final String txt_vouluntaryContributes = "//div[@label='Voluntary contributions']//input[@type='text']";
	private static final String drpdwn_vouluntaryContributesFrequency = "(//div[@label='Voluntary contributions']//div[@class='control-well'])[2]";
	private static final String txt_savingsGoal= "//div[@label='Savings goal at retirement']//input[@type='text']";		
	
	/*********************************************************************
	 * Method Name   : clickAgeCalculatorInformationIcon
	 * AUTHOR : Subramanian
	 * DESCRIPTION : click the age calculator info icon
	 @param = nil
	*********************************************************************/
	public CalculatorPage clickAgeCalculatorInfoIcon(){
		sleep(WAITING_MILLISECONDS_HIGH);
		switchFrame(iframe);
		explicitWaitElementToBeClickable(driverFindElementByXpath(btn_ageInfoIcon),WAITING_SECONS_HIGH);
		click(btn_ageInfoIcon);
		consolePrint("Passed:Clicked on the age info icon...");
		log("Passed:Clicked on the age info icon...");
		sleep(WAITING_MILLISECONDS_HIGH);
		return this;
	}
	
	
	/*********************************************************************
	 * Method Name   : verifyAgeTextFieldInfo
	 * AUTHOR : Subramanian
	 * DESCRIPTION : verify the info available after clicking on the info icon
	 @param = nil
	*********************************************************************/
	public CalculatorPage verifyAgeTextFieldInfo(String ageFieldMessage){		
		sleep(WAITING_MILLISECONDS_HIGH);
		WebElement textExpectedElement = driverFindElementByXpath(format(txt_ageField,ageFieldMessage));
		if(textExpectedElement.isDisplayed()){
		consolePrint("Passed: Field info is present on clicking the info icon..." +ageFieldMessage);
		log("Passed:Field info is present on clicking the info icon..."+ageFieldMessage);
		}
		else{
			consolePrint("Failed:Field info is not present on clicking the info icon...");
			log("Failed:Field info is not present on clicking the info icon...");
		}
		return this;
	}
	
	/*********************************************************************
	 * Method Name   : enterDetailsForCalculation
	 * AUTHOR : Subramanian
	 * DESCRIPTION : enter and verify the details for kiwi saver retirement projection calc
	 @param = inputs
	 @param inputs[0] = Age
	 @param inputs[1] = Employee status
	 @param inputs[2] = Employee salary
	 @param inputs[3] = kiwi saver contribution
	 @param inputs[4] = pir
	 @param inputs[5] = riskProfile
	 @param inputs[6] = kiwiSaverBalance
	 @param inputs[7] = voluntary contributes amount
	 @param inputs[8] = voluntary contributes frequency
	 @param inputs[9] = savings goal
	*********************************************************************/
	public CalculatorPage enterDetailsForCalculation(String...inputs){
		sleep(WAITING_MILLISECONDS_HIGH);
		switchFrame(iframe);
		sendKeys(txt_ageText,inputs[0]);
		consolePrint("Passed:Entered the age as :"+inputs[0]);
		log("Passed:Entered the age as :"+inputs[0]);
	    sleep(WAITING_MILLISECONDS_LOW);	
	    click(drpdwn_employeeStatus);
	    consolePrint("Passed: Clicked on employee Status drop down");
	    log("Passed: Clicked on employee Status drop down");
	    click(format(drpdwn_reusable,inputs[1]));
	    consolePrint("Passed: Selected the employee status as :"+inputs[1]);
	    log("Passed: Selected the employee status as :"+inputs[1]);
	    if(inputs[1].equalsIgnoreCase("Employed")){
	    	sendKeys(txt_salary,inputs[2]);
	    	consolePrint("Passed: Entered the employee salary as :"+inputs[2]);
	    	log("Passed: Entered the employee salary as :"+inputs[2]);
	    	sleep(WAITING_MILLISECONDS_LOW);
	    	click(format(radiobtn_kiwiSaverContribution,inputs[3]));
	    	consolePrint("Passed: Clicked the kiwi saver contribution as :"+inputs[3]);
	    	log("Passed: Clicked the kiwi saver contribution as :"+inputs[3]);
	    	
	    }else if(inputs[1].equalsIgnoreCase("Self-employed") || inputs[1].equalsIgnoreCase("Not employed")){
	    	sendKeys(txt_kiwiSaverBalance,inputs[6]);
	    	consolePrint("Passed: Entered the Kiwi saver balance as : "+inputs[6]);
	    	log("Passed: Entered the Kiwi saver balance as : "+inputs[6]);
	    	sleep(WAITING_MILLISECONDS_HIGH);
	    	sendKeys(txt_vouluntaryContributes,inputs[7]);
	    	consolePrint("Passed: Entered the voluntary contributes amount as : "+inputs[7]);
	    	log("Passed: Entered the voluntary contributes amount as : "+inputs[7]);
	    	sleep(WAITING_MILLISECONDS_HIGH);
	    	click(drpdwn_vouluntaryContributesFrequency);
	    	consolePrint("Passed: Clicked the voluntary contributes frequency dropdown");
	 	    log("Passed: Clicked the voluntary contributes frequency dropdown");
	 	    click(format(drpdwn_reusable,inputs[8]));
	 	    consolePrint("Passed: Clicked the voluntary contributes frequency as :" +inputs[8]);
	 	    log("Passed: Clicked the voluntary contributes frequency as :"+inputs[8]);
	 	    sendKeys(txt_savingsGoal,inputs[9]);
	 	    consolePrint("Passed: Entered the savings goal amount as : "+inputs[9]);
	    	log("Passed: Entered the savings goal amount as : "+inputs[9]);	    
	    }
	    click(drpdwn_pir);
	    consolePrint("Passed: Clicked on PIR(Prescribed investor rate) drop down");
	    log("Passed: Clicked on PIR(Prescribed investor rate) drop down");
	    sleep(WAITING_MILLISECONDS_LOW);
	    click(format(drpdwn_reusable,inputs[4]));
	    consolePrint("Passed: Clicked on PIR(Prescribed investor rate) % as :"+inputs[4]);
	    log("Passed: Clicked on PIR(Prescribed investor rate) % as :"+inputs[4]);
	    click(format(radiobtn_riskProfile,inputs[5]));
	    consolePrint("Passed: Clicked on risk profile as :" +inputs[5]);
	    log("Passed: Clicked on risk profile as :" +inputs[5]);	    
	    sleep(WAITING_MILLISECONDS_HIGH);
	    click(btn_retirementProjection);
	    consolePrint("Passed: Clicked on view retirement projection button");
	    log("Passed: Clicked on view retirement projection button");    
	    sleep(WAITING_MILLISECONDS_HIGH);
	    if(driverFindElementByXpath(lbl_resultsHeading).isDisplayed()){
	    	consolePrint("Passed: Retirement projection is successfully displayed as:"+driverFindElementByXpath(lbl_resultsHeading).getText());
		    log("Passed: Retirement projection is successfully displayed as:"+driverFindElementByXpath(lbl_resultsHeading).getText());    	
	    }else{
	    	consolePrint("Failed: Retirement projection is not displayed");
		    log("Failed: Retirement projection is not displayed");
	    }
	    if(driverFindElementByXpath(lbl_resultsGraphCalculation).isDisplayed()){
	    	consolePrint("Passed: Retirement projection graph is successfully displayed");
		    log("Passed: Retirement projection graph is successfully displayed");    	
	    }else{
	    	consolePrint("Failed: Retirement projection graph is not displayed");
		    log("Failed: Retirement projection graph is not displayed");
	    }
		return this;
		
	}
	
	
}
