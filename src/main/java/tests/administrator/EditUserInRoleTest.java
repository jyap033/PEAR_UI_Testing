package tests.administrator;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.administrator.EditRolesPage;
import pages.administrator.AdministratorHomePage;
import pages.LoginPage;
import tests.TestBase;

public class EditUserInRoleTest extends TestBase {
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("janice@gmail.com");
        loginpage.setPassword("Admin!23");
        loginpage.dropDownChooseRole("Administrator");

        loginpage.clickOnLoginButton();

        AdministratorHomePage administratorHomePage = PageFactory.initElements(driver, AdministratorHomePage.class);
        //Navigate to ‘Edit Roles’
        administratorHomePage.clickOnManageRolesButton();

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
        Thread.sleep(1000);
        editRolesPage.clickOnCreateRoleButton();

        //Enters RoleName and click ‘Create Role’
        editRolesPage.setRoleName("Test Role");

        //Click ‘Create Role’
        editRolesPage.clickOnConfirmCreateRoleButton();
    }
}
