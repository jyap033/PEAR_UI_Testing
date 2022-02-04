package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;
import pages.EditRolesPage;
import org.openqa.selenium.support.PageFactory;
import pages.RegisterPage;

public class RegistrationTest extends TestBase {
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("janice@gmail.com");
        loginpage.setPassword("Admin!23");
        loginpage.dropDownChooseRole("Administrator");
        loginpage.clickOnLoginButton();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnRegisterAccountButton();

        // Navigate to ‘Register Account’
        String exp_title = "Register - PEAR";
        String curr_window_title = driver.getTitle();

        try {
            Assert.assertEquals(curr_window_title, exp_title);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setFirstName("Peter");
        registerPage.setLastName("Tester");
        registerPage.setPreferedName("Peter Test");
        registerPage.DropDownChooseGender("Male");
        registerPage.setDateOfBirth("130909");
        registerPage.setNRIC("S3592622D");
        registerPage.setAddress("249 Jln Boon Lay, Singapore 619523");
        registerPage.setEmail("Peter_test@gmail.com");
        registerPage.setUsername("peter");
        registerPage.dropDownChooseRole("Guardian");
        registerPage.setPassword("Tester!23");
        registerPage.setConfirmPassword("Tester!23");

        // Enter Test Data and click ‘Register’
        registerPage.clickOnRegisterButton();

        //Admin Dashboard
        try {
            Assert.assertTrue(driver.getPageSource().contains("Peter"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
