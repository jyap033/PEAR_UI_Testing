package Scripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screenshot {
    public WebDriver driver;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void loginTest() {

        //define the url
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //maximize the window
        driver.manage().window().maximize();

        //delete the cookies saved
        driver.manage().deleteAllCookies();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //get the title of the webpage
        String pageTitle = driver.getTitle();
        System.out.println("The title of this page is ===> " +pageTitle);
//
//        //enter the locator of username and clear the input field before entering any value
//        driver.findElement(By.id("txtUsername")).clear();
//
//        //enter the username
//        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//
//        //enter the locator of password and clear the input field
//        driver.findElement(By.id("txtPassword")).clear();
//
//        //enter the value of password
//        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        //downcast the driver to access TakesScreenshot method
        TakesScreenshot ts = (TakesScreenshot)driver;

        //capture screenshot as output type FILE
        File file = ts.getScreenshotAs(OutputType.FILE);

        try {
            //save the screenshot taken in destination path
            FileUtils.copyFile(file, new File("./ScreenShot_Folder/Test1_Login.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the login page screenshot is taken");

    }}
