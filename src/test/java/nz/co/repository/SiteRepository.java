package nz.co.repository;

import nz.co.westpac.pages.CalculatorPage;
import nz.co.westpac.pages.HomePage;

/**
 * Creating page objects in site repository to access them in regression test
 * class
 * 
 * @author Subramanian_K
 *
 */
public class SiteRepository extends Starter {

	public HomePage homePage() {
		return new HomePage(this);
	}

	public CalculatorPage calculatorPage() {
		return new CalculatorPage(this);
	}

}
