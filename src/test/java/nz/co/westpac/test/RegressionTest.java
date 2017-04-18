package nz.co.westpac.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import nz.co.repository.SiteRepository;
import static nz.co.westpac.datacomponents.RetirementCalcInputs.*;

/**
 * Add all the regression tests required to test the application here
 *  
 * @author Subramanian_K04
 *
 */
public class RegressionTest extends SiteRepository {

	/*****************************************************************************************************
	 * Name : t01_Verify_if_information_Icon_Works_Fine
	 *
	 * Description : verify if the user is able to get a clear understanding of
	 * what needs to be entered in the field.
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------ Note : User
	 * Clicks information icon besides Current age the message “This calculator
	 * has an age limit of 64 years old as you need to be under the age of 65 to
	 * join KiwiSaver.” is displayed below the current age field.
	 ****************************************************************************************************/
	@Test(groups = {
	"Regression" }, description = "verify if the user is able to get a clear understanding of what needs to be entered in the field.")
	public void t01_Verify_if_information_Icon_Works_Fine() {
		// Click on the Kiwi saver calculator
		homePage().clickKiwiSaverCalculator();
		// Click the info icon next to age text field
		calculatorPage().clickAgeCalculatorInfoIcon();
		// verify that the field info is displayed correctly after the click
		calculatorPage().verifyAgeTextFieldInfo(data_AgeFieldMessage);
	}

	/*****************************************************************************************************
	 * Name : tc02_Verify_if_tax_projections_are_displayed__For_Employed
	 *
	 * Description : verify if a employed user is able to calculate what their
	 * KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------ Note:
	 * Employed • User whose Current age is 30 is Employed @ a Salary 82000 p/a
	 * and contributes to KiwiSaver @ 4% has a PIR 17.5% and chooses a high risk
	 * profile is able to calculate his projected balances at retirement.
	 ****************************************************************************************************/
	@Test(groups = {
	"Regression" }, description = "verify if a employed user is able to calculate what their KiwiSaver projected balance would be at retirement")
	public void tc02_Verify_if_tax_projections_are_displayed__For_Employed() {
		// Click on the Kiwi saver calculator
		homePage().clickKiwiSaverCalculator();
		// enter age and employment status
		calculatorPage().enterAgeAndEmploymentStatus(data_userAge1, data_employementStatus1);
		// Enter salary details
		calculatorPage().enterSalaryDetails(data_salary1);
		// enter kiwi saver contribution
		calculatorPage().enterKiwiSaverContribution(data_kiwiSaver1);
		// enter the Prescibed investor rate
		calculatorPage().enterPIRDetails(data_pir1);
		// select the risk profile required
		calculatorPage().selectRiskProfile(data_riskProfile1);
		// click calculate the retirements button
		calculatorPage().clickCalculateRetirementsButton();
		// Verify the graph and print the displayed result
		calculatorPage().verifyCalcResults();

	}

	/*****************************************************************************************************
	 * Name : tc03_Verify_if_tax_projections_are_displayed__For_Self_Employed
	 *
	 * Description : verify if a Self employed user is able to calculate what
	 * their KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------ Note:
	 * Unemployed scenario 1 : User whose current aged 45 is Self-employed, has
	 * a PIR 10.5%, current KiwiSaver balance is $100000, voluntary contributes
	 * $90 fortnightly and chooses medium risk profile with saving goals
	 * requirement of $290000 is able to calculate his projected balances at
	 * retirement.
	 ****************************************************************************************************/
	@Test(groups = {
	"Regression" }, description = "verify if a self employed user is able to calculate what their KiwiSaver projected balance would be at retirement")
	public void tc03_Verify_if_tax_projections_are_displayed__For_Self_Employed() {

		// Click on the Kiwi saver calculator
		homePage().clickKiwiSaverCalculator();
		// enter age and employment status
		calculatorPage().enterAgeAndEmploymentStatus(data_userAge2, data_employementStatus2);
		// enter the kiwi saver balance
		calculatorPage().enterKiwiSaverBalance(data_kiwiBalance2);
		// enter amount for vouluntary contributes and the frequncy
		calculatorPage().enterAndSelectVoluntaryContributesFrequecy(data_voluntaryContributes2, data_frequency2);
		// Enter th savings goal
		calculatorPage().enterSavingsGoals(data_savingsGoal2);
		// enter the Prescibed investor rate
		calculatorPage().enterPIRDetails(data_pir2);
		// select the risk profile required
		calculatorPage().selectRiskProfile(data_riskProfile2);
		// enter click calculate the retirements button
		calculatorPage().clickCalculateRetirementsButton();
		// Verify the graph and print the displayed result
		calculatorPage().verifyCalcResults();

	}

	/*****************************************************************************************************
	 * Name : tc04_Verify_if_tax_projections_are_displayed__For_UnEmployed
	 *
	 * Description : verify if a unemployed user is able to calculate what their
	 * KiwiSaver projected balance would be at retirement
	 * 
	 * Author : Subramanian
	 * ------------------------------------------------------------ Note:
	 * unemployed Scenario 2:• User whose current aged 55 is not employed, has a
	 * PIR 10.5%, current KiwiSaver balance is $140000, voluntary contributes
	 * $10 annually and chooses medium risk profile with saving goals
	 * requirement of $200000 is able to calculate his projected balances at
	 * retirement.
	 ****************************************************************************************************/
	@Test(groups = {
	"Regression" }, description = "verify if a unemployed user is able to calculate what their KiwiSaver projected balance would be at retirement")
	public void tc04_Verify_if_tax_projections_are_displayed__For_UnEmployed() {
		// Click on the Kiwi saver calculator
		homePage().clickKiwiSaverCalculator();
		// enter age and employment status
		calculatorPage().enterAgeAndEmploymentStatus(data_userAge3, data_employementStatus3);
		// enter the kiwi saver balance
		calculatorPage().enterKiwiSaverBalance(data_kiwiBalance3);
		// enter amount for vouluntary contributes and the frequncy
		calculatorPage().enterAndSelectVoluntaryContributesFrequecy(data_voluntaryContributes2, data_frequency3);
		// Enter th savings goal
		calculatorPage().enterSavingsGoals(data_savingsGoal3);
		// enter the Prescibed investor rate
		calculatorPage().enterPIRDetails(data_pir2);
		// select the risk profile required
		calculatorPage().selectRiskProfile(data_riskProfile2);
		// enter click calculate the retirements button
		calculatorPage().clickCalculateRetirementsButton();
		// Verify the graph and print the displayed result
		calculatorPage().verifyCalcResults();
	}

	/**
	 * quit() driver
	 */
	@AfterMethod
	public void quit() {
		// close the driver after a test is completed
		driver.close();
	}

}
