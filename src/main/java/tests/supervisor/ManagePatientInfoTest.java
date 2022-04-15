package tests.supervisor;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.supervisor.PatientManagement_MoreDetailPage;
import pages.supervisor.PatientManagementPage;
import pages.supervisor.SupervisorHomePage;
import pages.LoginPage;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class ManagePatientInfoTest extends TestBase {
    @Test
    public void init() throws Exception {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("jess@gmail.com");
        loginpage.setPassword("Supervisor!23");
        loginpage.dropDownChooseRole("Supervisor");
        loginpage.clickOnLoginButton();
        SupervisorHomePage supervisorHomePage = PageFactory.initElements(driver, SupervisorHomePage.class);
        supervisorHomePage.clickOnViewPatientButton();
        Thread.sleep(2000);
        String exp_title = "Patient Management - PEAR";
        String curr_window_title = driver.getTitle();
        try {
            Assert.assertEquals(curr_window_title, exp_title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PatientManagementPage patientManagementPage = PageFactory.initElements(driver, PatientManagementPage.class);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        patientManagementPage.clickOnAliceMoreDetailButton();
        Thread.sleep(2000);
        PatientManagement_MoreDetailPage patientManagementMoreDetailPage = PageFactory.initElements(driver, PatientManagement_MoreDetailPage.class);
        String firstname = patientManagementMoreDetailPage.getFirstNameTextBoxValue();
        String lastname = patientManagementMoreDetailPage.getLastNameTextBoxValue();
        try {
            Assert.assertEquals(firstname, "Alice");
            Assert.assertEquals(lastname, "Lee");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        supervisorHomePage.clickOnNavbarDropDownButton();
        supervisorHomePage.clickOnNavbarDropDown_LogOutButton();    }
}
