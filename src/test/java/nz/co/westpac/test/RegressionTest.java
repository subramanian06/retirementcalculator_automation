package nz.co.westpac.test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import nz.co.repository.SiteRepository;
import nz.co.westpac.entities.DriverFactory;
import static nz.co.westpac.utils.CommonFunctions.read;
import static nz.co.westpac.datacomponents.RetirementCalcInputs.*;

public class RegressionTest extends SiteRepository {
	//get the Web driver instance
	public static WebDriver driver = DriverFactory.getInstance().getDriver();
	
	
	/*****************************************************************************************************
	 * Name : t01_Verify_if_information_Icon_Works_Fine
	 *
	 * Description : verify if the user is able to get a clear understanding of what needs to be entered in the field.
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------
	 *Note : User Clicks information icon besides Current age the message 
	 *“This calculator has an age limit of 64 years old as you need 
	 *to be under the age of 65 to join KiwiSaver.” 
	 *is displayed below the current age field.
	 ****************************************************************************************************/
   @Test (groups = {"Passed"}, description = "verify if the user is able to get a clear understanding of what needs to be entered in the field.")
	public void t01_Verify_if_information_Icon_Works_Fine(){
	   //Start the test with a chrome browser
		start().startWithChrome();
		//Click on the Kiwi saver calculator
		homePage().clickKiwiSaverCalculator();
	    //Click the info icon next to age text field
		calculatorPage().clickAgeCalculatorInfoIcon();
        //verify that the field info is displayed correctly after the click
		calculatorPage().verifyAgeTextFieldInfo(data_AgeFieldMessage);
	}
   
   /*****************************************************************************************************
	 * Name : tc02_Verify_if_tax_projections_are_displayed__For_Employed
	 *
	 * Description : verify if a employed user is able to calculate what their KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------
	 *Note: Employed •	User whose Current age is 30 is Employed 
	 *@ a Salary 82000 p/a and contributes to KiwiSaver @ 4% has a PIR 17.5% and chooses
	 * a high risk profile is able to calculate his projected balances at retirement.
	 ****************************************************************************************************/
   @Test(groups = {"Passed"}, description = "verify if a employed user is able to calculate what their KiwiSaver projected balance would be at retirement")
   public void tc02_Verify_if_tax_projections_are_displayed__For_Employed(){
	 //Start the test with a chrome browser
	   start().startWithChrome();
	 //Click on the Kiwi saver calculator
	   homePage().clickKiwiSaverCalculator();
	   //Enters the details of a employed user for calculation
	   calculatorPage().enterDetailsForCalculation(read("userAge1"),read("employementStatus1"),read("salary1"),
			 read("kiwiSaver1"),read("pir1"),read("riskProfile1"));
   }
   
   /*****************************************************************************************************
	 * Name : tc03_Verify_if_tax_projections_are_displayed__For_UnEmployed1
	 *
	 * Description : verify if a unemployed user is able to calculate what their KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------
	 *Note: Unemployed scenario 1 :  User whose current aged 45 is Self-employed, 
	 *has a PIR 10.5%, current KiwiSaver balance is $100000, voluntary contributes $90 
	 *fortnightly and chooses medium risk profile with saving goals requirement of
	 *$290000 is able to calculate his projected balances at retirement.
	 ****************************************************************************************************/
   @Test(groups = {"Passed"}, description = "verify if a unemployed user is able to calculate what their KiwiSaver projected balance would be at retirement")
   public void tc03_Verify_if_tax_projections_are_displayed__For_UnEmployed1(){
	 //Start the test with a chrome browser
	   start().startWithChrome();
	 //Click on the Kiwi saver calculator
	   homePage().clickKiwiSaverCalculator();
	 //Enters the details of a employed user for calculation
	   calculatorPage().enterDetailsForCalculation(read("userAge2"),read("employementStatus2"),read("salary2"),
				 read("kiwiSaver1"),read("pir2"),read("riskProfile2"),read("kiwiBalance2"),read("voluntaryContributes2"),read("frequency2"),read("savingsGoal2"));
   }
   
   /*****************************************************************************************************
	 * Name : tc04_Verify_if_tax_projections_are_displayed__For_UnEmployed2
	 *
	 * Description : verify if a unemployed user is able to calculate what their KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------
	 *Note: unemployed Scenario 2:•	User whose current aged 55 is not employed, 
	 *has a PIR 10.5%, current KiwiSaver balance is $140000, 
	 *voluntary contributes $10 annually and chooses medium risk profile with 
	 *saving goals requirement of $200000 is able to calculate his projected balances at retirement.
	 ****************************************************************************************************/
   @Test(groups = {"Passed"}, description = "verify if a unemployed user is able to calculate what their KiwiSaver projected balance would be at retirement")
   public void tc04_Verify_if_tax_projections_are_displayed__For_UnEmployed2(){
	   start().startWithChrome();
	   homePage().clickKiwiSaverCalculator();
	   calculatorPage().enterDetailsForCalculation(read("userAge3"),read("employementStatus3"),read("salary3"),
				 read("kiwiSaver1"),read("pir2"),read("riskProfile2"),read("kiwiBalance3"),read("voluntaryContributes2"),read("frequency3"),read("savingsGoal3"));
   }
   
   /**
    * quit() driver
    */
   @AfterTest
   public void quit(){
	   //close the driver after all the tests are completed
	   driver.close();
   }

	
}
