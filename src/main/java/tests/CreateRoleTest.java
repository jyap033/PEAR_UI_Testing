package tests;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;
import pages.EditRolesPage;
import org.openqa.selenium.support.PageFactory;

public class CreateRoleTest extends TestBase {
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("janice@gmail.com");
        loginpage.setPassword("Admin!23");
        loginpage.dropDownChooseRole("Administrator");

        loginpage.clickOnLoginButton();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        //Navigate to ‘Edit Roles’
        homePage.clickOnEditRoleButtonButton();

        String exp_title = "All Roles - PEAR";
        String curr_window_title = driver.getTitle();

        try {
            Assert.assertEquals(curr_window_title, exp_title);
            Assert.assertTrue(driver.getPageSource().contains("Administrator"));
            Assert.assertTrue(driver.getPageSource().contains("Caregiver"));
            Assert.assertTrue(driver.getPageSource().contains("Doctor"));
            Assert.assertTrue(driver.getPageSource().contains("Game Therapist"));
            Assert.assertTrue(driver.getPageSource().contains("Guardian"));
            Assert.assertTrue(driver.getPageSource().contains("Supervisor"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        EditRolesPage editRolesPage = PageFactory.initElements(driver, EditRolesPage.class);
        editRolesPage.clickOnCreateRoleButton();

        //Enters RoleName and click ‘Create Role’
        editRolesPage.setRoleName("Test Role");

        //Click ‘Create Role’
        editRolesPage.clickOnConfirmCreateRoleButton();

    }
}
