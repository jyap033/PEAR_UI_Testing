package tests.administrator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.administrator.AdministratorHomePage;
import pages.LoginPage;
import pages.administrator.RegisterPage;
import tests.TestBase;

public class RegistrationTest extends TestBase {
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("janice@gmail.com");
        loginpage.setPassword("Admin!23");
        loginpage.dropDownChooseRole("Administrator");
        loginpage.clickOnLoginButton();

        AdministratorHomePage administratorHomePage = PageFactory.initElements(driver, AdministratorHomePage.class);
        administratorHomePage.clickOnRegisterAccountButton();

        // Navigate to ‘Register Account’
        String exp_title = "Register - PEAR";
        String curr_window_title = driver.getTitle();

        try {
            Assert.assertEquals(curr_window_title, exp_title);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

        registerPage.setDateOfBirth(""+Keys.TAB);
        registerPage.setNRIC("S3592622D");
        registerPage.setEmail("Peter_test@gmail.com");
        registerPage.dropDownChooseRole("Guardian");

        // Enter Test Data and click ‘Register’
        registerPage.clickOnRegisterButton();
        Thread.sleep(5000);

    }
}
