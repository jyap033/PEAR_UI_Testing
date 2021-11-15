package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
//public class DemoClass {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\jay_j\\Desktop\\Y4S1\\FYP\\Selenium\\chromedriver_win32 (2)\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://www.youtube.com/");
//		driver.manage().window().maximize();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.findElement(By.id("search")).sendKeys("singsing");;
//		driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
//		js.executeScript("window.scrollBy(0,300)");
//	}
//
//}

public class DemoClass {
	
public String baseUrl = "https://www.youtube.com/";
public String chromeDriverPath = "C:\\\\Users\\\\jay_j\\\\Desktop\\\\Y4S1\\\\FYP\\\\Selenium\\\\chromedriver_win32 (2)\\\\chromedriver.exe";
public String edgeDriverPath = "C:\\\\Users\\\\jay_j\\\\Desktop\\\\Y4S1\\\\FYP\\\\Selenium\\\\msedgedriver.exe";

WebDriver driver;
	
	

@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception {
	
	if(browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver",edgeDriverPath);
		driver = new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
	}
	else {
		throw new Exception("Browser is not correct");
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

//
// @BeforeTest
//	public void LaunchBrowser() {
//		System.setProperty("webdriver.chrome.driver",driverPath);
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
//	}
//	
 @Test
	public void Verify() {
		driver.get(baseUrl);

		String expected = "YouTube";
		String actual = driver.getTitle();
		Assert.assertEquals(actual,expected);
	}
// @Test
//	public void Verify1() {
//
//		String expected = "YouTube";
//		String actual = driver.getTitle();
//		Assert.assertEquals(actual,expected);
//	}
// @Test
//	public void Verify11() {
//
//		String expected = "YouTube";
//		String actual = driver.getTitle();
//		Assert.assertEquals(actual,expected);
//	}
 
 @AfterTest
 public void TerminateBrowser() {
		driver.close();

 }

}

