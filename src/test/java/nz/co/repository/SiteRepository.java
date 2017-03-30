package nz.co.repository;

import nz.co.westpac.pages.CalculatorPage;
import nz.co.westpac.pages.HomePage;
import nz.co.westpac.pages.Start;

public class SiteRepository {
	public HomePage homePage(){
		return new HomePage(this);
	}
	
	public Start start(){
		return new Start(this);
	}
	
	public CalculatorPage calculatorPage(){
		return new CalculatorPage(this);
	}
	

}
