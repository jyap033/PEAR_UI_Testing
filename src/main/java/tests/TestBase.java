package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public static WebDriver driver;
	public String chromeDriverPath = "C:\\\\Users\\\\jay_j\\\\Desktop\\\\Y4S1\\\\FYP\\\\Selenium\\\\chromedriver_win32 (2)\\\\chromedriver.exe";
	public String edgeDriverPath = "C:\\\\Users\\\\jay_j\\\\Desktop\\\\Y4S1\\\\FYP\\\\Selenium\\\\msedgedriver.exe";

	public String remote_url = "http://localhost:4444/wd/hub";
//@BeforeSuite
//public void initialise() throws IOException{
//
//	System.setProperty("webdriver.chrome.driver",chromeDriverPath);
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	driver.get("https://coremvc.fyp2017.com/Identity/Account/Login?ReturnUrl=%2F");
//	
//}

 

@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception {
	
	if(browser.equalsIgnoreCase("firefox")) {
		FirefoxOptions foptions = new FirefoxOptions();
		foptions.addArguments("--marionette-port");
		foptions.addArguments("disable-infobars"); 
		foptions.addArguments("2828"); 
		foptions.addArguments("--headless");

		driver = new RemoteWebDriver(new URL(remote_url), foptions);

	}
	else if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // Open browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to window os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		
		//System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new RemoteWebDriver(new URL(remote_url), options);
	}
	else { 
		throw new Exception("Browser is not correct");
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://coremvc.fyp2017.com/Identity/Account/Login?ReturnUrl=%2F");

}


@AfterTest
public void TerminateTest() {
	TestBase.driver.quit();
}
}