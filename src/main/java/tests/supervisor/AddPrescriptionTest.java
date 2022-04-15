package tests.supervisor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.supervisor.PatientManagementPage;
import pages.supervisor.PatientManagement_ManagePrescriptionPage;
import pages.supervisor.PatientManagement_MoreDetailPage;
import pages.supervisor.SupervisorHomePage;
import tests.TestBase;

public class AddPrescriptionTest extends TestBase {
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
        patientManagementPage.clickOnAliceMoreDetailButton();
        Thread.sleep(2000);

        PatientManagement_MoreDetailPage patientManagementMoreDetailPage = PageFactory.initElements(driver, PatientManagement_MoreDetailPage.class);
        patientManagementMoreDetailPage.clickOnManagePrescriptionButton();
        Thread.sleep(2000);

        PatientManagement_ManagePrescriptionPage patientManagementManagePrescriptionPage = PageFactory.initElements(driver, PatientManagement_ManagePrescriptionPage.class);
        patientManagementManagePrescriptionPage.clickOnAddPrescriptionButton();
        Thread.sleep(5000);
        patientManagementManagePrescriptionPage.dropDownChooseRole("Donepezil");
        patientManagementManagePrescriptionPage.clickOnLongTermRadioButton();
        patientManagementManagePrescriptionPage.setDosage("2 tabs");
        patientManagementManagePrescriptionPage.setFrequency("2");
        patientManagementManagePrescriptionPage.clickOnAfterMealTrueRadioButton();
        patientManagementManagePrescriptionPage.setInstruction("Always leave at least 4 hours between doses");
        patientManagementManagePrescriptionPage.setRemark("None");
        patientManagementManagePrescriptionPage.setStartDate("18112021"+ Keys.TAB+"12001");
        patientManagementManagePrescriptionPage.setEndDate("18112022"+ Keys.TAB+"12001");
        patientManagementManagePrescriptionPage.clickOnSubmitButton();
        Thread.sleep(2000);
        try {
            Assert.assertTrue(driver.getPageSource().contains("Changes saved successfully"));
        } catch (Exception e) {
            System.out.println("Changes saved successfully not found page " + e.getMessage());
        }
        supervisorHomePage.clickOnNavbarDropDownButton();
        supervisorHomePage.clickOnNavbarDropDown_LogOutButton();

    }

}
