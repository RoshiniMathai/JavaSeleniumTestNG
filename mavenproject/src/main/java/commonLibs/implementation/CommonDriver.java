package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {
	
	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectiontimeout;
	private String currentWorkingDirectiry;
	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 10;
		elementDetectiontimeout =10;
		// Launch URL
		currentWorkingDirectiry = System.getProperty("user.dir");
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",currentWorkingDirectiry+"/drivers/chrome.exe");
		}
		else {
			throw new Exception("Invalid Browser Type"+ browserType);
		}
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
		
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectiontimeout(int elementDetectiontimeout) {
		this.elementDetectiontimeout = elementDetectiontimeout;
	}

	public void navigateToURL(String url) {
		
		driver.manage().timeouts().implicitlyWait(elementDetectiontimeout,TimeUnit.SECONDS );
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void closeAllBrowsers()
	{
		driver.quit();
	}
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}
	
}
