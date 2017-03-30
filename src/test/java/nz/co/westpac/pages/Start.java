package nz.co.westpac.pages;



import org.openqa.selenium.WebDriver;


import nz.co.repository.SiteRepository;
import nz.co.westpac.entities.DriverFactory;


public class Start extends SitePage {
	public static final String chromeProperty = "webdriver.chrome.driver";
    public static final String RELATIVE_APP_PATH = "lib/chromedriver.exe";
    WebDriver driver;
    
    SiteRepository repository;
    
    public Start(SiteRepository repository){
		super(repository);
		this.repository=repository;
	}

    
	public Start startWithChrome(){
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.get("http://www.westpac.co.nz/");
		driver.manage().window().maximize();
		 return this;

	}
}
