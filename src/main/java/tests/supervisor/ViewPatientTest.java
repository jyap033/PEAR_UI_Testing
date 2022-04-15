package tests.supervisor;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.supervisor.PatientManagementPage;
import pages.supervisor.SupervisorHomePage;
import pages.LoginPage;
import tests.TestBase;

public class ViewPatientTest extends TestBase{
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("jess@gmail.com");
        loginpage.setPassword("Supervisor!23");
        loginpage.dropDownChooseRole("Supervisor");

        loginpage.clickOnLoginButton();

        SupervisorHomePage supervisorHomePage = PageFactory.initElements(driver, SupervisorHomePage.class);
        supervisorHomePage.clickOnViewPatientButton();

        String exp_title = "Patient Management - PEAR";
        String curr_window_title = driver.getTitle();
        Thread.sleep(2000);
        try {
            System.out.println("Active");
            Assert.assertEquals(curr_window_title, exp_title);
            Assert.assertTrue(driver.getPageSource().contains("Alice"));
            Assert.assertTrue(driver.getPageSource().contains("Bi"));
            Assert.assertTrue(driver.getPageSource().contains("Jeline"));
            Assert.assertTrue(driver.getPageSource().contains("Jon"));
            Assert.assertTrue(driver.getPageSource().contains("Yan"));
        } catch (Exception e) {
            System.out.println("Name not found in active patient list" + e.getMessage());
        }
        PatientManagementPage patientManagementPage = PageFactory.initElements(driver, PatientManagementPage.class);
        patientManagementPage.clickOnInactivePatientButton();
        Thread.sleep(2000);
        try {
            System.out.println("Inactive");
            Assert.assertEquals(curr_window_title, exp_title);
            Assert.assertTrue(driver.getPageSource().contains("John"));
            Assert.assertTrue(driver.getPageSource().contains("Mary"));
        } catch (Exception e) {
            System.out.println("Name not found in active patient list" + e.getMessage());
        }

        supervisorHomePage.clickOnNavbarDropDownButton();
        supervisorHomePage.clickOnNavbarDropDown_LogOutButton();    }
}
