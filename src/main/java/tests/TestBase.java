package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;

@BeforeMethod
@Parameters("browser")
public void setup(@Optional("Optional Parameter") String browser) throws Exception {
	if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions foptions = new FirefoxOptions();
		foptions.addArguments("--marionette-port");
		foptions.addArguments("disable-infobars"); 
		foptions.addArguments("2828"); 
		/*foptions.addArguments("--headless");*/
		driver = new FirefoxDriver(foptions);
	}
	else{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		//options.addArguments("start-maximized"); // Open browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to window os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
	}
	driver.get("https://coremvc.fyp2017.com/Identity/Account/Login?ReturnUrl=%2F");
}
@AfterMethod
public void TerminateTest() {
	driver.quit();
}
}