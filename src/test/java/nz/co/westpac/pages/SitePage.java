package nz.co.westpac.pages;

import nz.co.repository.SiteRepository;
import nz.co.westpac.entities.DriverManagerInstance;

public class SitePage extends DriverManagerInstance{
	protected SiteRepository repository;
	
	protected SitePage(SiteRepository repository){
		this.repository=repository;
	}
	
	public HomePage _GoToHomePage() {
		return this.repository.homePage();
	}
	
	public SitePage _GoToStartPage() {
		return this.repository.start();
	}
	
	public CalculatorPage _GoToCalculatorPage(){
		return this.repository.calculatorPage();
	}

}
